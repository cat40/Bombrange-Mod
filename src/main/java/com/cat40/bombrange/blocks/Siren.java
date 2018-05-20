/*package com.cat40.bombrange.blocks;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class Siren extends Block
{
    /** Whether this lamp block is the powered version. 
    private final boolean powered;

    public Siren(int par1, boolean par2)
    {
        super(Material.redstoneLight);
        this.powered = par2;

        if (par2)
        {
            this.setLightValue(1.0F);
        }
    }

    /**
     * Called whenever the block is added into the world. Args: world, x, y, z
     
    public void onBlockAdded(World par1World, int par2, int par3, int par4)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, Block.redstoneLampActive.blockID, 0, 2);
            }
        }
    }

    /**
     * Lets the block know when one of its neighbor changes. Doesn't know which neighbor changed (coordinates passed are
     * their own) Args: x, y, z, neighbor blockID
     
    public void onNeighborBlockChange(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if (this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.scheduleBlockUpdate(par2, par3, par4, this.blockID, 4);
            }
            else if (!this.powered && par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
            {
                par1World.setBlock(par2, par3, par4, Block.redstoneLampActive.blockID, 0, 2);
            }
        }
    }

    /**
     * Ticks the block if it's been scheduled
     
    public void updateTick(World par1World, int par2, int par3, int par4, Random par5Random)
    {
        if (!par1World.isRemote && this.powered && !par1World.isBlockIndirectlyGettingPowered(par2, par3, par4))
        {
            par1World.setBlock(par2, par3, par4, Block.redstoneLampIdle.blockID, 0, 2);
        }
    }

    /**
     * Returns the ID of the items to drop on destruction.
     
    public int idDropped(int par1, Random par2Random, int par3)
    {
        return Block.redstoneLampIdle.blockID;
    }

    @SideOnly(Side.CLIENT)

    /**
     * only called by clickMiddleMouseButton , and passed to inventory.setCurrentItem (along with isCreative)
     
    public int idPicked(World par1World, int par2, int par3, int par4)
    {
        return Block.redstoneLampIdle.blockID;
    }
}*/
package com.cat40.bombrange.blocks;

import java.util.Random;
import com.cat40.bombrange.Main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Siren extends Block
{
    private String assetPath = Main.modid;  
    private int thisBlockID;
    private String texturePath;
    
    public Siren (int id, Material material, String textureName)
    {
        super(material);
        this.setCreativeTab(Main.CreativeTabMod.tabBomb);
        this.setHarvestLevel("pickaxe", 1);
        setBlockName(textureName);
        texturePath = assetPath + textureName;
        thisBlockID = id;
    }
    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(texturePath);
    }

    /**
     * Gets the block's texture. Args: side, meta
     
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        return p_149691_1_ == 0 ? this.field_150115_b : (p_149691_1_ == 1 ? this.field_150116_a : this.blockIcon);
    }
*/
    public void primeTnt(World par1World, int par2, int par3, int par4, int par5)
    {
        if (!par1World.isRemote)
        {
            if ((par5 & 1) == 1)
            {
            	par1World.playSound(par2, par3, par4, assetPath + "Siren", 1.0F, 1.0F, true);
            }
        }
    }
    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);

        if (p_149726_1_.isBlockIndirectlyGettingPowered(p_149726_2_, p_149726_3_, p_149726_4_))
        {
            this.onBlockDestroyedByPlayer(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_, 1);
            p_149726_1_.setBlockToAir(p_149726_2_, p_149726_3_, p_149726_4_);
        }
    }

    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        if (p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_))
        {
            this.onBlockDestroyedByPlayer(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, 1);
            p_149695_1_.setBlockToAir(p_149695_2_, p_149695_3_, p_149695_4_);
        }
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
               /* EntityTNTPrimed var7 = new EntityTNTPrimed(p_150114_1_, (double)((float)p_150114_2_ + 0.5F), (double)((float)p_150114_3_ + 0.5F), (double)((float)p_150114_4_ + 0.5F), p_150114_6_);
                p_150114_1_.spawnEntityInWorld(var7);
                p_150114_1_.playSoundAtEntity(var7, "game.tnt.primed", 1.0F, 1.0F);*/
                this.primeTnt(p_150114_1_, p_150114_2_, p_150114_3_, p_150114_4_, 1);
            }
        }
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_5_.getCurrentEquippedItem() != null && p_149727_5_.getCurrentEquippedItem().getItem() == Main.Lighter)
        {
            //this.func_150114_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1, p_149727_5_);
            p_149727_1_.setBlockToAir(p_149727_2_, p_149727_3_, p_149727_4_);
            //p_149727_5_.getCurrentEquippedItem().damageItem(1, p_149727_5_);
            this.primeTnt(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, 1);
            return true;
        }
        else
        {
            return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
        }
    }

    public void onEntityCollidedWithBlock(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_)
    {
        if (p_149670_5_ instanceof EntityArrow && !p_149670_1_.isRemote)
        {
            EntityArrow var6 = (EntityArrow)p_149670_5_;

            if (var6.isBurning())
            {
                //this.func_150114_a(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1, var6.shootingEntity instanceof EntityLivingBase ? (EntityLivingBase)var6.shootingEntity : null);
            	this.primeTnt(p_149670_1_, p_149670_2_, p_149670_3_, p_149670_4_, 1);
            	p_149670_1_.setBlockToAir(p_149670_2_, p_149670_3_, p_149670_4_);
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
}

