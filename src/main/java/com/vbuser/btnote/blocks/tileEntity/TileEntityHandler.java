package com.vbuser.btnote.blocks.tileEntity;

import com.vbuser.btnote.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityBtnoteFive.class, new ResourceLocation(Reference.Mod_ID+":btnote_five"));
        GameRegistry.registerTileEntity(TileEntityBtnoteSix.class,new ResourceLocation(Reference.Mod_ID+":btnote_six"));
        GameRegistry.registerTileEntity(TileEntityBtnoteSeven.class,new ResourceLocation(Reference.Mod_ID+":btnote_seven"));
        GameRegistry.registerTileEntity(TileEntityBtnoteOne.class,new ResourceLocation(Reference.Mod_ID+":btnote_one"));
        GameRegistry.registerTileEntity(TileEntityBtnoteTwo.class,new ResourceLocation(Reference.Mod_ID+":btnote_two"));
        GameRegistry.registerTileEntity(TileEntityBtnoteThree.class,new ResourceLocation(Reference.Mod_ID+":btnote_three"));
        GameRegistry.registerTileEntity(TileEntityBtnoteFour.class,new ResourceLocation(Reference.Mod_ID+":btnote_four"));
    }
}
