package com.vbuser.btnote.init;

import com.vbuser.btnote.Main;
import com.vbuser.btnote.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {

    public static final List<Block> BLOCKS = new ArrayList<Block>();

    public static final Block NOTE_X = new Note_x("note_x",Material.WOOD, Main.btnotetab);

    public static final Block NOTE_ONE = new Note_one("note_one",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_TWO = new Note_two("note_two",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_THREE = new Note_three("note_three",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_FOUR = new Note_four("note_four",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_FIVE = new Note_five("note_five",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_SIX = new Note_six("note_six",Material.WOOD,Main.btnotetab);

    public static final Block NOTE_SEVEN = new Note_seven("note_seven",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_ONE = new Piano_one("piano_one",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_TWO = new Piano_two("piano_two",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_THREE = new Piano_three("piano_three",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_FOUR = new Piano_four("piano_four",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_FIVE = new Piano_five("piano_five",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_SIX = new Piano_six("piano_six",Material.WOOD,Main.btnotetab);

    public static final Block PIANO_SEVEN = new Piano_seven("piano_seven",Material.WOOD,Main.btnotetab);
}
