package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.explosions.StoneBoomBoom;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class StoneExplosive extends Explosive {

    public StoneExplosive(int id, Material material, String textureName, double power)
    {
        super(id, material, textureName, power);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        super.useExplosion(new StoneBoomBoom(world, x, y, z, (int) this.power));
    }
}