package com.cat40.bombrange.structures_backup;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class Structure_Backup 
{
	public StructureBlock[] blocks;
	int[] dims;
	// TODO public int[] dimentions;
/*	int xOffset;
	int yOffset;
	int zOffset;
	World world;*/
	
	public Structure_Backup(StructureBlock[] blockList, int lenth, int width, int height)
	{
		this.blocks = blockList;
		this.dims = new int[] {lenth, width, height};
		/*this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
		this.world = world; */
	}
	
	public void spawnStructure(int xOffset, int yOffset, int zOffset, boolean spawnAir, World world, Structure_Backup structure)
	{
		// TODO: add method to overwrite all blocks not included in block list, but in the dimentions, as air
		int x, y, z;
		int l, w, h;
		Block block;
		int[] cords;
		if (spawnAir)
		{
			for (l=0; l<this.dims[0]; l++)
			{
				for(w=0; w<this.dims[1]; w++)
				{
					for(h=0; h<this.dims[2]; h++)
					{
						world.setBlockToAir(xOffset+l, yOffset+h, zOffset+w);
					}
				}
			}
		}
		for(StructureBlock blockData : structure.blocks)
		{
			block = blockData.getBlock();
			cords = blockData.getCords();
			x = cords[0];
			y = cords[1];
			z = cords[2];
			world.setBlock(xOffset+x, yOffset+y, zOffset+z, block);
		}
	}
	
	public StructureBlock[] getBlocks()
	{
		return this.blocks;
	}
	
	/**
	 * Changes referance cordinates when player is looking other than north
	 * 0 = north, 1 = east, 2 = south, 3 = west
	 */
	public void setDir(int dir) // TODO might need to make this return a Structure object, use like structure=structure.toEast();
	{
		StructureBlock[] newBlocks = this.blocks;
		int xMult = 1;
		int zMult = 1;
		int x, y, z;
		int[] cords;
		int i = 0;
		
		boolean switchXZ = dir == 1 || dir == 3; 
		// switch x directions if facing south
		if (dir == 2)
		{
			xMult = -1;
		}
		// switch z directions if facing west
		else if (dir == 3)
		{
			zMult = -1;
		}
		for(StructureBlock block : this.blocks)
		{
			cords = block.getCords();
			x = cords[0];
			y = cords[1];
			z = cords[2];
			x *= xMult;
			z *= zMult;
			if(switchXZ)
			{
				newBlocks[i] = new StructureBlock(block.getBlock(), z, y, x);
			}
			else
			{
				newBlocks[i] = new StructureBlock(block.getBlock(), x, y, z);
			}
			i++;
		}
		this.blocks = newBlocks;
	}
	
	public void switchXZ()
	{
		int i = 0;
		int[] cords;
		StructureBlock[] newBlocks = this.blocks;
		for (StructureBlock block : this.blocks)
		{
			cords = block.getCords();
			newBlocks[i] = new StructureBlock(block.getBlock(), cords[2], cords[1], cords[0]);
			i++;
		}
		this.blocks = newBlocks;
	}
}
