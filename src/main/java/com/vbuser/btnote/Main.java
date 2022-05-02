package com.vbuser.btnote;

import com.vbuser.btnote.init.ModRecipes;
import com.vbuser.btnote.proxy.CommonProxy;
import com.vbuser.btnote.tabs.BtnoteTab;
import com.vbuser.btnote.util.Reference;
import com.vbuser.btnote.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.Mod_ID,name = Reference.NAME,version = Reference.VERSION)

public class Main {

    @Instance
    public static Main instance;

    public static final CreativeTabs btnotetab = new BtnoteTab("btnotetab");

    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS,serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event)
    {

    }

    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event)
    {

    }

    @EventHandler
    public static void Init(FMLInitializationEvent event)
    {
        ModRecipes.init();
        RegistryHandler.initRegistries();
    }

}
