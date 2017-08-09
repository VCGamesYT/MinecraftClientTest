package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;

public class LongJump extends Mod{

	public LongJump() {
		super("LongJump", "LongJump", Keyboard.KEY_K, Category.MOVEMENT);
	}
	@EventTarget
	public void onUpdate(EventUpdate event){
			if(mc.gameSettings.keyBindForward.pressed || mc.gameSettings.keyBindBack.pressed || mc.gameSettings.keyBindLeft.pressed || mc.gameSettings.keyBindRight.pressed && mc.gameSettings.keyBindJump.pressed){
				if(mc.thePlayer.isAirBorne){
					mc.thePlayer.motionX *= 1.11;
					mc.thePlayer.motionZ *= 1.11;
				}
			}else{
				mc.thePlayer.motionX *= 1;
				mc.thePlayer.motionZ *= 1;
			}
		}
	}

