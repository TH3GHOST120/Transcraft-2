package modmuss50.mods.transcraft.Client;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderLivingEvent;

public class ClientEventHandler {

	public boolean	resetRender	= false;

	@SubscribeEvent(priority = EventPriority.HIGHEST)
	public void entityColorRender(RenderLivingEvent.Pre event) {
		if (event.entity instanceof EntityPlayer) {
			EntityPlayer player = ((EntityPlayer) event.entity);
			if (player != null && !player.isInvisible() && player.getDisplayName().contains("mark123mark")) {
				// GL11.glColor4f(0.1F, 1.0F, 0.1F, 0.55F);
				// GL11.glEnable(3042);
				// GL11.glBlendFunc(770, 771);
				this.resetRender = true;
			}
		}

	}

	@SubscribeEvent
	public void entityColorRender(RenderLivingEvent.Post event) {
		if ((this.resetRender)) {
			// GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			// GL11.glRotatef(0, 0F, 0F, 00F);
			// GL11.glTranslatef(0F, 0F, 0F);
			// GL11.glDisable(3042);
		}
	}

}
