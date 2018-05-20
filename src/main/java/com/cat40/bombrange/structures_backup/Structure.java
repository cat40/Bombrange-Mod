package com.cat40.bombrange.structures_backup;

import net.minecraft.block.Block;
import net.minecraft.world.World;

public class Structure 
{
	public StructureBlock[] blocks;
	int[] dims;
	// TODO public int[] dimentions;
/*	int xOffset;
	int yOffset;
	int zOffset;
	World world;*/
	
	public Structure(StructureBlock[] blockList, int lenth, int width, int height)
	{
		this.blocks = blockList;
		this.dims = new int[] {lenth, width, height};
		/*this.xOffset = xOffset;
		this.yOffset = yOffset;
		this.zOffset = zOffset;
		this.world = world; */
	}
	
	public static void spawnStructure(int xOffset, int yOffset, int zOffset, boolean spawnAir, World world, StructureBlock[] structure)
	{
		// TODO: add method to overwrite all blocks not included in block list, but in the dimentions, as air
		int x, y, z;
		int[] dims = getDims(structure);
		int lenth = dims[0];
		int width = dims[1];
		int height = dims[2];
		int l, w, h;
		Block block;
		int[] cords;
		if (spawnAir)
		{
			for (l=0; l<lenth; l++)
			{
				for(w=0; w<width; w++)
				{
					for(h=0; h<height; h++)
					{
						world.setBlockToAir(xOffset+l, yOffset+h, zOffset+w);
					}
				}
			}
		}
		for(StructureBlock blockData : structure)
		{
			block = blockData.getBlock();
			cords = blockData.getCords();
			x = cords[0];
			y = cords[1];
			z = cords[2];
			world.setBlock(xOffset+x, yOffset+y, zOffset+z, block);
		}
	}
	
	/**
	 * Changes referance cordinates when player is looking other than north
	 * 0 = north, 1 = east, 2 = south, 3 = west
	 */
	public static StructureBlock[] setDir(int dir, StructureBlock[] parblocks) // TODO might need to make this return a Structure object, use like structure=structure.toEast();
	{
		StructureBlock[] newBlocks = parblocks;
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
		for(StructureBlock block : parblocks)
		//for(i=0; i<parblocks.length; i++)
		//System.out.println(new int[] {1, 2, 3}.length);
		//while(i<parblocks.length) //"Unexpected error" on this line for some reason
		{
			//StructureBlock block = parblocks[i];
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
		return newBlocks;
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
	
	public static int[] getDims(StructureBlock[] structure)
	{
		int lmax = 0, wmax = 0, hmax = 0;
		int lmin = 0, wmin = 0, hmin = 0;
		for(StructureBlock block : structure)
		{
			lmax = (block.x>lmax) ? block.x:lmax;
			lmin = (block.x<lmin) ? block.x:lmin;
			wmax = (block.z>wmax) ? block.z:wmax;
			wmax = (block.z<wmax) ? block.z:wmin;
			hmax = (block.y>hmax) ? block.y:hmax;
			hmin = (block.y<hmin) ? block.y:hmin;
		}
		return new int[] {Math.abs(lmax-lmin), Math.abs(wmax - wmin), Math.abs(hmax - hmin)};
	}
}
