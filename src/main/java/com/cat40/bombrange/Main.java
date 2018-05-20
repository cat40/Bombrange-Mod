/**
 * To export: change mod version on .GRADLE file
 * Open command propmpt in 1710 modding and run "gradlew build"
 * Open resulting .jar in builds folder and copy assets into it.
 */
package com.cat40.bombrange;

import com.cat40.MyCreativeTabs;
import com.cat40.bombrange.armor.BlastShirt;
import com.cat40.bombrange.biome.BiomeRegistry;
import com.cat40.bombrange.biome.WorldTypeBombRange;
import com.cat40.bombrange.blocks.GenericBlock;
import com.cat40.bombrange.blocks.MovableObsidian;
import com.cat40.bombrange.blocks.ReGlass;
import com.cat40.bombrange.blocks.Turf;
import com.cat40.bombrange.blocks.arrow.Arrow;
import com.cat40.bombrange.blocks.arrow.ArrowPrime;
import com.cat40.bombrange.blocks.blastingcap.Blast;
import com.cat40.bombrange.blocks.c4.Half.C4_Half;
import com.cat40.bombrange.blocks.c4.I.C4_1_2;
import com.cat40.bombrange.blocks.c4.Quart.C4_Quart;
import com.cat40.bombrange.blocks.c4.ThreeQuart.C4_ThreeQuart;
import com.cat40.bombrange.blocks.c4.V.C4_5;
import com.cat40.bombrange.blocks.c4.X.C4_10;
import com.cat40.bombrange.blocks.c4.XX.C4_20;
import com.cat40.bombrange.blocks.cord.Cord;
import com.cat40.bombrange.blocks.cord.CordList;
import com.cat40.bombrange.blocks.delay.Delay1;
import com.cat40.bombrange.blocks.delay.Delay10;
import com.cat40.bombrange.blocks.delay.Delay30;
import com.cat40.bombrange.blocks.delay.Delay5;
import com.cat40.bombrange.blocks.delay.DelayPrime1;
import com.cat40.bombrange.blocks.delay.DelayPrime10;
import com.cat40.bombrange.blocks.delay.DelayPrime30;
import com.cat40.bombrange.blocks.delay.DelayPrime5;
import com.cat40.bombrange.blocks.dispenser.Dispenser;
import com.cat40.bombrange.blocks.dynamite.Dynamite;
import com.cat40.bombrange.blocks.fire.Fire;
import com.cat40.bombrange.blocks.fire.FirePrime;
import com.cat40.bombrange.blocks.gunpowder.Gunpowder;
import com.cat40.bombrange.blocks.largefire.LargeFirePrime;
import com.cat40.bombrange.blocks.potion.Potion;
import com.cat40.bombrange.blocks.potion.PotionPrime;
import com.cat40.bombrange.blocks.powder.Powder;
import com.cat40.bombrange.blocks.powder.PowderPrime;
import com.cat40.bombrange.blocks.tnt.Tnt;
import com.cat40.bombrange.blocks.tnt.TntPrime;
import com.cat40.bombrange.blocks.tracer.Tracer;
import com.cat40.bombrange.blocks.tracer.TracerPrime;
import com.cat40.bombrange.blocks.tracer.TracerUsed;
import com.cat40.bombrange.items.GenericItem;
import com.cat40.bombrange.items.Lighter;
import com.cat40.bombrange.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.Block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.util.EnumHelper;


/* 	MOD INFO */
	@Mod(modid = "bombrange", name = "Bomb Range Mod", version = "0.1.0")
	//@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "com.cat40.bombrange.proxies.ClientProxy", serverSide = "com.cat40.bombrange.proxies.CommonProxy")
	public static CommonProxy proxy;
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */
	// mod id (for textures)
public static String modid_without_colon = "bombrange";
public static String modid = modid_without_colon + ":";
/* Explosives */
public static Block Bomb;
public static Block C41;
public static Block C45;
public static Block C410;
public static Block C420;
public static Block Dyno;
public static Block C4mine;
public static Block Turf;
public static Block Blast;
public static Block Cord;
public static Block Concrete;
public static Block ReConcrete;
public static Block SteelBlock;
public static Block ReGlass;
public static Block C4Quart;
public static Block C4Half;
public static Block C4ThreeQuart;
public static Block C41_2;
public static Block Powder;
public static Block Delay1;
public static Block Delay5;
public static Block Delay10;
public static Block Delay30;
public static Block Arrow;
public static Block Fire;
public static Block Potion;
public static Block FireLarge;
public static Block Tracer;
public static Block TracerUsed;
public static Block MovableObsidian;
public static Block Benchmark;
public static Block Dispense;
public static Block Tnt;
public static Block Sandbag;
//public static Block StructOldCannon;

