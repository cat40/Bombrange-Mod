package com.cat40.bombrange.biome;

import com.cat40.bombrange.Main;

import net.minecraft.block.Block;
import net.minecraft.world.biome.BiomeGenBase;

public class BombRange extends BiomeGenBase
{
    public BombRange(int par1)
    {
        super(par1);
        
        this.setBiomeName("The Bomb Range");
        
        this.topBlock = (Block)Main.Turf;
        this.fillerBlock = (Block)Main.Turf;
        this.rootHeight =  64;
        this.heightVariation = 0.05F;
        this.setTemperatureRainfall(1.5F, 0.2F);
   
    }
}