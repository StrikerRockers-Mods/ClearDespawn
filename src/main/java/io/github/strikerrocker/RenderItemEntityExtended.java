package io.github.strikerrocker;

import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderDispatcher;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.render.item.ItemRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;

public class RenderItemEntityExtended extends ItemEntityRenderer {
    public RenderItemEntityExtended(EntityRenderDispatcher entityRenderDispatcher, ItemRenderer itemRenderer) {
        super(entityRenderDispatcher, itemRenderer);
    }

    @Override
    public void render(ItemEntity itemEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        int remainingTime = 6000 - itemEntity.getAge();

        if (remainingTime <= 20 * 20) {

            if (true) {
                int flashFactor = Math.max(2, remainingTime / 20);

                if (remainingTime % (flashFactor) < 0.5f * flashFactor) {
                    return;
                }
            } else if (remainingTime % 20 < 10) {
                return;
            }
        }
        super.render(itemEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public static class Factory implements EntityRendererRegistry.Factory {

        @Override
        public EntityRenderer<? extends Entity> create(EntityRenderDispatcher entityRenderDispatcher, EntityRendererRegistry.Context context) {
            return new RenderItemEntityExtended(entityRenderDispatcher, MinecraftClient.getInstance().getItemRenderer());
        }
    }
}
