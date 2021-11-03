package io.github.strikerrocker;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = ClearDespawn.MODID)
public class ModConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(max = 300)
    public static int flashStartTime = 20;
    @ConfigEntry.BoundedDiscrete(max = 36000)
    public static int despawnTime = 6000;
}
