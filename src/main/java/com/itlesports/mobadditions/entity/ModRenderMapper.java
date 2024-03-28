package com.itlesports.mobadditions.entity;

import btw.client.render.entity.WolfRenderer;
import btw.entity.mob.WolfEntity;
import com.itlesports.mobadditions.entity.mob.fox.*;
import com.itlesports.mobadditions.entity.mob.rideable.HorseEntity;
import com.itlesports.mobadditions.entity.mob.rideable.HorseModel;
import com.itlesports.mobadditions.entity.mob.rideable.HorseRenderer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.src.ModelWolf;
import net.minecraft.src.RenderManager;

@Environment(EnvType.CLIENT)
public class ModRenderMapper {
    public static void createTileEntityRenderers() {

    }
    public static void createModEntityRenderers() {
        RenderManager.addEntityRenderer(FoxEntity.class, new FoxRenderer(new FoxEntityModel(), new FoxEntityModel(), 0.5F));
        RenderManager.addEntityRenderer(ArcticFoxEntity.class, new ArcticFoxRenderer(new ArcticFoxEntityModel(), new ArcticFoxEntityModel(), 0.5F));
        RenderManager.addEntityRenderer(HorseEntity.class, new HorseRenderer(new HorseModel(), new HorseModel(), 1.5F));
    }
}
