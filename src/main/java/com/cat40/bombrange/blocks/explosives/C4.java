package com.cat40.bombrange.blocks.explosives;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class C4 extends Explosive
{

    @SideOnly(Side.CLIENT)
    public C4(int id, Material material, String textureName, double power)
    {
        super(id, material, textureName, power);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        super.useExplosion(new Explosion(world, null, x, y, z, (int) this.power));
    }

    @Override
    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon(assetPath + "_side");
        this.field_150116_a = p_149651_1_.registerIcon(texturePath + "C4" + "_top");
        this.field_150115_b = p_149651_1_.registerIcon(texturePath + "C4" + "_bottom");
    }
}