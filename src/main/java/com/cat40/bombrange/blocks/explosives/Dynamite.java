package com.cat40.bombrange.blocks.explosives;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Dynamite extends Explosive
{

	@SideOnly(Side.CLIENT)
    public Dynamite (int par1, Material blockMaterial, String textureName)
	{        
        super(par1, blockMaterial, textureName, 5.0F);
        this.setBlockName(textureName);
        this.setHarvestLevel("pickaxe",  1);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        super.useExplosion(new Explosion(world, null, x, y, z, (int) this.power));
    }

    @Override
    public void registerBlockIcons(IIconRegister iconRegister)
    {
        this.blockIcon = iconRegister.registerIcon(this.assetPath);
        this.field_150116_a = iconRegister.registerIcon(this.assetPath);
        this.field_150115_b = iconRegister.registerIcon(this.assetPath);
    }
}