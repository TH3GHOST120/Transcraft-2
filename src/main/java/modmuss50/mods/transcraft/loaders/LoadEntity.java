package modmuss50.mods.transcraft.loaders;

import cpw.mods.fml.common.registry.EntityRegistry;
import modmuss50.mods.transcraft.Entitys.mob.Enderbat;
import modmuss50.mods.transcraft.Entitys.mob.NukeCreeper;
import modmuss50.mods.transcraft.Transcraft;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;

public class LoadEntity {

	public static void loadentity() {
		int entityID;
		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(NukeCreeper.class, "EnderCreeper", entityID);
		// EntityList.addMapping(NukeCreeper.class, "EnderCreeper",
		// entityID,0x515838, 0x868F6B);
		EntityRegistry.registerModEntity(NukeCreeper.class, "EnderCreeper", 2, Transcraft.instance, 64, 5, true);

		entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(Enderbat.class, "Enderbat", entityID);
		// EntityList.addMapping(Enderbat.class, "Enderbat", entityID,
		// 0x115838,0x268F6B);
		EntityRegistry.registerModEntity(Enderbat.class, "Enderbat", 3, Transcraft.instance, 65, 3, true);

		BiomeGenBase[] end = BiomeDictionary.getBiomesForType(BiomeDictionary.Type.END);

		EntityRegistry.addSpawn(NukeCreeper.class, 10, 8, 12, EnumCreatureType.creature, end);
		EntityRegistry.addSpawn(Enderbat.class, 10, 8, 12, EnumCreatureType.creature, end);
	}

}
