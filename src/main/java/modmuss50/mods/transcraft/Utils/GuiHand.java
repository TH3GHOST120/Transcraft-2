package modmuss50.mods.transcraft.Utils;

import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ContainerIG;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.GuiIG;
import modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder.ItemGrinderTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser.MagicalContainer;
import modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser.MagicalGui;
import modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser.MagicalTile;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntiyQuartzBlock;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.ContainerTC;
import modmuss50.mods.transcraft.Blocks.TileEntitys.Transcrafter.GuiTC;
import modmuss50.mods.transcraft.Client.gui.GuiRGBBlocks;
import modmuss50.mods.transcraft.Items.gui.ContainerTranspedia;
import modmuss50.mods.transcraft.Items.gui.TranspediaGui;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class GuiHand implements IGuiHandler {

	public GuiHand() {
		NetworkRegistry.INSTANCE.registerGuiHandler(Transcraft.instance, this);
	}

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity te = world.getTileEntity(x, y, z);

		if (ID == 2) {
			return new ContainerIG(player.inventory, (ItemGrinderTile) te);
		}
		else
			if (ID == 1) {
				return new ContainerTC(player.inventory, world, x, y, z);
			}
			else
				if (ID == 3) {
					return new ContainerTranspedia();
				}
				else
					if (ID == 5) {
						return new MagicalContainer(player.inventory, (MagicalTile) te);
					}
					else {
						return null;
					}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

		TileEntity te = world.getTileEntity(x, y, z);

		if (ID == 2) {
			return new GuiIG(player.inventory, (ItemGrinderTile) te);
		}
		else
			if (ID == 1) {
				return new GuiTC(player.inventory, world, x, y, z);
			}
			else
				if (ID == 3) {
					return new TranspediaGui();
				}
				else
					if (ID == 4) {
						return new GuiRGBBlocks((TileEntiyQuartzBlock) te);
					}
					else
						if (ID == 5) {
							return new MagicalGui(player.inventory, (MagicalTile) te);
						}
						else {
							return null;
						}

	}

}
