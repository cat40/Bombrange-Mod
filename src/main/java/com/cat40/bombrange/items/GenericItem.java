package com.cat40.bombrange.items;

import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;


public class GenericItem extends Item {
    
    private String texturePath = Main.modid;
    
    public GenericItem(int ItemID, String textureName)
    {
        super();
        this.setUnlocalizedName(textureName);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        texturePath += textureName;
    }

@Override   
@SideOnly(Side.CLIENT)

    public void registerIcons(IIconRegister iconRegister)
    {
        this.itemIcon = iconRegister.registerIcon(texturePath);
    }   


}