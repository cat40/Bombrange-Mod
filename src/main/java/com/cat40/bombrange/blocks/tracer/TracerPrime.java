package com.cat40.bombrange.blocks.tracer;

import com.cat40.bombrange.Main;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class TracerPrime extends Entity
{
    private World world;
    private EntityLivingBase tntPlacedBy;
    public int fuse = 0;

    public TracerPrime(World par1World)
    {
        super(par1World);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public TracerPrime(World par1World, double par2, double par4, double par6)//EntityLivingBase par8EntityLivingBase
    {
        this(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        //this.fuse = 0.25;
        this.world=par1World;
        this.prevPosX = par2;
        this.prevPosY = par4;
        this.prevPosZ = par6;
        //this.tntPlacedBy = par8EntityLivingBase;
    }

    protected void entityInit() {}

    /**
     * returns if this entity triggers Block.onEntityWalking on the blocks they walk on. used for spiders and wolves to
     * prevent them from trampling crops
     */
    protected boolean canTriggerWalking()
    {
        return false;
    }

    /**
     * Returns true if other Entities should be prevented from moving through this Entity.
     */
    public boolean canBeCollidedWith()
    {
        return !this.isDead;
    }

    /**
     * Called to update the entity's position/logic.
     */
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
        for(int i=0; i<100; i++)
        {
        	this.worldObj.spawnParticle("explode", this.posX, this.posY+0.5D, this.posZ, 255, 0, 0);
        	//System.out.println(System.out.format("spawned particel at %f, %f, %f", this.posX, this.posY, this.posZ));
        	// TODO Particles not appearing when tracer is moving rapidly
        }
        if (this.onGround)
        {
        	this.setDead();
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
            this.worldObj.setBlock((int) this.posX, (int) this.posY, (int) this.posZ, Main.tracerUsed);
        }

    }

    private void explode()
    {
        //float f = 0.70F;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, Main.arrowPower, true);
    }

    @SideOnly(Side.CLIENT)
    public float getShadowSize()
    {
        return 0.0F;
    }

    /**
     * returns null or the entityliving it was placed or ignited by
     */
    public EntityLivingBase getTntPlacedBy()
    {
        return this.tntPlacedBy;
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