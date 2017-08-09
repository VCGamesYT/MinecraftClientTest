package Plux;

import org.lwjgl.opengl.Display;

import Plux.Alts.AltManager;
import Plux.Commands.CommandManager;
import Plux.Event.EventManager;
import Plux.Files.FileManager;
import Plux.Files.FileManager.CustomFile;
import Plux.Friends.FriendManager;
import Plux.Mod.Mod;
import Plux.Mod.ModManager;
import Plux.UI.Hud;
import Plux.UI.Font.FontManager;
import Plux.UI.tab.TabGui;
import net.minecraft.client.Minecraft;
import net.minecraft.network.play.server.S02PacketChat;
import net.minecraft.util.ChatComponentText;

public class Plux {

public static final Plux instance = new Plux();
	
	public static Plux Plux = new Plux();
	
	public static ModManager modManager = new ModManager();
	
	public static FontManager fontManager = new FontManager();
	
	public static Hud HUD = new Hud();
	
	public static final String Name = "Plux";
	
	public static final String Version = "0.1";
	
	public static String prefix = "-";
	
	public static TabGui tabGui;
	
	public static AltManager altManager;
    
   public static CustomFile customFile;
    
    public static FileManager fileManager;
    
   public static FriendManager friendManager;
    
    public static CommandManager cmdManager;
    
    public static final String tag = "§7[§5Plux§7]§7 ";
    
	
	public  void start(){
		Display.setTitle(Name);
		EventManager.register(this);	
		fontManager.loadFonts();
		cmdManager = new CommandManager();
		fileManager = new FileManager();
	    friendManager = new FriendManager();
	    fileManager.loadFiles();
		tabGui = new TabGui();
		Runtime.getRuntime().addShutdownHook(new Thread(() -> end()));
	}
	public  void end(){
		
	}
	
	public static Plux getInstance(){
		return Plux;
	}
	public static void addChatMessage(String s){
		Minecraft.getMinecraft().thePlayer.addChatMessage(new ChatComponentText(tag + s));	
		}
		
	public static boolean onSendChatMessage(String s){
			if(s.startsWith(prefix)){
				
				cmdManager.callCommand(s.substring(1));
				return false;
			}
			for(Mod m: Plux.instance.modManager.getMods()){
				if(m.isToggled()){
					return m.onSendChatMessage(s);

				}
			}
			return true;
			
		}
		
		public static boolean onReciveChatMessage(S02PacketChat packet){
			for(Mod m: Plux.instance.modManager.getMods()){
				if(m.isToggled()){
					return m.onReciveChatMessage(packet);
		
				}
			}
			return true;
		}
}

