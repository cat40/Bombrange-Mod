package com.cat40;

import com.cat40.bombrange.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class MyCreativeTabs extends CreativeTabs
{
	public MyCreativeTabs(int id, String name)
	{
		super(id, name);
	}
	@SideOnly(Side.CLIENT)
	public Item getTabIconItem()
	{
		return Main.lighter;
	}
}
