package modmuss50.mods.transcraft.addons.Baubles;

import baubles.api.BaubleType;
import baubles.api.IBauble;
import modmuss50.mods.transcraft.Items.TranscraftItems;
import modmuss50.mods.transcraft.api.IItemEssenceStorgeItem;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.ItemStack;

/**
 * Created with IntelliJ IDEA. User: Mark Date: 02/04/14 Time: 15:38
 */
public class EnderBauble extends IItemEssenceStorgeItem implements IBauble {

	int	ticks	= 0;

	public EnderBauble() {
		this.maxStackSize = 1;
		this.setMaxDamage(32000);
	}

	@Override
	public BaubleType getBaubleType(ItemStack itemstack) {
		return BaubleType.BELT;

	}

	@Override
	public void onWornTick(ItemStack itemstack, EntityLivingBase player) {

		if (((EntityPlayer) player).capabilities.isFlying || ((EntityPlayer) player).capabilities.isCreativeMode) {
			// itemstack.damageItem(1, player);

			if (((EntityPlayer) player).getCurrentArmor(2) != null) {
				if (((EntityPlayer) player).getCurrentArmor(2).getItem() == TranscraftItems.EnderChest) {
					((EntityPlayer) player).capabilities.setFlySpeed(0.2F);
					// itemstack.damageItem(5, player);
				}
			}
			else {
				((EntityPlayer) player).capabilities.setFlySpeed(0.05F);
			}
		}
	}

	@Override
	public void onEquipped(ItemStack itemstack, EntityLivingBase player) {

		((EntityPlayer) player).capabilities.allowFlying = true;
		player.fallDistance = 0F;
		if (!player.worldObj.isRemote) {
			player.worldObj.playSoundAtEntity(player, "random.orb", 0.1F, 1.3f);
		}

	}

	@Override
	public void onUnequipped(ItemStack itemstack, EntityLivingBase player) {
		((EntityPlayer) player).capabilities.allowFlying = false;
		((EntityPlayer) player).capabilities.isFlying = false;
	}

	@Override
	public boolean canEquip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean canUnequip(ItemStack itemstack, EntityLivingBase player) {
		return true;
	}

	@Override
	public boolean hasEffect(ItemStack par1ItemStack, int a) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack par1ItemStack) {
		return EnumRarity.rare;
	}

}
