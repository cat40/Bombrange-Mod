package com.cat40.bombrange.biome;

import com.cat40.bombrange.Main;

import net.minecraft.world.biome.BiomeGenBase;

public class BiomeGenBombRange extends BiomeGenBase
{
	public BiomeGenBombRange(int id)
	{
		super(id);
        this.topBlock = Main.Turf;
        this.fillerBlock = Main.Turf;
        this.setHeight(BiomeGenBase.height_LowPlains);
        this.heightVariation = 0.05F;
        this.theBiomeDecorator.deadBushPerChunk = 5;
		
	}
}
