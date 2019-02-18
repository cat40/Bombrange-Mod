///**
// * To export: change mod version on .GRADLE file
// * Open command propmpt in 1710 modding and run "gradlew build"
// * Open resulting .jar in builds folder and copy assets into it.
// */
//package com.cat40.recordingminecart;
//
//import com.cat40.cheaparrows.proxies.CommonProxy;
//import cpw.mods.fml.common.Mod;
//import cpw.mods.fml.common.Mod.EventHandler;
//import cpw.mods.fml.common.SidedProxy;
//import cpw.mods.fml.common.event.FMLInitializationEvent;
//import cpw.mods.fml.common.event.FMLPreInitializationEvent;
//
//
///* 	MOD INFO */
//	@Mod(modid = "recordingminecart", name = "Track Recorder", version = "0.1.0")
//	//@NetworkMod(clientSideRequired=true, serverSideRequired=false)
//
//
//public class Main {
//
///*	PROXY INFO */
//	@SidedProxy(clientSide = "com.cat40.recordingminecart.proxies.ClientProxy", serverSide = "com.cat40.recordingminecart.proxies.CommonProxy")
//	public static CommonProxy proxy;
//
///**
// * DECLARATION SECTION
// * *********************************************************** */
//
//
///* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
//
///** Sounds */
///* @ForgeSubscribe
//public void onSound(SoundLoadEvent event) {
//// You add them the same way as you add blocks.
//event.manager.addSound("mod_id:Sparkler.ogg");
//}
// */
//@EventHandler
//	public  void preInit( FMLPreInitializationEvent event )
//	{
//
///**
// * LOAD SECTION
// * *********************************************************** */
//
// proxy.registerRenders();
//
///* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
//
//	}
//
//@EventHandler
//	public static void init( FMLInitializationEvent event )
//	{
//
///**
// * RECIPES SECTION
// * *********************************************************** */
//
//
///* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
//
//
///**
// * EXTRA METHODS SECTION
// * *********************************************************** */
//
///* ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^ */
//
//
//	}
//
//}
