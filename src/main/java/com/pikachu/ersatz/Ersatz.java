package com.pikachu.ersatz;

import ch.njol.skript.Skript;
import ch.njol.skript.SkriptAddon;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.IOException;

@SuppressWarnings("WeakerAccess")
public final class Ersatz extends JavaPlugin {

    private static Ersatz instance;
    private static SkriptAddon addonInstance;

    public Ersatz() {
        if (instance != null) {
            throw new IllegalStateException();
        }
        instance = this;
    }

    @Override
    public void onEnable() {
        try {
            getAddonInstance().loadClasses(getClass().getPackage() + ".skript");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static SkriptAddon getAddonInstance() {
        if (addonInstance == null) {
            addonInstance = Skript.registerAddon(getInstance());
        }
        return addonInstance;
    }

    public static Ersatz getInstance() {
        if (instance == null) {
            throw new IllegalStateException();
        }
        return instance;
    }
}
