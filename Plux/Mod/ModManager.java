package Plux.Mod;

import java.util.ArrayList;

import Plux.Mod.mods.*;

public class ModManager {
    public static ArrayList<Mod> activeMods = new ArrayList();

    public ModManager() {
    	//mods go here
    	activeMods.add(new Fly());
    	activeMods.add(new AntiVelocity());
    	activeMods.add(new HypixelFly());
    	activeMods.add(new FullBright());
    	activeMods.add(new InfiniteAura());
    	activeMods.add(new KillAura());
    	activeMods.add(new LongJump());
    	activeMods.add(new NoFall());
    	activeMods.add(new NoSlowDown());
    	activeMods.add(new Speed());
    	activeMods.add(new Sprint());
    }

    public Mod getMod(Class<? extends Mod> clazz) {
        for (Mod mod : ModManager.getMods()) {
            if (mod.getClass() != clazz) continue;
            return mod;
        }
        return null;
    }

    public static void arrayListSorter(String order) {
    }

    public static ArrayList<Mod> getMods() {
        return activeMods;
    }

    public Mod getModbyName(String name) {
        for (Mod mod : ModManager.getMods()) {
            if (!mod.getName().equalsIgnoreCase(name)) continue;
            return mod;
        }
        return null;
    }

   
   
    public ArrayList<Mod> enabledMods() {
        ArrayList<Mod> emods = new ArrayList<Mod>();
        for (Mod m2 : activeMods) {
            if (m2.isToggled()) {
                emods.add(m2);
                continue;
            }
            if (m2.isToggled()|| !emods.contains(m2)) continue;
            emods.remove(m2);
        }
        return emods;
    }
}

