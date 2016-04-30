package modmuss50.mods.transcraft.Entitys.mob;

import net.minecraft.client.renderer.entity.RenderCreeper;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class NukeCreeperRender extends RenderCreeper {

	public NukeCreeperRender() {
		super();
	}

	protected ResourceLocation func_110775_a(Entity par1Entity) {
		return texture;
	}

	static final ResourceLocation	texture	= new ResourceLocation("transcraft", "textures/mob/NukeCreeper.png");

}
