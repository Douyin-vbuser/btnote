package com.vbuser.btnote.blocks.tileEntity;

import com.vbuser.btnote.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {
    public static void registerTileEntities(){
        GameRegistry.registerTileEntity(TileEntityBtnoteFive.class, new ResourceLocation(Reference.Mod_ID+":btnote_five"));
    }
}
