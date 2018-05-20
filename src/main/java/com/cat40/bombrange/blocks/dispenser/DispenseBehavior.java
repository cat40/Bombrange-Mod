package com.cat40.bombrange.blocks.dispenser;

import net.minecraft.dispenser.IBlockSource;
import net.minecraft.item.ItemStack;

public interface DispenseBehavior
{
    DispenseBehavior itemDispenseBehaviorProvider = new DispenseBehavior()
    {
        private static final String __OBFID = "CL_00001200";
        public ItemStack dispense(IBlockSource p_82482_1_, ItemStack p_82482_2_)
        {
            return p_82482_2_;
        }
    };

    /**
     * Dispenses the specified ItemStack from a dispenser.
     */
    ItemStack dispense(IBlockSource p_82482_1_, ItemStack p_82482_2_);
}
