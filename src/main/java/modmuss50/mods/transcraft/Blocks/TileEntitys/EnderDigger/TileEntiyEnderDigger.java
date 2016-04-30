package modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger;

import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.Utils.FakePlayer;
import modmuss50.mods.transcraft.Utils.invUtil;
import modmuss50.mods.transcraft.netty.packets.PacketEnderDigger;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.ArrayList;
import java.util.List;

public class TileEntiyEnderDigger extends TileEntity {

	public int						cx, cy, cz, ax, ay, az;

	public static ArrayList<Block>	blacklist;
	boolean							hasinted	= false;
	public Block					CurrentBlock;
	int								ticks		= 0;
	int								size		= 16;
	int								speed		= 1;

	public int						xSize		= size;
	public int						ySize		= 8;
	public int						zSize		= size;

	public TileEntiyEnderDigger() {
		if (!hasinted) {
			blacklist = new ArrayList<Block>();
			blacklist.add(Blocks.water);
			blacklist.add(Blocks.lava);
			blacklist.add(Blocks.bedrock);
			blacklist.add(Blocks.flowing_lava);
			blacklist.add(Blocks.flowing_water);
			hasinted = true;
		}
	}

	public void updateEntity() {
		super.updateEntity();

		if (!hasinted) {
			blacklist = new ArrayList<Block>();
			hasinted = true;
		}

		if (ticks == speed) {
			ticks = 0;
			runQuarry();
		}
		else {
			ticks += 1;
		}

	}

	public void diggerBeam() {
		if (FMLCommonHandler.instance().getSide().isClient()) {
			if (cx != 0 & cy != 0 & cz != 0 & ax != 0 & ay != 0 & az != 0 & worldObj != null) {
				// FXSparkleRun.runEDFX(worldObj, xCoord + 0.5, yCoord + 0.5,
				// zCoord
				// + 0.5, cx + ax + 0.5, cy - ay + 0.5, cz + az + 0.5, 255, 255,
				// 255, 10);
			}
		}
	}

	public void runQuarry() {
		if (this.worldObj.isBlockIndirectlyGettingPowered(this.xCoord, this.yCoord, this.zCoord)) {
			if (cx == 0) {
				cx = this.xCoord;
			}

			if (cy == 0) {
				cy = this.yCoord - 1;
			}

			if (cz == 0) {
				cz = this.zCoord;
			}

			if (ax == size & az == size) {
				ax = 0;
				ay += 1;
				az = 0;
			}
			if (ax != size) {
				breakBlock(cx + ax, cy - ay, cz + az);
				ax += 1;
			}
			if (az != size & ax == size) {
				ax = 0;
				az += 1;
			}
			diggerBeam();
		}
	}

	public void breakBlock(int x, int y, int z) {
		CurrentBlock = this.getWorldObj().getBlock(x, y, x);
		int currentMeta = this.getWorldObj().getBlockMetadata(x, y, z);
		List<ItemStack> stacks = getItemStackFromBlock(worldObj, x, y, z);
		boolean wasAir = worldObj.isAirBlock(x, y, z);

		if (!canDig(worldObj.getBlock(x, y, z))) {
			return;
		}

		worldObj.setBlock(x, y, z, Blocks.air);

		if (wasAir)
			return;

		if (stacks == null || stacks.isEmpty())
			return;

		for (ItemStack stack : stacks) {

			if (worldObj.isRemote)
				return;

			stack.stackSize -= invUtil.addToRandomInventoryAround(worldObj, xCoord, yCoord, zCoord, stack);
			if (stack.stackSize <= 0)
				continue;

			float f = worldObj.rand.nextFloat() * 0.8F + 0.1F;
			float f1 = worldObj.rand.nextFloat() * 0.8F + 0.1F;
			float f2 = worldObj.rand.nextFloat() * 0.8F + 0.1F;

			EntityItem entityitem = new EntityItem(worldObj, xCoord + f, yCoord + f1 + 0.5F, zCoord + f2, stack);

			entityitem.lifespan = 1200;
			entityitem.delayBeforeCanPickup = 10;

			float f3 = 0.05F;
			entityitem.motionX = (float) worldObj.rand.nextGaussian() * f3;
			entityitem.motionY = (float) worldObj.rand.nextGaussian() * f3 + 1.0F;
			entityitem.motionZ = (float) worldObj.rand.nextGaussian() * f3;
			worldObj.spawnEntityInWorld(entityitem);
		}
	}

	public static boolean canDig(Block block) {

		if (blacklist.contains(block))
			return false;

		return true;
	}

	public static List<ItemStack> getItemStackFromBlock(World world, int i, int j, int k) {
		Block block = world.getBlock(i, j, k);

		if (block == null)
			return null;

		if (block.isAir(world, i, j, k))
			return null;

		int meta = world.getBlockMetadata(i, j, k);

		ArrayList<ItemStack> dropsList = block.getDrops(world, i, j, k, meta, 0);
		float dropChance = ForgeEventFactory.fireBlockHarvesting(dropsList, world, block, i, j, k, meta, 0, 1.0F, false, FakePlayer.getTranscraftPlayer(world));

		ArrayList<ItemStack> returnList = new ArrayList<ItemStack>();
		for (ItemStack s : dropsList) {
			if (world.rand.nextFloat() <= dropChance) {
				returnList.add(s);
			}
		}

		return returnList;
	}

	@Override
	/**
	 * Reads a tile entity from NBT.
	 */
	public void readFromNBT(NBTTagCompound par1NBTTagCompound) {
		super.readFromNBT(par1NBTTagCompound);
		cx = par1NBTTagCompound.getInteger("cx");
		cy = par1NBTTagCompound.getInteger("cy");
		cz = par1NBTTagCompound.getInteger("cz");
		ax = par1NBTTagCompound.getInteger("ax");
		ay = par1NBTTagCompound.getInteger("ay");
		az = par1NBTTagCompound.getInteger("az");
	}

	@Override
	/**
	 * Writes a tile entity to NBT.
	 */
	public void writeToNBT(NBTTagCompound par1NBTTagCompound) {
		super.writeToNBT(par1NBTTagCompound);
		par1NBTTagCompound.setInteger("cx", cx);
		par1NBTTagCompound.setInteger("cy", cy);
		par1NBTTagCompound.setInteger("cz", cz);
		par1NBTTagCompound.setInteger("ax", ax);
		par1NBTTagCompound.setInteger("ay", ay);
		par1NBTTagCompound.setInteger("az", az);
	}

	@Override
	public Packet getDescriptionPacket() {
		NBTTagCompound nbtTag = new NBTTagCompound();
		this.writeToNBT(nbtTag);
		return new S35PacketUpdateTileEntity(this.xCoord, this.yCoord, this.zCoord, 1, nbtTag);
	}

	@Override
	public void onDataPacket(NetworkManager net, S35PacketUpdateTileEntity packet) {
		readFromNBT(packet.func_148857_g());
		syncWithClient();
	}

	public void syncWithClient() {
		// checks to see if the tile enity is not no the client then sneds the
		// data to the client when called.
		if (FMLCommonHandler.instance().getSide().isServer()) {
			Transcraft.packetPipeline.sendToAll(new PacketEnderDigger(this.xCoord, this.yCoord, this.zCoord, cx, cy, cz, ax, ay, az));
		}

		worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}

	@Override
	public double getMaxRenderDistanceSquared() {
		return 16384;

	}

	@SideOnly(Side.CLIENT)
	@Override
	public AxisAlignedBB getRenderBoundingBox() {
		return INFINITE_EXTENT_AABB;
	}

}
