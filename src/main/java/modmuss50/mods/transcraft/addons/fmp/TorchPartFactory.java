package modmuss50.mods.transcraft.addons.fmp;

import codechicken.lib.vec.BlockCoord;
import codechicken.multipart.MultiPartRegistry;
import codechicken.multipart.TMultiPart;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import net.minecraft.block.Block;
import net.minecraft.world.World;

import java.util.Arrays;

public class TorchPartFactory implements MultiPartRegistry.IPartFactory, MultiPartRegistry.IPartConverter {
	@Override
	public TMultiPart createPart(String name, boolean client) {
		if (name.equals("tile.Transcraft:IronTorch.name"))
			return new IronTorchPart();

		return null;
	}

	public void init() {
		MultiPartRegistry.registerConverter(this);
		MultiPartRegistry.registerParts(this, new String[] { "tile.Transcraft:IronTorch.name", });
	}

	@Override
	public Iterable<Block> blockTypes() {
		return Arrays.asList(TranscraftBlocks.IronTorch);
	}

	@Override
	public TMultiPart convert(World world, BlockCoord pos) {
		Block b = world.getBlock(pos.x, pos.y, pos.z);
		int meta = world.getBlockMetadata(pos.x, pos.y, pos.z);
		if (b == TranscraftBlocks.IronTorch)
			return new IronTorchPart(meta);

		return null;
	}
}
