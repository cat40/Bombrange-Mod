package com.cat40.bombrange.blocks.substrate;

import com.cat40.bombrange.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

/**
 * todo: make another version that drops itself, and remains substrate when placed
 */
public class Substrate extends Block
{
    private String texturePath = Main.modid;  
    static int thisBlockID;
    final static int forceStone = 40;
    private int startx, starty, startz;
    
    public Substrate(int id, Material material, String textureName) {
        
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel("shovel", 1);
        setBlockName(textureName);
        texturePath += textureName;
        thisBlockID = id;
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }

    @Override
    public void onBlockAdded(World world, int x, int y, int z)
    {
        startx = x; starty = y; startz = z;
        super.onBlockAdded(world, x, y, z);

        if (world.isBlockIndirectlyGettingPowered(x, y, z))
        {
            this.onBlockDestroyedByPlayer(world, x, y, z, 1);
            world.setBlockToAir(x, y, z);
        }
        if (world.isAirBlock(x, y-1, z)) // todo check if it's a liquid
        {
            world.spawnEntityInWorld(new FallingSubstrate(world, x+0.5F, y, z+0.5F));
            world.setBlockToAir(x, y, z);
        }

        else
        {
            world.setBlockToAir(x, y, z); // this might be unessesary
            if(y <= forceStone)
                world.setBlock(x, y, z, Blocks.stone);
            else
                world.setBlock(x, y, z, Blocks.dirt);
        }
    }

    // can probably delete this, it's pretty much irrelevent
    @Override
    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        if (p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_))
        {
            this.onBlockDestroyedByPlayer(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
            p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
        }
    }

    // todo figure out what this does
    // seems to destroy the block if a burning arrow hit it
    @Override
    public void onEntityCollidedWithBlock(World world, int x, int y, int z, Entity entity)
    {
        if (entity instanceof EntityArrow && !world.isRemote)
        {
            EntityArrow var6 = (EntityArrow)entity;

            if (var6.isBurning())
            {
                //this.func_150114_a(world, x, y, z, 1, var6.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)var6.shootingEntity : null);
            	world.setBlockToAir(x, y, z);
            }
        }
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return true;
    }
}
