package com.cat40.bombrange.blocks;

import java.util.Random;
import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

public class MovableObsidian extends Block 
{
    private String texturePath = "minecraft:obsidian";//Main.modid;// "bombrange:";  
    private int thisBlockID;
    
	@SideOnly(Side.CLIENT)
    public MovableObsidian(int id, Material material, String Level, int intLevel)
    {  
    	super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel(Level, intLevel);
        setBlockName(textureName);
        //texturePath += textureName;
        thisBlockID = id;
    }

	public int idDropped(int par1, Random par2Random, int par3)
    {
        return thisBlockID;
    }
    @Override
    public int quantityDropped(Random random)
    {
        return 1;
    }
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }
    
}