public static Material stone = Material.rock;
public static Material bombMat = Material.rock;

public static Item Lighter;
public static Item CIron;
public static Item Steel;
public static Item SteelBar;
public static Item Plastic;
public static Item BlastHead, BlastShirt, BlastPants, BlastShoes;
public static Item WoolHat, WoolShirt, WoolPants, WoolShoes;

// constants
public static float bombres = 3.0F;
public static int idBase = 4000;
public static int blockidBase = idBase + 50;
public static SoundType bombSound = Block.soundTypeSnow;
public static Block bombProof = Blocks.bedrock;
public static int fuseLen = 1;
public static int dispenseFuseLen = 40;
public static float indestructable = 9999F;

/* explosion powers */
public static float C4Power = 6.3F; //relastic: 6.3
public static float cordPower = 0.7F;
public static float delayPower = 0.7F;
public static float bombPower = 3F;
public static float powderPower = 10F;
public static float arrowPower = 2F;

/* Biome */
public static  BiomeGenBase BombRange; 

/* entities */
public int EntityID = EntityRegistry.findGlobalUniqueEntityId();
CordList[] cordNames = {new CordList("1 Second Delay Primed", this.Delay1),
						new CordList("5 Second Delay Primed", this.Delay5),
						new CordList("10 Second Delay Primed", this.Delay10),
						new CordList("30 Second Delay Primed", this.Delay30)};


/* Creative tabs */
public static class CreativeTabMod
{
	public static MyCreativeTabs tabBomb = new MyCreativeTabs(CreativeTabs.getNextID(), "tabBomb");
}
  
  /** harvest level, max uses, efficdancy, damage, enchangabiliity. */
        public static ToolMaterial OneUse = EnumHelper.addToolMaterial("OneUse", 0, 1, 0.0F, 0.0F, 0);  
        
        public static ArmorMaterial ArmBlast = EnumHelper.addArmorMaterial("ArmBlast", 50, new int[]{3, 5, 4, 2}, 0);
        
void RI(Item item, String name)
{
	GameRegistry.registerItem(item,  name);
}

void RB(Block item, String name)
{
	GameRegistry.registerBlock(item,  name);
}

ItemStack Enchant(ItemStack stack, Enchantment enc, int level)
{
	stack.addEnchantment(enc, level);
	return stack;
}

public static boolean bool(double n)
{
	return (n != 0);
}
/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

/** Sounds */
/* @ForgeSubscribe
public void onSound(SoundLoadEvent event) {
// You add them the same way as you add blocks.
event.manager.addSound("mod_id:Sparkler.ogg");
}
 */
