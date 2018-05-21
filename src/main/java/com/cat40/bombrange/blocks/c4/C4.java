package com.cat40.bombrange.blocks.c4;

import com.cat40.bombrange.Main;
import com.cat40.bombrange.entity.DummyEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.IIcon;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;
public class C4 extends Block
{

    private String texturePath = Main.modid;
    private String assetPath;
    private IIcon field_150116_a;
    private IIcon field_150115_b;
    private double power;

    @SideOnly(Side.CLIENT)
    public C4(int id, Material material, String textureName, double power)
    {
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel("pickaxe", 1);
        setBlockName(textureName);
        assetPath = texturePath + textureName;
        this.power = power;
    }

    @Override
    /**
     * Gets the block's texture. Args: side, meta
     */
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
                world.createExplosion(new DummyEntity(world), x, y, z, (float) this.power, true);
            }
        }
    }
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    /**
     * Returns the quantity of items to drop on block destruction.
     */
    public int quantityDropped(Random p_149745_1_)
    {
        return 1;
    }

    /**
     * Called upon the block being destroyed by an explosion
     */
    public void onBlockDestroyedByExplosion(World par1World, int par2, int par3, int par4, Explosion par5Explosion)
    {
        if (!par1World.isRemote)
        {
            this.primeTnt(par1World, par2, par3, par4, 1);
        }
    }

    public void onBlockDestroyedByPlayer(World p_149664_1_, int p_149664_2_, int p_149664_3_, int p_149664_4_, int p_149664_5_)
    {
        this.func_150114_a(p_149664_1_, p_149664_2_, p_149664_3_, p_149664_4_, p_149664_5_, (EntityLivingBase)null);
    }

    public void func_150114_a(World p_150114_1_, int p_150114_2_, int p_150114_3_, int p_150114_4_, int p_150114_5_, EntityLivingBase p_150114_6_)
    {
        if (!p_150114_1_.isRemote)
        {
            if ((p_150114_5_ & 1) == 1)
            {
                this.primeTnt(p_150114_1_, p_150114_2_, p_150114_3_, p_150114_4_, 1);
            }
        }
    }


    /**
     * Return whether this block can drop from an explosion.
     */
    public boolean canDropFromExplosion(Explosion p_149659_1_)
    {
        return false;
    }

    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(assetPath + "_side");
        this.field_150116_a = p_149651_1_.registerIcon(texturePath + "C4" + "_top");
        this.field_150115_b = p_149651_1_.registerIcon(texturePath + "C4" + "_bottom");
    }
}
