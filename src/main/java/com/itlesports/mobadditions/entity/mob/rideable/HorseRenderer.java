package com.itlesports.mobadditions.entity.mob.rideable;

import com.google.common.collect.Maps;
import java.util.Map;

import org.lwjgl.opengl.GL11;
import net.minecraft.src.*;
public class HorseRenderer extends RenderLiving
{
    private static final Map field_110852_a = Maps.newHashMap();
    private static final ResourceLocation whiteHorseTextures = new ResourceLocation("textures/entity/horse/horse_white.png");
    private static final ResourceLocation muleTextures = new ResourceLocation("textures/entity/horse/mule.png");
    private static final ResourceLocation donkeyTextures = new ResourceLocation("textures/entity/horse/donkey.png");
    private static final ResourceLocation zombieHorseTextures = new ResourceLocation("textures/entity/horse/horse_zombie.png");
    private static final ResourceLocation skeletonHorseTextures = new ResourceLocation("textures/entity/horse/horse_skeleton.png");

    public HorseRenderer(ModelBase par1ModelBase, HorseModel horseModel, float par2)
    {
        super(par1ModelBase, par2);
    }

    protected void func_110847_a(HorseEntity par1HorseEntity, float par2)
    {
        float var3 = 1.0F;
        int var4 = par1HorseEntity.getHorseType();

        if (var4 == 1)
        {
            var3 *= 0.87F;
        }
        else if (var4 == 2)
        {
            var3 *= 0.92F;
        }

        GL11.glScalef(var3, var3, var3);
        super.preRenderCallback(par1HorseEntity, par2);
    }

    protected void func_110846_a(HorseEntity par1HorseEntity, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        if (par1HorseEntity.isInvisible())
        {
            this.mainModel.setRotationAngles(par2, par3, par4, par5, par6, par7, par1HorseEntity);
        }
        else
        {
            //this.bindEntityTexture(par1HorseEntity);
            this.mainModel.render(par1HorseEntity, par2, par3, par4, par5, par6, par7);
        }
    }

    protected ResourceLocation func_110849_a(HorseEntity par1HorseEntity)
    {
        if (!par1HorseEntity.func_110239_cn())
        {
            switch (par1HorseEntity.getHorseType())
            {
                case 0:
                default:
                    return whiteHorseTextures;

                case 1:
                    return donkeyTextures;

                case 2:
                    return muleTextures;

                case 3:
                    return zombieHorseTextures;

                case 4:
                    return skeletonHorseTextures;
            }
        }
        else
        {
            return this.func_110848_b(par1HorseEntity);
        }
    }

    private ResourceLocation func_110848_b(HorseEntity par1HorseEntity)
    {
        String var2 = par1HorseEntity.getHorseTexture();
        ResourceLocation var3 = (ResourceLocation)field_110852_a.get(var2);

        if (var3 == null)
        {
            var3 = new ResourceLocation(var2);
            //Minecraft.getMinecraft().getTextureManager().loadTexture(var3, new LayeredTexture(par1HorseEntity.getVariantTexturePaths()));
            field_110852_a.put(var2, var3);
        }

        return var3;
    }

    /**
     * Allows the render to do any OpenGL state modifications necessary before the model is rendered. Args:
     * entityLiving, partialTickTime
     */
    protected void preRenderCallback(EntityLiving par1EntityLiving, float par2)
    {
        this.func_110847_a((HorseEntity)par1EntityLiving, par2);
    }

    /**
     * Renders the model in RenderLiving
     */
    protected void renderModel(EntityLiving par1EntityLiving, float par2, float par3, float par4, float par5, float par6, float par7)
    {
        this.func_110846_a((HorseEntity)par1EntityLiving, par2, par3, par4, par5, par6, par7);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Entity par1Entity)
    {
        return this.func_110849_a((HorseEntity)par1Entity);
    }
}