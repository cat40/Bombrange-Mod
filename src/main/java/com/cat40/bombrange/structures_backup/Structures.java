/**
 * Class to define default structures to build
 * Note: order of blocks in structure array does not matter as long as co-ordinates are good
 * Co-ordinates are expressed as blocks away from spawn point in x, y, z directions
 * z positive is direction player is facing. x positive is to player's right
 */
package com.cat40.bombrange.structures_backup;

import net.minecraft.init.Blocks;

public class Structures
{
	// Structures
	/*public static Structure cannonOld;
	public static Structure mortar;
	public static Structure longRangeMortar;*/
	
	//Structure components 
	public static StructureBlock[] cannonOldBlock;
	public static StructureBlock[] mortarBlock;
	public static StructureBlock[] longRangeMortarBlock;
	public static StructureBlock[] test;
	
	public Structures()
	{
		// x and z are switched on cannonOld.
		this.test = new StructureBlock[] {new StructureBlock(Blocks.obsidian, 0, 0, 0)};
		int x = 0;
		this.cannonOldBlock = new StructureBlock[] {new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	
												  	new StructureBlock(Blocks.obsidian, 3, 2, ++x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	
												  	new StructureBlock(Blocks.planks, 0, 2, ++x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 4, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 2, x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 4, x),
												  	
												  	new StructureBlock(Blocks.planks, 0, 0, ++x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 6, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 0, x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 6, x),
												  	
												  	new StructureBlock(Blocks.planks, 0, 0 ,++x),
												  	new StructureBlock(Blocks.planks, 0, 5, x),
												  	new StructureBlock(Blocks.planks, 0, 9, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 0 ,x),
												  	new StructureBlock(Blocks.planks, 8, 5, x),
												  	new StructureBlock(Blocks.planks, 8, 9, x),
												  	
												  	new StructureBlock(Blocks.planks, 0, 0, ++x),
												  	new StructureBlock(Blocks.planks, 0, 1, x),
												  	new StructureBlock(Blocks.planks, 0, 2, x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 4, x),
												  	new StructureBlock(Blocks.planks, 0, 5, x),
												  	new StructureBlock(Blocks.planks, 0, 6, x),
												  	//new StructureBlock(Blocks.planks, 0, 7, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 0, x),
												  	new StructureBlock(Blocks.planks, 8, 1, x),
												  	new StructureBlock(Blocks.planks, 8, 2, x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 5, x),
												  	new StructureBlock(Blocks.planks, 8, 6, x),
												  	new StructureBlock(Blocks.planks, 8, 7, x),
												  	new StructureBlock(Blocks.planks, 1, 5, x),
												  	new StructureBlock(Blocks.planks, 2, 5, x),
												  	new StructureBlock(Blocks.planks, 6, 5, x),
												  	new StructureBlock(Blocks.planks, 7, 5, x),
												  	new StructureBlock(Blocks.planks, 2, 1, x),
												  	new StructureBlock(Blocks.planks, 2, 2, x),
												  	new StructureBlock(Blocks.planks, 6, 1, x),
												  	new StructureBlock(Blocks.planks, 6, 2, x),
												  	new StructureBlock(Blocks.planks, 3, 1, x),
												  	new StructureBlock(Blocks.planks, 4, 1, x),
												  	new StructureBlock(Blocks.planks, 5, 1, x),
												  	// code above this point might have some bad co-oridnatse (started at one instead of 0)
												  	
												  	new StructureBlock(Blocks.planks, 0, 0 ,++x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 6, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 3, 1, x),
												  	new StructureBlock(Blocks.planks, 4, 1, x),
												  	new StructureBlock(Blocks.planks, 5, 1, x),
												  	new StructureBlock(Blocks.planks, 8, 0 ,x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 6, x),
												  	
												  	new StructureBlock(Blocks.planks, 0, 1, ++x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 5, x),
												  	new StructureBlock(Blocks.obsidian, 3, 2, x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 3, 1, x),
												  	new StructureBlock(Blocks.planks, 4, 1, x),
												  	new StructureBlock(Blocks.planks, 5, 1, x),
												  	new StructureBlock(Blocks.planks, 8, 1, x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 5, x),
												  	
												  	new StructureBlock(Blocks.obsidian, 3, 2, ++x),
												  	new StructureBlock(Blocks.obsidian, 4, 2, x),
												  	new StructureBlock(Blocks.obsidian, 5, 2, x),
												  	new StructureBlock(Blocks.obsidian, 3, 3, x),
												  	new StructureBlock(Blocks.obsidian, 5, 3, x),
												  	new StructureBlock(Blocks.obsidian, 3, 4, x),
												  	new StructureBlock(Blocks.obsidian, 4, 4, x),
												  	new StructureBlock(Blocks.obsidian, 5, 4, x),
												  	new StructureBlock(Blocks.planks, 3, 1, x),
												  	new StructureBlock(Blocks.planks, 4, 1, x),
												  	new StructureBlock(Blocks.planks, 5, 1, x),
												  	new StructureBlock(Blocks.planks, 0, 2, x),
												  	new StructureBlock(Blocks.planks, 0, 3, x),
												  	new StructureBlock(Blocks.planks, 0, 4, x),
												  	new StructureBlock(Blocks.planks, 8, 2, x),
												  	new StructureBlock(Blocks.planks, 8, 3, x),
												  	new StructureBlock(Blocks.planks, 8, 4, x),
												  	
												  	new StructureBlock(Blocks.planks, 4, 0, ++x),
												  	new StructureBlock(Blocks.planks, 4, 1, x),
												  	
												  	new StructureBlock(Blocks.planks, 4, 0, ++x),
												  	
												  	new StructureBlock(Blocks.planks, 4, 0, ++x)};
		//this.cannonOld = new Structure(this.cannonOldBlock, 11, 9, 7);
	}
	
	
	// Helper functions
	StructureBlock[] addToStructure(StructureBlock[] structure, StructureBlock[] part)
	{
		int i;
		int len1 = structure.length;
		int len2 = part.length;
		StructureBlock[] newStruct = new StructureBlock[len1+len2];
		for(i=0; i<len1; i++)
		{
			newStruct[i] = structure[i];
		}
		for(i=0; i<len2; i++)
		{
			newStruct[i+len1] = part[i]; 
		}
		return newStruct;
	}
}
	
/** structure dimentoins (width, lentch, height)
 * Cannon Old: (9, 11, 7)
 * 
 */
