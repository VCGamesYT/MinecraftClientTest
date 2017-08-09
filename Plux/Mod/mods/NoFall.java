package Plux.Mod.mods;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;
import net.minecraft.network.play.client.C03PacketPlayer;

public class NoFall extends Mod{

	public NoFall() {
		super("NoFall", "NoFall", Keyboard.KEY_N, Category.PLAYER);
	}
	@EventTarget
	public void onUpdate(EventUpdate e){
			if(mc.thePlayer.fallDistance >= 2F){
				mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer(true));
		}
	}

}

