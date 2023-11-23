package io.github.strikerrocker.cleardespawn;

import net.minecraft.world.entity.item.ItemEntity;

public interface IConfigHelper {
    int getFlashStartTime();

    int getItemDespawnTime(ItemEntity entity);

    boolean isUrgentFlashEnabled();
}
