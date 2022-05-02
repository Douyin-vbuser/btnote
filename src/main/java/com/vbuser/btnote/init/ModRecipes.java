package com.vbuser.btnote.init;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

    public static void init(){
        GameRegistry.addSmelting(ModBlocks.NOTE_FIVE,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_FOUR ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_THREE ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_TWO ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_ONE ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_SIX ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_SEVEN ,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.NOTE_X ,new ItemStack(Blocks.NOTEBLOCK),10f);
    }

}
