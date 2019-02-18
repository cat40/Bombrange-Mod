package com.cat40.bombrange.blocks.explosives;

import net.minecraft.block.material.Material;
import net.minecraft.world.World;

/**
 * Should remove a 3x4xDEFAULT_LENGTH rectangular prism of blocks and place railes there
 * Ideas:
 *  Self ballast (place blocks underneath the rails)
 *  Self tunnel (place blocks around to create a tunnel, will protect against falling blocks and liquids
 */
public class RailRoadExplosive extends Explosive {

    private final static int DEFAULT_LENGTH = 20;  // the default length of rails to be built with each explosion
    public RailRoadExplosive(int id, Material material, String textureName, double power) {
        super(id, material, textureName, power);
        // TODO determine direction of placement
    }

    @Override
    public void blowUp(World world, int x, int y, int z) {
        // for now, just goes in the positive x direction, y should be the bottom level
        System.out.println("rail road blowing up");
        for(int xPos = x; xPos < x+DEFAULT_LENGTH; xPos++)
        {
            for(int yPos = y; yPos < y+4; yPos++)
            {
                for(int zPos = z-1; zPos <=z+1; zPos++)
                {
                    // remove the blocks
                    world.setBlockToAir(xPos, yPos, zPos);
                }
            }
        }
    }
}
