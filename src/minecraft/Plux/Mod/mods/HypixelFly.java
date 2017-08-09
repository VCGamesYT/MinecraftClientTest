package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventPreMotionUpdates;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class HypixelFly extends Mod{

	public HypixelFly() {
		super("HypixelFly", "HypixelFly", Keyboard.KEY_H, Category.MOVEMENT);
	}
	@EventTarget
	public void onUpdate(EventPreMotionUpdates e){
			if(mc.thePlayer.isSneaking()){
				mc.thePlayer.motionY = -0.4;
			}
			else if (mc.gameSettings.keyBindJump.pressed){
				mc.thePlayer.motionY = 0.4;
			}
			else if (mc.gameSettings.keyBindForward.pressed || mc.gameSettings.keyBindBack.pressed || mc.gameSettings.keyBindLeft.pressed || mc.gameSettings.keyBindRight.pressed){
				mc.thePlayer.motionY = 0;
				mc.thePlayer.setSprinting(true);
			}
			else{
				mc.thePlayer.motionY = 0;
			}
		}

}
