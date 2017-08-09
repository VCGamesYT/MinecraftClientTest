package Plux.Commands;

public abstract class Command {
	public abstract String getAlias();
	public abstract String getSyntax();
	public abstract void onCommand(String command, String[] args) throws Exception;
}
