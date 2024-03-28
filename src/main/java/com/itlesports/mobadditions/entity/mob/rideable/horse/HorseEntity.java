package com.itlesports.mobadditions.entity.mob.rideable.horse;

import btw.entity.mob.SquidEntity;
import btw.entity.mob.behavior.*;
import com.itlesports.mobadditions.entity.EntityLivingBase;
import com.itlesports.mobadditions.entity.EntityLivingData;
import com.itlesports.mobadditions.entity.mob.attributes.*;
import com.itlesports.mobadditions.item.ModItems;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;
import btw.item.BTWItems;

import java.util.Iterator;
import java.util.List;

public class HorseEntity extends KickingAnimal implements IInvBasic
{
    private int inLove;
    private boolean objectChanged;
    private static final IEntitySelector horseBreedingSelector = new EntityHorseBredSelector();
    private static final Attribute horseJumpStrength = (new RangedAttribute("horse.jumpStrength", 0.7D, 0.0D, 2.0D)).func_111117_a("Jump Strength").setShouldWatch(true);
    private static final String[] horseArmorTextures = new String[] {null, "/mobadditions/entity/mob/horse/armor/horse_armor_iron.png", "/mobadditions/entity/mob/horse/armor/horse_armor_gold.png", "/mobadditions/entity/mob/horse/armor/horse_armor_diamond.png"};
    private static final String[] field_110273_bx = new String[] {"", "meo", "goo", "dio"};
    private static final int[] armorValues = new int[] {0, 5, 7, 11};
    private static final String[] horseTextures = new String[] {"/mobadditions/entity/mob/horse/horse_white.png", "/mobadditions/entity/mob/horse/horse_creamy.png", "/mobadditions/entity/mob/horse/horse_chestnut.png", "/mobadditions/entity/mob/horse/horse_brown.png", "/mobadditions/entity/mob/horse/horse_black.png", "/mobadditions/entity/mob/horse/horse_gray.png", "/mobadditions/entity/mob/horse/horse_darkbrown.png"};
    private static final String[] field_110269_bA = new String[] {"horse_white.png", "horse_creamy.png", "horse_chestnut.png", "horse_brown.png", "horse_black.png", "horse_gray.png", "horse_darkbrown.png"};
    private static final String[] horseMarkingTextures = new String[] {null, "/mobadditions/entity/mob/horse/horse_markings_white.png", "/mobadditions/entity/mob/horse/horse_markings_whitefield.png", "/mobadditions/entity/mob/horse/horse_markings_whitedots.png", "/mobadditions/entity/mob/horse/horse_markings_blackdots.png"};
    private static final String[] field_110292_bC = new String[] {"", "horse_markings_white.png", "horse_markings_whitefield.png", "horse_markings_whitedots.png", "horse_markings_blackdots.png"};
    private int eatingHaystackCounter;
    private int openMouthCounter;
    private int jumpRearingCounter;
    public int field_110278_bp;
    public int field_110279_bq;
    protected boolean horseJumping;
    private AnimalChest horseChest;
    private boolean hasReproduced;

    /**
     * "The higher this value, the more likely the horse is to be tamed next time a player rides it."
     */
    protected int temper;
    protected float jumpPower;
    private boolean field_110294_bI;
    private float headLean;
    private float prevHeadLean;
    private float rearingAmount;
    private float prevRearingAmount;
    private float mouthOpenness;
    private float prevMouthOpenness;
    private int field_110285_bP;
    private String field_110286_bQ;
    private String[] field_110280_bR = new String[3];

    public HorseEntity(World par1World)
    {
        super(par1World);
        this.texture = "/mobadditions/entity/mob/horse/horse_brown.png";
        this.setSize(1.4F, 1.6F);
        this.isImmuneToFire = false;
        this.setChested(false);
        this.getNavigator().setAvoidsWater(true);

        tasks.addTask(0, new EntityAISwimming(this));
        tasks.addTask(1, new AnimalFleeBehavior(this, 0.25F));
        tasks.addTask(1, new EntityAIAvoidEntity(this, EntityZombie.class, 8.0F, 0.6F, 0.7F));
        tasks.addTask(2, new EntityAIMate(this, 1.0F));
        tasks.addTask(3, new MultiTemptBehavior(this, 0.2F));
        tasks.addTask(4, new GrazeBehavior(this));
        tasks.addTask(5, new MoveToLooseFoodBehavior(this, 0.15F));
        tasks.addTask(6, new MoveToGrazeBehavior(this, 0.15F));
        tasks.addTask(7, new EntityAIFollowParent(this, 0.2F));
        tasks.addTask(8, new SimpleWanderBehavior(this, 0.2F));
        tasks.addTask(9, new EntityAIWatchClosest(this, EntityPlayer.class, 6F));
        tasks.addTask(10, new EntityAILookIdle(this));

        this.landMovementFactor = 0.1F;
        this.moveSpeed = 0.1F;
        this.func_110226_cD();
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(16, 0);
        this.dataWatcher.addObject(19, (byte) 0);
        this.dataWatcher.addObject(20, 0);
        this.dataWatcher.addObject(17, String.valueOf(""));
        this.dataWatcher.addObject(31, 0);
    }

    public void setHorseType(int par1)
    {
        this.dataWatcher.updateObject(19, (byte) par1);
        this.func_110230_cF();
    }

    /**
     * returns the horse type
     */
    public int getHorseType()
    {
        return this.dataWatcher.getWatchableObjectByte(19);
    }

    public void setHorseVariant(int par1)
    {
        this.dataWatcher.updateObject(20, par1);
        this.func_110230_cF();
    }

    public int getHorseVariant()
    {
        return this.dataWatcher.getWatchableObjectInt(20);
    }

    /**
     * Gets the username of the entity.
     */
    public String getEntityName()
    {
        //if (this.hasCustomNameTag())
       // {
            //return this.getCustomNameTag();
       // }
        //else
        {
            int var1 = this.getHorseType();

            switch (var1)
            {
                case 0:
                default:
                    return StatCollector.translateToLocal("entity.horse.name");

                case 1:
                    return StatCollector.translateToLocal("entity.donkey.name");

                case 2:
                    return StatCollector.translateToLocal("entity.mule.name");

                case 3:
                    return StatCollector.translateToLocal("entity.zombiehorse.name");

                case 4:
                    return StatCollector.translateToLocal("entity.skeletonhorse.name");
            }
        }
    }

