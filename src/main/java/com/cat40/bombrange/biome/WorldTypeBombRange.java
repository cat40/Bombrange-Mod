package com.cat40.bombrange.biome;

import net.minecraft.world.WorldType;
import net.minecraft.world.gen.layer.GenLayer;
import net.minecraft.world.gen.layer.GenLayerBiomeEdge;
import net.minecraft.world.gen.layer.GenLayerZoom;

public class WorldTypeBombRange extends WorldType
{
	public WorldTypeBombRange(int par1, String name)
	{
		super(name);
	}
	
	public GenLayer getBiomeLayer(long worldSeed, GenLayer parentLayer)
	{
		GenLayer ret = new BombRangeGenLayerBiome(200L, parentLayer, this);
		ret = GenLayerZoom.magnify(1000L,  ret,  2);
		ret = new GenLayerBiomeEdge(1000L, ret);
		return ret;
	}
	
}
