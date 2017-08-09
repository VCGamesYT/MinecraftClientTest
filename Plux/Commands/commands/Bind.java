package Plux.Commands.commands;

import org.lwjgl.input.Keyboard;

import Plux.Plux;
import Plux.Commands.Command;
import Plux.Mod.Mod;

public class Bind extends Command{

	@Override
	public String getAlias() {
		return "bind";
	}

	@Override
	public String getSyntax() {
		return "-bind mod key | -bind del mod";
	}

	@Override
	public void onCommand(String command, String[] args) throws Exception {
		args[1] = args[1].toUpperCase();
		int key = Keyboard.getKeyIndex(args[1]);
		for(Mod m: Plux.instance.modManager.getMods()){
			if(args[0].equalsIgnoreCase(m.getName())){
				m.setKey(Keyboard.getKeyIndex(Keyboard.getKeyName(key)));
				Plux.addChatMessage(args[0] + "§7 has been binded to §7" + args[1]);
			}
		}
		
		if(args[0].equalsIgnoreCase("del")){
			for(Mod m: Plux.instance.modManager.getMods()){
				if(m.getName().equalsIgnoreCase(args[1])){
					m.setKey(0);
					Plux.addChatMessage(args[1] + " has been unbinded");
				}
			
			
		}
				
			}
		
		Plux.getInstance();
		Plux.instance.fileManager.saveFiles();
	}

}
