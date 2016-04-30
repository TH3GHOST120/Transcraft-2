package modmuss50.mods.transcraft.Utils;

import modmuss50.mods.transcraft.Items.TranscraftItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

public class ItemHelper {
	private static double	rand;

	public static void droptransmutter(EntityPlayer player, EntityLivingBase entity) {

		if (GeneralHelper.isHostileEntity(entity)) {
			rand = Math.random();

			if (rand < 0.15d) {
				entity.dropItem(TranscraftItems.BasicTransmuter, 1);
			}
		}
	}

}
