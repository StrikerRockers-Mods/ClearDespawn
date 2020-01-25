package io.github.strikerrocker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class ClearDespawn implements ModInitializer {
	@Override
	public void onInitialize() {
        EntityRendererRegistry.INSTANCE.register(EntityType.ITEM, new RenderItemEntityExtended.Factory());
    }
}