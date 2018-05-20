package com.cat40.bombrange.armor;

import com.cat40.bombrange.Main;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;

public class BlastShirt extends ItemArmor
{

	public BlastShirt(ArmorMaterial Material, int renderIndex, int type, String name)
	{
		super(Material, renderIndex, type);
		this.setUnlocalizedName(name);
	}
	
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		if (this.armorType == 2)
		{
			return Main.modid + "textures/armor/BlastArmor_2.png";
		}
		return Main.modid + "textures/armor/BlastArmor_1.png";
	}
}


