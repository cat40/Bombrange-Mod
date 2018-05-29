package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.explosions.MiningBoomBoom;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class MiningExplosive extends Explosive {

    @SideOnly(Side.CLIENT)
    public MiningExplosive(int id, Material material, String textureName, double power)
    {
        super(id, material, textureName, power);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        Explosion boom = new MiningBoomBoom(world, x, y, z, (int) this.power);
        boom.doExplosionA();
        boom.doExplosionB(true);
    }
}
