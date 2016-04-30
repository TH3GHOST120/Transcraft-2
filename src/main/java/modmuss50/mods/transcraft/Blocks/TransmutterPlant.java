package modmuss50.mods.transcraft.Blocks;

import net.minecraft.block.BlockCrops;
import net.minecraft.creativetab.CreativeTabs;

public class TransmutterPlant extends BlockCrops {

	public TransmutterPlant() {
		super();
		float f = 0.5F;
		this.setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, 0.25F, 0.5F + f);
		this.setCreativeTab((CreativeTabs) null);
		this.setHardness(0.0F);
		this.setStepSound(soundTypeGrass);
		this.disableStats();
	}

}