    private boolean getHorseWatchableBoolean(int par1)
    {
        return (this.dataWatcher.getWatchableObjectInt(16) & par1) != 0;
    }

    private void setHorseWatchableBoolean(int par1, boolean par2)
    {
        int var3 = this.dataWatcher.getWatchableObjectInt(16);

        if (par2)
        {
            this.dataWatcher.updateObject(16, var3 | par1);
        }
        else
        {
            this.dataWatcher.updateObject(16, var3 & ~par1);
        }
    }

    public boolean isAdultHorse()
    {
        return !this.isChild();
    }

    public boolean isTame()
    {
        return this.getHorseWatchableBoolean(2);
    }

    public boolean func_110253_bW()
    {
        return this.isAdultHorse();
    }

    public String getOwnerName()
    {
        return this.dataWatcher.getWatchableObjectString(17);
    }

    public void setOwnerName(String par1Str)
    {
        this.dataWatcher.updateObject(17, par1Str);
    }

    public float getHorseSize()
    {
        int var1 = this.getGrowingAge();
        return var1 >= 0 ? 1.0F : 0.5F + (float)(-24000 - var1) / -24000.0F * 0.5F;
    }

    /**
     * "Sets the scale for an ageable entity according to the boolean parameter, which says if it's a child."
     */
    /*
    public void setScaleForAge(boolean par1)
    {
        if (par1)
        {
            this.setScale(this.getHorseSize());
        }
        else
        {
            this.setScale(1.0F);
        }
    }

     */

    public boolean isHorseJumping()
    {
        return this.horseJumping;
    }

    public void setHorseTamed(boolean par1)
    {
        this.setHorseWatchableBoolean(2, par1);
    }

    public void setHorseJumping(boolean par1)
    {
        this.horseJumping = par1;
    }
/*
    public boolean allowLeashing()
    {
        return !this.func_110256_cu() && super.allowLeashing();
    }

 */

    protected void func_142017_o(float par1)
    {
        if (par1 > 6.0F && this.isEatingHaystack())
        {
            this.setEatingHaystack(false);
        }
    }

    public boolean isChested()
    {
        return this.getHorseWatchableBoolean(8);
    }

    public int func_110241_cb()
    {
        return this.dataWatcher.getWatchableObjectInt(31);
    }

    /**
     * 0 = iron, 1 = gold, 2 = diamond
     */
    public int getHorseArmorIndex(ItemStack par1ItemStack)
    {
        return par1ItemStack == null ? 0 : (par1ItemStack.itemID == ModItems.horseArmorIron.itemID ? 1 : (par1ItemStack.itemID == ModItems.horseArmorGold.itemID ? 2 : (par1ItemStack.itemID == ModItems.horseArmorDiamond.itemID ? 3 : 0)));
    }

    public boolean isEatingHaystack()
    {
        return this.getHorseWatchableBoolean(32);
    }

    public boolean isRearing()
    {
        return this.getHorseWatchableBoolean(64);
    }

    public boolean func_110205_ce()
    {
        return this.getHorseWatchableBoolean(16);
    }

    public boolean getHasReproduced()
    {
        return this.hasReproduced;
    }

    public void func_110236_r(int par1)
    {
        this.dataWatcher.updateObject(31, par1);
        this.func_110230_cF();
    }

    public void func_110242_l(boolean par1)
    {
        this.setHorseWatchableBoolean(16, par1);
    }

    public void setChested(boolean par1)
    {
        this.setHorseWatchableBoolean(8, par1);
    }

    public void setHasReproduced(boolean par1)
    {
        this.hasReproduced = par1;
    }

    public void setHorseSaddled(boolean par1)
    {
        this.setHorseWatchableBoolean(4, par1);
    }

    public int getTemper()
    {
        return this.temper;
    }

    public void setTemper(int par1)
    {
        this.temper = par1;
    }

    public int increaseTemper(int par1)
    {
        int var2 = MathHelper.clamp_int(this.getTemper() + par1, 0, this.getMaxTemper());
        this.setTemper(var2);
        return var2;
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, float par2)
    {
        Entity var3 = par1DamageSource.getEntity();
        if (this.riddenByEntity != null && !(this.riddenByEntity instanceof SquidEntity)) {
            return !this.riddenByEntity.equals(var3);
        }
        else {
            return super.attackEntityFrom(par1DamageSource, (int) par2);
        }
    }

    /**
     * Returns the current armor value as determined by a call to InventoryPlayer.getTotalArmorValue
     */
    public int getTotalArmorValue()
    {
        return armorValues[this.func_110241_cb()];
    }

    /**
     * Returns true if this entity should push and be pushed by other entities when colliding.
     */
    public boolean canBePushed()
    {
        return this.riddenByEntity == null;
    }

    public boolean prepareChunkForSpawn()
    {
        int var1 = MathHelper.floor_double(this.posX);
        int var2 = MathHelper.floor_double(this.posZ);
        this.worldObj.getBiomeGenForCoords(var1, var2);
        return true;
    }

    public void dropChests()
    {
        if (!this.worldObj.isRemote && this.isChested())
        {
            this.dropItem(Block.chest.blockID, 1);
            this.setChested(false);
        }
    }

