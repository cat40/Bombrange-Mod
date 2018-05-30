package com.cat40.bombrange.blocks.explosives;

import com.cat40.bombrange.explosions.DeforestationBoomBoom;
import net.minecraft.block.material.Material;
import net.minecraft.world.World;

public class DeforestationExplosive extends Explosive {

    public DeforestationExplosive(int id, Material material, String textureName, double power)
    {
        super(id, material, textureName, power);
    }

    public void blowUp(World world, int x, int y, int z)
    {
        super.useExplosion(new DeforestationBoomBoom(world, x, y, z, (int) this.power));
    }
}
