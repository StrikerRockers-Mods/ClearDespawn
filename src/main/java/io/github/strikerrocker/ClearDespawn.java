package io.github.strikerrocker;

import de.guntram.mcmod.crowdintranslate.CrowdinTranslate;
import de.guntram.mcmod.fabrictools.ConfigurationProvider;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.entity.EntityType;

public class ClearDespawn implements ClientModInitializer {
    
    public static final String MODNAME = "ClearDespawn";
    public static final String MODID   = "cleardespawn";

	@Override
	public void onInitializeClient() {
        ConfigurationHandler confHandler = ConfigurationHandler.getInstance();
        ConfigurationProvider.register(MODNAME, confHandler);
        confHandler.load(ConfigurationProvider.getSuggestedFile(MODID));
        CrowdinTranslate.downloadTranslations(MODID);
        
        EntityRendererRegistry.INSTANCE.register(EntityType.ITEM, new RenderItemEntityExtended.Factory());
    }
}