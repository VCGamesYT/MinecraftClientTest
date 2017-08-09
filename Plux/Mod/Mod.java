package Plux.Mod;

import Plux.Category.Category;
import Plux.Event.EventManager;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;

public class Mod {
	public static Minecraft mc = Minecraft.getMinecraft();
	private String name;
	private String ArrayListName;
	private int key;
	private boolean toggled;
	private String[] alias;
	private Category category;
	
	public Mod(String n, String an, int var1, Category c){
		name = n;
		ArrayListName = an;
		key = var1;
		category = c;
		toggled = false;
	}
	public void toggle(){
		onToggle();
		toggled = !toggled;
		if(toggled){
			onEnable();
		}
		else{
			onDisable();
			
		}
		
		
	}

	public void onEnable() {EventManager.register(this);}
	public void onDisable() {EventManager.unregister(this);}
	public void onUpdate(){}
	public void onRender(){}
	public void onToggle(){}

	
	
	public Minecraft getMc() {
		return mc;
	}

	public void setMc(Minecraft mc) {
		this.mc = mc;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public String GetArrayListName(){
		return ArrayListName;
	}
	public void setArrayListName(String ArrayListName){
		this.ArrayListName = ArrayListName;
	}

	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public boolean isToggled() {
		return toggled;
	}

	public void setToggled(boolean toggled) {
		this.toggled = toggled;
	}
	public Category getCategory(){
		return category;
	}
	public boolean onSendChatMessage(String s) {

		return true;
	}
	public boolean onReciveChatMessage(S02PacketChat packet) {

		return true;
	}
	public final boolean isCategory(Category s) {
		if (s == category)
			return true;
		return false;
	}
	 public String[] getAlias() {
        return this.alias;
    }


}
