package com.cat40.bombrange.biome;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeDictionary.Type;

public class BiomeRegistry
{
	public static void mainRegistry()
	{
		initializeBiome();
		registerBiome();
	}
	
	public static BiomeGenBase BombRange;
	
	public static void initializeBiome()
	{
		BombRange = new BiomeGenBombRange(137).setBiomeName("The Bomb Range");
		
	}

	
	public static void registerBiome()
	{
		BiomeDictionary.registerBiomeType(BombRange, Type.FOREST);
		BiomeManager.addSpawnBiome(BombRange);
	}
	
}
