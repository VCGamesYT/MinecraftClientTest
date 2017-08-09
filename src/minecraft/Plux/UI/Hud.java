package Plux.UI;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;


import Plux.Plux;
import Plux.Category.Category;
import Plux.Event.EventManager;
import Plux.Event.EventTarget;
import Plux.Event.events.EventRender2D;
import Plux.Mod.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.ScaledResolution;

public class Hud {
    public Hud() {

        EventManager.register(this);
    }

    @EventTarget
    public void onRender(EventRender2D event) {
    	ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft(), Minecraft.getMinecraft().displayWidth, Minecraft.getMinecraft().displayHeight);
    	if(!Minecraft.getMinecraft().gameSettings.showDebugInfo && Objects.nonNull(Minecraft.getMinecraft().thePlayer) && Objects.nonNull(Minecraft.getMinecraft().theWorld) ) {
    		
    		 Plux.instance.fontManager.hud.drawStringWithShadow("§l"+Plux.instance.Name , 2, 5, 0xcc07ef);
    	        renderArrayList(scaledResolution);
    	        if(Minecraft.getMinecraft().currentScreen == null){
    	        drawTabGui();
    	        }
    	}
       
    }

    private void renderArrayList(ScaledResolution scaledResolution) {
    	int index = 0;
    	long x = 0;
        int yCount = 5;
        int right = scaledResolution.getScaledWidth();
        List<Mod> mod = Plux.instance.modManager.getMods();
		mod.sort(new Comparator<Mod>(){
			public final int compare(Mod m1, Mod m2){
				return ((Integer)
						Minecraft.getMinecraft().fontRendererObj.getStringWidth(m2.GetArrayListName())).compareTo(Minecraft.getMinecraft().fontRendererObj.getStringWidth(m1.GetArrayListName()));
				}});
        for (Mod Mod : Plux.instance.modManager.getMods()) {
            if (Mod.isToggled() && Mod.getCategory() != Category.NONE) {
                Plux.instance.fontManager.arraylist.drawString(Mod.GetArrayListName(), right - Plux.instance.fontManager.arraylist.getStringWidth(Mod.GetArrayListName()) - 2, yCount, 0xcc07ef);
                yCount += 10;
                index++;
                x++;
                	
            }
           
        }
        
    }
    
    public void drawTabGui(){
    	Plux.instance.tabGui.setColourBox(-88526139);
    	Plux.instance.tabGui.drawGui(2, 18);
    }
   
}