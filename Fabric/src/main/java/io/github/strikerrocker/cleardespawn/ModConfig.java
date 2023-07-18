package io.github.strikerrocker.cleardespawn;

import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;

@Config(name = Constants.MOD_ID)
public class ModConfig implements ConfigData {
    @ConfigEntry.BoundedDiscrete(max = 300)
    public int flashStartTime = 20;
    @ConfigEntry.BoundedDiscrete(max = 36000)
    public int despawnTime = 6000;
    public boolean urgentFlash = true;
}
