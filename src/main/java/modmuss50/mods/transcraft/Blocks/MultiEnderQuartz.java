package modmuss50.mods.transcraft.Blocks;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Blocks.TileEntitys.TileEntiyQuartzBlock;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IIcon;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.awt.*;

public class MultiEnderQuartz extends BlockContainer {

	public static String[]	types		= { "CutEnderQuartz", "EnderQuartzBrick", "EnderQuartzBrick2", "enderquartz" };

	private static IIcon[]	icons		= new IIcon[4];
	int						currenticon	= 0;

	public MultiEnderQuartz() {
		super(Material.rock);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public int colorMultiplier(IBlockAccess iba, int x, int y, int z) {
		TileEntity te = iba.getTileEntity(x, y, z);
		if (te != null && te instanceof TileEntiyQuartzBlock) {
			TileEntiyQuartzBlock telp = (TileEntiyQuartzBlock) te;

			return new Color(telp.red, telp.green, telp.blue).getRGB();
		}
		else {
			return 0;
		}
	}

	@Override
	public TileEntity createNewTileEntity(World var1, int var2) {
		return new TileEntiyQuartzBlock();
	}

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float hitX, float hitY, float hitZ) {
		ItemStack stack = player.getHeldItem();
		Item item = stack != null ? stack.getItem() : null;
		if (item == null || (item != null && item != Items.dye)) {
			if (item == TranscraftItems.ColorCopier) {
				return false;
			}
			player.openGui(Transcraft.instance, 4, world, x, y, z);
			TileEntity te = world.getTileEntity(x, y, z);
			TileEntiyQuartzBlock telp = (TileEntiyQuartzBlock) te;
			telp.syncWithClient();
		}
		else
			if (item != null && item == Items.dye && stack.stackSize > 1) {
				TileEntity te = world.getTileEntity(x, y, z);
				if (te != null && te instanceof TileEntiyQuartzBlock) {
					TileEntiyQuartzBlock telp = (TileEntiyQuartzBlock) te;
					if (telp.red == 255 || telp.green == 255 || telp.blue == 255) {
						setColourRGB(telp, stack.getItemDamage() == 1 ? 0 : telp.red, stack.getItemDamage() == 2 ? 0 : telp.green, stack.getItemDamage() == 4 ? 0 : telp.blue);
					}
					if (player.isSneaking()) {
						if (telp.red > 11 & telp.green > 11 & telp.blue > 11) {
							if (stack.getItemDamage() == 1) {
								setColourRGB(telp, telp.red - 10, telp.green, telp.blue);
							}
							else
								if (stack.getItemDamage() == 2) {
									setColourRGB(telp, telp.red, telp.green - 10, telp.blue);
								}
								else
									if (stack.getItemDamage() == 4) {
										setColourRGB(telp, telp.red, telp.green, telp.blue + 10);
									}
						}
						else {
							if (telp.red != 255 & telp.green != 255 & telp.blue != 255) {
								if (stack.getItemDamage() == 1) {
									setColourRGB(telp, telp.red + 10, telp.green, telp.blue);
								}
								else
									if (stack.getItemDamage() == 2) {
										setColourRGB(telp, telp.red, telp.green + 10, telp.blue);
									}
									else
										if (stack.getItemDamage() == 4) {
											setColourRGB(telp, telp.red, telp.green, telp.blue + 10);
										}
							}

						}
					}
					else {
						if (telp.red < 244 || telp.green < 244 || telp.blue < 244) {
							if (stack.getItemDamage() == 1) {
								setColourRGB(telp, telp.red + 10, telp.green, telp.blue);
							}
							else
								if (stack.getItemDamage() == 2) {
									setColourRGB(telp, telp.red, telp.green + 10, telp.blue);
								}
								else
									if (stack.getItemDamage() == 4) {
										setColourRGB(telp, telp.red, telp.green, telp.blue + 10);
									}
						}
						else {
							if (telp.red != 255 || telp.green != 255 || telp.blue != 255) {
								if (stack.getItemDamage() == 1) {
									setColourRGB(telp, telp.red + 10, telp.green, telp.blue);
								}
								else
									if (stack.getItemDamage() == 2) {
										setColourRGB(telp, telp.red, telp.green + 10, telp.blue);
									}
									else
										if (stack.getItemDamage() == 4) {
											setColourRGB(telp, telp.red, telp.green, telp.blue + 10);
										}
							}

						}

					}
				}
			}
			else
				if (item != null && item == Items.dye && stack.stackSize == 1) {
					TileEntity te = world.getTileEntity(x, y, z);
					if (te != null && te instanceof TileEntiyQuartzBlock) {
						TileEntiyQuartzBlock telp = (TileEntiyQuartzBlock) te;
						setColorToMatchDye(player.getHeldItem().getItemDamage(), telp);
					}
				}

		if (item != null && item == Items.stick) {
			TileEntity te = world.getTileEntity(x, y, z);
			if (te != null && te instanceof TileEntiyQuartzBlock) {
				TileEntiyQuartzBlock telp = (TileEntiyQuartzBlock) te;
				if (player.isSneaking()) {
					if (telp.texture != 4) {
						telp.texture += 1;
						telp.syncWithClient();
					}

				}
				else {
					if (telp.texture != 0) {
						telp.texture -= 1;
						telp.syncWithClient();
					}

				}

			}
		}

		return true;
	}

	private void setColorToMatchDye(int dyeDmg, TileEntiyQuartzBlock telp) {
		switch (dyeDmg) {
			case 0: {
				setColourHex(telp, 0x191919);
				break;
			}
			case 1: {
				setColourHex(telp, 0x993333);
				break;
			}
			case 2: {
				setColourHex(telp, 0x667F33);
				break;
			}
			case 3: {
				setColourHex(telp, 0x664C33);
				break;
			}
			case 4: {
				setColourHex(telp, 0x334CB2);
				break;
			}
			case 5: {
				setColourHex(telp, 0x7F3FB2);
				break;
			}
			case 6: {
				setColourHex(telp, 0x4C7F99);
				break;
			}
			case 7: {
				setColourHex(telp, 0x999999);
				break;
			}
			case 8: {
				setColourHex(telp, 0x4C4C4C);
				break;
			}
			case 9: {
				setColourHex(telp, 0xF27FA5);
				break;
			}
			case 10: {
				setColourHex(telp, 0x7FCC19);
				break;
			}
			case 11: {
				setColourHex(telp, 0xE5E533);
				break;
			}
			case 12: {
				setColourHex(telp, 0x6699D8);
				break;
			}
			case 13: {
				setColourHex(telp, 0xB24CD8);
				break;
			}
			case 14: {
				setColourHex(telp, 0xD87F33);
				break;
			}
			case 15: {
				setColourHex(telp, 0xFFFFFF);
				break;
			}
		}
	}

	private void setColourRGB(TileEntiyQuartzBlock telp, int red, int green, int blue) {
		telp.red = red;
		telp.green = green;
		telp.blue = blue;

		telp.updateBlock();
	}

	private void setColourHex(TileEntiyQuartzBlock telp, int hex) {
		Color color = new Color(hex);
		telp.red = color.getRed();
		telp.green = color.getGreen();
		telp.blue = color.getBlue();

		telp.updateBlock();
	}
}
