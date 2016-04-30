package modmuss50.mods.transcraft.Blocks.TileEntitys.MagicalInfuser;

import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

import java.util.Random;

/**
 * Created by Mark on 17/04/14.
 */
public class BlockMagicalInfuser extends BlockContainer {

	private final Random			random	= new Random();
	public static final Material	mat		= (new Material(MapColor.ironColor));

	public BlockMagicalInfuser() {
		super(mat);
		setBlockBounds(0.25F, 0.8F, 0.25F, 0.75F, 0.3F, 0.75F);
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new MagicalTile();
	}

	/**
	 * ejects contained items into the world, and notifies neighbours of an
	 * update, as appropriate
	 */
	public void breakBlock(World par1World, int par2, int par3, int par4, Block par5, int par6) {
		MagicalTile tile = (MagicalTile) par1World.getTileEntity(par2, par3, par4);

		if (tile != null) {
			for (int j1 = 0; j1 < tile.getSizeInventory(); ++j1) {
				ItemStack itemstack = tile.getStackInSlot(j1);

				if (itemstack != null) {
					float f = this.random.nextFloat() * 0.8F + 0.1F;
					float f1 = this.random.nextFloat() * 0.8F + 0.1F;
					EntityItem entityitem;

					for (float f2 = this.random.nextFloat() * 0.8F + 0.1F; itemstack.stackSize > 0; par1World.spawnEntityInWorld(entityitem)) {
						int k1 = this.random.nextInt(21) + 10;

						if (k1 > itemstack.stackSize) {
							k1 = itemstack.stackSize;
						}

						itemstack.stackSize -= k1;
						entityitem = new EntityItem(par1World, (double) ((float) par2 + f), (double) ((float) par3 + f1), (double) ((float) par4 + f2), new ItemStack(itemstack.getItem(), k1, itemstack.getItemDamage()));
						float f3 = 0.05F;
						entityitem.motionX = (double) ((float) this.random.nextGaussian() * f3);
						entityitem.motionY = (double) ((float) this.random.nextGaussian() * f3 + 0.2F);
						entityitem.motionZ = (double) ((float) this.random.nextGaussian() * f3);

						if (itemstack.hasTagCompound()) {
							entityitem.getEntityItem().setTagCompound((NBTTagCompound) itemstack.getTagCompound().copy());
						}
					}
				}
			}

		}

		super.breakBlock(par1World, par2, par3, par4, par5, par6);
	}

	/**
	 * Called upon block activation (right click on the block.)
	 */
	public boolean onBlockActivated(World par1World, int par2, int par3, int par4, EntityPlayer par5EntityPlayer, int par6, float par7, float par8, float par9) {
		MagicalTile tile = (MagicalTile) par1World.getTileEntity(par2, par3, par4);

		par1World.markTileEntityChunkModified(par2, par3, par4, tile);

		ItemStack stack = par5EntityPlayer.inventory.getCurrentItem();

		if (MultiBlockHelper.isMultiBlockStructure(par1World, par2, par2, par4, 3, 3, 1, TranscraftBlocks.MagicalInfuser)) {
			if (par1World.isRemote) {
				return true;
			}
			else {
				MagicalTile tileentity = (MagicalTile) par1World.getTileEntity(par2, par3, par4);

				if (tileentity != null) {
					par5EntityPlayer.openGui(Transcraft.instance, 5, par1World, par2, par3, par4);
				}

				return true;
			}
		}

		return false;
	}

	@Override
	public int getRenderType() {
		return -1;
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
}
