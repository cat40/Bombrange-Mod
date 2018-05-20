/**
 * Class to define default structures to build
 * Note: order of blocks in structure array does not matter as long as co-ordinates are good
 * Co-ordinates are expressed as blocks away from spawn point in x, y, z directions
 * z positive is direction player is facing. x positive is to player's right
 */
package com.cat40.bombrange.structures;

import com.cat40.bombrange.Main;

import net.minecraft.init.Blocks;

public class Structures
{
	// Structures
	public static Structure cannonOld;
	public static Structure mortar;
	public static Structure longRangeMortar;
	
	//Structure components 
	public static StructurePart cannonOldObsidian;
	public static StructurePart cannonOldPlanks;
	
	public static StructurePart[] cannonOldBlock;
	public static StructurePart[] mortarBlock;
	public static StructurePart[] longRangeMortarBlock;
	public static StructurePart[] test;
	
	public Structures()
	{
		// x and z are switched on cannonOld.
		//this.test = new StructurePart[] {new StructurePart(Blocks.obsidian, 0, 0, 0)};
		int x = 0;
		// start planks at x=3
		this.cannonOldObsidian = new StructurePart(Main.MovableObsidian, new int[][]   {{3, 2, x},
																					    {4, 2, x},
																						{5, 2, x},
																						{3, 3, x},
																						{5, 3, x},
																						{4, 4, x},
																						{5, 4, x},	
																						{3, 2, ++x},
																						{4, 2, x},
																						{5, 2, x},
																						{3, 3, x},
																						{5, 3, x},
																						{3, 4, x},
																						{4, 4, x},
																						{5, 4, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{5, 4, x},
																					  	{3, 2, ++x},
																					  	{4, 2, x},
																					  	{5, 2, x},
																					  	{3, 3, x},
																					  	{5, 3, x},
																					  	{3, 4, x},
																					  	{4, 4, x},
																					  	{5, 4, x}});
		this.cannonOldObsidian.switchXZCords();
		x = 3;
		this.cannonOldPlanks = new StructurePart(Blocks.planks, new int[][]{{0, 2, x},
												  	                        {0, 3, x},
																		  	{0, 4, x},
																		  	{8, 2, x},
																		  	{8, 3, x},
																		  	{8, 4, x},
																		  	{0, 0, ++x},
																		  	{0, 3, x},
																		  	{0, 6, x},
																		  	{8, 0, x},
																		  	{8, 3, x},
																		  	{8, 6, x},
																		  	{0, 0 ,++x},
																		  	{0, 5, x},
																		  	{0, 9, x},
																		  	{8, 0 ,x},
																		  	{8, 5, x},
																		  	{8, 9, x},
																		  	{0, 0, ++x},
																		  	{0, 1, x},
																		  	{0, 2, x},
																		  	{0, 3, x},
																		  	{0, 4, x},
																		  	{0, 5, x},
																		  	{0, 6, x},
																		  	{8, 0, x},
																		  	{8, 1, x},
																		  	{8, 2, x},
																		  	{8, 3, x},
																		  	{8, 4, x},
																		  	{8, 5, x},
																		  	{8, 6, x},
																		  	{8, 7, x},
																		  	{1, 5, x},
																		  	{2, 5, x},
																		  	{6, 5, x},
																		  	{7, 5, x},
																		  	{2, 1, x},
																		  	{2, 2, x},
																		  	{6, 1, x},
																		  	{6, 2, x},
																		  	{3, 1, x},
																		  	{4, 1, x},
																		  	{5, 1, x},
																		  	{0, 0 ,++x},
																		  	{0, 3, x},
																		  	{0, 6, x},
																		  	{3, 1, x},
																		  	{4, 1, x},
																		  	{5, 1, x},
																		  	{8, 0 ,x},
																		  	{8, 3, x},
																		  	{8, 6, x},
																		  	{0, 1, ++x},
																		  	{0, 3, x},
																		  	{0, 5, x},
																		  	{3, 1, x},
																		  	{4, 1, x},
																		  	{5, 1, x},
																		  	{8, 1, x},
																		  	{8, 3, x},
																		  	{8, 5, x},
																		  	{3, 1, ++x},
																		  	{4, 1, x},
																		  	{5, 1, x},
																		  	{0, 2, x},
																		  	{0, 3, x},
																		  	{0, 4, x},
																		  	{8, 2, x},
																		  	{8, 3, x},
																		  	{8, 4, x},
																		  	{4, 0, ++x},
																		  	{4, 1, x},
																		  	{4, 0, ++x},
																		  	{4, 0, ++x}});
		this.cannonOldPlanks.switchXZCords();
		this.cannonOld = new Structure(new StructurePart[] {cannonOldObsidian, cannonOldPlanks}, 9, 11, 7);
	}
	
	
	// Helper functions
	StructurePart[] addToStructure(StructurePart[] structure, StructurePart[] part)
	{
		int i;
		int len1 = structure.length;
		int len2 = part.length;
		StructurePart[] newStruct = new StructurePart[len1+len2];
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
