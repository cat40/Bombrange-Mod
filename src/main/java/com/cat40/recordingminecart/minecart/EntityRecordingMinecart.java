package com.cat40.recordingminecart.minecart;

import jdk.nashorn.internal.runtime.regexp.joni.exception.ValueException;
import net.minecraft.block.Block;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.world.World;

public class EntityRecordingMinecart extends EntityMinecart {

    private double prevX, prevY, prevZ;
    private Block ballast, left, right;

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

    /**
     * @return the direction the minecart is moving. does not check for vertical movement
     */
    private int getDirection()
    {
        if(this.prevX - this.posX >= 1)
            return 1;
        else if (this.prevX - this.posX <= -1)
            return 2;
        else if (this.prevZ - this.posZ >= 1)
            return 3;
        else if (this.prevZ - this.posZ <= -1)
            return 4;
        return -1;
    }

    @Override
    public void onUpdate()
    {
        super.onUpdate();
        if(this.getDirection() > 0)
        {
            // do stuff
            this.ballast = this.worldObj.getBlock(cordInt(this.posX), cordInt(this.posY-1), cordInt(this.posZ));
            switch(getDirection())
            {
                case 1:
                    left = this.worldObj.getBlock(cordInt(this.posX), cordInt(this.posY), cordInt(this.posZ-1));
                    right = this.worldObj.getBlock(cordInt(this.posX), cordInt(this.posY), cordInt(this.posZ+1));
                    break;
                case 2:
                    left = this.worldObj.getBlock(cordInt(this.posX), cordInt(this.posY), cordInt(this.posZ+1));
                    right = this.worldObj.getBlock(cordInt(this.posX), cordInt(this.posY), cordInt(this.posZ-1));
                    break;
                case 3:
                    left = this.worldObj.getBlock(cordInt(this.posX+1), cordInt(this.posY), cordInt(this.posZ));
                    right = this.worldObj.getBlock(cordInt(this.posX-1), cordInt(this.posY), cordInt(this.posZ));
                    break;
                case 4:
                    left = this.worldObj.getBlock(cordInt(this.posX-1), cordInt(this.posY), cordInt(this.posZ));
                    right = this.worldObj.getBlock(cordInt(this.posX+1), cordInt(this.posY), cordInt(this.posZ));
                    break;
                default:
                    throw new ValueException("direction " + getDirection() + " makes no sense");
            }
            this.prevX = this.posX;
            this.prevY = this.posY;
            this.prevZ = this.posZ;
        }
    }
}
