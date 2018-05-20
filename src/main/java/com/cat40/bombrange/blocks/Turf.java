package com.cat40.bombrange.blocks;

import java.util.Random;

import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;

public class Turf extends Block 
{
    private String texturePath = Main.modid;  
    private int thisBlockID;
    
	@SideOnly(Side.CLIENT)
    public Turf (int id, Material material, String textureName)
    {       
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel("shovel", 2);
        setBlockName(textureName);
        texturePath += textureName;
        thisBlockID = id;
    }

    public int idDropped(int par1, Random par2Random, int par3)
    {
        return getIdFromBlock(Blocks.dirt);
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