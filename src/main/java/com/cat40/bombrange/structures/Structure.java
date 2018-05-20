package com.cat40.bombrange.structures;

import net.minecraft.world.World;

public class Structure 
{
	public StructurePart[] blocks;
	int[] dims;
	int lenth, width, height;
/*	int xOffset;
	int yOffset;
	int zOffset;
	World world;*/
	
	public Structure(StructurePart[] partList, int lenth, int width, int height)
	{
		this.blocks = partList;
		this.dims = new int[] {lenth, width, height};
		this.lenth = lenth;
		this.width = width;
		this.height = height;
	}
	
	public void spawnStructure(World world, int xOffset, int yOffset, int zOffset, boolean spawnAir)
	{
		int[][] cords;
		int x, y, z;
		int l, w, h;
		int lenth = this.lenth;
		int width = this.width;
		int height = this.height;
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
		for(StructurePart blockData : this.blocks)
		{
			for(int[] cord : blockData.getCords())
			{
				world.setBlock(xOffset+cord[0], yOffset+cord[1], zOffset+cord[2], blockData.getBlock());
			}
		}
	}
	
	/**
	 * Changes referance cordinates when player is looking other than north
	 * 0 = north, 1 = east, 2 = south, 3 = west
	 */
	//public static Structure setDir(int dir, Structure parblocks) // TODO might need to make this return a Structure object, use like structure=structure.toEast();
	public void setDir(int dir)
	{
		StructurePart[] newBlocks = this.blocks;
		int xMult = 1;
		int zMult = 1;
		int x, y, z;
		int[] cords;
		int i = 0;
		
		boolean switchXZ = (dir == 1 || dir == 3); 
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
		for(StructurePart block : newBlocks)
		{
			/*cords = block.getCords();
			x = cords[0];
			y = cords[1];
			z = cords[2];
			x *= xMult;
			z *= zMult;
			if(switchXZ)
			{
				newBlocks[i] = new StructurePart(block.getBlock(), z, y, x);
			}
			else
			{
				newBlocks[i] = new StructurePart(block.getBlock(), x, y, z);
			}
			i++;*/
			block.multCords(xMult, 1, zMult);
			if(switchXZ)
			{
				block.switchXZCords();
			}
		}
		//return newBlocks;
	}

	// use StructurePart.switchXZCords() instead
/*	public void switchXZ()
	{
		int i = 0;
		int[] cords;
		StructurePart[] newBlocks = this.blocks;
		for (StructurePart block : this.blocks)
		{
			cords = block.getCords();
			newBlocks[i] = new StructurePart(block.getBlock(), block.getCords());
			i++;
		}
		this.blocks = newBlocks;
	} */
	
/*	public static int[] getDims(StructurePart[] structure)
	{
		int lmax = 0, wmax = 0, hmax = 0;
		int lmin = 0, wmin = 0, hmin = 0;
		for(StructurePart block : structure)
		{
			lmax = (block.x>lmax) ? block.x:lmax;
			lmin = (block.x<lmin) ? block.x:lmin;
			wmax = (block.z>wmax) ? block.z:wmax;
			wmax = (block.z<wmax) ? block.z:wmin;
			hmax = (block.y>hmax) ? block.y:hmax;
			hmin = (block.y<hmin) ? block.y:hmin;
		}
		return new int[] {Math.abs(lmax-lmin), Math.abs(wmax - wmin), Math.abs(hmax - hmin)};
	}*/
	
/*	public static StructurePart[] getParts()
	{
		return this.blocks;
	}*/
}
