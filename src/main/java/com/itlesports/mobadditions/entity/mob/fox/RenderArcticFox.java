package com.itlesports.mobadditions.entity.mob.fox;


import com.prupe.mcpatcher.cc.ColorizeEntity;
import com.prupe.mcpatcher.mal.resource.FakeResourceLocation;
import com.prupe.mcpatcher.mob.MobRandomizer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.*;
import org.lwjgl.opengl.GL11;

@Environment(EnvType.CLIENT)
public class RenderArcticFox extends RenderLiving
{
    public RenderArcticFox(ModelBase par1ModelBase, ModelBase par2ModelBase, float par3)
    {
        super(par1ModelBase, par3);
        this.setRenderPassModel(par2ModelBase);
    }

    protected float getTailRotation(ArcticFoxEntity par1ArcticFoxEntity, float par2)
    {
        return par1ArcticFoxEntity.getTailRotation();
    }

    protected int func_82447_a(ArcticFoxEntity par1ArcticFoxEntity, int par2, float par3)
    {
        float var4;

        if (par2 == 0 && par1ArcticFoxEntity.getWolfShaking())
        {
            var4 = par1ArcticFoxEntity.getBrightness(par3) * par1ArcticFoxEntity.getShadingWhileShaking(par3);
            this.loadTexture(par1ArcticFoxEntity.getTexture());
            GL11.glColor3f(var4, var4, var4);
            return 1;
        }
        else if (par2 == 1 && par1ArcticFoxEntity.isTamed())
        {
            this.loadTexture(FakeResourceLocation.unwrap(MobRandomizer.randomTexture((Entity)par1ArcticFoxEntity, FakeResourceLocation.wrap("/mob/wolf_collar.png"))));
            var4 = 1.0F;
            int var5 = par1ArcticFoxEntity.getCollarColor();
            GL11.glColor3f(var4 * ColorizeEntity.getWolfCollarColor(EntitySheep.fleeceColorTable[var5], var5)[0], var4 * ColorizeEntity.getWolfCollarColor(EntitySheep.fleeceColorTable[var5], var5)[1], var4 * ColorizeEntity.getWolfCollarColor(EntitySheep.fleeceColorTable[var5], var5)[2]);
            return 1;
        }
        else
        {
            return -1;
        }
    }

    /**
     * Queries whether should render the specified pass or not.
     */
    protected int shouldRenderPass(EntityLiving par1EntityLiving, int par2, float par3)
    {
        return this.func_82447_a((ArcticFoxEntity) par1EntityLiving, par2, par3);
    }

    /**
     * Defines what float the third param in setRotationAngles of ModelBase is
     */
    protected float handleRotationFloat(EntityLiving par1EntityLiving, float par2)
    {
        return this.getTailRotation((ArcticFoxEntity) par1EntityLiving, par2);
    }
}

