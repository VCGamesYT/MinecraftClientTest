package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class Fly extends Mod{

	public Fly() {
		super("Fly", "Fly", Keyboard.KEY_F, Category.MOVEMENT);
	}
	@EventTarget
	public void onUpdate(EventUpdate event){
		mc.thePlayer.capabilities.isFlying = true;
		mc.thePlayer.capabilities.allowFlying = true;
		mc.thePlayer.capabilities.setFlySpeed(0.2F);
	}
	public void onDisable(){
		super.onDisable();
		mc.thePlayer.capabilities.isFlying = false;
		mc.thePlayer.capabilities.allowFlying = false;
	}

}
