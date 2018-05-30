package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;
public abstract class Explosive extends Block
{

    private String texturePath = Main.modid;
    private String assetPath;
    private IIcon field_150116_a;
    private IIcon field_150115_b;
    double power;

    @SideOnly(Side.CLIENT)
    public Explosive(int id, Material material, String textureName, double power)
    {
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel("pickaxe", 1);
        setBlockName(textureName);
        assetPath = texturePath + textureName;
        this.power = power;
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    @Override
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 0 ? this.field_150115_b : (p_149691_1_ == 1 ? this.field_150116_a : this.blockIcon);
    }

    public void primeTnt(World world, int x, int y, int z, int par5)
    {
        if (!world.isRemote)
        {
            if ((par5 & 1) == 1)
            {
                blowUp(world, x, y, z);
            }
        }
    }

    void useExplosion(Explosion boom)
    {
        boom.doExplosionA();
        boom.doExplosionB(true);
    }

    public abstract void blowUp(World world, int x, int y, int z);

    @Override
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    @Override
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    @Override
    public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
    {
        if (!par1World.isRemote)
        {
            this.primeTnt(par1World, par2, par3, par4, 1);
        }
    }

    @Override
    public void onBlockDestroyedByPlayer(World world, int x, int y, int z, int thing)
    {
        if (!world.isRemote)
        {
            if ((thing & 1) == 1)
            {
                this.primeTnt(world, x, y, z, 1);
            }
        }
    }

    /**
     * Return whether this block can drop from an explosion.
     */
    @Override
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(assetPath + "_side");
        this.field_150116_a = p_149651_1_.registerIcon(texturePath + "C4" + "_top");
        this.field_150115_b = p_149651_1_.registerIcon(texturePath + "C4" + "_bottom");
    }
}
