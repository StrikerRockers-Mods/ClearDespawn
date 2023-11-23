package io.github.strikerrocker.cleardespawn;

import net.minecraft.world.entity.item.ItemEntity;

public class ConfigHelper implements IConfigHelper {
    @Override
    public int getFlashStartTime() {
        return ClearDespawn.config.flashStartTime;
    }

    @Override
    public int getItemDespawnTime(ItemEntity entity) {
        return ClearDespawn.config.despawnTime;
    }

    @Override
    public boolean isUrgentFlashEnabled() {
        return ClearDespawn.config.urgentFlash;
    }
}
