package modmuss50.mods.transcraft.Utils;

import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

import java.util.Map;

/**
 * Created by Mark on 18/04/14.
 */
public class MultiBlockPattern {

	public final char[][][]		pattern;
	private final int			offsetX;
	private final int			offsetY;
	private final int			offsetZ;
	private final AxisAlignedBB	entityCheckBounds;

	public MultiBlockPattern(char[][][] pattern) {
		this(pattern, 1, 1, 1);
	}

	public MultiBlockPattern(char[][][] pattern, int offsetX, int offsetY, int offsetZ) {
		this(pattern, offsetX, offsetY, offsetZ, null);
	}

	public MultiBlockPattern(char[][][] pattern, int offsetX, int offsetY, int offsetZ, AxisAlignedBB entityCheckBounds) {
		this.pattern = pattern;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.offsetZ = offsetZ;
		this.entityCheckBounds = entityCheckBounds;
	}

	public AxisAlignedBB getEntityCheckBounds(int masterX, int masterY, int masterZ) {
		if (this.entityCheckBounds == null)
			return null;
		return this.entityCheckBounds.copy().offset(masterX, masterY, masterZ);
	}

	public char getPatternMarkerChecked(int x, int y, int z) {
		if ((x < 0) || (y < 0) || (z < 0))
			return 'O';
		if ((x >= getPatternWidthX()) || (y >= getPatternHeight()) || (z >= getPatternWidthZ()))
			return 'O';
		return getPatternMarker(x, y, z);
	}

	public char getPatternMarker(int x, int y, int z) {
		return this.pattern[y][x][z];
	}

	public int getMasterOffsetX() {
		return this.offsetX;
	}

	public int getMasterOffsetY() {
		return this.offsetY;
	}

	public int getMasterOffsetZ() {
		return this.offsetZ;
	}

	public int getPatternHeight() {
		return this.pattern.length;
	}

	public int getPatternWidthX() {
		return this.pattern[0].length;
	}

	public int getPatternWidthZ() {
		return this.pattern[0][0].length;
	}

	public int getMasterRelativeX(int posX, int patternX) {
		return this.offsetX - patternX + posX;
	}

	public int getMasterRelativeY(int posY, int patternY) {
		return this.offsetY - patternY + posY;
	}

	public int getMasterRelativeZ(int posZ, int patternZ) {
		return this.offsetZ - patternZ + posZ;
	}

	public TileEntity placeStructure(World world, int xCoord, int yCoord, int zCoord, Block block, Map blockMapping) {
		if (block == null) {
			return null;
		}
		int xWidth = getPatternWidthX();
		int zWidth = getPatternWidthZ();
		int height = getPatternHeight();

		int xOffset = xCoord - getMasterOffsetX();
		int yOffset = yCoord - getMasterOffsetY();
		int zOffset = zCoord - getMasterOffsetZ();

		TileEntity master = null;

		for (byte px = 0; px < xWidth; px = (byte) (px + 1)) {
			for (byte py = 0; py < height; py = (byte) (py + 1))
				for (byte pz = 0; pz < zWidth; pz = (byte) (pz + 1)) {
					char marker = getPatternMarker(px, py, pz);

					Integer metadata = (Integer) blockMapping.get(Character.valueOf(marker));
					if (metadata != null) {
						int x = px + xOffset;
						int y = py + yOffset;
						int z = pz + zOffset;

						world.setBlock(x, y, z, block, metadata.intValue(), 3);

						if ((px == getMasterOffsetX()) && (py == getMasterOffsetY()) && (pz == getMasterOffsetZ()))
							master = world.getTileEntity(x, y, z);
					}
				}
		}
		return master;
	}
}
