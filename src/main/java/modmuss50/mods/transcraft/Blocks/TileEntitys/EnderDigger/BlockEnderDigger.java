package modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEnderDigger extends BlockContainer {

	public BlockEnderDigger() {
		super(Material.circuits);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntiyEnderDigger();
	}
}
