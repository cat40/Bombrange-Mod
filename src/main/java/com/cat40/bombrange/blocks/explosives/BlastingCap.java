package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.Main;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EffectRenderer;
import net.minecraft.client.particle.EntityExplodeFX;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.World;

import java.util.Random;

public class BlastingCap extends ActivatableExplosive
{

    private static Random random = new Random();
    private  EffectRenderer effectRenderer;

    @SideOnly(Side.CLIENT)
    public BlastingCap (int id, Material material, String textureName) {
        super(id, material, textureName, 1.250F);
        this.effectRenderer = Minecraft.getMinecraft().effectRenderer;
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
        // type, positions, motions
        System.out.println("spawning particle at " + x +" " + y + " " + z);
        double spread = 2;
        for(int __=0; __<20; __++)
            Minecraft.getMinecraft().effectRenderer.addEffect(new EntityExplodeFX(world,
                    x+0.5+spread*Math.random()-0.5,
                    y+0.5+Math.random(),
                    z+0.5+spread*Math.random()-0.5,
                    (Math.random()-0.5)/10,
                    Math.random()/10,
                    (Math.random()-0.5)/10));
        for(int b=-1; b<=1; b++)
        {
            for(int a=-1; a<=1; a++)
            {
                for (int c = -1; c <= 1; c++)
                {
                    int xcord = a+x;
                    int ycord = b+y;
                    int zcord = c+z;

                    Block block = world.getBlock(xcord, ycord, zcord);
                    if (Main.explosives.contains(block))
                    {
                        block.onBlockDestroyedByExplosion(world, xcord, ycord, zcord, null);
                        world.setBlockToAir(xcord, ycord, zcord);
                    }
                }
            }
        }
    }
}
