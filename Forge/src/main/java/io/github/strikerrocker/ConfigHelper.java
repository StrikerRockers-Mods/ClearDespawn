package io.github.strikerrocker;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return Config.CLIENT.flashStartTime.get();
    }

    @Override
    public int getItemDespawnTime() {
        return Config.CLIENT.despawnTime.get();
    }
}
