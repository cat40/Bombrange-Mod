package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;

public class BlastingCap extends ActivatableExplosive
{

    @SideOnly(Side.CLIENT)
    public BlastingCap (int id, Material material, String textureName) {
        super(id, material, textureName, 1.250F);
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.assetPath);
        this.field_150116_a = iconRegister.registerIcon(this.assetPath);
        this.field_150115_b = iconRegister.registerIcon(this.assetPath);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        for(int b=-1; b<=1; b++)
        {
            for(int a=-1; a<=1; a++)
            {
                for (int c = -1; c <= 1; c++)
                {
                    Block block = world.getBlock(a + x, b + y, c + z);
                    System.out.println(Blocks.tnt.getMaterial());
                    if (block.getMaterial() == Main.bombMat)
                    {
                        //world.setBlock(a + x, b + y, c + z, Blocks.brick_block);
                        block.onBlockDestroyedByExplosion(world, a*x, b*y, c*z, null);
                        world.setBlockToAir(a*x, b*y, c*z);
                    }
                }
            }
        }
    }
}