@EventHandler	
	public  void preInit( FMLPreInitializationEvent event ) 
	{

/**	
 * LOAD SECTION 
 * *********************************************************** */ 

 proxy.registerRenders(); 
   /** Other */
    //  LOAD THE CREATIVE TAB
/*       public static CreativeTabs MyCreativeTab_1 = new CreativeTabs("MyCreativeTab_1")
        {
            public ItemStack getIconItemStack() {
                return new ItemStack(Lighter, 1, 0);   // Icon, Stack Size, Tab Position
            }
        };
    */     
  /*  Planned: infinate redstone for blasting purposes //  LOAD MITHREL ORE
        redstone_dust_line = new BlastWire(4007).setStepSound(Block.soundStoneFootstep).setHardness(10.0F).setResistance(9.0F).setCreativeTab(MyCreativeTab_1);
        GameRegistry.registerBlock(redstone_dust_line, "redstone_dust_line");
        //LanguageRegistry.addName(redstone_dust_line, "Detonation Wire"); 
		MinecraftForge.setBlockHarvestLevel(redstone_dust_line, "pickaxe", 1);   
     */
 /** Explosives
  * Minecraft Dynamite(5001)-5 blast power
    * Minecraft nitroglycerin (LIQUID)-6.4 Blast power
   * Minecraft C4 6.3 blast power
  * Relistic C4 -10 lbs 28.53 blast power
  * relistic c4- 1lbs -2.85
  * C4- 5 lbs 14.26
  * C4-20 lbs -57.78
  * Minecraft Gunpoweder: 3 blast power
  * Relistic Gunpowder: 4,000,000 blast power
  * todo condense all explosives into one class which has arguements for entity spawned. (think entity type is Entity
  * todo Condense all explosive entities into one class wich has argument for blast power.
  * todo remove entities and make the blocks explode instead of spawning an explosive entity.
  * todo make sandbags fall like gravel and sand
  * todo Use seperate explosives with a longer fuse when dispensed, to allow for condensing and falling into water
  */
 
 		//custom dispenser behavior
 		Bomb = new Gunpowder(idBase, stone, "Bomb").setHardness(10.0F).setStepSound(Block.soundTypeAnvil).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Bomb, "Bomb");
        
        C4Quart = new C4_Quart(++idBase, bombMat, "C4Quart").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        C4Half = new C4_Half(++idBase, bombMat, "C4Half").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        C4ThreeQuart = new C4_ThreeQuart(++idBase, bombMat, "C4ThreeQuart").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        C41 = new C4_1_2(++idBase, bombMat, "C41").setHardness(10.0F).setResistance(bombres);
        C45 = new C4_5(++idBase, bombMat, "C45").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        C410 = new C4_10(++idBase, bombMat, "C410").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        C420 = new C4_20(++idBase, bombMat, "C420").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);//*/  
       // Benchmark = new C4_10(++idBase, bombMat, "benchmark").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(C4Quart, "C4Quart").setStepSound(bombSound);
        GameRegistry.registerBlock(C4Half,  "C4Half").setStepSound(bombSound);
        GameRegistry.registerBlock(C4ThreeQuart, "C4ThreeQuart").setStepSound(bombSound);
        GameRegistry.registerBlock(C41, "C41").setStepSound(bombSound);
        GameRegistry.registerBlock(C45, "C45").setStepSound(bombSound);
        GameRegistry.registerBlock(C410, "C410").setStepSound(bombSound);
        GameRegistry.registerBlock(C420, "C420").setStepSound(bombSound);
       // GameRegistry.registerBlock(Benchmark, "Benchmark").setStepSound(bombSound);
        
        Powder = new Powder(++idBase, bombMat, "Powder").setHardness(10.0F).setStepSound(bombSound).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Powder, "Powder");

        Dyno = new Dynamite(++idBase, bombMat, "Dyno").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Dyno, "Dyno");

        Turf = new Turf(++idBase, bombMat, "Turf").setResistance(150).setStepSound(Block.soundTypeGravel).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Turf, "Turf");
        
        Blast = new Blast(++idBase, bombMat, "Blast").setStepSound(bombSound).setResistance(0.5F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Blast,  "Blast");
        
        Cord = new Cord(++idBase, bombMat, "Cord").setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Cord,  "Cord");
        
        Delay1 = new Delay1(++idBase, bombMat, "Delay1", 1*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Delay1,  "Delay1");
        
        Delay5 = new Delay5(++idBase, bombMat, "Delay5").setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Delay5,  "Delay5");
        
        Delay10 = new Delay10(++idBase, bombMat, "Delay10", 10*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Delay10,  "Delay10");
        
        Delay30 = new Delay30(++idBase, bombMat, "Delay30", 30*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Delay30,  "Delay30");
        
        Arrow = new Arrow(++idBase, bombMat, "Arrow").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Arrow,  "Arrow");
        
        Fire = new Fire(++idBase, bombMat, "Fire").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Fire, "Fire");
        
        Potion = new Potion(++idBase, bombMat, "Potion").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(Potion, "Potion");
        
        Tnt = new Tnt(++idBase, bombMat, "Tnt").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(Tnt, "Tnt");
        
        /*FireLarge = new LargeFire(++idBase, bombMat, "FireLarge").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(FireLarge, "FireLarge");*/
        //TODO FireLarge is spawning fireballs about every second (but only calls the method in the entity class once)
        //Fireballs are not exploding or lighting fires.
        
        Lighter = new Lighter(++idBase, OneUse, "Lighter").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(Lighter, "Lighter");
        //LanguageRegistry.addName(Lighter, "Fuse Lighter"); 
        
        Concrete = new GenericBlock(++idBase, Material.rock, "Concrete", "Pickaxe", 2).setResistance(50).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Concrete, "Concrete");
        
        ReConcrete = new GenericBlock(++idBase, Material.rock, "ReConcrete", "Pickaxe", 2).setResistance(70).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(ReConcrete, "ReConcrete");

        Sandbag = new GenericBlock(++idBase, Material.sand, "Sandbag", "Shovel", 0).setResistance(45);
        GameRegistry.registerBlock(Sandbag, "Sandbag"); // todo add a texture for this
        
        Steel = new GenericItem(++idBase, "Steel").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(Steel, "Steel");
        
        CIron = new GenericItem(++idBase, "CIron").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(CIron,  "CIron");
        
        SteelBar = new GenericItem(++idBase, "SteelBar").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(SteelBar, "SteelBar");
        
        ReGlass = new ReGlass(++idBase, Material.glass, "ReGlass", "Pickaxe", 0).setResistance(45).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(ReGlass, "ReGlass");
        
        Plastic = new GenericItem(++idBase, "Plastic").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(Plastic,  "Plastic");
        
        Dispense = new Dispenser(++idBase).setResistance(indestructable).setStepSound(Block.soundTypeStone).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(Dispense, "Dispense");
        //GameRegistry.registerTileEntity(Dispenser.class, "Dispense");
        
        Tracer = new Tracer(++idBase, Material.rock, "Tracer").setResistance(bombres).setStepSound(bombSound);//
        GameRegistry.registerBlock(Tracer, "Tracer");
        
        TracerUsed = new TracerUsed(++idBase, Material.rock, "Tracer").setResistance(bombres).setStepSound(bombSound).setLightLevel(0.5F);
        GameRegistry.registerBlock(TracerUsed, "TracerUsed");
        
        MovableObsidian = new MovableObsidian(++idBase, Material.rock, "pickaxe", 3).setResistance(9999F).setStepSound(Block.soundTypeStone);
        GameRegistry.registerBlock(MovableObsidian, "MovableObsidian");
        
        /*StructOldCannon = new BlockStructure(++idBase, Material.rock, "OldCannon", Structures.cannonOld, false);
        GameRegistry.registerBlock(StructOldCannon, "OldCannon");// TODO: game crashing on every loop over the structure components */
        
        // Primed Explosives (for rendering)
        EntityRegistry.registerModEntity(ArrowPrime.class, "Primed Arrow Bomb", ++EntityID, this, 256, 10, true);//, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
        EntityRegistry.registerModEntity(FirePrime.class, "Primed Fire Bomb", ++EntityID, this, 256, 10, true);
        EntityRegistry.registerModEntity(PotionPrime.class, "Primed Potion Bomb", ++EntityID, this, 256, 10, true);
        EntityRegistry.registerModEntity(PowderPrime.class, "Primed Black Powder Charge",  ++EntityID,  this,  64,  10,  true);
    	EntityRegistry.registerModEntity(DelayPrime1.class, "1 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime5.class, "5 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime10.class, "10 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime30.class, "30 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(TracerPrime.class, "Primed Tracer", ++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(LargeFirePrime.class,"Primed Large Fire Bomb", ++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(TntPrime.class,"Primed TNT Bomb", ++EntityID, this, 256, 10, true);

        BlastHead = new BlastShirt(ArmBlast, 0, 0, "BlastHead").setTextureName(modid + "BlastHead").setCreativeTab(CreativeTabMod.tabBomb);
        BlastShirt = new BlastShirt(ArmBlast, 0, 1, "BlastShirt").setTextureName(modid + "BlastShirt").setCreativeTab(CreativeTabMod.tabBomb);
        BlastPants = new BlastShirt(ArmBlast, 0, 2, "BlastPants").setTextureName(modid + "BlastPants").setCreativeTab(CreativeTabMod.tabBomb);
        BlastShoes = new BlastShirt(ArmBlast, 0, 3, "BlastShoes").setTextureName(modid + "BlastShoes").setCreativeTab(CreativeTabMod.tabBomb);
        GameRegistry.registerItem(BlastHead,  "BlastHead");
        GameRegistry.registerItem(BlastShirt, "BlastShirt");
        GameRegistry.registerItem(BlastPants, "BlastPants");
        GameRegistry.registerItem(BlastShoes, "BlastShoes");
        
        WoolHat = new GenericItem(++idBase, "WoolHat").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(WoolHat, "WoolHat");
        WoolShirt = new GenericItem(++idBase, "WoolShirt").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(WoolShirt, "WoolShirt");
        WoolPants = new GenericItem(++idBase, "WoolPants").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(WoolPants, "WoolPants");
        WoolShoes = new GenericItem(++idBase, "WoolShoes").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(WoolShoes, "WoolShoes");
       
        //biome
        BiomeRegistry.mainRegistry();
        
       
//  REMOVE OTHER BIOMES (doesn't work)
 /*   //    BiomeManager.removeSpawnBiome(BiomeGenBase.desert);
        BiomeManager.removeSpawnBiome(BiomeGenBase.desertHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.desertHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.extremeHillsEdge);
        BiomeManager.removeSpawnBiome(BiomeGenBase.forest);
        BiomeManager.removeSpawnBiome(BiomeGenBase.forestHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.frozenOcean);
        BiomeManager.removeSpawnBiome(BiomeGenBase.frozenRiver);
        BiomeManager.removeSpawnBiome(BiomeGenBase.iceMountains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.icePlains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.jungle);
        BiomeManager.removeSpawnBiome(BiomeGenBase.jungleHills);
        BiomeManager.removeSpawnBiome(BiomeGenBase.mushroomIsland);
        BiomeManager.removeSpawnBiome(BiomeGenBase.ocean);
        BiomeManager.removeSpawnBiome(BiomeGenBase.plains);
        BiomeManager.removeSpawnBiome(BiomeGenBase.river);
        BiomeManager.removeSpawnBiome(BiomeGenBase.swampland);
        BiomeManager.removeSpawnBiome(BiomeGenBase.taiga);
        BiomeManager.removeSpawnBiome(BiomeGenBase.taigaHills);  //*/
     
		/************************************Testing/*******************************************************************/
				  

	 	  // */ 
		/*************************************************************************************************************************************/
		//.setHardness(3.5F).setStepSound(soundStoneFootstep).setLightValue(0.875F). [furnace active]
		
		//.setHardness(3.0F).setResistance(5.0F).setStepSound(Block.soundStoneFootstep).
		
		//.setStepSound(Block.soundStoneFootstep) [how to set a step sound so Eclipse will actually be able to reconize it without an error] 
		/*************************************************************************************************************************************/
		

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */
 
 /* Item Stacks 
   // ItemStacks (Item/block, stack size, damage)
 ItemStack C41Stack = new ItemStack(Main.C41, 1);
 ItemStack C45Stack = new ItemStack(Main.C45, 1);
 ItemStack C410Stack = new ItemStack(Main.C410, 1);
 ItemStack C420Stack = new ItemStack(Main.C420, 1);
 ItemStack C4mineStack = new ItemStack(Main.C4mine, 1);
 ItemStack C41_2Stack = new ItemStack(Main.C41, 2);
 ItemStack C45_2Stack = new ItemStack(Main.C45, 2);
 ItemStack C410_2Stack = new ItemStack(Main.C410,2);
 ItemStack C420_2Stack = new ItemStack(Main.C420, 2);
 ItemStack C41_5Stack = new ItemStack(Main.C41, 5); */
	
	//yourItemStack.addEnchantment(Enchantment.protection, 3); // adding enchantments. Do what ever you like
 
    //  Dynamite Recipie (temporary until Nitroglycerin is added)     
        GameRegistry.addRecipe(new ItemStack(Dyno, 1),
                "SXS",
                "XSX",
                "SXS",
            'S', Blocks.sand,
            'X', Items.gunpowder
        );
    //  Gunpower bomb         
        GameRegistry.addRecipe(new ItemStack(Bomb, 5),
                "SSS",
                "SSS",
                "SSS",
            'S', Items.gunpowder);
    //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(C4Half, 1),
                "SXS",
                "XSX",
                "SXS",
            'S', Items.gunpowder,
            'X', Plastic);
            //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(Lighter, 1),
                "G",
                "S",
                "T",
            'S', Items.stick,
            'G', Items.gunpowder,
            'T', Blocks.torch);

        GameRegistry.addRecipe(new ItemStack(Concrete, 1),
                "W",
                "S",
            'S', Blocks.sand,
            'W', Items.water_bucket.setContainerItem(Items.bucket));
        
        GameRegistry.addRecipe(new ItemStack(SteelBar, 2),
                "S",
                "S",
            'S', Steel);
        
        GameRegistry.addRecipe(new ItemStack(ReConcrete, 1),
        		"R",
                "W",
                "S",
            'S', Blocks.sand,
            'W', Items.water_bucket.setContainerItem(Items.bucket),
            'R', SteelBar);
        
        GameRegistry.addRecipe(new ItemStack(Cord, 8),
                "WWW",
        	"WGW",
        	"WWW",
        'W', Blocks.wool,
        'G', Items.gunpowder);
        
        GameRegistry.addRecipe(new ItemStack(WoolHat, 1),
        				"WWW",
        				"W W",
        				
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(WoolShirt, 1),
        				"W W", 
        				"WWW", 
        				"WWW", 
        				
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(WoolPants, 1),
        				"WWW",
        				"W W",
        				"W W",
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(WoolShoes, 1),
        				"W W",
        				"W W",
        				'W', Blocks.wool);
        
     //2;1x7,7x3,1x2;1;village(size=5 distance=9)   
	 //GameRegistry.addShapelessRecipe(new ItemStack (C4mine, 1), new ItemStack (C41, 2);//, new ItemStack (C41, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (C45, 1), new ItemStack (C41, 1), new ItemStack (C41, 1), new ItemStack (C41, 1), new ItemStack (C41, 1), new ItemStack (C41, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (C410, 1), new ItemStack (C45, 1), new ItemStack (C45, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (C420, 1), new ItemStack (C410, 1), new ItemStack (C410, 1)); 
	 GameRegistry.addShapelessRecipe(new ItemStack(CIron, 1), new ItemStack (Items.coal, 1), new ItemStack (Items.iron_ingot, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(C41, 1), new ItemStack(C4Half, 1), new ItemStack(C4Half, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(C4Quart, 2),  new ItemStack(C4Half, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(C4ThreeQuart, 1),  new ItemStack(C4Quart, 1), new ItemStack(C4Quart, 1), new ItemStack(C4Quart, 1));
	 
	 ItemStack StackBlastH = new ItemStack(BlastHead, 1);//.addEnchantment(Enchantment.blastProtection, 4);
	 StackBlastH.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastC = new ItemStack(BlastShirt, 1);
	 StackBlastH.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastP = new ItemStack(BlastPants, 1);
	 StackBlastP.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastS = new ItemStack(BlastShoes, 1);
	 StackBlastS.addEnchantment(Enchantment.blastProtection, 4);
	 
	 GameRegistry.addShapelessRecipe(StackBlastH, new ItemStack(Items.iron_helmet, 1), new ItemStack(Items.leather_helmet), new ItemStack(WoolHat, 1));
	 GameRegistry.addShapelessRecipe(StackBlastC, new ItemStack(Items.iron_chestplate, 1), new ItemStack(Items.leather_chestplate, 1), new ItemStack(WoolShirt, 1));
	 GameRegistry.addShapelessRecipe(StackBlastP, new ItemStack(Items.iron_leggings, 1), new ItemStack(Items.leather_leggings, 1), new ItemStack(WoolPants, 1));
	 GameRegistry.addShapelessRecipe(StackBlastS, new ItemStack(Items.iron_boots, 1), new ItemStack(Items.leather_boots, 1), new ItemStack(WoolShoes, 1));
	 
	 GameRegistry.addSmelting(new ItemStack(CIron, 1), new ItemStack (Steel, 1), 10F);
	 GameRegistry.addSmelting(new ItemStack(Items.wheat, 1), new ItemStack(Plastic, 1), 2.0F);
	 GameRegistry.addSmelting(new ItemStack(Blocks.sapling,1), new ItemStack(Plastic, 1), 2.0F);
	 

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

    //  CHANGE TAB NAME
        //LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_1", "en_US", "The Bomb Range Mod");   
        

        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{
		WorldType BombRange = new WorldTypeBombRange(7, "Bomb Range");
		//dispenser stuff
       // BlockDispenser.dispenseBehaviorRegistry.putObject(Powder, new BehaviorProjectileDispense());
        
	}
	
}
