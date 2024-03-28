// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.5.2
// Paste this class into your mod and call render() in your Entity Render class
// Note: You may need to adjust the y values of the 'setRotationPoint's

package com.itlesports.mobadditions.entity.mob.rideable.horse;

import net.minecraft.src.*;

public class HorseModel extends ModelBase {
	private final ModelRenderer Body;
	private final ModelRenderer TailA;
	private final ModelRenderer Leg1A;
	private final ModelRenderer Leg2A;
	private final ModelRenderer Leg3A;
	private final ModelRenderer Leg4A;
	private final ModelRenderer Head;
	private final ModelRenderer Ear1;
	private final ModelRenderer Ear2;
	private final ModelRenderer MuleEarL;
	private final ModelRenderer MuleEarR;
	private final ModelRenderer Neck;
	private final ModelRenderer Bag1;
	private final ModelRenderer Bag2;
	private final ModelRenderer Saddle;
	private final ModelRenderer SaddleMouthL;
	private final ModelRenderer SaddleMouthR;
	private final ModelRenderer SaddleMouthLine;
	private final ModelRenderer SaddleMouthLineR;
	private final ModelRenderer HeadSaddle;

	public HorseModel() {
		textureWidth = 64;
		textureHeight = 64;

		Body = new ModelRenderer(this);
		Body.setRotationPoint(0.0F, 11.0F, 9.0F);
		this.Body.setTextureOffset(0, 32).addBox(-5.0F, -8.0F, -20.0F, 10, 10, 22, 0.0F);

		TailA = new ModelRenderer(this);
		TailA.setRotationPoint(0.0F, 4.0F, 11.0F);
		setRotation(TailA, 0.5236F, 0.0F, 0.0F);
		this.TailA.setTextureOffset(42, 36).addBox(-1.5F, 0.0F, -2.0F, 3, 14, 4, 0.0F);

		Leg1A = new ModelRenderer(this);
		Leg1A.setRotationPoint(3.0F, 13.0F, 9.0F);
		this.Leg1A.setTextureOffset(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);

		Leg2A = new ModelRenderer(this);
		Leg2A.setRotationPoint(-3.0F, 13.0F, 9.0F);
		this.Leg2A.setTextureOffset(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);

		Leg3A = new ModelRenderer(this);
		Leg3A.setRotationPoint(3.0F, 13.0F, -9.0F);
		this.Leg3A.setTextureOffset(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);

		Leg4A = new ModelRenderer(this);
		Leg4A.setRotationPoint(-3.0F, 13.0F, -9.0F);
		this.Leg4A.setTextureOffset(48, 21).addBox(-2.0F, 0.0F, -2.0F, 4, 11, 4, 0.0F);

		Head = new ModelRenderer(this);
		Head.setRotationPoint(0.0F, -4.0F, -11.0F);
		setRotation(Head, -0.1047F, 0.0873F, 0.0F);
		this.Head.setTextureOffset(0, 13).addBox(-3.0F, -5.0F, -6.0F, 6, 5, 7, 0.0F);
		this.Head.setTextureOffset(0, 25).addBox(-2.0F, -5.0F, -11.0F, 4, 5, 5, 0.0F);

		Ear1 = new ModelRenderer(this);
		Ear1.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(Ear1, 0.5236F, 0.0F, 0.0873F);
		this.Ear1.setTextureOffset(19, 16).addBox(-0.5F, -18.0F, 2.99F, 2, 3, 1, 0.0F);

		Ear2 = new ModelRenderer(this);
		Ear2.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(Ear2, 0.5236F, 0.0F, -0.0873F);
		this.Ear2.setTextureOffset(19, 16).addBox(-1.5F, -18.0F, 2.99F, 2, 3, 1, 0.0F);

		MuleEarL = new ModelRenderer(this);
		MuleEarL.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(MuleEarL, 0.5236F, 0.0F, 0.2618F);
		this.MuleEarL.setTextureOffset(0, 12).addBox(-3.0F, -22.0F, 2.99F, 2, 7, 1, 0.0F);

		MuleEarR = new ModelRenderer(this);
		MuleEarR.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(MuleEarR, 0.5236F, 0.0F, -0.2618F);
		this.MuleEarR.setTextureOffset(0, 12).addBox(1.0F, -22.0F, 2.99F, 2, 7, 1, 0.0F);

		Neck = new ModelRenderer(this);
		Neck.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(Neck, 0.5236F, 0.0F, 0.0F);
		this.Neck.setTextureOffset(0, 35).addBox(-2.0F, -11.0F, -3.0F, 4, 12, 7, 0.0F);
		this.Neck.setTextureOffset(56, 36).addBox(-1.0F, -16.0F, 4.0F, 2, 16, 2, 0.0F);

		Bag1 = new ModelRenderer(this);
		Bag1.setRotationPoint(-5.0F, 3.0F, 11.0F);
		setRotation(Bag1, 0.0F, -1.5708F, 0.0F);
		this.Bag1.setTextureOffset(26, 21).addBox(-9.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F);

		Bag2 = new ModelRenderer(this);
		Bag2.setRotationPoint(5.0F, 3.0F, 11.0F);
		setRotation(Bag2, 0.0F, 1.5708F, 0.0F);
		this.Bag2.setTextureOffset(26, 21).addBox(1.0F, 0.0F, 0.0F, 8, 8, 3, 0.0F);

		Saddle = new ModelRenderer(this);
		Saddle.setRotationPoint(0.0F, 2.0F, 2.0F);
		this.Saddle.setTextureOffset(26, 0).addBox(-5.0F, 1.0F, -5.5F, 10, 9, 9, 0.5F);

		SaddleMouthL = new ModelRenderer(this);
		SaddleMouthL.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(SaddleMouthL, 0.5236F, 0.0F, 0.0F);
		this.SaddleMouthL.setTextureOffset(29, 5).addBox(2.0F, -14.0F, -6.0F, 1, 2, 2, 0.0F);

		SaddleMouthR = new ModelRenderer(this);
		SaddleMouthR.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(SaddleMouthR, 0.5236F, 0.0F, 0.0F);
		this.SaddleMouthR.setTextureOffset(29, 5).addBox(-3.0F, -14.0F, -6.0F, 1, 2, 2, 0.0F);

		SaddleMouthLine = new ModelRenderer(this);
		SaddleMouthLine.setRotationPoint(0.0F, 7.0F, -8.0F);
		this.SaddleMouthLine.setTextureOffset(32, 2).addBox(3.1F, -10.0F, -11.5F, 0, 3, 16, 0.0F);

		SaddleMouthLineR = new ModelRenderer(this);
		SaddleMouthLineR.setRotationPoint(0.0F, 7.0F, -8.0F);
		this.SaddleMouthLineR.setTextureOffset(32, 2).addBox(-3.1F, -10.0F, -11.5F, 0, 3, 16, 0.0F);

		HeadSaddle = new ModelRenderer(this);
		HeadSaddle.setRotationPoint(0.0F, 7.0F, -8.0F);
		setRotation(HeadSaddle, 0.5236F, 0.0F, 0.0F);
		this.HeadSaddle.setTextureOffset(19, 0).addBox(-2.0F, -16.0F, -5.0F, 4, 5, 2, 0.25F);
		this.HeadSaddle.setTextureOffset(0, 0).addBox(-3.0F, -16.0F, -3.0F, 6, 5, 7, 0.25F);
	}

	/**
	* Sets the models various rotation angles then renders the model.
	*/
	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		this.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
		Body.render(f5);
		TailA.render(f5);
		Leg1A.render(f5);
		Leg2A.render(f5);
		Leg3A.render(f5);
		Leg4A.render(f5);
		Head.render(f5);
		Ear1.render(f5);
		Ear2.render(f5);
		MuleEarL.render(f5);
		MuleEarR.render(f5);
		Neck.render(f5);
		Bag1.render(f5);
		Bag2.render(f5);
		Saddle.render(f5);
		SaddleMouthL.render(f5);
		SaddleMouthR.render(f5);
		SaddleMouthLine.render(f5);
		SaddleMouthLineR.render(f5);
		HeadSaddle.render(f5);
	}

	/**
	* Sets the model's various rotation angles. For bipeds, f and f1 are used for animating the movement of arms
	* and legs, where f represents the time(so that arms and legs swing back and forth) and f1 represents how
	* "far" arms and legs can swing at most.
	*/
	@Override
    public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity) {

    }
	
	/**
	*	Sets the rotation of a ModelRenderer. Only called if the ModelRenderer has a rotation
	*/
    public void setRotation(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}