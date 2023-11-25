package io.github.strikerrocker.cleardespawn;

import net.minecraft.world.entity.item.ItemEntity;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return Config.CLIENT.flashStartTime.get();
    }

    @Override
    public int getItemDespawnTime(ItemEntity entity) {
        return entity.lifespan;
    }

    @Override
    public boolean isUrgentFlashEnabled() {
        return Config.CLIENT.urgentFlash.get();
    }
}
