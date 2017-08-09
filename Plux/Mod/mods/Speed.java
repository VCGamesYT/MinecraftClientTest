package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class Speed extends Mod{

	public Speed() {
		super("Speed", "Speed", Keyboard.KEY_M, Category.MOVEMENT);
	}
	@EventTarget
	public void onUpdate(EventUpdate e){
			if(mc.thePlayer.onGround){
				mc.thePlayer.motionX *= 1.3;
				mc.thePlayer.motionZ *= 1.3;
		}
	}

}
