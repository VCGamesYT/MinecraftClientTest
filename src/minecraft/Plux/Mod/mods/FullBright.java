package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class FullBright extends Mod{

	public FullBright() {
		super("FullBright", "FullBright", Keyboard.KEY_B, Category.RENDER);
	}
	@EventTarget
	public void onUpdate(EventUpdate e)
	{
			mc.gameSettings.gammaSetting = 100F;
	}
	public void onDisable(){
		super.onDisable();
		mc.gameSettings.gammaSetting = 0F;
	}
}
