package com.itlesports.mobadditions.entity.mob.util;

import btw.client.network.packet.handler.EntityEventPacketHandler;
import btw.network.packet.BTWPacketManager;
import btw.world.util.WorldUtils;
import com.itlesports.mobadditions.entity.mob.util.attributes.*;
import com.itlesports.mobadditions.entity.mob.util.attributes.BaseAttributeMap;
import net.minecraft.src.*;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.List;

public abstract class KickingAnimal extends EntityAnimal {
    private BaseAttributeMap attributeMap;
    public float limbSwingAmount;
    public float prevLimbSwingAmount;
    public float limbSwing;


    public static final int KICK_ATTACK_TICKS_TO_COOLDOWN = 40;
    public static final double KICK_ATTACK_RANGE = 1.75D;
    public static final int KICK_ATTACK_DURATION = 20;
    public static final double KICK_ATTACK_TIP_COLLISION_WIDTH = 2.75D;
    public static final double KICK_ATTACK_TIP_COLLISION_HALF_WIDTH = (KICK_ATTACK_TIP_COLLISION_WIDTH / 2D);
    public static final double KICK_ATTACK_TIP_COLLISION_HEIGHT = 2D;
    public static final double KICK_ATTACK_TIP_COLLISION_HALF_HEIGHT = (KICK_ATTACK_TIP_COLLISION_HEIGHT / 2D);

    protected int kickAttackCooldownTimer = KICK_ATTACK_TICKS_TO_COOLDOWN;

    public int kickAttackInProgressCounter = -1;

    public int kickAttackLegUsed = 0;
    public KickingAnimal(World par1World) {
        super(par1World);
        this.applyEntityAttributes();
    }

    @Override
    public void onLivingUpdate() {
        updateKickAttack();
        super.onLivingUpdate();
    }

    protected void updateKickAttack() {
        if (kickAttackInProgressCounter >= 0) {
            kickAttackInProgressCounter++;

            if (kickAttackInProgressCounter >= KICK_ATTACK_DURATION) {
                kickAttackInProgressCounter = -1;
            }
        }
        else if (!worldObj.isRemote) // attacks are only launched on the server
        {
            kickAttackCooldownTimer--;

            // check if we should initiate an attack, which only applies if the cow is burning or has a target, which are the same conditions
            // that are used to determine if the cow is panicked and fleeing
            if (isEntityAlive() && !isChild() && !getWearingBreedingHarness() && kickAttackCooldownTimer <= 0 && (isBurning() || getAITarget() != null)) {
                Vec3 kickCenter = computeKickAttackCenter();

                AxisAlignedBB tipBox = AxisAlignedBB.getAABBPool()
                        .getAABB(kickCenter.xCoord - KICK_ATTACK_TIP_COLLISION_HALF_WIDTH, kickCenter.yCoord - KICK_ATTACK_TIP_COLLISION_HALF_HEIGHT,
                                kickCenter.zCoord - KICK_ATTACK_TIP_COLLISION_HALF_WIDTH, kickCenter.xCoord + KICK_ATTACK_TIP_COLLISION_HALF_WIDTH,
                                kickCenter.yCoord + KICK_ATTACK_TIP_COLLISION_HALF_HEIGHT, kickCenter.zCoord + KICK_ATTACK_TIP_COLLISION_HALF_WIDTH);

                List potentialCollisionList = worldObj.getEntitiesWithinAABB(EntityLiving.class, tipBox);

                if (!potentialCollisionList.isEmpty()) {
                    boolean bAttackLaunched = false;

                    Vec3 lineOfSightOrigin = Vec3.createVectorHelper(posX, posY + (height / 2F), posZ);

                    for (Object o : potentialCollisionList) {
                        EntityLiving tempEntity = (EntityLiving) o;

                        if (!(tempEntity instanceof KickingAnimal) && tempEntity.isEntityAlive() && tempEntity.ridingEntity != this
                                && (canEntityBeSeenForAttackToCenterOfMass(tempEntity, lineOfSightOrigin) || getDistanceSqToEntity(tempEntity) <= (1.25 * 1.25)))
                        {
                            bAttackLaunched = true;

                            kickAttackHitTarget(tempEntity);
                        }
                    }

                    if (bAttackLaunched) {
                        launchKickAttack();
                    }
                }
            }
        }
    }

