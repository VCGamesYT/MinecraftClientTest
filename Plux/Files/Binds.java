package Plux.Files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.lwjgl.input.Keyboard;

import Plux.Plux;
import Plux.Mod.Mod;




public class Binds
extends FileManager.CustomFile {
    public Binds(String name, boolean Mod2, boolean loadOnStart) {
        super(name, Mod2, loadOnStart);
    }

    @Override
    public void loadFile() throws IOException {
        String line;
        BufferedReader variable9 = new BufferedReader(new FileReader(this.getFile()));
        while ((line = variable9.readLine()) != null) {
            int i2 = line.indexOf(":");
            if (i2 < 0) continue;
            String Mod = line.substring(0, i2).trim();
            String key = line.substring(i2 + 1).trim();
            Plux.getInstance();
            Mod m2 = Plux.Plux.instance.modManager.getModbyName(Mod);
            m2.setKey(Keyboard.getKeyIndex(key.toUpperCase()));
        }
        variable9.close();
        System.out.println("Loaded " + this.getName() + " File!");
    }

    @Override
    public void saveFile() throws IOException {
        PrintWriter variable9 = new PrintWriter(new FileWriter(this.getFile()));
        for (Mod m2 : Plux.instance.modManager.getMods()) {
            variable9.println(String.valueOf(String.valueOf(m2.getName())) + ":" + Keyboard.getKeyName(m2.getKey()));
        }
        variable9.close();
    }
}

