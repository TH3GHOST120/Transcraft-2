package modmuss50.mods.transcraft.loaders;

import modmuss50.mods.transcraft.Items.*;
import modmuss50.mods.transcraft.Items.Technium.*;
import modmuss50.mods.transcraft.Items.Tools.*;
import modmuss50.mods.transcraft.Items.armor.*;
import modmuss50.mods.transcraft.Transcraft;
import modmuss50.mods.transcraft.Utils.TranscraftUtil;
import net.minecraft.item.Item;

public class LoadItems {

	public static Item	TestItem;

	public static void LoadItems() {

		TranscraftItems.BasicTransmuter = new BasicTransmuter().setUnlocalizedName("Transcraft:BasicTransmuter").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:BasicTransmuter");

		TranscraftItems.QuadTransmuter = new modmuss50.mods.transcraft.Items.QuadTransmuter().setUnlocalizedName("Transcraft:QuadTransmuter").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:QuadTransmuter");

		TranscraftItems.NanoTransmuter = new modmuss50.mods.transcraft.Items.NanoTransmuter().setUnlocalizedName("Transcraft:NanoTransmuter").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:NanoTransmuter");

		TranscraftItems.Oil = new modmuss50.mods.transcraft.Items.Oil().setUnlocalizedName("Transcraft:Oil").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:Oil");

		TranscraftItems.Plastic = new modmuss50.mods.transcraft.Items.Plastic().setUnlocalizedName("Transcraft:Plastic").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:Plastic");

		TranscraftItems.IronStick = new modmuss50.mods.transcraft.Items.IronStick().setUnlocalizedName("Transcraft:IronStick").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:IronStick");

		TranscraftItems.HardendPlastic = new modmuss50.mods.transcraft.Items.HardendPlastic().setUnlocalizedName("Transcraft:HardendPlastic").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:HardendPlastic");

		TranscraftItems.EnderGem = new modmuss50.mods.transcraft.Items.EnderGem().setUnlocalizedName("Transcraft:EnderGem").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:EnderGem");

		TranscraftItems.EnderQuartz = new modmuss50.mods.transcraft.Items.EnderQuartz().setUnlocalizedName("Transcraft:EnderQuartz").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:EnderQuartz");

		TranscraftItems.DarkEndershard = new modmuss50.mods.transcraft.Items.DarkEndershard().setUnlocalizedName("Transcraft:DarkEndershard").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:DarkEndershard");

		TranscraftItems.HotDog = new modmuss50.mods.transcraft.Items.Food.HotDog().setUnlocalizedName("Transcraft:HotDog").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.BunkerPick = new modmuss50.mods.transcraft.Items.Tools.BunkerPick(TranscraftUtil.BunkerToolEnum).setUnlocalizedName("Transcraft:EnderPick").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.EnderSword = new modmuss50.mods.transcraft.Items.Tools.EnderSword(TranscraftUtil.EnderToolEnum).setUnlocalizedName("Transcraft:EnderSword").setCreativeTab(Transcraft.Transtab).setFull3D();

		TranscraftItems.EnderHelmet = (new ArmorEnderHelmet(TranscraftUtil.EnderEnum, 0, 0)).setUnlocalizedName("Transcraft:EnderHelmet").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.EnderChest = (new ArmorEnderChest(TranscraftUtil.EnderEnum, 0, 1)).setUnlocalizedName("Transcraft:EnderChest").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.EnderLegs = (new ArmorEnderLegs(TranscraftUtil.EnderEnum, 0, 2)).setUnlocalizedName("Transcraft:EnderLegs").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.EnderBoots = (new ArmorEnderBoots(TranscraftUtil.EnderEnum, 0, 3)).setUnlocalizedName("Transcraft:EnderBoots").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.TechniumHelmet = (new TechniumHelmet(TranscraftUtil.TechniumEnum, 0, 0)).setUnlocalizedName("Transcraft:TechniumHelmet").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.TechniumChestplate = (new TechniumChestplate(TranscraftUtil.TechniumEnum, 0, 1)).setUnlocalizedName("Transcraft:TechniumChestplate").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.TechniumLeggs = (new TechniumLeggs(TranscraftUtil.TechniumEnum, 0, 2)).setUnlocalizedName("Transcraft:TechniumLeggs").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.TechniumBoots = (new TechniumBoots(TranscraftUtil.TechniumEnum, 0, 3)).setUnlocalizedName("Transcraft:TechniumBoots").setCreativeTab(Transcraft.Transtab);

		if (TranscraftUtil.devstuff)
			TranscraftItems.Transpedia = new Transpeadia().setUnlocalizedName("Transcraft:Transpedia").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:Transpedia");

		TranscraftItems.FireStaff = new FireStaff().setUnlocalizedName("Transcraft:FireStaff").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:FireStaff");

		// TranscraftItems.ColourSetter = new ColourSetter()
		// .setUnlocalizedName("Transcraft:ColourSetter")
		// .setCreativeTab(Transcraft.Transtab)
		// .setTextureName("transcraft:ColourSetter");

		TranscraftItems.Technium = new Technium().setUnlocalizedName("Transcraft:Technium").setCreativeTab(Transcraft.Transtab).setTextureName("transcraft:Technium");

		TranscraftItems.PlasticAxe = new PlasticAxe(TranscraftUtil.PlasticTool).setUnlocalizedName("Transcraft:PlasticAxe").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticHoe = new PlasticHoe(TranscraftUtil.PlasticTool).setUnlocalizedName("Transcraft:PlasticHoe").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticPickaxe = new PlasticPickaxe(TranscraftUtil.PlasticTool).setUnlocalizedName("Transcraft:PlasticPickaxe").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticShovel = new PlasticShovel(TranscraftUtil.PlasticTool).setUnlocalizedName("Transcraft:PlasticShovel").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticSword = new PlasticSword(TranscraftUtil.PlasticTool).setUnlocalizedName("Transcraft:PlasticSword").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticHelmet = (new ArmorPlasticHelmet(TranscraftUtil.PlasticEnum, 0, 0)).setUnlocalizedName("Transcraft:PlasticHelmet").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticChest = (new ArmorPlasticChestplate(TranscraftUtil.PlasticEnum, 0, 1)).setUnlocalizedName("Transcraft:PlasticChest").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticLegs = (new ArmorPlasticLegs(TranscraftUtil.PlasticEnum, 0, 2)).setUnlocalizedName("Transcraft:PlasticLegs").setCreativeTab(Transcraft.Transtab);

		TranscraftItems.PlasticBoots = (new ArmorPlasticBoots(TranscraftUtil.PlasticEnum, 0, 3)).setUnlocalizedName("Transcraft:PlasticBoots").setCreativeTab(Transcraft.Transtab);

		if (TranscraftUtil.devstuff)
			TranscraftItems.MagicalTransmutter = new MagicalTransmutter().setUnlocalizedName("Transcraft:MagicalTransmutter").setCreativeTab(Transcraft.Transtab).setTextureName("Transcraft:MagicalTransmutter");

		TranscraftItems.ColorCopier = new ColorCopier().setUnlocalizedName("Transcraft:ColorCopier").setCreativeTab(Transcraft.Transtab).setTextureName("Transcraft:ColorCopier");
	}

}
