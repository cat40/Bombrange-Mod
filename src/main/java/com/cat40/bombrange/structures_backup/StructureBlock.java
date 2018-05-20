package com.cat40.bombrange.structures_backup;

import net.minecraft.block.Block;
//TODO make this take a list of coordinates to spawn each block type instead of sotring the block type and cooridnates the current way
public class StructureBlock
{
	Block block;
	int x;
	int y;
	int z;
	public StructureBlock(Block block, int x, int y, int z)
	{
		this.block = block;
		this.x = x;
		this.y = y;
		this.z = z;
	}
	
	public int[] getCords()
	{
		int[] cords = {this.x, this.y, this.z};
		return cords;
	}
	
	public Block getBlock()
	{
		return this.block;
	}
}
