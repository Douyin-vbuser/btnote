package com.vbuser.btnote.items.tools;

import com.vbuser.btnote.Main;
import com.vbuser.btnote.init.ModItems;
import com.vbuser.btnote.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;
import net.minecraft.item.Item.ToolMaterial;

public class ToolAxe extends ItemAxe implements IHasModel{
    public ToolAxe(String name,CreativeTabs tab,ToolMaterial material){

        super(material,15.0F,-0.5F);
        setUnlocalizedName(name);
        setRegistryName(name);
        setCreativeTab(tab);

        ModItems.ITEMS.add(this);

    }

    @Override
    public void registerModels(){
        Main.proxy.registerItemRenderer(this,0,"inventory");
    }
}
