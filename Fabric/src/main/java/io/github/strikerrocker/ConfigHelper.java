package io.github.strikerrocker;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return ModConfig.flashStartTime;
    }

    @Override
    public int getItemDespawnTime() {
        return ModConfig.despawnTime;
    }
}
