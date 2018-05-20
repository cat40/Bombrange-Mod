package com.cat40.bombrange.structures_backup;

import java.util.Random;
import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class BlockStructure extends Block 
{
    private String texturePath = "bombrange:";  
    private int thisBlockID;
    private StructureBlock[] structure;
    private boolean spawnAir;
    //private int[] cords;
    
	@SideOnly(Side.CLIENT)
    public BlockStructure(int id, Material material, String textureName, StructureBlock[] structure, boolean spawnAir)
    {  
    	super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        //this.setHarvestLevel(Level, intLevel);
        setBlockName(textureName);
        texturePath += textureName;
        thisBlockID = id;
        this.structure = structure;
        this.spawnAir = spawnAir;
        //this.cords = Structure.getDims(structure);
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
    
    public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (player.getCurrentEquippedItem() != null && player.getCurrentEquippedItem().getItem() == Main.Lighter)
        {
            world.setBlockToAir(x, y, z);
            int dir = MathHelper.floor_double((double)(player.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3; // 0 = north, 1 = east, etc.
            world.setBlockToAir(x, y, z);
            //world.setBlock(x, y, z, Blocks.obsidian);
            //Structure.setDir(dir, this.structure);
            Structure.spawnStructure(x, y, z, this.spawnAir, world, this.structure);
            //p_149727_5_.getCurrentEquippedItem().damageItem(1, p_149727_5_);
            return true;
        }
        else
        {
            return super.onBlockActivated(world, x, y, z, player, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
        }
    }
    
}