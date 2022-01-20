package io.github.strikerrocker;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.ItemEntityRenderer;
import net.minecraft.world.entity.item.ItemEntity;

public class RenderItemEntityExtended extends ItemEntityRenderer {
    public RenderItemEntityExtended(EntityRendererProvider.Context context) {
        super(context);
    }

    @Override
    public void render(ItemEntity entity, float entityYaw, float partialTicks, PoseStack matrixStack, MultiBufferSource buffer, int packedLight) {
        int remainingTime = Services.CONFIG_HELPER.getItemDespawnTime() - entity.getAge();
        if (remainingTime <= 20 * Services.CONFIG_HELPER.getFlashStartTime()) {
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
        super.render(entity, entityYaw, partialTicks, matrixStack, buffer, packedLight);
    }

    public static class Factory implements EntityRendererProvider<ItemEntity> {
        @Override
        public EntityRenderer<ItemEntity> create(Context context) {
            return new RenderItemEntityExtended(context);
        }
    }
}