    public boolean canEntityBeSeenForAttackToCenterOfMass(Entity entity, Vec3 attackOrigin) {
        return worldObj.rayTraceBlocks_do_do(attackOrigin,
                worldObj.getWorldVec3Pool().getVecFromPool(entity.posX, entity.posY + (entity.height / 2F), entity.posZ), false, true) == null;
    }

    public Vec3 computeKickAttackCenter() {
        float fAttackAngle = MathHelper.wrapAngleTo180_float(rotationYaw + 180F);

        double dPosX = (double) (-MathHelper.sin(fAttackAngle / 180.0F * (float) Math.PI)) * KICK_ATTACK_RANGE;
        double dPosY = height / 2F;
        double dPosZ = (double) (MathHelper.cos(fAttackAngle / 180.0F * (float) Math.PI)) * KICK_ATTACK_RANGE;

        dPosX += posX;
        dPosY += posY;
        dPosZ += posZ;

        return Vec3.createVectorHelper(dPosX, dPosY, dPosZ);
    }

    private void launchKickAttack() {
        kickAttackInProgressCounter = 0;
        kickAttackCooldownTimer = KICK_ATTACK_TICKS_TO_COOLDOWN;

        transmitKickAttackToClients();
    }

    private void transmitKickAttackToClients() {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        DataOutputStream dataStream = new DataOutputStream(byteStream);

        try {
            dataStream.writeInt(entityId);
            dataStream.writeByte((byte) EntityEventPacketHandler.COW_KICK_ATTACK_EVENT_ID);
        }
        catch (Exception exception) {
            exception.printStackTrace();
        }

        Packet250CustomPayload packet = new Packet250CustomPayload(BTWPacketManager.CUSTOM_ENTITY_EVENT_PACKET_CHANNEL, byteStream.toByteArray());
        WorldUtils.sendPacketToAllPlayersTrackingEntity((WorldServer) worldObj, this, packet);
    }

    public void onClientNotifiedOfKickAttack() {
        kickAttackInProgressCounter = 0;
        kickAttackLegUsed = rand.nextInt(2);
        worldObj.playSound(posX, posY, posZ, "random.bow", 1F, (rand.nextFloat() - rand.nextFloat()) * 0.2F + 0.5F);
    }

    private void kickAttackHitTarget(Entity hitEntity) {
        DamageSource cowSource = DamageSource.causeMobDamage(this);
        int kickDamage = 7;

        if (hitEntity instanceof EntityPlayer) {
            kickDamage *= this.worldObj.getDifficulty().getCowKickStrengthMultiplier();
        }

        if (hitEntity.attackEntityFrom(cowSource, kickDamage)) {
            if (isBurning() && rand.nextFloat() < 0.6F) {
                hitEntity.setFire(4);
            }

            this.onKickedByAnimal(this);
        }
    }
    public void onKickedByAnimal(KickingAnimal kickingAnimal)
    {
        flingAwayFromEntity(kickingAnimal, getCowKickMovementMultiplier());
    }
    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        return entityLivingOnSpawnWithEgg(par1EntityLivingData);
    }

    public EntityLivingData entityLivingOnSpawnWithEgg(EntityLivingData par1EntityLivingData) {
        this.getEntityAttribute(SharedMonsterAttributes.followRange).applyModifier(new AttributeModifier("Random spawn bonus", this.rand.nextGaussian() * 0.05D, 1));
        return par1EntityLivingData;
    }
    public AttributeInstance getEntityAttribute(Attribute par1Attribute)
    {
        return this.getAttributeMap().getAttributeInstance(par1Attribute);
    }
    public BaseAttributeMap getAttributeMap()
    {
        if (this.attributeMap == null)
        {
            this.attributeMap = new ServersideAttributeMap();
        }

        return this.attributeMap;
    }
    protected void applyEntityAttributes()
    {
        this.getAttributeMap().func_111150_b(SharedMonsterAttributes.maxHealth);
        this.getAttributeMap().func_111150_b(SharedMonsterAttributes.knockbackResistance);
        this.getAttributeMap().func_111150_b(SharedMonsterAttributes.movementSpeed);

        if (!this.isAIEnabled())
        {
            this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.10000000149011612D);
        }
    }
}
