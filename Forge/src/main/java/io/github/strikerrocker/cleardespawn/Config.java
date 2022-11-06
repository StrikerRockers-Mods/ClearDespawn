package io.github.strikerrocker.cleardespawn;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_SPEC;

    static {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class ClientConfig {

        public final ForgeConfigSpec.IntValue flashStartTime;
        public final ForgeConfigSpec.IntValue despawnTime;
        public final ForgeConfigSpec.BooleanValue urgentFlash;

        ClientConfig(ForgeConfigSpec.Builder builder) {
            builder.push("general");
            flashStartTime = builder.comment("Blinking start time before the item despawns, in seconds").defineInRange("flashStartTime", 20, 0, 36000);
            despawnTime = builder.comment("Time until items will despawn (Change only if the items in the pack have different time limit)").defineInRange("despawnTime", 6000, 0, 36000);
            urgentFlash = builder.comment("Set to true to have item flash faster as it gets closer to despawning").define("urgentFlash", true);
            builder.pop();
        }
    }
}
