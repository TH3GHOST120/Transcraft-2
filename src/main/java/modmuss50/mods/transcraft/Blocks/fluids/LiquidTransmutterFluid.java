package modmuss50.mods.transcraft.Blocks.fluids;

import net.minecraftforge.fluids.Fluid;

public class LiquidTransmutterFluid extends Fluid {
	public LiquidTransmutterFluid(String fluidName) {
		super(fluidName);
		this.setIcons(BlockFluidLiquidTransmuter.StillIcon, BlockFluidLiquidTransmuter.FlowingIcon);
	}

}
