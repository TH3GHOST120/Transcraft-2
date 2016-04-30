package modmuss50.mods.transcraft.Utils;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.IMob;

public class GeneralHelper {
	public static boolean isHostileEntity(EntityLivingBase entity) {

		if (entity instanceof IMob)
			return true;
		else
			return false;
	}
}
