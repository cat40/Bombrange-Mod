package com.cat40.bombrange.blocks.explosives;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class Blast extends ActivatableExplosive
{

	@SideOnly(Side.CLIENT)
    public Blast (int id, Material material, String textureName) {
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
        super.useExplosion(new Explosion(world, null, x, y, z, (int) this.power));
    }
}
