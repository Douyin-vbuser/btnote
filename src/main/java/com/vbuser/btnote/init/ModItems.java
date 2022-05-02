package com.vbuser.btnote.init;

import com.vbuser.btnote.items.ItemBase;
import com.vbuser.btnote.items.tools.ToolAxe;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAxe;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {

    public static final List<Item> ITEMS = new ArrayList<Item>();

    //public static final Item NOTE_TOOLS = new ItemBase("note_tools");

    public static final Item.ToolMaterial MATERIAL_OBSIDIAN = EnumHelper.addToolMaterial("note_tools",4,70616,40.0F,10.0F,40);

    public static final ItemAxe NOTE_TOOLS = new ToolAxe("note_tools", CreativeTabs.TOOLS,MATERIAL_OBSIDIAN);

    public static final Item PITCH_TOOLS = new ItemBase("pitch_tools");

    //public static final Item PIANO = new ItemBase("piano");
}
