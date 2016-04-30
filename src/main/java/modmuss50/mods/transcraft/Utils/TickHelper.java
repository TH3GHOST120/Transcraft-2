package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.TickEvent;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.potion.PotionEffect;

public class TickHelper {

	public static void init() {

	}

	@SubscribeEvent
	public void TranscraftTickEvent(TickEvent.PlayerTickEvent event) {

		if (Config.EnderArmorBuffs == true) {
			if (event.player.getCurrentArmor(3) != null) {
				if (event.player.getCurrentArmor(3).getItem() == TranscraftItems.EnderHelmet) {
					event.player.addPotionEffect(new PotionEffect(16, 240, 0, true));
					event.player.addPotionEffect(new PotionEffect(13, 2, 3, true));

				}
			}

			if (event.player.getCurrentArmor(2) != null) {
				if (event.player.getCurrentArmor(2).getItem() == TranscraftItems.EnderChest) {

					double var7 = event.player.posX + Math.random() * (0 - 1) + 0.5;
					double var9 = event.player.posY + Math.random() * (0 - 1) - 0.6;
					double var11 = event.player.posZ + Math.random() * (0 - 1) + 0.5;

					event.player.worldObj.spawnParticle("portal", var7, var9, var11, 0.0D, 0.0D, 0.0D);
					// event.player.worldObj.spawnParticle("portal", var7, var9,
					// var11, 0.0D, 0.0D, 0.0D);

				}
				else {

				}
			}

			if (event.player.getCurrentArmor(1) != null) {
				if (event.player.getCurrentArmor(1).getItem() == TranscraftItems.EnderLegs) {
					if (event.player.isSprinting()) {
						event.player.addPotionEffect(new PotionEffect(1, 2, 8, true));
					}

					if (event.player.stepHeight < 1.0f)
						event.player.stepHeight = 1.0f;

				}

				if (event.player.getCurrentArmor(0) != null) {
					if (event.player.getCurrentArmor(0).getItem() == TranscraftItems.EnderBoots) {
						event.player.addPotionEffect(new PotionEffect(8, 2, 7, true));
						event.player.fallDistance = 0;
					}
				}
			}

			if (event.player.getCurrentArmor(1) != null) {
				if (event.player.getCurrentArmor(1).getItem() == TranscraftItems.TechniumLeggs) {
					if (event.player.stepHeight < 1.0f)
						event.player.stepHeight = 1.0f;

				}
			}
		}
	}

}
