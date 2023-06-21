package io.github.strikerrocker.cleardespawn;

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
            if (Services.CONFIG_HELPER.isUrgentFlashEnabled()) {
                int flashFactor = Math.max(2, remainingTime / 20);
                if (remainingTime % flashFactor < 0.5f * flashFactor) {
                    return;
                }
            } else if (remainingTime % 20 < 10) {
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
