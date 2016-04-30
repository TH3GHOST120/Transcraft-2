package modmuss50.mods.transcraft.Blocks.fluids;

import com.google.common.base.Optional;
import cpw.mods.fml.common.registry.GameRegistry;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.api.Fluids;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;

public class TranscraftFluids {

	public static void init() {
		registerFluids();
		initializeLiquids();
		initializeContainers();
		registerBlocks();
	}

	private static void registerFluids() {

		Fluids.LiquidTransmutterFluid = Optional.of(new LiquidTransmutterFluid("transcraft:LiquidTransmutter"));
		FluidRegistry.registerFluid(Fluids.LiquidTransmutterFluid.get());
		FluidRegistry.registerFluid(new LiquidTransmutterFluid("LiquidTransmutterFluid"));
	}

	private static void initializeLiquids() {
		Fluids.LiquidTransmutter = Optional.of(new BlockFluidLiquidTransmuter("LiquidTransmuter").setBlockName("transcraft:LiquidTransmutter"));
	}

	private static void initializeContainers() {

		Fluids.ItemBucketLiquidTrasnmutter = Optional.of((new ItemBucketLiquidTrasnmutter(Fluids.LiquidTransmutter.get()).setMaxStackSize(1).setUnlocalizedName("transcraft.BucketLiquidTrasnmutter")).setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:bucket_transmutter"));

		registerItem(Fluids.ItemBucketLiquidTrasnmutter.get());

		// FluidContainerRegistry.registerFluidContainer(FluidRegistry.getFluidStack("LiquidTransmutterFluid",
		// FluidContainerRegistry.BUCKET_VOLUME), new
		// ItemStack(Fluids.ItemBucketLiquidTrasnmutter.get()), new
		// ItemStack(Items.bucket));

		BucketHandler.INSTANCE.buckets.put(Fluids.LiquidTransmutter.get(), Fluids.ItemBucketLiquidTrasnmutter.get());
		MinecraftForge.EVENT_BUS.register(BucketHandler.INSTANCE);
	}

	private static void registerBlocks() {
		GameRegistry.registerBlock(Fluids.LiquidTransmutter.get(), "LiquidTransmutter");
	}

	public static void registerItem(Item item) {
		GameRegistry.registerItem(item, item.getUnlocalizedName().replace("item.", ""));
	}

}