    private void func_110266_cB()
    {
        this.openHorseMouth();
        this.worldObj.playSoundAtEntity(this, "eating", 1.0F, 1.0F + (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F);
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1)
    {
        if (par1 > 1.0F)
        {
            this.playSound("mob.horse.land", 0.4F, 1.0F);
        }

        int var2 = MathHelper.ceiling_float_int(par1 * 0.5F - 3.0F);

        if (var2 > 0)
        {
            this.attackEntityFrom(DamageSource.fall, var2);

            if (this.riddenByEntity != null)
            {
                this.riddenByEntity.attackEntityFrom(DamageSource.fall, var2);
            }

            int var3 = this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY - 0.2D - (double)this.prevRotationYaw), MathHelper.floor_double(this.posZ));

            if (var3 > 0)
            {
                StepSound var4 = Block.blocksList[var3].stepSound;
                this.worldObj.playSoundAtEntity(this, var4.getStepSound(), var4.getVolume() * 0.5F, var4.getPitch() * 0.75F);
            }
        }
    }

    private int func_110225_cC()
    {
        int var1 = this.getHorseType();
        return this.isChested() && (var1 == 1 || var1 == 2) ? 17 : 2;
    }

    private void func_110226_cD()
    {
        AnimalChest var1 = this.horseChest;
        this.horseChest = new AnimalChest("HorseChest", this.func_110225_cC());
        this.horseChest.func_110133_a(this.getEntityName());

        if (var1 != null)
        {
            var1.func_110132_b(this);
            int var2 = Math.min(var1.getSizeInventory(), this.horseChest.getSizeInventory());

            for (int var3 = 0; var3 < var2; ++var3)
            {
                ItemStack var4 = var1.getStackInSlot(var3);

                if (var4 != null)
                {
                    this.horseChest.setInventorySlotContents(var3, var4.copy());
                }
            }

            var1 = null;
        }

        this.horseChest.func_110134_a(this);
        this.func_110232_cE();
    }

    private void func_110232_cE()
    {
        if (!this.worldObj.isRemote)
        {
            this.setHorseSaddled(this.horseChest.getStackInSlot(0) != null);

            if (this.func_110259_cr())
            {
                this.func_110236_r(this.getHorseArmorIndex(this.horseChest.getStackInSlot(1)));
            }
        }
    }

    /**
     * Called by InventoryBasic.onInventoryChanged() on a array that is never filled.
     */
    public void onInventoryChanged(InventoryBasic par1InventoryBasic)
    {
        int var2 = this.func_110241_cb();
        boolean var3 = this.isHorseSaddled();
        this.func_110232_cE();

        if (this.ticksExisted > 20)
        {
            if (var2 == 0 && var2 != this.func_110241_cb())
            {
                this.playSound("mob.horse.armor", 0.5F, 1.0F);
            }

            if (!var3 && this.isHorseSaddled())
            {
                this.playSound("mob.horse.leather", 0.5F, 1.0F);
            }
        }
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        this.prepareChunkForSpawn();
        return super.getCanSpawnHere();
    }

    protected HorseEntity getClosestHorse(Entity par1Entity, double par2)
    {
        double var4 = Double.MAX_VALUE;
        Entity var6 = null;
        List var7 = this.worldObj.getEntitiesWithinAABBExcludingEntity(par1Entity, par1Entity.boundingBox.addCoord(par2, par2, par2), horseBreedingSelector);
        Iterator var8 = var7.iterator();

        while (var8.hasNext())
        {
            Entity var9 = (Entity)var8.next();
            double var10 = var9.getDistanceSq(par1Entity.posX, par1Entity.posY, par1Entity.posZ);

            if (var10 < var4)
            {
                var6 = var9;
                var4 = var10;
            }
        }

        return (HorseEntity)var6;
    }

    public double getHorseJumpStrength()
    {
        return this.getEntityAttribute(horseJumpStrength).getAttributeValue();
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        this.openHorseMouth();
        int var1 = this.getHorseType();
        return var1 == 3 ? "mob.horse.zombie.death" : (var1 == 4 ? "mob.horse.skeleton.death" : (var1 != 1 && var1 != 2 ? "mob.horse.death" : "mob.horse.donkey.death"));
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        boolean var1 = this.rand.nextInt(4) == 0;
        int var2 = this.getHorseType();
        return var2 == 4 ? Item.bone.itemID : (var2 == 3 ? (var1 ? 0 : Item.rottenFlesh.itemID) : Item.leather.itemID);
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        this.openHorseMouth();

        int var1 = this.getHorseType();
        return var1 == 3 ? "mob.horse.zombie.hit" : (var1 == 4 ? "mob.horse.skeleton.hit" : (var1 != 1 && var1 != 2 ? "mob.horse.hit" : "mob.horse.donkey.hit"));
    }

    public boolean isHorseSaddled()
    {
        return this.getHorseWatchableBoolean(4);
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        this.openHorseMouth();

        int var1 = this.getHorseType();
        return var1 == 3 ? "mob.horse.zombie.idle" : (var1 == 4 ? "mob.horse.skeleton.idle" : (var1 != 1 && var1 != 2 ? "mob.horse.idle" : "mob.horse.donkey.idle"));
    }

    protected String getAngrySoundName()
    {
        this.openHorseMouth();
        this.makeHorseRear();
        int var1 = this.getHorseType();
        return var1 != 3 && var1 != 4 ? (var1 != 1 && var1 != 2 ? "mob.horse.angry" : "mob.horse.donkey.angry") : null;
    }

    /**
     * Plays step sound at given x, y, z for the entity
     */
    protected void playStepSound(int par1, int par2, int par3, int par4)
    {
        StepSound var5 = Block.blocksList[par4].stepSound;

        if (this.worldObj.getBlockId(par1, par2 + 1, par3) == Block.snow.blockID)
        {
            var5 = Block.snow.stepSound;
        }

        if (!Block.blocksList[par4].blockMaterial.isLiquid())
        {
            int var6 = this.getHorseType();

            if (this.riddenByEntity != null && var6 != 1 && var6 != 2)
            {
                ++this.field_110285_bP;

                if (this.field_110285_bP > 5 && this.field_110285_bP % 3 == 0)
                {
                    this.playSound("mob.horse.gallop", var5.getVolume() * 0.15F, var5.getPitch());

                    if (var6 == 0 && this.rand.nextInt(10) == 0)
                    {
                        this.playSound("mob.horse.breathe", var5.getVolume() * 0.6F, var5.getPitch());
                    }
                }
                else if (this.field_110285_bP <= 5)
                {
                    this.playSound("mob.horse.wood", var5.getVolume() * 0.15F, var5.getPitch());
                }
            }
            else if (var5 == Block.soundWoodFootstep)
            {
                this.playSound("mob.horse.soft", var5.getVolume() * 0.15F, var5.getPitch());
            }
            else
            {
                this.playSound("mob.horse.wood", var5.getVolume() * 0.15F, var5.getPitch());
            }
        }
    }

    protected void applyEntityAttributes()
    {
        super.applyEntityAttributes();
        this.getAttributeMap().func_111150_b(horseJumpStrength);
        this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(10.0D);
        //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.17499999403953552D);
    }

    /**
     * Will return how many at most can spawn in a chunk at once.
     */
    public int getMaxSpawnedInChunk()
    {
        return 6;
    }

    public int getMaxTemper()
    {
        return 100;
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.8F;
    }

    /**
     * Get number of ticks, at least during which the living entity will be silent.
     */
    public int getTalkInterval()
    {
        return 400;
    }

    public boolean func_110239_cn()
    {
        return this.getHorseType() == 0 || this.func_110241_cb() > 0;
    }

    private void func_110230_cF()
    {
        this.field_110286_bQ = null;
    }

    private void setHorseTexturePaths()
    {
        this.field_110286_bQ = "/mobadditions/entity/mob/horse/";
        this.field_110280_bR[0] = null;
        this.field_110280_bR[1] = null;
        this.field_110280_bR[2] = null;
        int var1 = this.getHorseType();
        int var2 = this.getHorseVariant();
        int var3;

        if (var1 == 0)
        {
            var3 = var2 & 255;
            int var4 = (var2 & 65280) >> 8;
            this.field_110280_bR[0] = horseTextures[var3];
            this.field_110286_bQ = this.field_110286_bQ + field_110269_bA[var3];
            this.field_110280_bR[1] = horseMarkingTextures[var4];
            this.field_110286_bQ = this.field_110286_bQ + field_110292_bC[var4];
        }
        else
        {
            this.field_110280_bR[0] = "";
            this.field_110286_bQ = this.field_110286_bQ + "_" + var1 + "_";
        }

        var3 = this.func_110241_cb();
        this.field_110280_bR[2] = horseArmorTextures[var3];
        this.field_110286_bQ = this.field_110286_bQ + field_110273_bx[var3];
    }

    @Override
    @Environment(EnvType.CLIENT)
    public String getTexture()
    {
        if (this.field_110286_bQ == null)
        {
            this.setHorseTexturePaths();
        }

        return this.field_110286_bQ;
    }

    public String[] getVariantTexturePaths()
    {
        if (this.field_110286_bQ == null)
        {
            this.setHorseTexturePaths();
        }

        return this.field_110280_bR;
    }
