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
        GameRegistry.registerTileEntity(TileEntityPianoFive.class, new ResourceLocation(Reference.Mod_ID+":piano_five"));
        GameRegistry.registerTileEntity(TileEntityPianoSix.class,new ResourceLocation(Reference.Mod_ID+":piano_six"));
        GameRegistry.registerTileEntity(TileEntityPianoSeven.class,new ResourceLocation(Reference.Mod_ID+":piano_seven"));
        GameRegistry.registerTileEntity(TileEntityPianoOne.class,new ResourceLocation(Reference.Mod_ID+":piano_one"));
        GameRegistry.registerTileEntity(TileEntityPianoTwo.class,new ResourceLocation(Reference.Mod_ID+":piano_two"));
        GameRegistry.registerTileEntity(TileEntityPianoThree.class,new ResourceLocation(Reference.Mod_ID+":piano_three"));
        GameRegistry.registerTileEntity(TileEntityPianoFour.class,new ResourceLocation(Reference.Mod_ID+":piano_four"));
    }
}
