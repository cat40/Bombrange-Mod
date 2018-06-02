package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
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
        for (int i = 0; i < 8; i++)
        {
            int a = (int) Math.pow(-1, i / 4);
            int b = (int) Math.pow(-1, i / 2);
            int c = (int) Math.pow(-1, i);
            Block block = world.getBlock(a*x, b*y, c*z);
            if(block.getMaterial() == Main.bombMat)
            {
                block.onBlockDestroyedByExplosion(world, a*x, b*y, c*z, null);
                world.setBlockToAir(a*x, b*y, c*z);
            }


        }
    }
}
