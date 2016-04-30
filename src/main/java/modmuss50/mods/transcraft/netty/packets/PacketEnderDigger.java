package modmuss50.mods.transcraft.netty.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import modmuss50.mods.transcraft.Blocks.TileEntitys.EnderDigger.TileEntiyEnderDigger;
import modmuss50.mods.transcraft.netty.AbstractPacket;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

/**
 * Created by Mark on 21/04/14.
 */
public class PacketEnderDigger extends AbstractPacket {
	int	posX, posY, posZ;
	int	cx, cy, cz, ax, ay, az;

	public PacketEnderDigger() {

	}

	public PacketEnderDigger(int posX, int posY, int posZ, int cx, int cy, int cz, int ax, int ay, int az) {
		this.posX = posX;
		this.posY = posY;
		this.posZ = posZ;

		this.cx = cx;
		this.cy = cy;
		this.cz = cz;
		this.ax = ax;
		this.ay = ay;
		this.az = az;
	}

	public PacketEnderDigger(TileEntiyEnderDigger te) {
		this.posX = te.xCoord;
		this.posY = te.yCoord;
		this.posZ = te.zCoord;

		this.cx = te.cx;
		this.cy = te.cy;
		this.cz = te.cz;
		this.ax = te.ax;
		this.ay = te.ay;
		this.az = te.az;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(posX);
		buffer.writeInt(posY);
		buffer.writeInt(posZ);

		buffer.writeInt(cx);
		buffer.writeInt(cy);
		buffer.writeInt(cz);
		buffer.writeInt(ax);
		buffer.writeInt(ay);
		buffer.writeInt(az);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		this.posX = buffer.readInt();
		this.posY = buffer.readInt();
		this.posZ = buffer.readInt();

		this.cx = buffer.readInt();
		this.cy = buffer.readInt();
		this.cz = buffer.readInt();
		this.ax = buffer.readInt();
		this.ay = buffer.readInt();
		this.az = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		World worldObj = player.worldObj;
		if (worldObj.getTileEntity(posX, posY, posZ) instanceof TileEntiyEnderDigger) {
			TileEntiyEnderDigger te = (TileEntiyEnderDigger) worldObj.getTileEntity(posX, posY, posZ);
			if (te != null) {
				te.cx = this.cx;
				te.cy = this.cy;
				te.cz = this.cz;
				te.ax = this.ax;
				te.ay = this.ay;
				te.az = this.az;
				te.getWorldObj().markBlockForUpdate(posX, posY, posZ);
				te.getWorldObj().markBlockRangeForRenderUpdate(posX, posY, posZ, posX, posY, posZ);
			}
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {

	}
}
