package com.cat40.bombrange.blocks.cord;

import net.minecraft.block.Block;

public class CordList
{
	private String name;
	private Block block;

	public CordList(String name, Block block)
	{
		this.block = block;
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public Block getBlock()
	{
		return this.block;
	}
}