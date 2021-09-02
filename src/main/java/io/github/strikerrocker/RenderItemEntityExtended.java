package io.github.strikerrocker;

import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ItemEntityRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.ItemEntity;

public class RenderItemEntityExtended extends ItemEntityRenderer {
    public RenderItemEntityExtended(EntityRendererFactory.Context context) {
        super(context);
    }

    @Override
    public void render(ItemEntity itemEntity, float f, float g, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        int remainingTime = 6000 - itemEntity.getItemAge();
        if (remainingTime <= 20 * ConfigurationHandler.getFlashStartTime()) {
            int flashFactor = remainingTime / 20;
            if (flashFactor < 2) {
                flashFactor = 2;
            }
            if (flashFactor > 20) {
                flashFactor = 20;
            }

            if (remainingTime % flashFactor < flashFactor / 2) {
                return;
            }
        }
        super.render(itemEntity, f, g, matrixStack, vertexConsumerProvider, i);
    }

    public static class Factory implements EntityRendererFactory<ItemEntity> {

        @Override
        public EntityRenderer<ItemEntity> create(EntityRendererFactory.Context context) {
            return new RenderItemEntityExtended(context);
        }
    }
}
