package com.cat40.bombrange.blocks;

import java.util.Random;
import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;

/**
 * a generic block class for creating generic blocks
 */
public class GenericBlock extends Block
{
    private String texturePath = Main.modid;// "bombrange:";  
    private int thisBlockID;

    /**
     * @param id integer id of the block
     * @param material material of the block
     * @param textureName texture file name (also the name of the block, unless overridden)
     * @param tool mining tool
     * @param level mining level
     */
	@SideOnly(Side.CLIENT)
    public GenericBlock(int id, Material material, String textureName, String tool, int level)
    {
        this(id, material, textureName, textureName, tool, level);
    }

    /**
     * @param id integer id of the block
     * @param material material of the block
     * @param textureName texture file name, excluding extension
     * @param name the name of the block
     * @param tool mining tool
     * @param level mining level
     */
    @SideOnly(Side.CLIENT)
    public GenericBlock(int id, Material material, String textureName, String name, String tool, int level)
    {
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel(tool, level);
        this.setBlockName(name);
        texturePath += textureName;
        thisBlockID = id;
    }

    //todo figure out what this is supposed to be doing
	public int idDropped(int par1, Random par2Random, int par3)
    {
        return thisBlockID;
    }

    /**
     * Sets the block name
     * @param name the name of the block
     */
    public void setName(String name)
    {
        this.setBlockName(name);
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