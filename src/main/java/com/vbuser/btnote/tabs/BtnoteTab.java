package com.vbuser.btnote.tabs;

import com.vbuser.btnote.init.ModBlocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class BtnoteTab extends CreativeTabs{
    public BtnoteTab(String label) {
    super("btnotetab");
    }

    public ItemStack getTabIconItem() {
        return new ItemStack(Item.getItemFromBlock(ModBlocks.NOTE_X));
    }
}
