package com.cat40.recordingminecart.minecart;

import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class EntityRecordingMinecart extends EntityMinecart {

    public EntityRecordingMinecart(World world)
    {
        super(world);
    }

    public EntityRecordingMinecart(World world, double x, double y, double z)
    {
        super(world, x, y, z);
    }

    public int getMinecartType()
    {
        return 8;
    }

    private static double cordFloat(int cord)
    {
        return cord+0.5;
    }

    private static int cordInt(double cord)
    {
        return (int) (cord-0.5);
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        
    }

}
