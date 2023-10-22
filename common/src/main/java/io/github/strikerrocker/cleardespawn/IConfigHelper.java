package io.github.strikerrocker.cleardespawn;

import net.minecraft.world.entity.item.ItemEntity;

public interface IConfigHelper {
    int getFlashStartTime();

    @Deprecated(forRemoval = true)
    int getItemDespawnTime();

    default int getItemDespawnTime(ItemEntity entity) {
        return this.getItemDespawnTime();
    }

    boolean isUrgentFlashEnabled();
}
