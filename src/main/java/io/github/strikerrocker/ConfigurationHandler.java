package io.github.strikerrocker;

import de.guntram.mcmod.fabrictools.ConfigChangedEvent;
import de.guntram.mcmod.fabrictools.Configuration;
import de.guntram.mcmod.fabrictools.ModConfigurationHandler;
import java.io.File;

public class ConfigurationHandler implements ModConfigurationHandler
{
    private static ConfigurationHandler instance;

    private Configuration config;
    private String configFileName;

    private int flashStartTime;

    public static ConfigurationHandler getInstance() {
        if (instance==null) {
            instance=new ConfigurationHandler();
        }
        return instance;
    }
    
    public void load(final File configFile) {
        if (config == null) {
            config = new Configuration(configFile);
            configFileName=configFile.getPath();
            loadConfig();
        }
    }
    
    public static String getConfigFileName() {
        return getInstance().configFileName;
    }

    @Override
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
        if (event.getModID().equals(ClearDespawn.MODNAME)) {
            loadConfig();
        }
    }
    
    @Override
    public void onConfigChanging(ConfigChangedEvent.OnConfigChangingEvent event) {
        if (event.getModID().equals(ClearDespawn.MODNAME)) {
            switch (event.getItem()) {
                case "cleardespawn.config.timeleft":     
                    flashStartTime = (int)(Integer)(event.getNewValue());
                    break;
            }
        }
    }
    
    private void loadConfig() {
        flashStartTime=config.getInt("cleardespawn.config.timeleft", 
                Configuration.CATEGORY_CLIENT, 20, 0, 300, "cleardespawn.config.tt.timeleft");

        if (config.hasChanged())
            config.save();
    }
    
    @Override
    public Configuration getConfig() {
        return getInstance().config;
    }

    public static int getFlashStartTime()      { return getInstance().flashStartTime; }
}
