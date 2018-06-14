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

    @Override
    public boolean onItemUse(ItemStack p_77648_1_, EntityPlayer p_77648_2_, World p_77648_3_, int p_77648_4_, int p_77648_5_, int p_77648_6_, int p_77648_7_, float p_77648_8_, float p_77648_9_, float p_77648_10_) {
        if (BlockRailBase.func_150051_a(p_77648_3_.getBlock(p_77648_4_, p_77648_5_, p_77648_6_))) {
            if (!p_77648_3_.isRemote) {
                EntityMinecart entityminecart = EntityMinecart.createMinecart(p_77648_3_, (double)((float)p_77648_4_ + 0.5F), (double)((float)p_77648_5_ + 0.5F), (double)((float)p_77648_6_ + 0.5F), this.minecartType);
                if (p_77648_1_.hasDisplayName()) {
                    entityminecart.setMinecartName(p_77648_1_.getDisplayName());
                }

                p_77648_3_.spawnEntityInWorld(entityminecart);
            }

            --p_77648_1_.stackSize;
            return true;
        } else {
            return false;
        }
    }
}
