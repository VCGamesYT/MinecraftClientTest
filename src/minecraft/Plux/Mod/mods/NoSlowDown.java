package Plux.Mod.mods;


import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class NoSlowDown extends Mod{
	public NoSlowDown(){
		super("NoSlowDown","NoSlowDown",0,Category.MOVEMENT);
	}
       @EventTarget
       public void onUpdate(EventUpdate e){
    	   if(mc.thePlayer.isBlocking()){
    		   mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0,0,0), EnumFacing.UP));
    	   }
       }
}
