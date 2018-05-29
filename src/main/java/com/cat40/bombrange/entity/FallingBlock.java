package com.cat40.bombrange.entity;

import com.cat40.bombrange.Main;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class FallingBlock extends Entity
{
    public int fuse = 0;

    public FallingBlock(World par1World)
    {
        super(par1World);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public FallingBlock(World par1World, double par2, double par4, double par6)//EntityLivingBase par8EntityLivingBase
    {
        this(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
    }

    protected void entityInit() {}

    /**
     * Called to update the entity's position/logic.
     */
    
    @Override
    public void onUpdate()
    {
        this.fuse ++;
        this.prevPosX = this.posX;
        this.prevPosY = this.posY;
        this.prevPosZ = this.posZ;
        this.motionY -= 0.03999999910593033D;
        this.moveEntity(this.motionX, this.motionY, this.motionZ);
        this.motionX *= 0.9800000190734863D;
        this.motionY *= 0.9800000190734863D;
        this.motionZ *= 0.9800000190734863D;
        if (this.onGround)
        {
            this.setDead();
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
            this.worldObj.setBlock((int) this.posX, (int) this.posY, (int) this.posZ, errotr);
        }

    }


    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    protected void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setByte("Fuse", (byte)this.fuse);
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    protected void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.fuse = par1NBTTagCompound.getByte("Fuse");
    }
}