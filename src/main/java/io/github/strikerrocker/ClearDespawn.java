package io.github.strikerrocker;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.client.render.EntityRendererRegistry;
import net.minecraft.entity.ItemEntity;

public class ClearDespawn implements ModInitializer {
	@Override
	public void onInitialize() {
		EntityRendererRegistry.INSTANCE.register(ItemEntity.class, new RenderItemEntityExtended.Factory());
	}
}
