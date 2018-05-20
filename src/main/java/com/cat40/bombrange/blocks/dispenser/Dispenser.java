package com.cat40.bombrange.blocks.dispenser;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import com.cat40.bombrange.Main;
import com.cat40.bombrange.blocks.arrow.ArrowPrime;
import com.cat40.bombrange.blocks.blastingcap.BlastPrime;
import com.cat40.bombrange.blocks.c4.Half.HalfPrime;
import com.cat40.bombrange.blocks.c4.I.IPrime;
import com.cat40.bombrange.blocks.c4.Quart.QuartPrime;
import com.cat40.bombrange.blocks.c4.ThreeQuart.ThreeQuartPrime;
import com.cat40.bombrange.blocks.c4.V.VPrime;
import com.cat40.bombrange.blocks.c4.X.XPrime;
import com.cat40.bombrange.blocks.c4.XX.XXPrime;
import com.cat40.bombrange.blocks.delay.DelayPrime1;
import com.cat40.bombrange.blocks.delay.DelayPrime10;
import com.cat40.bombrange.blocks.delay.DelayPrime30;
import com.cat40.bombrange.blocks.delay.DelayPrime5;
import com.cat40.bombrange.blocks.fire.FirePrime;
import com.cat40.bombrange.blocks.gunpowder.GunpowderPrime;
import com.cat40.bombrange.blocks.potion.PotionPrime;
import com.cat40.bombrange.blocks.powder.PowderPrime;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockPistonBase;
import net.minecraft.block.BlockSourceImpl;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.dispenser.BehaviorDefaultDispenseItem;
import net.minecraft.dispenser.IBlockSource;
import net.minecraft.dispenser.IPosition;
import net.minecraft.dispenser.PositionImpl;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityDispenser;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IIcon;
import net.minecraft.util.IRegistry;
import net.minecraft.util.RegistryDefaulted;
import net.minecraft.world.World;

public class Dispenser extends BlockContainer
{
    public static final IRegistry dispenseBehaviorRegistry = new RegistryDefaulted(new BehaviorDefaultDispenseItem());
    protected Random field_149942_b = new Random();
    protected IIcon field_149944_M;
    protected IIcon field_149945_N;
    protected IIcon field_149946_O;
    static int thisBlockID;
    int orientation;
    private static final String __OBFID = "CL_00000229";

    public Dispenser(int id)
    {
        super(Material.rock);
        thisBlockID = id;
        //this.setCreativeTab(CreativeTabs.tabRedstone);
    }

    public int func_149738_a(World p_149738_1_)
    {
        return 4;
    }
    
/*    Entity get_entity(Class c, World world, int x, int y, int z)
    {
    	return new c.newInstance(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5));
    }*/

