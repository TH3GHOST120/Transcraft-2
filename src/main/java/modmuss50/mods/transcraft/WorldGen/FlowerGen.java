package modmuss50.mods.transcraft.WorldGen;

import cpw.mods.fml.common.eventhandler.Event;
import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import modmuss50.mods.transcraft.Blocks.TranscraftBlocks;
import net.minecraftforge.event.terraingen.DecorateBiomeEvent;

public class FlowerGen {

	public static int	flowerQuantity	= 1;
	public static int	flowerDensity	= 1;

	@SubscribeEvent(priority = EventPriority.LOWEST)
	public void onWorldDecoration(DecorateBiomeEvent.Decorate event) {
		if (event.rand.nextInt(500) == 0) {
			if ((event.getResult() == Event.Result.ALLOW || event.getResult() == Event.Result.DEFAULT) && event.type == DecorateBiomeEvent.Decorate.EventType.FLOWERS)
				for (int i = 0; i < flowerQuantity; i++) {
					int x = event.chunkX + event.rand.nextInt(16) + 8;
					int z = event.chunkZ + event.rand.nextInt(16) + 8;
					int y = event.world.getTopSolidOrLiquidBlock(x, z);

					for (int j = 0; j < flowerDensity; j++) {
						int x1 = x + event.rand.nextInt(8) - event.rand.nextInt(8);
						int y1 = y + event.rand.nextInt(4) - event.rand.nextInt(4);
						int z1 = z + event.rand.nextInt(8) - event.rand.nextInt(8);

						if (event.world.isAirBlock(x1, y1, z1) && (!event.world.provider.hasNoSky || y1 < 127) && TranscraftBlocks.TransmutterFlower.canBlockStay(event.world, x1, y1, z1))
							event.world.setBlock(x1, y1, z1, TranscraftBlocks.TransmutterFlower, 0, 2);
					}
				}
		}

	}
}
