package Plux.Commands;

import java.util.ArrayList;

import Plux.Plux;
import Plux.Commands.commands.*;

public class CommandManager {
	private ArrayList<Command> Commands;
	public CommandManager(){
		Commands = new ArrayList();
		//0 - command go here
		addCommand(new Bind());
	}
	public void addCommand(Command c){
		Commands.add(c);
		
	}
	public ArrayList<Command> getCommands(){
		return Commands;
	}
	public void callCommand(String input){
		String[] split = input.split(" ");
		String Command = split[0];
		String args = input.substring(Command.length()).trim();
		for(Command c: getCommands()){
			if(c.getAlias().equalsIgnoreCase(Command)){
				try{
					
				
				c.onCommand(args, args.split(" "));
			}catch (Exception e){
				Plux.addChatMessage(c.getSyntax());
				
			}
				return;
		}
	}
		Plux.addChatMessage("§7Command not found! use -help");

}}
