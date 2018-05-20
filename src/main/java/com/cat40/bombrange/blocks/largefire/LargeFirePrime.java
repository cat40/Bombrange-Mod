package com.cat40.bombrange.blocks.largefire;

import com.cat40.bombrange.Main;
import com.cat40.bombrange.entity.EntityLargeFireball;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
//import net.minecraft.entity.projectile.EntityLargeFireball;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class LargeFirePrime extends Entity
{
    /** How long the fuse is */
    public int fuse = 4*20;
    public static float power = 0.70F;
    public static float arrowSpeed = 5;
    private static int arrowDamage = 100;
    private static int arrowPunch = 10;
    private static int arrowNum = 5; //Number of arrows in smallest ring. *arrowNumMultiplier per each subsequent ring
    private static double arrowNumMultiplier = 1.25;
    private double arrowSpacing;// = (360.0D/(double)arrowNum);
    private double[][] arrowVectors;
    private World world;
    private static int fireStrenth = 5;
    private static double velocityMultiplier = 1.125; //controls spread (max spread)
    private static int rings = 10; //number of rings spawed when detonated
    private static double ringSpacing = velocityMultiplier/rings;
    private int ringArrowNum;
    //private EntityPlayer tntPlacedBy;
    private EntityLivingBase tntPlacedBy;

    public LargeFirePrime(World par1World)
    {
        super(par1World);
        this.preventEntitySpawning = true;
        this.setSize(0.98F, 0.98F);
        this.yOffset = this.height / 2.0F;
        //need to find out where RenderTNTPrimed is called and copy that
        //Arrow not rendering at all
        
        arrowVectors = new double[rings][1];
        for(int i=0; i<rings; i++)
        {
        	ringArrowNum = (int) (arrowNum*Math.pow(arrowNumMultiplier, i));
        	arrowVectors[i] = new double[ringArrowNum];
        	arrowSpacing = (2*Math.PI)/ringArrowNum;
        	for(int i2=0; i2<ringArrowNum; i2++)
        	{
        		arrowVectors[i][i2] = arrowSpacing*(i2+1);
        	}
        }
        /*for(int i=0; i<arrowNum; i++)
        {
        	arrowVectors[i] = Math.toRadians((arrowSpacing*(i+1)));
        }*/
    }

    public LargeFirePrime(World par1World, double par2, double par4, double par6)//EntityLivingBase par8EntityLivingBase
    {
        this(par1World);
        this.setPosition(par2, par4, par6);
        float f = (float)(Math.random() * Math.PI * 2.0D);
        this.motionX = (double)(-((float)Math.sin((double)f)) * 0.02F);
        this.motionY = 0.20000000298023224D;
        this.motionZ = (double)(-((float)Math.cos((double)f)) * 0.02F);
        //this.fuse = 0.25;
        this.world = par1World;
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
            this.motionX *= 0.699999988079071D;
            this.motionZ *= 0.699999988079071D;
            this.motionY *= -0.5D;
        }

        if (this.fuse-- <= 0)
        {
            this.setDead();

            if (!this.worldObj.isRemote)
            {
                this.explode();
                //EntityArrow entityarrow = new EntityArrow(this.worldObj, this, this.tntPlacedBy, 1.6F, (float)(14 - this.worldObj.difficultySetting.getDifficultyId() * 4));
                //double
            	double[] xzvelocities;
            	double spreadMultiplier;
                int i;
                int i2;
                System.out.println("Spawned fire");
            	for(i=0; i<this.rings; i++)
                {
        			spreadMultiplier = this.ringSpacing*(i+1);
                	ringArrowNum = (int) (arrowNum*Math.pow(arrowNumMultiplier, i));
            		for(i2=0; i2<ringArrowNum; i2++)
            		{
	            		EntityLargeFireball entitylargefireball = new EntityLargeFireball(this.worldObj);
	            		xzvelocities = new double[2];
	            		xzvelocities = this.getVelocity(this.arrowVectors[i][i2]);
	            		double x = xzvelocities[0]*spreadMultiplier;//this.velocityMultiplier*spreadMultiplier;
	            		double z = xzvelocities[1]*spreadMultiplier;//this.velocityMultiplier*spreadMultiplier;
	            		double y = -3;
	            		entitylargefireball.accelerationX = x;
	            		entitylargefireball.accelerationZ = z;
	            		entitylargefireball.accelerationY = y;
	                    entitylargefireball.posX = this.posX;
	                    entitylargefireball.posY = this.posY + (double)(this.height / 2.0F) + 0.5D;
	                    entitylargefireball.posZ = this.posZ;
	                    entitylargefireball.field_92057_e = this.fireStrenth;
	                    this.worldObj.spawnEntityInWorld(entitylargefireball);
            		}
                }
            }
        }
        else
        {
            this.worldObj.spawnParticle("smoke", this.posX, this.posY + 0.5D, this.posZ, 0.0D, 0.0D, 0.0D);
        }
    }

    private void explode()
    {
        //float f = 0.70F;
        this.worldObj.createExplosion(this, this.posX, this.posY, this.posZ, Main.arrowPower, true);
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
    
    double[] getVelocity(double angle)
    {
	    double x;
	    double z;
	    double[] velocities;
	    velocities = new double[2];
	    // hypotnuse = 1
	    x = Math.sin(angle);
	    z = Math.cos(angle);
	    velocities[0] = x;
	    velocities[1] = z;
	    return velocities;
    }
}