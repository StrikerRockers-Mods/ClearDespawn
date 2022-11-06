package io.github.strikerrocker.cleardespawn;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return Config.CLIENT.flashStartTime.get();
    }

    @Override
    public int getItemDespawnTime() {
        return Config.CLIENT.despawnTime.get();
    }

    @Override
    public boolean isUrgentFlashEnabled() {
        return Config.CLIENT.urgentFlash.get();
    }
}
