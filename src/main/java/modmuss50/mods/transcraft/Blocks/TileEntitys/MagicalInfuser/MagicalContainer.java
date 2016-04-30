package modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

/**
 * Created by Mark on 17/04/14.
 */
public class MagicalContainer extends Container {
	private IInventory	lowerChestInventory;
	private int			numRows	= 3;

	private MagicalTile	tileEntity;

	public MagicalContainer(InventoryPlayer player, MagicalTile tile) {
		this.tileEntity = tile;
		lowerChestInventory = this.tileEntity;

		this.addSlotToContainer(new Slot(this.tileEntity, 0, 8, 24));

		this.addSlotToContainer(new Slot(this.tileEntity, 1, 8, 95));
		this.addSlotToContainer(new Slot(this.tileEntity, 2, 118, 57));

		this.bindPlayerInventory(player);
	}

	protected void bindPlayerInventory(InventoryPlayer player) {
		for (int y = 0; y < 3; y++) {
			for (int x = 0; x < 9; x++) {
				addSlotToContainer(new Slot(player, x + y * 9 + 9, 8 + x * 18, 138 + y * 18));
			}
		}

		for (int x = 0; x < 9; x++) {
			addSlotToContainer(new Slot(player, x, 8 + x * 18, 196));
		}
	}

	public boolean canInteractWith(EntityPlayer par1EntityPlayer) {
		return this.lowerChestInventory.isUseableByPlayer(par1EntityPlayer);
	}

	/**
	 * Called when a player shift-clicks on a slot. You must override this or
	 * you will crash when someone does that.
	 */
	public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2) {
		ItemStack itemstack = null;
		Slot slot = (Slot) this.inventorySlots.get(par2);

		if (slot != null && slot.getHasStack()) {
			ItemStack itemstack1 = slot.getStack();
			itemstack = itemstack1.copy();

			if (par2 < this.numRows * 9) {
				if (!this.mergeItemStack(itemstack1, this.numRows * 9, this.inventorySlots.size(), true)) {
					return null;
				}
			}
			else
				if (!this.mergeItemStack(itemstack1, 0, this.numRows * 9, false)) {
					return null;
				}

			if (itemstack1.stackSize == 0) {
				slot.putStack((ItemStack) null);
			}
			else {
				slot.onSlotChanged();
			}
		}

		return itemstack;
	}

	/**
	 * Called when the container is closed.
	 */
	public void onContainerClosed(EntityPlayer par1EntityPlayer) {
		super.onContainerClosed(par1EntityPlayer);
		this.lowerChestInventory.closeInventory();
	}

	/**
	 * Return this chest container's lower chest inventory.
	 */
	public IInventory getLowerChestInventory() {
		return this.lowerChestInventory;
	}

}
