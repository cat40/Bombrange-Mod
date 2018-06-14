package com.cat40.recordingminecart.minecart;

import net.minecraft.block.BlockRailBase;
import net.minecraft.entity.item.EntityMinecart;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemMinecart;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemRecordingMinecart extends ItemMinecart {

    public ItemRecordingMinecart(int type) {
        super(type);
    }


    private static double cordFloat(int cord)
    {
        return cord+0.5;
    }
    private static int cordInt(double cord)
    {
        return (int) (cord-0.5);
    }

    @Override
    public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (BlockRailBase.func_150051_a(world.getBlock(x, y, z))) {
            if (!world.isRemote) {
                EntityMinecart entityminecart = new EntityRecordingMinecart(world, cordFloat(x), cordFloat(y), cordFloat(z));
                if (itemStack.hasDisplayName()) {
                    entityminecart.setMinecartName(itemStack.getDisplayName());
                }

                world.spawnEntityInWorld(entityminecart);
            }

            --itemStack.stackSize;
            return true;
        } else {
            return false;
        }
    }
}