/*
    public void openGUI(EntityPlayer par1EntityPlayer)
    {
        if (!this.worldObj.isRemote && (this.riddenByEntity == null || this.riddenByEntity == par1EntityPlayer) && this.isTame())
        {
            this.horseChest.func_110133_a(this.getEntityName());
            par1EntityPlayer.displayGUIHorse(this, this.horseChest);
        }
    }

 */

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer player) {
        ItemStack item = player.inventory.getCurrentItem();

        if (item != null && item.itemID == Item.monsterPlacer.itemID) {
            return super.interact(player);
        }
        else if (!this.isTame() && this.func_110256_cu()) {
            return false;
        }
        //else if (this.isTame() && this.isAdultHorse() && player.isSneaking()) {
            //this.openGUI(player);
           // return true;
       // }
        else if (this.func_110253_bW() && this.riddenByEntity != null) {
            return super.interact(player);
        }
        else {
            if (item != null) {
                boolean itemConsumed = false;

                /*if (this.func_110259_cr()) { // Can accept armor
                    byte var4 = -1;

                    if (item.itemID == Item.horseArmorIron.itemID) {
                        var4 = 1;
                    }
                    else if (item.itemID == Item.horseArmorGold.itemID) {
                        var4 = 2;
                    }
                    else if (item.itemID == Item.horseArmorDiamond.itemID) {
                        var4 = 3;
                    }

                    if (var4 >= 0) {
                        if (!this.isTame()) {
                            this.makeHorseRearWithSound();
                            return true;
                        }

                        this.openGUI(player);
                        return true;
                    }
                }*/

                if (!itemConsumed && !this.func_110256_cu()) {
                    float healAmount = 0.0F;

                    if (item.itemID == Item.wheat.itemID) {
                        healAmount = 2.0F;
                    }
                    else if (item.itemID == Item.sugar.itemID) {
                        healAmount = 1.0F;
                    }
                    else if (item.itemID == Item.bread.itemID) {
                        healAmount = 7.0F;
                    }
                    //else if (item.itemID == ModBlocks.hay.blockID) {
                       // healAmount = 20.0F;
                   //}
                    else if (item.itemID == Item.appleRed.itemID) {
                        healAmount = 3.0F;
                    }
                    else if (item.itemID == Item.goldenCarrot.itemID) {
                        healAmount = 4.0F;

                        if (this.isTame() && this.getGrowingAge() == 0) {
                            itemConsumed = true;
                            this.func_110196_bT();
                        }
                    }
                    else if (item.itemID == Item.appleGold.itemID) {
                        healAmount = 10.0F;

                        if (this.isTame() && this.getGrowingAge() == 0) {
                            itemConsumed = true;
                            this.func_110196_bT();
                        }
                    }

                    if (this.getHealth() < this.getMaxHealth() && healAmount > 0.0F) {
                        this.heal((int) healAmount);
                        itemConsumed = true;
                    }

                    if (itemConsumed) {
                        this.func_110266_cB();
                    }
                }

                if (!this.isTame() && !itemConsumed) {
                    //if (this.func_111282_a(getHeldItem(), this)) {
                       // return true;
                   // }

                    this.makeHorseRearWithSound();
                    return true;
                }

                /*if (!itemConsumed && this.func_110229_cs() && !this.isChested() && item.itemID == Block.chest.blockID) {
                    this.setChested(true);
                    this.playSound("mob.chickenplop", 1.0F, (this.rand.nextFloat() - this.rand.nextFloat()) * 0.2F + 1.0F);
                    itemConsumed = true;
                    this.func_110226_cD();
                }*/

                /*if (!itemConsumed && this.func_110253_bW() && !this.isHorseSaddled() && item.itemID == Item.saddle.itemID) {
                    this.openGUI(player);
                    return true;
                }*/

                if (itemConsumed) {
                    if (!player.capabilities.isCreativeMode && --item.stackSize == 0) {
                        player.inventory.setInventorySlotContents(player.inventory.currentItem, null);
                    }

                    return true;
                }
            }

            /*if (this.func_110253_bW() && this.riddenByEntity == null) {
                if (item != null && item.func_111282_a(player, this)) {
                    return true;
                }
                else {
                    this.func_110237_h(player);
                    return true;
                }
            }
            else {
                return super.interact(player);
            }*/

            return super.interact(player);
        }
    }

    private void func_110237_h(EntityPlayer par1EntityPlayer)
    {
        par1EntityPlayer.rotationYaw = this.rotationYaw;
        par1EntityPlayer.rotationPitch = this.rotationPitch;
        this.setEatingHaystack(false);
        this.setRearing(false);

        if (!this.worldObj.isRemote)
        {
            par1EntityPlayer.mountEntity(this);
        }
    }

    public boolean func_110259_cr()
    {
        return this.getHorseType() == 0;
    }

    public boolean func_110229_cs()
    {
        int var1 = this.getHorseType();
        return var1 == 2 || var1 == 1;
    }

    /**
     * Dead and sleeping entities cannot move
     */
    protected boolean isMovementBlocked()
    {
        return this.riddenByEntity != null && this.isHorseSaddled() ? true : this.isEatingHaystack() || this.isRearing();
    }

    public boolean func_110256_cu()
    {
        int var1 = this.getHorseType();
        return var1 == 3 || var1 == 4;
    }

    public boolean func_110222_cv()
    {
        return this.func_110256_cu() || this.getHorseType() == 2;
    }

    /**
     * Checks if the parameter is an item which this animal can be fed to breed it (wheat, carrots or seeds depending on
     * the animal type)
     */
    public boolean isBreedingItem(ItemStack item)
    {
        return item.itemID == Item.cake.itemID;
    }

    private void func_110210_cH()
    {
        this.field_110278_bp = 1;
    }

    /**
     * Called when the mob's health reaches 0.
     */
    public void onDeath(DamageSource par1DamageSource)
    {
        super.onDeath(par1DamageSource);

        if (!this.worldObj.isRemote)
        {
            this.dropChestItems();
        }
    }

    @Override
    protected void dropFewItems(boolean killedByPlayer, int lootingModifier) {
        if (!isStarving()) {
            int numDrops = rand.nextInt(3) + rand.nextInt(1 + lootingModifier) + 1;

            if (isFamished()) {
                numDrops = numDrops / 2;
            }

            for (int i = 0; i < numDrops; ++i) {
                dropItem(Item.leather.itemID, 1);
            }

            if (!hasHeadCrabbedSquid()) {
                numDrops = rand.nextInt(3) + 1 + rand.nextInt(1 + lootingModifier);

                if (isFamished()) {
                    numDrops = numDrops / 2;
                }

                for (int iTempCount = 0; iTempCount < numDrops; ++iTempCount) {
                    if (isBurning()) {
                        if (worldObj.getDifficulty().shouldBurningMobsDropCookedMeat()) {
                            dropItem(ModItems.cookedCheval.itemID, 1);
                        }
                        else {
                            dropItem(BTWItems.burnedMeat.itemID, 1);
                        }
                    }
                    else {
                        dropItem(ModItems.rawCheval.itemID, 1);
                    }
                }
            }
        }
    }

    /**
     * Called frequently so the entity can update its state every tick as required. For example, zombies and skeletons
     * use this to react to sunlight and start to burn.
     */
    public void onLivingUpdate()
    {
        if (this.rand.nextInt(200) == 0)
        {
            this.func_110210_cH();
        }

        super.onLivingUpdate();

        if (!this.worldObj.isRemote)
        {
            if (this.rand.nextInt(900) == 0 && this.deathTime == 0)
            {
                this.heal((int) 1.0F);
            }

            if (!this.isEatingHaystack() && this.riddenByEntity == null && this.rand.nextInt(300) == 0 && this.worldObj.getBlockId(MathHelper.floor_double(this.posX), MathHelper.floor_double(this.posY) - 1, MathHelper.floor_double(this.posZ)) == Block.grass.blockID)
            {
                this.setEatingHaystack(true);
            }

            if (this.isEatingHaystack() && ++this.eatingHaystackCounter > 50)
            {
                this.eatingHaystackCounter = 0;
                this.setEatingHaystack(false);
            }

            if (this.func_110205_ce() && !this.isAdultHorse() && !this.isEatingHaystack())
            {
                HorseEntity var1 = this.getClosestHorse(this, 16.0D);

                if (var1 != null && this.getDistanceSqToEntity(var1) > 4.0D)
                {
                    PathEntity var2 = this.worldObj.getPathEntityToEntity(this, var1, 16.0F, true, false, false, true);
                    this.setPathToEntity(var2);
                }
            }
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public boolean hasObjectChanged()
    {
        return this.objectChanged;
    }

    public void onUpdate()
    {
        super.onUpdate();

        if (this.worldObj.isRemote && this.hasObjectChanged())
        {
            this.func_111144_e();
            this.func_110230_cF();
        }

        if (this.openMouthCounter > 0 && ++this.openMouthCounter > 30)
        {
            this.openMouthCounter = 0;
            this.setHorseWatchableBoolean(128, false);
        }

        if (!this.worldObj.isRemote && this.jumpRearingCounter > 0 && ++this.jumpRearingCounter > 20)
        {
            this.jumpRearingCounter = 0;
            this.setRearing(false);
        }

        if (this.field_110278_bp > 0 && ++this.field_110278_bp > 8)
        {
            this.field_110278_bp = 0;
        }

        if (this.field_110279_bq > 0)
        {
            ++this.field_110279_bq;

            if (this.field_110279_bq > 300)
            {
                this.field_110279_bq = 0;
            }
        }

        this.prevHeadLean = this.headLean;

        if (this.isEatingHaystack())
        {
            this.headLean += (1.0F - this.headLean) * 0.4F + 0.05F;

            if (this.headLean > 1.0F)
            {
                this.headLean = 1.0F;
            }
        }
        else
        {
            this.headLean += (0.0F - this.headLean) * 0.4F - 0.05F;

            if (this.headLean < 0.0F)
            {
                this.headLean = 0.0F;
            }
        }

        this.prevRearingAmount = this.rearingAmount;

        if (this.isRearing())
        {
            this.prevHeadLean = this.headLean = 0.0F;
            this.rearingAmount += (1.0F - this.rearingAmount) * 0.4F + 0.05F;

            if (this.rearingAmount > 1.0F)
            {
                this.rearingAmount = 1.0F;
            }
        }
        else
        {
            this.field_110294_bI = false;
            this.rearingAmount += (0.8F * this.rearingAmount * this.rearingAmount * this.rearingAmount - this.rearingAmount) * 0.6F - 0.05F;

            if (this.rearingAmount < 0.0F)
            {
                this.rearingAmount = 0.0F;
            }
        }

        this.prevMouthOpenness = this.mouthOpenness;

        if (this.getHorseWatchableBoolean(128))
        {
            this.mouthOpenness += (1.0F - this.mouthOpenness) * 0.7F + 0.05F;

            if (this.mouthOpenness > 1.0F)
            {
                this.mouthOpenness = 1.0F;
            }
        }
        else
        {
            this.mouthOpenness += (0.0F - this.mouthOpenness) * 0.7F - 0.05F;

            if (this.mouthOpenness < 0.0F)
            {
                this.mouthOpenness = 0.0F;
            }
        }
    }

    @Override
    public int getMaxHealth() {
        return 30;
    }
    private void openHorseMouth()
    {
        if (!this.worldObj.isRemote)
        {
            this.openMouthCounter = 1;
            this.setHorseWatchableBoolean(128, true);
        }
    }

    private boolean func_110200_cJ()
    {
        return this.riddenByEntity == null && this.ridingEntity == null && this.isTame() && this.isAdultHorse() && !this.func_110222_cv() && this.getHealth() >= this.getMaxHealth();
    }

    public void setEating(boolean par1)
    {
        this.setHorseWatchableBoolean(32, par1);
    }

    public void setEatingHaystack(boolean par1)
    {
        this.setEating(par1);
    }

    public void setRearing(boolean par1)
    {
        if (par1)
        {
            this.setEatingHaystack(false);
        }

        this.setHorseWatchableBoolean(64, par1);
    }

    private void makeHorseRear()
    {
        if (!this.worldObj.isRemote)
        {
            this.jumpRearingCounter = 1;
            this.setRearing(true);
        }
    }

    public void makeHorseRearWithSound()
    {
        this.makeHorseRear();
        String var1 = this.getAngrySoundName();

        if (var1 != null)
        {
            this.playSound(var1, this.getSoundVolume(), this.getSoundPitch());
        }
    }

    public void dropChestItems()
    {
        this.dropItemsInChest(this, this.horseChest);
        this.dropChests();
    }

    private void dropItemsInChest(Entity par1Entity, AnimalChest par2AnimalChest)
    {
        if (par2AnimalChest != null && !this.worldObj.isRemote)
        {
            for (int var3 = 0; var3 < par2AnimalChest.getSizeInventory(); ++var3)
            {
                ItemStack var4 = par2AnimalChest.getStackInSlot(var3);

                if (var4 != null)
                {
                    this.entityDropItem(var4, 0.0F);
                }
            }
        }
    }

    public boolean setTamedBy(EntityPlayer par1EntityPlayer)
    {
        this.setOwnerName(par1EntityPlayer.getCommandSenderName());
        this.setHorseTamed(true);
        return true;
    }

    /**
     * Moves the entity based on the specified heading.  Args: strafe, forward
     */
    public void moveEntityWithHeading(float par1, float par2)
    {
        if (this.riddenByEntity != null && this.isHorseSaddled())
        {
            this.prevRotationYaw = this.rotationYaw = this.riddenByEntity.rotationYaw;
            this.rotationPitch = this.riddenByEntity.rotationPitch * 0.5F;
            this.setRotation(this.rotationYaw, this.rotationPitch);
            this.rotationYawHead = this.renderYawOffset = this.rotationYaw;
            par1 = ((EntityLivingBase)this.riddenByEntity).moveStrafing * 0.5F;
            par2 = ((EntityLivingBase)this.riddenByEntity).moveForward;

            if (par2 <= 0.0F)
            {
                par2 *= 0.25F;
                this.field_110285_bP = 0;
            }

            if (this.onGround && this.jumpPower == 0.0F && this.isRearing() && !this.field_110294_bI)
            {
                par1 = 0.0F;
                par2 = 0.0F;
            }

            if (this.jumpPower > 0.0F && !this.isHorseJumping() && this.onGround)
            {
                this.motionY = this.getHorseJumpStrength() * (double)this.jumpPower;

                if (this.isPotionActive(Potion.jump))
                {
                    this.motionY += (double)((float)(this.getActivePotionEffect(Potion.jump).getAmplifier() + 1) * 0.1F);
                }

                this.setHorseJumping(true);
                this.isAirBorne = true;

                if (par2 > 0.0F)
                {
                    float var3 = MathHelper.sin(this.rotationYaw * (float)Math.PI / 180.0F);
                    float var4 = MathHelper.cos(this.rotationYaw * (float)Math.PI / 180.0F);
                    this.motionX += (double)(-0.4F * var3 * this.jumpPower);
                    this.motionZ += (double)(0.4F * var4 * this.jumpPower);
                    this.playSound("mob.horse.jump", 0.4F, 1.0F);
                }

                this.jumpPower = 0.0F;
            }

            this.stepHeight = 1.0F;
            this.jumpMovementFactor = this.getAIMoveSpeed() * 0.1F;

            if (!this.worldObj.isRemote)
            {
                //this.setAIMoveSpeed((float)this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue());
                super.moveEntityWithHeading(par1, par2);
            }

            if (this.onGround)
            {
                this.jumpPower = 0.0F;
                this.setHorseJumping(false);
            }

            this.prevLimbSwingAmount = this.limbSwingAmount;
            double var8 = this.posX - this.prevPosX;
            double var5 = this.posZ - this.prevPosZ;
            float var7 = MathHelper.sqrt_double(var8 * var8 + var5 * var5) * 4.0F;

            if (var7 > 1.0F)
            {
                var7 = 1.0F;
            }

            this.limbSwingAmount += (var7 - this.limbSwingAmount) * 0.4F;
            this.limbSwing += this.limbSwingAmount;
        }
        else
        {
            this.stepHeight = 0.5F;
            this.jumpMovementFactor = 0.02F;
            super.moveEntityWithHeading(par1, par2);
        }
    }

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setBoolean("EatingHaystack", this.isEatingHaystack());
        par1NBTTagCompound.setBoolean("ChestedHorse", this.isChested());
        par1NBTTagCompound.setBoolean("HasReproduced", this.getHasReproduced());
        par1NBTTagCompound.setBoolean("Bred", this.func_110205_ce());
        par1NBTTagCompound.setInteger("Type", this.getHorseType());
        par1NBTTagCompound.setInteger("Variant", this.getHorseVariant());
        par1NBTTagCompound.setInteger("Temper", this.getTemper());
        par1NBTTagCompound.setBoolean("Tame", this.isTame());
        par1NBTTagCompound.setString("OwnerName", this.getOwnerName());

        if (this.isChested())
        {
            NBTTagList var2 = new NBTTagList();

            for (int var3 = 2; var3 < this.horseChest.getSizeInventory(); ++var3)
            {
                ItemStack var4 = this.horseChest.getStackInSlot(var3);

                if (var4 != null)
                {
                    NBTTagCompound var5 = new NBTTagCompound();
                    var5.setByte("Slot", (byte)var3);
                    var4.writeToNBT(var5);
                    var2.appendTag(var5);
                }
            }

            par1NBTTagCompound.setTag("Items", var2);
        }

        if (this.horseChest.getStackInSlot(1) != null)
        {
            par1NBTTagCompound.setTag("ArmorItem", this.horseChest.getStackInSlot(1).writeToNBT(new NBTTagCompound("ArmorItem")));
        }

        if (this.horseChest.getStackInSlot(0) != null)
        {
            par1NBTTagCompound.setTag("SaddleItem", this.horseChest.getStackInSlot(0).writeToNBT(new NBTTagCompound("SaddleItem")));
        }
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setEatingHaystack(par1NBTTagCompound.getBoolean("EatingHaystack"));
        this.func_110242_l(par1NBTTagCompound.getBoolean("Bred"));
        this.setChested(par1NBTTagCompound.getBoolean("ChestedHorse"));
        this.setHasReproduced(par1NBTTagCompound.getBoolean("HasReproduced"));
        this.setHorseType(par1NBTTagCompound.getInteger("Type"));
        this.setHorseVariant(par1NBTTagCompound.getInteger("Variant"));
        this.setTemper(par1NBTTagCompound.getInteger("Temper"));
        this.setHorseTamed(par1NBTTagCompound.getBoolean("Tame"));

        if (par1NBTTagCompound.hasKey("OwnerName"))
        {
            this.setOwnerName(par1NBTTagCompound.getString("OwnerName"));
        }

        //AttributeInstance var2 = this.getAttributeMap().getAttributeInstanceByName("Speed");

        //if (var2 != null)
        //{
            //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(var2.getBaseValue() * 0.15D);
        //}

        if (this.isChested())
        {
            NBTTagList var3 = par1NBTTagCompound.getTagList("Items");
            this.func_110226_cD();

            for (int var4 = 0; var4 < var3.tagCount(); ++var4)
            {
                NBTTagCompound var5 = (NBTTagCompound)var3.tagAt(var4);
                int var6 = var5.getByte("Slot") & 255;

                if (var6 >= 2 && var6 < this.horseChest.getSizeInventory())
                {
                    this.horseChest.setInventorySlotContents(var6, ItemStack.loadItemStackFromNBT(var5));
                }
            }
        }

        ItemStack var7;

        if (par1NBTTagCompound.hasKey("ArmorItem"))
        {
            var7 = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("ArmorItem"));

            if (var7 != null && func_110211_v(var7.itemID))
            {
                this.horseChest.setInventorySlotContents(1, var7);
            }
        }

        if (par1NBTTagCompound.hasKey("SaddleItem"))
        {
            var7 = ItemStack.loadItemStackFromNBT(par1NBTTagCompound.getCompoundTag("SaddleItem"));

            if (var7 != null && var7.itemID == Item.saddle.itemID)
            {
                this.horseChest.setInventorySlotContents(0, var7);
            }
        }
        else if (par1NBTTagCompound.getBoolean("Saddle"))
        {
            this.horseChest.setInventorySlotContents(0, new ItemStack(Item.saddle));
        }

        this.func_110232_cE();
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal par1EntityAnimal)
    {
        if (par1EntityAnimal == this)
        {
            return false;
        }
        else if (par1EntityAnimal.getClass() != this.getClass())
        {
            return false;
        }
        else
        {
            HorseEntity var2 = (HorseEntity)par1EntityAnimal;

            if (this.func_110200_cJ() && var2.func_110200_cJ())
            {
                int var3 = this.getHorseType();
                int var4 = var2.getHorseType();
                return var3 == var4 || var3 == 0 && var4 == 1 || var3 == 1 && var4 == 0;
            }
            else
            {
                return false;
            }
        }
    }

    public EntityAgeable createChild(EntityAgeable par1EntityAgeable)
    {
        HorseEntity var2 = (HorseEntity)par1EntityAgeable;
        HorseEntity var3 = new HorseEntity(this.worldObj);
        int var4 = this.getHorseType();
        int var5 = var2.getHorseType();
        int var6 = 0;

        if (var4 == var5)
        {
            var6 = var4;
        }
        else if (var4 == 0 && var5 == 1 || var4 == 1 && var5 == 0)
        {
            var6 = 2;
        }

        if (var6 == 0)
        {
            int var8 = this.rand.nextInt(9);
            int var7;

            if (var8 < 4)
            {
                var7 = this.getHorseVariant() & 255;
            }
            else if (var8 < 8)
            {
                var7 = var2.getHorseVariant() & 255;
            }
            else
            {
                var7 = this.rand.nextInt(7);
            }

            int var9 = this.rand.nextInt(5);

            if (var9 < 4)
            {
                var7 |= this.getHorseVariant() & 65280;
            }
            else if (var9 < 8)
            {
                var7 |= var2.getHorseVariant() & 65280;
            }
            else
            {
                var7 |= this.rand.nextInt(5) << 8 & 65280;
            }

            var3.setHorseVariant(var7);
        }

        var3.setHorseType(var6);

        double var14 = this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getBaseValue() + (double)this.func_110267_cL();
        var3.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(var14 / 3.0D);
        double var13 = this.getEntityAttribute(horseJumpStrength).getBaseValue() + this.getEntityAttribute(horseJumpStrength).getBaseValue() + this.func_110245_cM();
        var3.getEntityAttribute(horseJumpStrength).setAttribute(var13 / 3.0D);
        //double var11 = this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getBaseValue() + this.func_110203_cN();
        //var3.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(var11 / 0.15D);

        return var3;
    }
    public AttributeInstance getEntityAttribute(Attribute par1Attribute)
    {
        return this.getAttributeMap().getAttributeInstance(par1Attribute);
    }


    public EntityLivingData onSpawnWithEgg(EntityLivingData par1EntityLivingData)
    {
        Object par1EntityLivingData1 = super.onSpawnWithEgg(par1EntityLivingData);
        boolean var2 = false;
        int var3 = 0;
        int var7;

        if (par1EntityLivingData1 instanceof HorseEntityGroupData)
        {
            var7 = ((HorseEntityGroupData)par1EntityLivingData1).field_111107_a;
            var3 = ((HorseEntityGroupData)par1EntityLivingData1).field_111106_b & 255 | this.rand.nextInt(5) << 8;
        }
        else
        {
            if (this.rand.nextInt(10) == 0)
            {
                var7 = 1;
            }
            else
            {
                int var4 = this.rand.nextInt(7);
                int var5 = this.rand.nextInt(5);
                var7 = 0;
                var3 = var4 | var5 << 8;
            }

            par1EntityLivingData1 = new HorseEntityGroupData(var7, var3);
        }

        this.setHorseType(var7);
        this.setHorseVariant(var3);

        if (this.rand.nextInt(5) == 0)
        {
            this.setGrowingAge(-24000);
        }


        if (var7 != 4 && var7 != 3)
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute((double)this.func_110267_cL());

            if (var7 == 0)
            {
                //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(this.func_110203_cN());
            }
            else
            {
                //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.17499999701976776D);
            }
        }
        else
        {
            this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(15.0D);
            //this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(0.15000000298023224D);
        }

        if (var7 != 2 && var7 != 1)
        {
            this.getEntityAttribute(horseJumpStrength).setAttribute(this.func_110245_cM());
        }
        else
        {
            this.getEntityAttribute(horseJumpStrength).setAttribute(0.5D);
        }


        return (EntityLivingData)par1EntityLivingData1;
    }

    public float getGrassEatingAmount(float par1)
    {
        return this.prevHeadLean + (this.headLean - this.prevHeadLean) * par1;
    }

    public float getRearingAmount(float par1)
    {
        return this.prevRearingAmount + (this.rearingAmount - this.prevRearingAmount) * par1;
    }

    public float func_110201_q(float par1)
    {
        return this.prevMouthOpenness + (this.mouthOpenness - this.prevMouthOpenness) * par1;
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    protected boolean isAIEnabled()
    {
        return true;
    }

    public void setJumpPower(int par1)
    {
        if (this.isHorseSaddled())
        {
            if (par1 < 0)
            {
                par1 = 0;
            }
            else
            {
                this.field_110294_bI = true;
                this.makeHorseRear();
            }

            if (par1 >= 90)
            {
                this.jumpPower = 1.0F;
            }
            else
            {
                this.jumpPower = 0.4F + 0.4F * (float)par1 / 90.0F;
            }
        }
    }

    /**
     * "Spawns particles for the horse entity. par1 tells whether to spawn hearts. If it is false, it spawns smoke."
     */
    protected void spawnHorseParticles(boolean par1)
    {
        String var2 = par1 ? "heart" : "smoke";

        for (int var3 = 0; var3 < 7; ++var3)
        {
            double var4 = this.rand.nextGaussian() * 0.02D;
            double var6 = this.rand.nextGaussian() * 0.02D;
            double var8 = this.rand.nextGaussian() * 0.02D;
            this.worldObj.spawnParticle(var2, this.posX + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, this.posY + 0.5D + (double)(this.rand.nextFloat() * this.height), this.posZ + (double)(this.rand.nextFloat() * this.width * 2.0F) - (double)this.width, var4, var6, var8);
        }
    }

    public void handleHealthUpdate(byte par1)
    {
        if (par1 == 7)
        {
            this.spawnHorseParticles(true);
        }
        else if (par1 == 6)
        {
            this.spawnHorseParticles(false);
        }
        else
        {
            super.handleHealthUpdate(par1);
        }
    }

    public void updateRiderPosition()
    {
        super.updateRiderPosition();

        if (this.prevRearingAmount > 0.0F)
        {
            float var1 = MathHelper.sin(this.renderYawOffset * (float)Math.PI / 180.0F);
            float var2 = MathHelper.cos(this.renderYawOffset * (float)Math.PI / 180.0F);
            float var3 = 0.7F * this.prevRearingAmount;
            float var4 = 0.15F * this.prevRearingAmount;
            this.riddenByEntity.setPosition(this.posX + (double)(var3 * var1), this.posY + this.getMountedYOffset() + this.riddenByEntity.getYOffset() + (double)var4, this.posZ - (double)(var3 * var2));

            if (this.riddenByEntity instanceof EntityLivingBase)
            {
                ((EntityLivingBase)this.riddenByEntity).renderYawOffset = this.renderYawOffset;
            }
        }
    }

    private float func_110267_cL()
    {
        return 15.0F + (float)this.rand.nextInt(8) + (float)this.rand.nextInt(9);
    }

    private double func_110245_cM()
    {
        return 0.4000000059604645D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D + this.rand.nextDouble() * 0.2D;
    }

    private double func_110203_cN()
    {
        return (0.44999998807907104D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D + this.rand.nextDouble() * 0.3D) * 0.25D;
    }

    public static boolean func_110211_v(int par0)
    {
        return par0 == ModItems.horseArmorIron.itemID || par0 == ModItems.horseArmorGold.itemID || par0 == ModItems.horseArmorDiamond.itemID;
    }

    /**
     * returns true if this entity is by a ladder, false otherwise
     */
    public boolean isOnLadder()
    {
        return false;
    }

    @Override
    public boolean isValidZombieSecondaryTarget(EntityZombie zombie) {
        return true;
    }

    @Override
    public boolean isSubjectToHunger() {
        return true;
    }

    @Override
    public boolean getCanCreatureTypeBePossessed() {
        return true;
    }
    public void func_110196_bT()
    {
        this.inLove = 600;
        this.entityToAttack = null;
        this.worldObj.setEntityState(this, (byte)18);
    }
    public void func_111144_e()
    {
        this.objectChanged = false;
    }
    //public static boolean func_111282_a(ItemStack itemStack, EntityLiving par2EntityLiving)
    //{
       // return Item.itemsList[itemStack.itemID].itemInteractionForEntity(itemStack, par2EntityLiving);
    //}
}