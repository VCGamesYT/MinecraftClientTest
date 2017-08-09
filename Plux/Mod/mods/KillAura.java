package Plux.Mod.mods;

import java.util.Iterator;

import org.lwjgl.input.Keyboard;

import Plux.Category.Category;
import Plux.Event.EventTarget;
import Plux.Event.events.EventUpdate;
import Plux.Mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityOtherPlayerMP;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.network.play.client.C03PacketPlayer;
import net.minecraft.network.play.client.C07PacketPlayerDigging;
import net.minecraft.network.play.client.C07PacketPlayerDigging.Action;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.MathHelper;

public class KillAura extends Mod{
	private int ticks = 0;
	public static float yaw;
	public static float pitch;
	public static Entity entity;
	public static double cps = 18.0;
	public static double reach = 7.0;
	public KillAura() {
		super("KillAura", "KillAura", Keyboard.KEY_R, Category.COMBAT);
	}
	@EventTarget
	public void onUpdate(EventUpdate event){
		ticks++;
		entity = closeEntity();
		if (entity != null) {
		                if(mc.thePlayer.getDistanceToEntity(entity) <= (float) reach) {
		                	
		                	if(entity.isInvisible()){
		                		return;
		                	}
		                    if(entity.isEntityAlive()) {
		                    	if(mc.thePlayer.getHeldItem() != null){
		    							mc.thePlayer.setItemInUse(mc.thePlayer.getHeldItem(), mc.thePlayer.getHeldItem().getMaxItemUseDuration());
		    							//HINT: Place block (packet)
		                        	}
		                    	LookAtEntity(entity);
		    					if(ticks >= 20/cps){
		    						//HINT: Relase the item (packet)
		    						mc.thePlayer.sendQueue.addToSendQueue(new C02PacketUseEntity(entity, C02PacketUseEntity.Action.ATTACK));
		    						//HINT: Place block (packet)
			                        mc.thePlayer.swingItem();
			                        ticks = 0;
		    					}
		                    }
		                }
					}
			}
	
	public Entity closeEntity() {
		Entity close = null;
		for (Object o : mc.theWorld.loadedEntityList) {
			Entity e = (Entity) o;
			if (e instanceof EntityOtherPlayerMP && e.isEntityAlive() && !e.isInvisible()) {
				if (close == null || mc.thePlayer.getDistanceToEntity(e) < mc.thePlayer.getDistanceToEntity(close)) {
					close = e;
				}
			}
		}
		return close;
	}

	public static float[] getRotations(Entity ent)
	{
	  double x = ent.posX;
	  double z = ent.posZ;
	  double y = ent.boundingBox.maxY - 4.0D;
	  return getRotationFromPosition(x, z, y);
	}
	public static float[] getRotationFromPosition(double x, double z, double y)
	{
	  double xDiff = x - Minecraft.getMinecraft().thePlayer.posX;
	  double zDiff = z - Minecraft.getMinecraft().thePlayer.posZ;
	  double yDiff = y - Minecraft.getMinecraft().thePlayer.posY + Minecraft.getMinecraft().thePlayer.getEyeHeight();
	  double dist = MathHelper.sqrt_double(xDiff * xDiff + zDiff * zDiff);
	  float yaw = (float)(Math.atan2(zDiff, xDiff) * 180.0D / Math.PI) - 90.0F;
	  float pitch = (float)-(Math.atan2(yDiff, dist) * 180.0D / Math.PI);
	  return new float[] { yaw, pitch };
	}
   
    public static void LookAtEntity(Entity entity)
      {
    	float[] rotations = getRotations(entity);
		  yaw = rotations[0];
		 pitch = rotations[1];
      }
	public static void look() {
		mc.thePlayer.sendQueue
				.addToSendAuraQueue(new C03PacketPlayer.C05PacketPlayerLook(yaw, pitch, mc.thePlayer.onGround));
	}

	public static void poslook() {
		mc.thePlayer.sendQueue.addToSendAuraQueue(new C03PacketPlayer.C06PacketPlayerPosLook(mc.thePlayer.posX,
				mc.thePlayer.getEntityBoundingBox().minY, mc.thePlayer.posZ, yaw, pitch, mc.thePlayer.onGround));
	}
	
}
