package io.github.strikerrocker;

import de.guntram.mcmod.fabrictools.ConfigChangedEvent;
import de.guntram.mcmod.fabrictools.Configuration;
import de.guntram.mcmod.fabrictools.ModConfigurationHandler;

import java.io.File;

public class ConfigurationHandler implements ModConfigurationHandler {
    private static ConfigurationHandler instance;

    private Configuration config;

    private int flashStartTime;
    private int despawnTime;

    public static ConfigurationHandler getInstance() {
        if (instance == null) instance = new ConfigurationHandler();
        return instance;
    }

    public static int getFlashStartTime() {
        return getInstance().flashStartTime;
    }

    public static int getDespawnTime() {
        return getInstance().despawnTime;
    }

    public void load(final File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            loadConfig();
        }
    }

    @Override
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ClearDespawn.MODNAME)) {
            loadConfig();
        }
    }

    @Override
    public void onConfigChanging(ConfigChangedEvent.OnConfigChangingEvent event) {
        if (event.getModID().equals(ClearDespawn.MODNAME) && "cleardespawn.config.timeleft".equals(event.getItem())) {
            flashStartTime = (Integer) (event.getNewValue());
        }
    }

    private void loadConfig() {
        flashStartTime = config.getInt("cleardespawn.config.timeleft",
                Configuration.CATEGORY_CLIENT, 20, 0, 300, "cleardespawn.config.tt.timeleft");
        despawnTime = config.getInt("cleardespawn.config.despawntime",
                Configuration.CATEGORY_CLIENT, 6000, 0, 36000, "cleardespawn.config.tt.despawntime");
        if (config.hasChanged())
            config.save();
    }

    @Override
    public Configuration getConfig() {
        return getInstance().config;
    }
}
