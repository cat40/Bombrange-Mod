/**
 * To export: change mod version on .GRADLE file
 * Open command propmpt in 1710 modding and run "gradlew build"
 * Open resulting .jar in builds folder and copy assets into it.
 */
package com.cat40.cheaparrows;

import com.cat40.bombrange.proxies.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;


/* 	MOD INFO */
	@Mod(modid = "cheaparrows", name = "Cheap Arrows", version = "0.1.0")
	//@NetworkMod(clientSideRequired=true, serverSideRequired=false)	


public class Main {

/*	PROXY INFO */
	@SidedProxy(clientSide = "com.cat40.cheaparrows.proxies.ClientProxy", serverSide = "com.cat40.cheaparrows.proxies.CommonProxy")
	public static CommonProxy proxy;
	
/**	
 * DECLARATION SECTION 
 * *********************************************************** */


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

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	}

@EventHandler
	public static void init( FMLInitializationEvent event ) 
	{
	
/**	
 * RECIPES SECTION 
 * *********************************************************** */

    //  Dynamite Recipie (temporary until Nitroglycerin is added)
        GameRegistry.addRecipe(new ItemStack(Items.arrow, 4),
                "C",
                "S",
                "F",
            'C', Blocks.cobblestone,
            'S', Items.stick,
            'F', Items.feather);

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
/**	
 * EXTRA METHODS SECTION 
 * *********************************************************** */

/* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */	

	
	}
	
}
