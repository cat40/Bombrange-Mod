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
import com.cat40.bombrange.blocks.cord.Cord;
import com.cat40.bombrange.blocks.cord.CordList;
import com.cat40.bombrange.blocks.delay.*;
import com.cat40.bombrange.blocks.dispenser.Dispenser;
import com.cat40.bombrange.blocks.explosives.*;
import com.cat40.bombrange.blocks.fire.Fire;
import com.cat40.bombrange.blocks.fire.FirePrime;
import com.cat40.bombrange.blocks.largefire.LargeFirePrime;
import com.cat40.bombrange.blocks.potion.Potion;
import com.cat40.bombrange.blocks.potion.PotionPrime;
import com.cat40.bombrange.blocks.powder.Powder;
import com.cat40.bombrange.blocks.powder.PowderPrime;
import com.cat40.bombrange.blocks.substrate.FallingSubstrate;
import com.cat40.bombrange.blocks.substrate.Substrate;
import com.cat40.bombrange.blocks.tnt.Tnt;
import com.cat40.bombrange.blocks.tnt.TntPrime;
import com.cat40.bombrange.blocks.tracer.Tracer;
import com.cat40.bombrange.blocks.tracer.TracerPrime;
import com.cat40.bombrange.blocks.tracer.TracerUsed;
import com.cat40.bombrange.entity.DummyEntity;
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

import java.util.ArrayList;
import java.util.List;


/* 	MOD INFO */
	@Mod(modid = "bombrange", name = "bomb Range Mod", version = "0.2.0")
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
public static Block bomb;
public static Block c41;
public static Block c45;
public static Block c410;
public static Block c420;
public static Block dyno;
public static Block turf;
public static Block blast;
public static Block cord;
public static Block concrete;
public static Block reConcrete;
public static Block reGlass;
public static Block c4Quart;
public static Block c4Half;
public static Block c4ThreeQuart;
public static Block powder;
public static Block delay1;
public static Block delay5;
public static Block delay10;
public static Block delay30;
public static Block arrow;
public static Block fire;
public static Block potion;
public static Block fireLarge;
public static Block tracer;
public static Block tracerUsed;
public static Block movableObsidian;
public static Block dispense;
public static Block tnt;
public static Block sandbag;
public static Block substrate;
public static Block mining;
public static Block deforestation;
public static Block stoneExplosive;
public static Block blastingCap;
public static List<Block> explosives;
//public static Block StructOldCannon;

public static Material stone = Material.rock;
public static Material bombMat = new Material(null); //Material.rock;

public static Item lighter;
public static Item cIron;
public static Item steel;
public static Item steelBar;
public static Item plastic;
public static Item blastHead, blastShirt, blastPants, blastShoes;
public static Item woolHat, woolShirt, woolPants, woolShoes;

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
CordList[] cordNames = {new CordList("1 Second Delay Primed", this.delay1),
						new CordList("5 Second Delay Primed", this.delay5),
						new CordList("10 Second Delay Primed", this.delay10),
						new CordList("30 Second Delay Primed", this.delay30)};


/* Creative tabs */
public static class CreativeTabMod
{
	public static MyCreativeTabs tabBomb = new MyCreativeTabs(CreativeTabs.getNextID(), "tabBomb");
}
  
  /** harvest level, max uses, efficdancy, damage, enchangabiliity. */
        public static ToolMaterial OneUse = EnumHelper.addToolMaterial("OneUse", 0, 1, 0.0F, 0.0F, 0);  
        
        public static ArmorMaterial ArmBlast = EnumHelper.addArmorMaterial("ArmBlast", 50, new int[]{3, 5, 4, 2}, 0);
        
