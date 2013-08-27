package thearchitect;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import thearchitect.core.proxy.CommonProxy;
import thearchitect.lib.Reference;

import net.minecraft.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.ForgeSubscribe;

import com.google.common.eventbus.Subscribe;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

/**
 * @author ProPercivalalb
 * The Main Mod Class.
 */
@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION, dependencies = Reference.MOD_DEPENDENCIES)
@NetworkMod(clientSideRequired = false, serverSideRequired = true)
public class TheArchitect {

	@Instance(value = Reference.MOD_ID)
	public static TheArchitect instance;
	
	@SidedProxy(clientSide = Reference.SP_CLIENT, serverSide = Reference.SP_SERVER)
    public static CommonProxy proxy;
	
	public static String sectionSign = "";
	
	public TheArchitect() {
   	 	instance = this;
    }
	
	@EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        //Initialize the custom commands
        //CommandHandler.initCommands(event);
    }
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		proxy.onPreLoad();
		//VersionHelper.checkVersion(Type.BLANK);
		//Loads the Languages into the game
		//LocalizationHandler.loadLanguages();
		//Sets the mc directory
		//DirectoryHelper.setMcDir(event);
		//Loads the Blocks/Items
		ModBlocks.inti();
		ModItems.inti();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		//NetworkRegistry.instance().registerChannel(new PacketHandler(), Reference.CHANNEL_NAME);
		NetworkRegistry.instance().registerGuiHandler(instance, proxy);
		//Action Handler
		//MinecraftForge.EVENT_BUS.register(new ActionHandler());
		proxy.registerHandlers();
	}
		
	@EventHandler
	public void modsLoaded(FMLPostInitializationEvent par1) {
		
	}
}
