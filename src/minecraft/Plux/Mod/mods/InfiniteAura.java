package Plux.Mod.mods;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;

public class InfiniteAura extends Mod{
	private int ticks = 0;
	public InfiniteAura() {
		super("InfiniteAura", "InfiniteAura", Keyboard.KEY_G, Category.COMBAT);
	}
	@EventTarget
	public void onUpdate(EventUpdate event){
			ticks++;
			if(ticks >= 20 - speed()){
				ticks = 0;
				for(Iterator<Entity> entities = mc.theWorld.loadedEntityList.iterator(); entities.hasNext();) {
		            Object theObject = entities.next();
		            if(theObject instanceof EntityLivingBase) {
		                EntityLivingBase entity = (EntityLivingBase) theObject;
		               
		                if(entity instanceof EntityPlayerSP) continue;
		               
		                if(mc.thePlayer.getDistanceToEntity(entity) <= 200F) {
		                	
		                	if(entity.isInvisible()){
		                		break;
		                	}
		                    if(entity.isEntityAlive()) {
		    						mc.thePlayer.sendQueue.addToSendQueue(new C03PacketPlayer.C04PacketPlayerPosition(entity.posX, entity.posY, entity.posZ, true));
		                    	if(mc.thePlayer.getHeldItem() != null){
		    							mc.thePlayer.setItemInUse(mc.thePlayer.getHeldItem(), mc.thePlayer.getHeldItem().getMaxItemUseDuration());
		                        	}
		                    	if(mc.thePlayer.isBlocking()){
		    						mc.thePlayer.sendQueue.addToSendQueue(new C07PacketPlayerDigging(Action.RELEASE_USE_ITEM, new BlockPos(0, 0, 0), EnumFacing.UP));
		    					}
		    					
		                    	mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
		                        mc.thePlayer.swingItem();
		                        break;
		                    }
				}
			}
		}
			}
	}
	private int speed() {
		return 18;
	}

}
