package com.vbuser.btnote.init;

import net.minecraft.init.Blocks;
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
        GameRegistry.addSmelting(ModBlocks.PIANO_ONE,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_TWO,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_THREE,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_FOUR,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_FIVE,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_SIX,new ItemStack(Blocks.NOTEBLOCK),10f);
        GameRegistry.addSmelting(ModBlocks.PIANO_SEVEN,new ItemStack(Blocks.NOTEBLOCK),10f);
    }

}
