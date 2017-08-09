package Plux.UI.Font;

import java.awt.Font;

public class FontManager {

    public MinecraftFontRenderer hud = null;

    public MinecraftFontRenderer arraylist = null;

    public MinecraftFontRenderer mainMenu = null;

    public MinecraftFontRenderer chat = null;


    private static String fontName = "Comfortaa";

    public void loadFonts() {

        hud = new MinecraftFontRenderer(new Font(fontName, Font.PLAIN, 22), true, true);
        arraylist = new MinecraftFontRenderer(new Font(fontName, Font.PLAIN, 18), true, true);
        mainMenu = new MinecraftFontRenderer(new Font(fontName, Font.PLAIN, 50), true, true);
        chat = new MinecraftFontRenderer(new Font("Verdana", Font.PLAIN, 17), true, true);
    }

    public static String getFontName() {

        return fontName;
    }

    public static void setFontName(String fontName) {

        FontManager.fontName = fontName;
    }
}
