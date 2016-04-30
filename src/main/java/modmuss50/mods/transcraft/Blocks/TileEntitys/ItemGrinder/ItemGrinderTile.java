package modmuss50.mods.transcraft.Blocks.TileEntitys.ItemGrinder;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileBase;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.Utils.Config;
import modmuss50.mods.transcraft.api.IItemEssenceStorgeItem;
import modmuss50.mods.transcraft.api.IItemTransmutter;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class ItemGrinderTile extends TileBase implements IInventory, ISidedInventory {
	private ItemStack[]			chestContents		= new ItemStack[36];
	private static final int[]	slots_top			= new int[] { 0 };
	private static final int[]	slots_bottom		= new int[] { 2, 1 };
	private static final int[]	slots_sides			= new int[] { 1 };

	/**
	 * The current angle of the lid (between 0 and 1)
	 */
	public float				lidAngle;

	public double				CurrentIXPValue		= 0;
	public double				CurrnetMaxValue		= 0;
	public int					CurrentintIXPValue	= 0;
	public int					CurrnetintMaxValue	= 0;

	/**
	 * The angle of the lid last tick
	 */
	public float				prevLidAngle;

	/**
	 * The number of players currently using this chest
	 */
	public int					numUsingPlayers;

	/**
	 * Server sync counter (once per 20 ticks)
	 */
	private int					ticksSinceSync;
	private int					field_94046_i;
	private String				field_94045_s;

	public ItemGrinderTile() {
		this.field_94046_i = -1;
	}

	@SideOnly(Side.CLIENT)
	public ItemGrinderTile(int par1) {
		this.field_94046_i = par1;
	}

	/**
	 * Returns the number of slots in the inventory.
	 */
	public int getSizeInventory() {
		return chestContents.length;
	}

	public void incIXP() {
		CurrentIXPValue = CurrentIXPValue + 0.125;

	}

	public void incIXP(int am) {
		CurrentIXPValue = CurrentIXPValue + am;
	}

	/**
	 * Returns the stack in slot i
	 */
	public ItemStack getStackInSlot(int par1) {
		return par1 >= this.chestContents.length ? null : this.chestContents[par1];
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	public ItemStack decrStackSize(int par1, int par2) {
		if (this.chestContents[par1] != null) {
			ItemStack itemstack;

			if (this.chestContents[par1].stackSize <= par2) {
				itemstack = this.chestContents[par1];
				this.chestContents[par1] = null;
				this.markDirty();
				return itemstack;
			}
			else {
				itemstack = this.chestContents[par1].splitStack(par2);

				if (this.chestContents[par1].stackSize == 0) {
					this.chestContents[par1] = null;
				}

				this.markDirty();
				return itemstack;
			}
		}
		else {
			return null;
		}
	}

	/**
	 * Removes from an inventory slot (first arg) up to a specified number
	 * (second arg) of items and returns them in a new stack.
	 */
	public ItemStack incrStackSize(int par1, int par2) {
		if (this.chestContents[par1] != null) {
			if (this.chestContents[par1].stackSize < 64) {
				ItemStack i;
				ItemStack newI;

				i = chestContents[par1];
				newI = i;

				newI.stackSize = i.stackSize + 1;

				return newI;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
	}

	/**
	 * When some containers are closed they call this on each slot, then drop
	 * whatever it returns as an EntityItem - like when you close a workbench
	 * GUI.
	 */
	public ItemStack getStackInSlotOnClosing(int par1) {
		if (this.chestContents[par1] != null) {
			ItemStack itemstack = this.chestContents[par1];
			this.chestContents[par1] = null;
			return itemstack;
		}
		else {
			return null;
		}
	}

	public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
		if (par1 < this.chestContents.length) {
			this.chestContents[par1] = par2ItemStack;

			if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit()) {
				par2ItemStack.stackSize = this.getInventoryStackLimit();
			}

			this.markDirty();
		}
	}

	/**
	 * Returns the name of the inventory.
	 */
	public String getInvName() {
		return this.isInvNameLocalized() ? this.field_94045_s : "container.chest";
	}

	/**
	 * If this returns false, the inventory name will be used as an unlocalized
	 * name, and translated into the player's language. Otherwise it will be
	 * used directly.
	 */
	public boolean isInvNameLocalized() {
		return this.field_94045_s != null && this.field_94045_s.length() > 0;
	}

	/**
	 * Sets the custom display name to use when opening a GUI for this specific
	 * TileEntityChest.
	 */
	public void setChestGuiName(String par1Str) {
		this.field_94045_s = par1Str;
	}

	@Override
	/**
	 * getAccessibleSlotsFromSides a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 10);
		this.chestContents = new ItemStack[this.getSizeInventory()];

		if (par1NBTTagCompound.hasKey("CustomName")) {
			this.field_94045_s = par1NBTTagCompound.getString("CustomName");
		}

		for (int i = 0; i < nbttaglist.tagCount(); ++i) {
			NBTTagCompound nbttagcompound1 = (NBTTagCompound) nbttaglist.getCompoundTagAt(i);
			int j = nbttagcompound1.getByte("Slot") & 255;

			if (j >= 0 && j < this.chestContents.length) {
				this.chestContents[j] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
			}
		}

		this.CurrentIXPValue = par1NBTTagCompound.getDouble("ItemEssence");

	}

	public double getIXPValue() {
		return this.CurrentIXPValue;
	}

	public double getCurrnetMaxValue() {
		return this.CurrnetMaxValue;
	}

	@Override
	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		NBTTagList nbttaglist = new NBTTagList();

		par1NBTTagCompound.setDouble("ItemEssence", this.CurrentIXPValue);

		for (int i = 0; i < this.chestContents.length; ++i) {
			if (this.chestContents[i] != null) {
				NBTTagCompound nbttagcompound1 = new NBTTagCompound();
				nbttagcompound1.setByte("Slot", (byte) i);
				this.chestContents[i].writeToNBT(nbttagcompound1);
				nbttaglist.appendTag(nbttagcompound1);
			}
		}

		par1NBTTagCompound.setTag("Items", nbttaglist);

		if (this.isInvNameLocalized()) {
			par1NBTTagCompound.setString("CustomName", this.field_94045_s);
		}

	}

	/**
	 * Returns the maximum stack size for a inventory slot. Seems to always be
	 * 64, possibly will be extended. *Isn't this more of a set than a get?*
	 */
	public int getInventoryStackLimit() {
		return 64;
	}

	/**
	 * Do not make give this method the name canInteractWith because it clashes
	 * with Container
	 */
	public boolean isUseableByPlayer(EntityPlayer par1EntityPlayer) {
		return this.worldObj.getTileEntity(this.xCoord, this.yCoord, this.zCoord) != this ? false : par1EntityPlayer.getDistanceSq((double) this.xCoord + 0.5D, (double) this.yCoord + 0.5D, (double) this.zCoord + 0.5D) <= 64.0D;
	}

	/**
	 * Causes the TileEntity to reset all it's cached values for it's container
	 * block, blockID, metaData and in the case of chests, the adjcacent chest
	 * check
	 */
	public void updateContainingBlockInfo() {
		super.updateContainingBlockInfo();
	}

	private void handleEnergy() {
		int slot = 1;

		for (int j = 1; slot < 28; slot++) {
			if (slot == 1) {
				if (getStackInSlot(slot) != null) {
					int IXP = 1;
					CurrentIXPValue = CurrentIXPValue + IXP;
					decrStackSize(slot, 1);
				}
			}
			else {
				if (getStackInSlot(slot - 1) == null) {
					if (getStackInSlot(slot) != null) {
						int IXP = 1;
						CurrentIXPValue = CurrentIXPValue + IXP;
						decrStackSize(slot, 1);

					}
				}
			}

		}
	}

	private void makeItems() {
		int slot = 0;
		int mainSlot = 1;

		int BASIC = Config.BasicItemEssence;
		int QUAD = Config.QuadItemEssence;
		int NANO = Config.NanoItemEssence;

		if (BASIC == 0) {
			BASIC = BASIC + 1;
		}

		if (QUAD == 0) {
			QUAD = QUAD + 1;
		}

		if (NANO == 0) {
			NANO = NANO + 1;
		}

		if (getStackInSlot(0) != null) {
			if (getStackInSlot(0).getItem() instanceof IItemEssenceStorgeItem) {
				int maxDamge = getStackInSlot(0).getItem().getMaxDamage();
				int currentDamage = getStackInSlot(0).getItem().getDamage(getStackInSlot(0));
				if (currentDamage < maxDamge) {
					if (CurrentIXPValue > 0) {
						getStackInSlot(0).getItem().setDamage(getStackInSlot(0), currentDamage - 1);
						CurrentIXPValue -= 1;
					}
				}
			}
			else {
				if (getStackInSlot(0).getItem() instanceof IItemTransmutter) {

					if (getStackInSlot(0).getItem() == TranscraftItems.BasicTransmuter) {
						CurrnetMaxValue = BASIC;
						CurrnetintMaxValue = BASIC;

						if (BASIC != 0 && getStackInSlot(0).stackSize <= 64) {
							if (CurrentIXPValue >= BASIC) {
								CurrentIXPValue -= BASIC;
								incrStackSize(0, 1);

							}
						}
					}

					if (getStackInSlot(0).getItem() == TranscraftItems.QuadTransmuter) {
						CurrnetMaxValue = QUAD;
						CurrnetintMaxValue = QUAD;

						if (QUAD != 0 && getStackInSlot(0).stackSize <= 64) {
							if (CurrentIXPValue >= QUAD) {
								CurrentIXPValue -= QUAD;
								incrStackSize(0, 1);

							}
						}
					}

					if (getStackInSlot(0).getItem() == TranscraftItems.NanoTransmuter) {
						CurrnetMaxValue = NANO;
						CurrnetintMaxValue = NANO;

						if (NANO != 0 && getStackInSlot(0).stackSize <= 64) {
							if (CurrentIXPValue >= NANO) {
								CurrentIXPValue -= NANO;
								incrStackSize(0, 1);

							}

						}

					}
				}

			}

		}

	}

	/**
	 * Allows the entity to update its state. Overridden in most subclasses,
	 * e.g. the mob spawner uses this to count ticks and creates a new spawn
	 * inside its implementation.
	 */
	public void updateEntity() {
		super.updateEntity();

		handleEnergy();

		makeItems();
		++this.ticksSinceSync;

		// NetworkHandler.sendToAll(getDescriptionPacket());

	}

	/**
	 * Called when a client event is received with the event number and
	 * argument, see World.sendClientEvent
	 */
	public boolean receiveClientEvent(int par1, int par2) {
		if (par1 == 1) {
			this.numUsingPlayers = par2;
			return true;
		}
		else {
			return super.receiveClientEvent(par1, par2);
		}
	}

	public void openChest() {
		if (this.numUsingPlayers < 0) {
			this.numUsingPlayers = 0;
		}

		++this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());

	}

	public void closeChest() {
		if (this.getBlockType() != null && this.getBlockType() instanceof ItemGrinder) {
			--this.numUsingPlayers;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
		}
	}

	public int[] getAccessibleSlotsFromSide(int par1) {
		return par1 == 0 ? slots_bottom : (par1 == 1 ? slots_top : slots_sides);
	}

	/**
	 * Returns true if automation is allowed to insert the given stack (ignoring
	 * stack size) into the given slot.
	 */
	public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
		return true;
	}

	/**
	 * invalidates a tile entity
	 */
	public void invalidate() {
		super.invalidate();
		this.updateContainingBlockInfo();
	}

	public int func_98041_l() {
		if (this.field_94046_i == -1) {
			if (this.worldObj == null || !(this.getBlockType() instanceof ItemGrinder)) {
				return 0;
			}

			this.field_94046_i = ((ItemGrinder) this.getBlockType()).isTrapped;
		}

		return this.field_94046_i;
	}

	@Override
	public boolean canExtractItem(int slot, ItemStack itemstack, int side) {
		if (slot == 0) {
			return itemstack.getItem() instanceof IItemTransmutter;
		}
		else {
			return false;
		}
		// }

	}

	@Override
	public boolean canInsertItem(int slotID, ItemStack itemstack, int side) {
		if (slotID == 0) {
			return false;
		}
		else {
			return true;
		}

	}

	public void writeCustomNBT(NBTTagCompound cmp) {
		super.writeCustomNBT(cmp);

		cmp.setDouble("IEV", CurrentIXPValue);
	}

	public void readCustomNBT(NBTTagCompound cmp) {
		super.readCustomNBT(cmp);

		CurrentIXPValue = cmp.getDouble("IEV");

	}

	@Override
	public String getInventoryName() {
		return "ItemGrinder";
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public void openInventory() {
		if (this.numUsingPlayers < 0) {
			this.numUsingPlayers = 0;
		}

		++this.numUsingPlayers;
		this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
		this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());

	}

	@Override
	public void closeInventory() {
		if (this.getBlockType() instanceof ItemGrinder) {
			--this.numUsingPlayers;
			this.worldObj.addBlockEvent(this.xCoord, this.yCoord, this.zCoord, this.getBlockType(), 1, this.numUsingPlayers);
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord, this.zCoord, this.getBlockType());
			this.worldObj.notifyBlocksOfNeighborChange(this.xCoord, this.yCoord - 1, this.zCoord, this.getBlockType());
		}

	}

	// @Override
	// public Packet getDescriptionPacket() {
	// try {
	// return (new PacketIxp(xCoord, yCoord, zCoord, CurrentintIXPValue) {
	// }).getProxy();
	// } catch (IOException e) {
	// TCLog.error(e);
	// }
	// return null;
	// }

}
