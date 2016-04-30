package modmuss50.mods.transcraft.Blocks.TileEntitys;

import cpw.mods.fml.common.FMLCommonHandler;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.netty.packets.PacketQuartz;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.Packet;
import net.minecraft.network.play.server.S35PacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;

public class TileEntiyQuartzBlock extends TileEntity {

	public int	red		= 255;
	public int	green	= 255;
	public int	blue	= 255;
	public int	texture	= 0;

	@Override
	public void writeToNBT(NBTTagCompound compound) {
		super.writeToNBT(compound);

		compound.setInteger("red", red);
		compound.setInteger("green", green);
		compound.setInteger("blue", blue);
		compound.setInteger("texture", texture);

	}

	public void writeToItemNBT(NBTTagCompound compound) {
		compound.setInteger("red", red);
		compound.setInteger("green", green);
		compound.setInteger("blue", blue);
		compound.setInteger("texture", texture);

	}

	public void readFromItemNBT(NBTTagCompound nbt) {
		red = nbt.getInteger("red");
		green = nbt.getInteger("green");
		blue = nbt.getInteger("blue");
	}

	@Override
	public void readFromNBT(NBTTagCompound compound) {
		super.readFromNBT(compound);

		red = compound.getInteger("red");
		green = compound.getInteger("green");
		blue = compound.getInteger("blue");
		texture = compound.getInteger("texture");
	}

	public void updateBlock() {
		this.worldObj.markBlockRangeForRenderUpdate(this.xCoord, this.yCoord, this.zCoord, this.xCoord, this.yCoord, this.zCoord);
		this.worldObj.markBlockForUpdate(this.xCoord, this.yCoord, this.zCoord);
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
			Transcraft.packetPipeline.sendToAll(new PacketQuartz(this.xCoord, this.yCoord, this.zCoord, red, green, blue, texture));
		}

		worldObj.func_147479_m(xCoord, yCoord, zCoord);
	}

	@Override
	public boolean canUpdate() {
		return false;
	}

}