private void RI(Item item, String name)
{
	GameRegistry.registerItem(item,  name);
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
                return new ItemStack(lighter, 1, 0);   // Icon, Stack Size, Tab Position
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
    * Minecraft nitroglycerin (LIQUID)-6.4 blast power
   * Minecraft C4 6.3 blast power
  * Relistic C4 -10 lbs 28.53 blast power
  * relistic c4- 1lbs -2.85
  * C4- 5 lbs 14.26
  * C4-20 lbs -57.78
  * Minecraft Gunpoweder: 3 blast power
  * Relistic Gunpowder: 4,000,000 blast power
  * todo condense all explosives into one class with variable power
  * todo make sandbags fall like gravel and sand
  * todo Use seperate explosives with a longer fuse when dispensed, to allow for condensing and falling into water
  * todo remove id or figure out why it's irrelevent
  * todo add special propellent block that has a directional explosion
  * todo add mining explosives that drop everything, or everything but stone and dirt.
  * todo add explosive that only destroys stone (and drops it all)
  * todo add explosion effects to blasting cap
  * todo modify powder explosion to make more smoke
  */
 
 		//custom dispenser behavior
 		bomb = new Gunpowder(idBase, stone, "bomb").setHardness(10.0F).setStepSound(Block.soundTypeAnvil).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(bomb, "bomb");
        
        c4Quart = new C4(++idBase, bombMat, "c4Quart", C4Power/4).setCreativeTab(Main.CreativeTabMod.tabBomb);
        c4Half = new C4(++idBase, bombMat, "c4Half", C4Power/2).setCreativeTab(Main.CreativeTabMod.tabBomb);
        c4ThreeQuart = new C4(++idBase, bombMat, "c4ThreeQuart", C4Power * 3.0/4.0).setCreativeTab(Main.CreativeTabMod.tabBomb);
        c41 = new C4(++idBase, bombMat, "c41", C4Power);
        c45 = new C4(++idBase, bombMat, "c45", C4Power*5).setCreativeTab(Main.CreativeTabMod.tabBomb);
        c410 = new C4(++idBase, bombMat, "c410", C4Power*10).setCreativeTab(Main.CreativeTabMod.tabBomb);
        c420 = new C4(++idBase, bombMat, "c420", C4Power*20).setCreativeTab(Main.CreativeTabMod.tabBomb);//*/
       // Benchmark = new C4_10(++idBase, bombMat, "benchmark").setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(c4Quart, "c4Quart");
        GameRegistry.registerBlock(c4Half,  "c4Half");
        GameRegistry.registerBlock(c4ThreeQuart, "c4ThreeQuart");
        GameRegistry.registerBlock(c41, "c41");
        GameRegistry.registerBlock(c45, "c45");
        GameRegistry.registerBlock(c410, "c410");
        GameRegistry.registerBlock(c420, "c420");
       // GameRegistry.registerBlock(Benchmark, "Benchmark").setStepSound(bombSound);
        
        powder = new Powder(++idBase, bombMat, "powder").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(powder, "powder");

        dyno = new Dynamite(++idBase, bombMat, "dyno").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(dyno, "dyno");

        turf = new Turf(++idBase, bombMat, "turf").setResistance(150).setStepSound(Block.soundTypeGravel).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(turf, "turf");
        
        blast = new Blast(++idBase, bombMat, "blast").setStepSound(bombSound).setResistance(0.5F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(blast,  "blast");
        
        cord = new Cord(++idBase, bombMat, "cord").setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(cord,  "cord");
        
        delay1 = new Delay1(++idBase, bombMat, "delay1", 1*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(delay1,  "delay1");
        
        delay5 = new Delay5(++idBase, bombMat, "delay5").setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(delay5,  "delay5");
        
        delay10 = new Delay10(++idBase, bombMat, "delay10", 10*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(delay10,  "delay10");
        
        delay30 = new Delay30(++idBase, bombMat, "delay30", 30*20).setStepSound(Block.soundTypeGrass).setResistance(0.1F).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(delay30,  "delay30");
        
        arrow = new Arrow(++idBase, bombMat, "arrow").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(arrow,  "arrow");
        
        fire = new Fire(++idBase, bombMat, "fire").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(fire, "fire");
        
        potion = new Potion(++idBase, bombMat, "potion").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(potion, "potion");
        
        tnt = new Tnt(++idBase, bombMat, "tnt").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(tnt, "tnt");

        mining = new MiningExplosive(++idBase, bombMat, "miningExplosive", C4Power).setStepSound(bombSound);
        GameRegistry.registerBlock(mining, "miningExplosive");

        deforestation = new DeforestationExplosive(++idBase, bombMat, "deforestationExplosive", 20*C4Power);
        GameRegistry.registerBlock(deforestation, "deforestationExplosive");

        stoneExplosive = new StoneExplosive(++idBase, bombMat, "stoneExplosive", C4Power);
        GameRegistry.registerBlock(stoneExplosive, "stoneExplosive");

        blastingCap = new BlastingCap(++idBase, bombMat, "blastingCap");
        GameRegistry.registerBlock(blastingCap, "blastingCap");
        
        /*fireLarge = new LargeFire(++idBase, bombMat, "fireLarge").setStepSound(bombSound).setHardness(10.0F).setResistance(bombres);
        GameRegistry.registerBlock(fireLarge, "fireLarge");*/
        //TODO fireLarge is spawning fireballs about every second (but only calls the method in the entity class once)
        //Fireballs are not exploding or lighting fires.
        
        lighter = new Lighter(++idBase, OneUse, "lighter").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(lighter, "lighter");
        //LanguageRegistry.addName(lighter, "Fuse lighter");
        
        concrete = new GenericBlock(++idBase, Material.rock, "concrete", "Pickaxe", 2).setResistance(50).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(concrete, "concrete");
        
        reConcrete = new GenericBlock(++idBase, Material.rock, "reConcrete", "Pickaxe", 2).setResistance(70).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(reConcrete, "reConcrete");

        sandbag = new GenericBlock(++idBase, Material.sand, "sandbag", "Shovel", 0).setResistance(45).setStepSound(Block.soundTypeGravel);
        GameRegistry.registerBlock(sandbag, "sandbag"); // todo add a texture for this
        
        steel = new GenericItem(++idBase, "steel").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(steel, "steel");
        
        cIron = new GenericItem(++idBase, "cIron").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(cIron,  "cIron");
        
        steelBar = new GenericItem(++idBase, "steelBar").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(steelBar, "steelBar");
        
        reGlass = new ReGlass(++idBase, Material.glass, "reGlass", "Pickaxe", 0).setResistance(45).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(reGlass, "reGlass");
        
        plastic = new GenericItem(++idBase, "plastic").setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerItem(plastic,  "plastic");
        
        dispense = new Dispenser(++idBase).setResistance(indestructable).setStepSound(Block.soundTypeStone).setCreativeTab(Main.CreativeTabMod.tabBomb);
        GameRegistry.registerBlock(dispense, "dispense");
        //GameRegistry.registerTileEntity(Dispenser.class, "dispense");
        
        tracer = new Tracer(++idBase, Material.rock, "tracer").setResistance(bombres).setStepSound(bombSound);//
        GameRegistry.registerBlock(tracer, "tracer");
        
        tracerUsed = new TracerUsed(++idBase, Material.rock, "tracer").setResistance(bombres).setStepSound(bombSound).setLightLevel(0.5F);
        GameRegistry.registerBlock(tracerUsed, "tracerUsed");
        
        movableObsidian = new MovableObsidian(++idBase, Material.rock, "pickaxe", 3).setResistance(9999F).setStepSound(Block.soundTypeStone);
        GameRegistry.registerBlock(movableObsidian, "movableObsidian");

        substrate = new Substrate(++idBase, Material.ground, "substrate");
        GameRegistry.registerBlock(substrate, "substrate");
        
        /*StructOldCannon = new BlockStructure(++idBase, Material.rock, "OldCannon", Structures.cannonOld, false);
        GameRegistry.registerBlock(StructOldCannon, "OldCannon");// TODO: game crashing on every loop over the structure components */
        
        // Primed Explosives (for rendering)
        EntityRegistry.registerModEntity(ArrowPrime.class, "Primed arrow bomb", ++EntityID, this, 256, 10, true);//, id, mod, trackingRange, updateFrequency, sendsVelocityUpdates);
        EntityRegistry.registerModEntity(FirePrime.class, "Primed fire bomb", ++EntityID, this, 256, 10, true);
        EntityRegistry.registerModEntity(PotionPrime.class, "Primed potion bomb", ++EntityID, this, 256, 10, true);
        EntityRegistry.registerModEntity(PowderPrime.class, "Primed Black powder Charge",  ++EntityID,  this,  64,  10,  true);
    	EntityRegistry.registerModEntity(DelayPrime1.class, "1 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime5.class, "5 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime10.class, "10 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(DelayPrime30.class, "30 Second Delay Primed", ++EntityID, this, 64, 10, true);
    	EntityRegistry.registerModEntity(TracerPrime.class, "Primed substrate", ++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(LargeFirePrime.class,"Primed Large fire bomb", ++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(TntPrime.class,"Primed TNT bomb", ++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(FallingSubstrate.class, "Falling substrate:",++EntityID, this, 256, 10, true);
    	EntityRegistry.registerModEntity(DummyEntity.class, "Dummy Entity", ++EntityID, this, 256, 10, true);

        blastHead = new BlastShirt(ArmBlast, 0, 0, "blastHead").setTextureName(modid + "blastHead").setCreativeTab(CreativeTabMod.tabBomb);
        blastShirt = new BlastShirt(ArmBlast, 0, 1, "blastShirt").setTextureName(modid + "blastShirt").setCreativeTab(CreativeTabMod.tabBomb);
        blastPants = new BlastShirt(ArmBlast, 0, 2, "blastPants").setTextureName(modid + "blastPants").setCreativeTab(CreativeTabMod.tabBomb);
        blastShoes = new BlastShirt(ArmBlast, 0, 3, "blastShoes").setTextureName(modid + "blastShoes").setCreativeTab(CreativeTabMod.tabBomb);
        GameRegistry.registerItem(blastHead,  "blastHead");
        GameRegistry.registerItem(blastShirt, "blastShirt");
        GameRegistry.registerItem(blastPants, "blastPants");
        GameRegistry.registerItem(blastShoes, "blastShoes");
        
        woolHat = new GenericItem(++idBase, "woolHat").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(woolHat, "woolHat");
        woolShirt = new GenericItem(++idBase, "woolShirt").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(woolShirt, "woolShirt");
        woolPants = new GenericItem(++idBase, "woolPants").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(woolPants, "woolPants");
        woolShoes = new GenericItem(++idBase, "woolShoes").setCreativeTab(Main.CreativeTabMod.tabBomb);
        RI(woolShoes, "woolShoes");
       
        //biome
        BiomeRegistry.mainRegistry();

        this.explosives = new ArrayList<Block>(){{ // todo replace this with a type check if the block is extension of Explosive
            add(Blocks.tnt);
            add(bomb);
            add(c41);
            add(c45);
            add(c410);
            add(c420);
            add(dyno);
            add(cord);
            add(c4Quart);
            add(c4Half);
            add(c4ThreeQuart);
            add(powder);
            add(delay1);
            add(delay5);
            add(delay10);
            add(delay30);
            add(arrow);
            add(fire);
            add(potion);
            add(fireLarge);
            add(tracer);
            add(tnt);
            add(mining);
            add(deforestation);
            add(stoneExplosive);
            add(blastingCap);
        }};
       
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
 
	//yourItemStack.addEnchantment(Enchantment.protection, 3); // adding enchantments. Do what ever you like
 
    //  Dynamite Recipie (temporary until Nitroglycerin is added)     
        GameRegistry.addRecipe(new ItemStack(dyno, 1),
                "SXS",
                "XSX",
                "SXS",
            'S', Blocks.sand,
            'X', Items.gunpowder
        );
    //  Gunpower bomb         
        GameRegistry.addRecipe(new ItemStack(bomb, 5),
                "SSS",
                "SSS",
                "SSS",
            'S', Items.gunpowder);

        GameRegistry.addRecipe(new ItemStack(c4Half, 1),
                "SXS",
                "XSX",
                "SXS",
            'S', Items.gunpowder,
            'X', plastic);
            //  ITEM RECIPE         
        GameRegistry.addRecipe(new ItemStack(lighter, 1),
                "G",
                "S",
                "T",
            'S', Items.stick,
            'G', Items.gunpowder,
            'T', Blocks.torch);

        GameRegistry.addRecipe(new ItemStack(concrete, 1),
                "W",
                "S",
            'S', Blocks.sand,
            'W', Items.water_bucket.setContainerItem(Items.bucket));
        
        GameRegistry.addRecipe(new ItemStack(steelBar, 2),
                "S",
                "S",
            'S', steel);
        
        GameRegistry.addRecipe(new ItemStack(reConcrete, 1),
        		"R",
                "W",
                "S",
            'S', Blocks.sand,
            'W', Items.water_bucket.setContainerItem(Items.bucket),
            'R', steelBar);
        
        GameRegistry.addRecipe(new ItemStack(cord, 8),
                "WWW",
        	"WGW",
        	"WWW",
        'W', Blocks.wool,
        'G', Items.gunpowder);
        
        GameRegistry.addRecipe(new ItemStack(woolHat, 1),
        				"WWW",
        				"W W",
        				
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(woolShirt, 1),
        				"W W", 
        				"WWW", 
        				"WWW", 
        				
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(woolPants, 1),
        				"WWW",
        				"W W",
        				"W W",
        				'W', Blocks.wool);
        GameRegistry.addRecipe(new ItemStack(woolShoes, 1),
        				"W W",
        				"W W",
        				'W', Blocks.wool);
        
     //2;1x7,7x3,1x2;1;village(size=5 distance=9)   
	 //GameRegistry.addShapelessRecipe(new ItemStack (C4mine, 1), new ItemStack (c41, 2);//, new ItemStack (c41, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (c45, 1), new ItemStack (c41, 1), new ItemStack (c41, 1), new ItemStack (c41, 1), new ItemStack (c41, 1), new ItemStack (c41, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (c410, 1), new ItemStack (c45, 1), new ItemStack (c45, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack (c420, 1), new ItemStack (c410, 1), new ItemStack (c410, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(cIron, 1), new ItemStack (Items.coal, 1), new ItemStack (Items.iron_ingot, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(c41, 1), new ItemStack(c4Half, 1), new ItemStack(c4Half, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(c4Quart, 2),  new ItemStack(c4Half, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(c4ThreeQuart, 1),  new ItemStack(c4Quart, 1), new ItemStack(c4Quart, 1), new ItemStack(c4Quart, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(sandbag, 1), new ItemStack(Blocks.wool, 1), new ItemStack(Blocks.sand, 1));
	 GameRegistry.addShapelessRecipe(new ItemStack(substrate, 2), new ItemStack(Blocks.sand, 1), new ItemStack(Blocks.gravel, 1));

	 ItemStack StackBlastH = new ItemStack(blastHead, 1);//.addEnchantment(Enchantment.blastProtection, 4);
	 StackBlastH.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastC = new ItemStack(blastShirt, 1);
	 StackBlastH.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastP = new ItemStack(blastPants, 1);
	 StackBlastP.addEnchantment(Enchantment.blastProtection, 4);
	 
	 ItemStack StackBlastS = new ItemStack(blastShoes, 1);
	 StackBlastS.addEnchantment(Enchantment.blastProtection, 4);
	 
	 GameRegistry.addShapelessRecipe(StackBlastH, new ItemStack(Items.iron_helmet, 1), new ItemStack(Items.leather_helmet), new ItemStack(woolHat, 1));
	 GameRegistry.addShapelessRecipe(StackBlastC, new ItemStack(Items.iron_chestplate, 1), new ItemStack(Items.leather_chestplate, 1), new ItemStack(woolShirt, 1));
	 GameRegistry.addShapelessRecipe(StackBlastP, new ItemStack(Items.iron_leggings, 1), new ItemStack(Items.leather_leggings, 1), new ItemStack(woolPants, 1));
	 GameRegistry.addShapelessRecipe(StackBlastS, new ItemStack(Items.iron_boots, 1), new ItemStack(Items.leather_boots, 1), new ItemStack(woolShoes, 1));
	 
	 GameRegistry.addSmelting(new ItemStack(cIron, 1), new ItemStack (steel, 1), 10F);
	 GameRegistry.addSmelting(new ItemStack(Items.wheat, 1), new ItemStack(plastic, 1), 2.0F);
	 GameRegistry.addSmelting(new ItemStack(Blocks.sapling,1), new ItemStack(plastic, 1), 2.0F);
	 

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

    //  CHANGE TAB NAME
        //LanguageRegistry.instance().addStringLocalization("itemGroup.MyCreativeTab_1", "en_US", "The bomb Range Mod");
        

        


/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}

@EventHandler
	public static void postInit( FMLPostInitializationEvent event ) 
	{
		WorldType BombRange = new WorldTypeBombRange(7, "bomb Range");
		//dispenser stuff
       // BlockDispenser.dispenseBehaviorRegistry.putObject(powder, new BehaviorProjectileDispense());
        
	}
	
}
