package com.cat40.bombrange.structures;

import net.minecraft.block.Block;

//TODO make this take a list of coordinates to spawn each block type instead of sotring the block type and cooridnates the current way
public class StructurePart
{
	Block block;
	int[] x;
	int[] y;
	int[] z;
	public StructurePart(Block block, int[][] cords)
	{
		int i;
		this.block = block;
		this.x = new int[cords.length];
		this.y = new int[cords.length];
		this.z = new int[cords.length];
		for(i=0; i<cords.length; i++)
		{
			this.x[i] = cords[i][0];
			this.y[i] = cords[i][1];
			this.z[i] = cords[i][2];
		}
		/*this.x = cords[0];
		this.y = cords[1];
		this.z = cords[2];*/
	}
	
	public Block getBlock()
	{
		return this.block;
	}
	
	public int[][] getCords()
	{
		return new int[][] {this.x, this.y, this.z};
	}
	
	public void switchXZCords()
	{
		int[] oldx = this.x;
		int[] oldz = this.z;
		this.x = oldz;
		this.z = oldx;
	}
	
	public void multCords(int xMult, int yMult, int zMult)
	{
		int i;
		for(i=0; i<this.x.length; i++)
		{
			this.x[i] = this.x[i]*xMult;
		}
		for(i=0; i<this.y.length; i++)
		{
			this.y[i] = this.y[i]*yMult;
		}
		for(i=0; i<this.z.length; i++)
		{
			this.z[i] = this.z[i]*zMult;
		}
	}
}
