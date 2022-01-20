package io.github.strikerrocker;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.Toml4jConfigSerializer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.world.entity.EntityType;

public class ClearDespawn implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        AutoConfig.register(ModConfig.class, Toml4jConfigSerializer::new);
        EntityRendererRegistry.register(EntityType.ITEM, new RenderItemEntityExtended.Factory());
    }
}