package com.cat40.bombrange;

import net.minecraft.entity.Entity;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class BoomBoom extends Explosion {

    public BoomBoom(World world, double x, double y, double z, float power)
    {
        this(world, null, x, y, z, power);
    }

    public BoomBoom(World world, Entity entity, double x, double y, double z, float power)
    {
        super(world, entity, x, y, z, power);
    }


}
