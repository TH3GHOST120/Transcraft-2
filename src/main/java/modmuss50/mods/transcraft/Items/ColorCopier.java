package modmuss50.mods.transcraft.Items;

import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntiyQuartzBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import org.electricitycraft.api.Colors;

import java.util.List;

public class ColorCopier extends Item {
	public ColorCopier() {
		super();
	}

	@Override
	public boolean onItemUse(ItemStack i, EntityPlayer p, World w, int x, int y, int z, int a, float s, float f, float g) {
		if (w.getTileEntity(x, y, z) != null && w.getTileEntity(x, y, z) instanceof TileEntiyQuartzBlock) {
			if (p.isSneaking()) {
				TileEntiyQuartzBlock te = (TileEntiyQuartzBlock) w.getTileEntity(x, y, z);
				i.stackTagCompound = new NBTTagCompound();
				te.writeToItemNBT(i.stackTagCompound);
			}
			else {
				if (i.stackTagCompound == null) {

				}
				else {
					TileEntiyQuartzBlock te = (TileEntiyQuartzBlock) w.getTileEntity(x, y, z);

					te.readFromItemNBT(i.stackTagCompound);

					w.markBlockForUpdate(x, y, z);
				}
			}

			return true;
		}
		return false;
	}

	@Override
	public void addInformation(ItemStack i, EntityPlayer p, List l, boolean b) {
		if (i.stackTagCompound == null) {
			l.add("No NBT Data stored");
		}
		else {
			l.add(Colors.RED + "Red: " + i.stackTagCompound.getInteger("red"));
			l.add(Colors.GREEN + "Green: " + i.stackTagCompound.getInteger("green"));
			l.add(Colors.BLUE + "Blue: " + i.stackTagCompound.getInteger("blue"));
		}
	}
}
