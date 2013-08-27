package thearchitect.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.network.IGuiHandler;

public class CommonProxy implements IGuiHandler {

	public static final int GUI_ID_SPAWNER_SETTING = 1;
	public static final int GUI_ID_SKULL_NAME 	   = 2;
	public static final int GUI_ID_ITEM_EDITOR 	   = 3;
	public static final int GUI_ID_FILTERS_1 	   = 4;
	public static final int GUI_ID_FILTERS_2 	   = 5;
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) { 
		return null;
	}

	public void registerHandlers() {}

	public void onPreLoad() {
		
	}
}
