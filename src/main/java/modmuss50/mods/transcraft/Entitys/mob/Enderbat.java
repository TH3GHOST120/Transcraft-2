package modmuss50.mods.transcraft.Entitys.mob;

import net.minecraft.entity.passive.EntityBat;
import net.minecraft.world.World;

public class Enderbat extends EntityBat {

	public Enderbat(World par1World) {
		super(par1World);
	}

	public void initCreature() {
		// if (this.rand.nextInt(100) == 0)
		this.dataWatcher.updateObject(17, Byte.valueOf((byte) 1));
	}
}
