package Plux.Mod.mods;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class Sprint extends Mod{

	public Sprint() {
		super("Sprint", "Sprint", 0, Category.MOVEMENT);
	}
	@EventTarget
	public void onUpdate(EventUpdate e){
		if(mc.thePlayer.moveForward > 0){
			mc.thePlayer.setSprinting(true);
		}
	}
}