    public void onBlockAdded(World p_149726_1_, int p_149726_2_, int p_149726_3_, int p_149726_4_)
    {
        super.onBlockAdded(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
        this.func_149938_m(p_149726_1_, p_149726_2_, p_149726_3_, p_149726_4_);
    }

    private void func_149938_m(World world, int x, int y, int z)
    {
        if (!world.isRemote)
        {
            Block var5 = world.getBlock(x, y, z - 1);
            Block var6 = world.getBlock(x, y, z + 1);
            Block var7 = world.getBlock(x - 1, y, z);
            Block var8 = world.getBlock(x + 1, y, z);
            byte var9 = 3;

            if (var5.func_149730_j() && !var6.func_149730_j())
            {
                var9 = 3;
            }

            if (var6.func_149730_j() && !var5.func_149730_j())
            {
                var9 = 2;
            }

            if (var7.func_149730_j() && !var8.func_149730_j())
            {
                var9 = 5;
            }

            if (var8.func_149730_j() && !var7.func_149730_j())
            {
                var9 = 4;
            }

            world.setBlockMetadataWithNotify(x, y, z, var9, 2);
        }
    }

    /**
     * Gets the block's texture. Args: side, meta
     */
    public IIcon getIcon(int p_149691_1_, int p_149691_2_)
    {
        int var3 = p_149691_2_ & 7;
        return p_149691_1_ == var3 ? (var3 != 1 && var3 != 0 ? this.field_149945_N : this.field_149946_O) : (var3 != 1 && var3 != 0 ? (p_149691_1_ != 1 && p_149691_1_ != 0 ? this.blockIcon : this.field_149944_M) : this.field_149944_M);
    }

    public void registerBlockIcons(IIconRegister p_149651_1_)
    {
        this.blockIcon = p_149651_1_.registerIcon("furnace_side");
        this.field_149944_M = p_149651_1_.registerIcon("furnace_top");
        this.field_149946_O = p_149651_1_.registerIcon(Main.modid + "dispenser_front_vertical");
        this.field_149945_N = this.field_149946_O;//p_149651_1_.registerIcon(Main.modid + "dispenser_front_horizontal");
    }

    /**
     * Called upon block activation (right click on the block.)
     */
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
        if (p_149727_1_.isRemote)
        {
            return true;
        }
        else
        {
            TileEntityDispenser var10 = (TileEntityDispenser)p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);

            if (var10 != null)
            {
                p_149727_5_.func_146102_a(var10);
            }

            return true;
        }
    }

    protected void func_149941_e(World world, int x, int y, int z)
    {
        BlockSourceImpl var5 = new BlockSourceImpl(world, x, y, z);
        TileEntityDispenser var6 = (TileEntityDispenser)var5.getBlockTileEntity();

        if (var6 != null)
        {
            int var7 = var6.func_146017_i();

            if (var7 < 0)
            {
                world.playAuxSFX(1001, x, y, z, 0);
            }
            else
            {
        		//IPrime entitytntprimed = new IPrime(world, (double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5));
                //world.spawnEntityInWorld(entitytntprimed);
                ItemStack var8 = var6.getStackInSlot(var7);
                String name = var8.getUnlocalizedName();
            	var8 = var6.decrStackSize(var7, 1);
                //might be able to put hashmap in Main and only make the new entity on each dispenser call
                //might not be causing demage becuase it thinks the world is not remote
              //  boolean wasRemote = world.isRemote; //this fix is undesirable for servers!. And not working
              //  world.isRemote = false;
            	System.out.println(world.isRemote);
            	double bombx = x + 0.5;
            	double bomby = y;// + 0.5;
            	double bombz = z + 0.5;
            	double offset = 1.0;
            	//this.orientation = this.func_149939_a((IBlockSource) var6);
            	this.orientation = world.getBlockMetadata(x,y,z);
            	System.out.println(this.orientation);
            	//z = north/south
            	//x = east/west
            	//y = up/down
            	//0=down, 1=up
            	//2=south, 5=west, 3=north, 4=east 
            	if (this.orientation == 8) //down
            	{
            		bomby -= offset;
            	}
            	else if (this.orientation == 9)//9)//1) //up
            	{
            		bomby += offset;
            	}
            	else if (this.orientation == 10)//2)//north
            	{
            		bombz -= offset;
            	}
            	else if (this.orientation == 11)//3)//south
            	{
            		bombz += offset;
            	}
            	else if (this.orientation == 12)//4)//east
            	{
            		bombx -= offset;
            	}
            	else if (this.orientation == 13)//5)//west
            	{
            		bombx += offset;
            	}
                Map<String, Entity> bombs = new HashMap<String, Entity>();
                bombs.put("tile.C4Quart", new QuartPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C4Half", new HalfPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C4ThreeQuart", new ThreeQuartPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C41", new IPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C45", new VPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C410", new XPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.C420", new XXPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.Delay1", new DelayPrime1(world, bombx, bomby, bombz));
                bombs.put("tile.Delay5", new DelayPrime5(world, bombx, bomby, bombz));
                bombs.put("tile.Delay10", new DelayPrime10(world, bombx, bomby, bombz));
                bombs.put("tile.Delay30", new DelayPrime30(world, bombx, bomby, bombz));
                bombs.put("tile.Powder", new PowderPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.Arrow", new ArrowPrime(world, bombx, bomby, bombz));
                bombs.put("tile.Potion", new PotionPrime(world, bombx, bomby, bombz));
                bombs.put("tile.Fire", new FirePrime(world, bombx, bomby, bombz));
                bombs.put("tile.Bomb", new GunpowderPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                bombs.put("tile.Blast", new BlastPrime(world, bombx, bomby, bombz, Main.dispenseFuseLen));
                if (bombs.containsKey(name))
                {
                	Entity entity = bombs.get(name);
                	world.spawnEntityInWorld(bombs.get(name));
                	//world.createExplosion(entity, x, y, z, 10F, true);
                }
                else
                {
                	world.playAuxSFX(1001, x, y, z, 0);
                }
                
                //world.isRemote = wasRemote;

               /* ItemStack var8 = var6.getStackInSlot(var7);
                IBehaviorDispenseItem var9 = this.func_149940_a(var8);

                if (var9 != DispenseBehavior.itemDispenseBehaviorProvider)
                {
                    ItemStack var10 = var9.dispense(var5, var8);
                    var6.setInventorySlotContents(var7, var10.stackSize == 0 ? null : var10);
                } */
            }
        }
    }

 private int func_149939_a() {
		// TODO Auto-generated method stub
		return 0;
	}

/*   protected IBehaviorDispenseItem func_149940_a(ItemStack p_149940_1_)
    {
        return (IBehaviorDispenseItem)dispenseBehaviorRegistry.getObject(p_149940_1_.getItem());
    }*/

    public void onNeighborBlockChange(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_)
    {
        boolean var6 = p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_, p_149695_4_) || p_149695_1_.isBlockIndirectlyGettingPowered(p_149695_2_, p_149695_3_ + 1, p_149695_4_);
        int var7 = p_149695_1_.getBlockMetadata(p_149695_2_, p_149695_3_, p_149695_4_);
        boolean var8 = (var7 & 8) != 0;

        if (var6 && !var8)
        {
            p_149695_1_.scheduleBlockUpdate(p_149695_2_, p_149695_3_, p_149695_4_, this, this.func_149738_a(p_149695_1_));
            p_149695_1_.setBlockMetadataWithNotify(p_149695_2_, p_149695_3_, p_149695_4_, var7 | 8, 4);
        }
        else if (!var6 && var8)
        {
            p_149695_1_.setBlockMetadataWithNotify(p_149695_2_, p_149695_3_, p_149695_4_, var7 & -9, 4);
        }
    }

    /**
     * Ticks the block if it's been scheduled
     */
    public void updateTick(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_)
    {
        if (!p_149674_1_.isRemote)
        {
            this.func_149941_e(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_);
        }
    }

    /**
     * Returns a new instance of a block's tile entity class. Called on placing the block.
     */
    public TileEntity createNewTileEntity(World p_149915_1_, int p_149915_2_)
    {
        return new TileEntityDispenser();
    }

    /**
     * Called when the block is placed in the world.
     */
    public void onBlockPlacedBy(World p_149689_1_, int p_149689_2_, int p_149689_3_, int p_149689_4_, EntityLivingBase p_149689_5_, ItemStack p_149689_6_)
    {
        int var7 = BlockPistonBase.determineOrientation(p_149689_1_, p_149689_2_, p_149689_3_, p_149689_4_, p_149689_5_);
        p_149689_1_.setBlockMetadataWithNotify(p_149689_2_, p_149689_3_, p_149689_4_, var7, 2);
        this.orientation = var7;
        if (p_149689_6_.hasDisplayName())
        {
            ((TileEntityDispenser)p_149689_1_.getTileEntity(p_149689_2_, p_149689_3_, p_149689_4_)).func_146018_a(p_149689_6_.getDisplayName());
        }
    }

    public void breakBlock(World p_149749_1_, int p_149749_2_, int p_149749_3_, int p_149749_4_, Block p_149749_5_, int p_149749_6_)
    {
        TileEntityDispenser var7 = (TileEntityDispenser)p_149749_1_.getTileEntity(p_149749_2_, p_149749_3_, p_149749_4_);

        if (var7 != null)
        {
            for (int var8 = 0; var8 < var7.getSizeInventory(); ++var8)
            {
                ItemStack var9 = var7.getStackInSlot(var8);

                if (var9 != null)
                {
                    float var10 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
                    float var11 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;
                    float var12 = this.field_149942_b.nextFloat() * 0.8F + 0.1F;

                    while (var9.stackSize > 0)
                    {
                        int var13 = this.field_149942_b.nextInt(21) + 10;

                        if (var13 > var9.stackSize)
                        {
                            var13 = var9.stackSize;
                        }

                        var9.stackSize -= var13;
                        EntityItem var14 = new EntityItem(p_149749_1_, (double)((float)p_149749_2_ + var10), (double)((float)p_149749_3_ + var11), (double)((float)p_149749_4_ + var12), new ItemStack(var9.getItem(), var13, var9.getItemDamage()));

                        if (var9.hasTagCompound())
                        {
                            var14.getEntityItem().setTagCompound((NBTTagCompound)var9.getTagCompound().copy());
                        }

                        float var15 = 0.05F;
                        var14.motionX = (double)((float)this.field_149942_b.nextGaussian() * var15);
                        var14.motionY = (double)((float)this.field_149942_b.nextGaussian() * var15 + 0.2F);
                        var14.motionZ = (double)((float)this.field_149942_b.nextGaussian() * var15);
                        p_149749_1_.spawnEntityInWorld(var14);
                    }
                }
            }

            p_149749_1_.func_147453_f(p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_);
        }

        super.breakBlock(p_149749_1_, p_149749_2_, p_149749_3_, p_149749_4_, p_149749_5_, p_149749_6_);
    }

    public static IPosition func_149939_a(IBlockSource p_149939_0_)
    {
        EnumFacing var1 = func_149937_b(p_149939_0_.getBlockMetadata());
        double var2 = p_149939_0_.getX() + 0.7D * (double)var1.getFrontOffsetX();
        double var4 = p_149939_0_.getY() + 0.7D * (double)var1.getFrontOffsetY();
        double var6 = p_149939_0_.getZ() + 0.7D * (double)var1.getFrontOffsetZ();
        return new PositionImpl(var2, var4, var6);
    }

    public static EnumFacing func_149937_b(int p_149937_0_)
    {
        return EnumFacing.getFront(p_149937_0_ & 7);
    }

    public boolean hasComparatorInputOverride()
    {
        return true;
    }

    public int getComparatorInputOverride(World p_149736_1_, int p_149736_2_, int p_149736_3_, int p_149736_4_, int p_149736_5_)
    {
        return Container.calcRedstoneFromInventory((IInventory)p_149736_1_.getTileEntity(p_149736_2_, p_149736_3_, p_149736_4_));
    }
}
