package com.cat40.bombrange.blocks.substrate;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class FallingSubstrate extends Entity
{
    private World world;
    public int fuse = 0;
    private static final int stoneDist = 5;
    private int startY;

    public FallingSubstrate(World par1World)
    {
        super(par1World);
        world = par1World;
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
    }

    public FallingSubstrate(World par1World, double x, double y, double z)//EntityLivingBase par8EntityLivingBase
    {
        this(par1World);
        this.setPosition(x, y, z);
        this.motionX = 0;
        this.motionY = 0;
        this.motionZ = 0;
        this.world = par1World;
        this.prevPosX = x;
        this.prevPosY = y;
        this.prevPosZ = z;
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
        this.motionX *= 1;
        this.motionY *= 1;
        this.motionZ *= 1;
        /*
        for(int i=0; i<100; i++)
        {
        	this.worldObj.spawnParticle("explode", this.posX, this.posY+0.5D, this.posZ, 255, 0, 0);
        	//System.out.println(System.out.format("spawned particel at %f, %f, %f", this.posX, this.posY, this.posZ));
        	// TODO Particles not appearing when tracer is moving rapidly
        }
        */

        if (this.onGround)
        {
        	this.setDead();
            this.motionX *= 1; //0.699999988079071D;
            this.motionZ *= 1 ; //0.699999988079071D;
            this.motionY *= -0.5D;
            // sets the block to spawn to stone if the entity has fallen more than 5 blocks
            Block spawnBlock = this.posY <= this.startY - stoneDist ? Blocks.stone : Blocks.dirt;
            this.worldObj.setBlock((int) (this.posX-0.5F), (int) this.posY, (int) (this.posZ-0.5F), spawnBlock);
        }

    }

    @SideOnly(Side.CLIENT)
    @Override
    public float getShadowSize()
    {
        return 0.0F;
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