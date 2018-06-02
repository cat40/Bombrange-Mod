/*package com.cat40.bombrange.armor;

import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class BlastArmor extends ItemArmor{

    private String texturePath = Main.modid + "textures/armor/";
    private String iconPath = Main.modid;

    public BlastArmor(int par1, ArmorMaterial par2EnumArmorMaterial, int par3, int par4, String myArmorName) {
        super(par2EnumArmorMaterial, par3, par4);
        this.setMaxStackSize(1);
        //this.setCreativeTab(CreativeTabs.tabCombat);
        this.SetArmorType(myArmorName, par4);
    }


    private void SetArmorType(String myArmorName, int par4)
    {
        switch(par4)
        {
        case 0:
            this.setUnlocalizedName("MyHelmet_1");
            this.texturePath += myArmorName + "_1.png";
            //this.texturePath = "bombrange:textures/armor/myarmor_1";
            this.iconPath += "MyHelmet_1";
            break;
        case 1:
            this.setUnlocalizedName("MyChest_1");
            this.texturePath += myArmorName + "_1.png";
            this.iconPath += "MyChest_1";
            break;
        case 2:
            this.setUnlocalizedName("MyLeggings_1");
            this.texturePath += myArmorName + "_2.png";
            this.iconPath += "MyLeggings_1";
            break;
        case 3:
            this.setUnlocalizedName("MyBoots_1");
            this.texturePath += myArmorName + "_1.png";
            this.iconPath += "MyBoots_1";
            break;
        }
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister reg)
    {
        this.itemIcon = reg.registerIcon(this.iconPath);
    }

    public String getArmorTexture(ItemStack stack, Entity entity, int layer, int slot)
    {
        return this.texturePath;
    	//return "bombrange:textures/armor/myarmor_1";
    }

}*/

package com.cat40.bombrange.armor;

import net.minecraft.item.ItemArmor;

public class BlastArmorOld extends ItemArmor {

	public BlastArmorOld(String unlocalizedName, ArmorMaterial material, int renderIndex, int armorType) {
		super(material, renderIndex, armorType);

		this.setUnlocalizedName(unlocalizedName);
	}

	/*@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
		if (itemStack.getItem() == Main.BlastHead) {
			this.effectPlayer(player, potion.nightVision, 0);
		}
		if (itemStack.getItem() == ModItems.tutorialChestplate) {
			this.effectPlayer(player, potion.digSpeed, 0);
		}
		if (itemStack.getItem() == ModItems.tutorialLeggings) {
			this.effectPlayer(player, potion.moveSpeed, 0);
		}
		if (itemStack.getItem() == ModItems.tutorialBoots) {
			this.effectPlayer(player, potion.jump, 1);
		}

		if (this.isWearingFullSet(player, ModItems.tutorialHelmet, ModItems.tutorialChestplate, ModItems.tutorialLeggings, ModItems.tutorialBoots)) {
			this.effectPlayer(player, potion.regeneration, 1);
		}
	}*/
/*
	private void effectPlayer(EntityPlayer player, potion potion, int amplifier) {
		//Always effect for 8 seconds, then refresh
	//	if (player.getActivePotionEffect(potion) == null || player.getActivePotionEffect(potion).getDuration() <= 1)
			//player.addPotionEffect(new PotionEffect(potion.id, 159, amplifier, true, true));
	}

	private boolean isWearingFullSet(EntityPlayer player, Item helmet, Item chestplate, Item leggings, Item boots) {
		return player.inventory.armorItemInSlot(3) != null && player.inventory.armorItemInSlot(3).getItem() == helmet
				&& player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem() == chestplate
				&& player.inventory.armorItemInSlot(1) != null && player.inventory.armorItemInSlot(1).getItem() == leggings
				&& player.inventory.armorItemInSlot(0) != null && player.inventory.armorItemInSlot(0).getItem() == boots;
	}*/
}


