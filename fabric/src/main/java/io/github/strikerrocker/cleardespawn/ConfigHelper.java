package io.github.strikerrocker.cleardespawn;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return ClearDespawn.config.flashStartTime;
    }

    @Override
    public int getItemDespawnTime() {
        return ClearDespawn.config.despawnTime;
    }

    @Override
    public boolean isUrgentFlashEnabled() {
        return ClearDespawn.config.urgentFlash;
    }
}
