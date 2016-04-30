package modmuss50.mods.transcraft.Blocks.ComOres;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Client.Renders.particles.FXSparkleRun;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

import java.util.Random;

public class ComTransmutterOre extends Block {
	public ComTransmutterOre() {
		super(Material.ground);
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(World par1World, int par2, int par3, int par4, Random par5Random) {
		FXSparkleRun.transmutterOre(par1World, par2, par3, par4, par5Random);
	}

}
