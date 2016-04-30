package modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class TranscrafterModel extends ModelBase {
	// fields
	public ModelRenderer	Middle;
	public ModelRenderer	Bottom;
	public ModelRenderer	Top_bit_1;
	public ModelRenderer	Top_bit_2;
	public ModelRenderer	Top_bit_3;
	public ModelRenderer	Top_bit_4;
	public ModelRenderer	Floaty_part;
	public int				fix	= 7;

	public TranscrafterModel() {
		textureWidth = 64;
		textureHeight = 128;

		Middle = new ModelRenderer(this, 0, 0);
		Middle.addBox(0F, 0F, 0F, 14, fix, 14);
		Middle.setRotationPoint(-7F, 16F, -7F);
		Middle.setTextureSize(64, 128);
		Middle.mirror = true;
		setRotation(Middle, 0F, 0F, 0F);
		Bottom = new ModelRenderer(this, 0, 24);
		Bottom.addBox(0F, 0F, 0F, 16, 1, 16);
		Bottom.setRotationPoint(-8F, 23F, -8F);
		Bottom.setTextureSize(64, 128);
		Bottom.mirror = true;
		setRotation(Bottom, 0F, 0F, 0F);
		Top_bit_1 = new ModelRenderer(this, 0, 60);
		Top_bit_1.addBox(0F, 0F, 0F, 10, 1, 1);
		Top_bit_1.setRotationPoint(-5F, 15F, 4F);
		Top_bit_1.setTextureSize(64, 128);
		Top_bit_1.mirror = true;
		setRotation(Top_bit_1, 0F, 0F, 0F);
		Top_bit_2 = new ModelRenderer(this, 0, 45);
		Top_bit_2.addBox(0F, 0F, 0F, 1, 1, 10);
		Top_bit_2.setRotationPoint(-5F, 15F, -5F);
		Top_bit_2.setTextureSize(64, 128);
		Top_bit_2.mirror = true;
		setRotation(Top_bit_2, 0F, 0F, 0F);
		Top_bit_3 = new ModelRenderer(this, 0, 60);
		Top_bit_3.addBox(0F, 0F, 0F, 10, 1, 1);
		Top_bit_3.setRotationPoint(-5F, 15F, -5F);
		Top_bit_3.setTextureSize(64, 128);
		Top_bit_3.mirror = true;
		setRotation(Top_bit_3, 0F, 0F, 0F);
		Top_bit_4 = new ModelRenderer(this, 0, 45);
		Top_bit_4.addBox(0F, 0F, 0F, 1, 1, 10);
		Top_bit_4.setRotationPoint(4F, 15F, -5F);
		Top_bit_4.setTextureSize(64, 128);
		Top_bit_4.mirror = true;
		setRotation(Top_bit_4, 0F, 0F, 0F);
		Floaty_part = new ModelRenderer(this, 0, 65);
		Floaty_part.addBox(0F, 0F, 0F, 4, 4, 4);
		Floaty_part.setRotationPoint(-3F, 10F, 0F);
		Floaty_part.setTextureSize(64, 128);
		Floaty_part.mirror = true;
		setRotation(Floaty_part, -0.7853982F, 0F, -0.7853982F);
	}

	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		// super.render(entity, f, f1, f2, f3, f4, f5);
		// setRotationAngles(f, f1, f2, f3, f4, f5 ,e );
		Middle.render(f5);
		Bottom.render(f5);
		Top_bit_1.render(f5);
		Top_bit_2.render(f5);
		Top_bit_3.render(f5);
		Top_bit_4.render(f5);
		Floaty_part.render(f5);
	}

	void setRotation(ModelRenderer model, float x, float y, float z) {
		model.rotateAngleX = x;
		model.rotateAngleY = y;
		model.rotateAngleZ = z;
	}

	public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity e) {
		super.setRotationAngles(f, f1, f2, f3, f4, f5, e);
	}

}
