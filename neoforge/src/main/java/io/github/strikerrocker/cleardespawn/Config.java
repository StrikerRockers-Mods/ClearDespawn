package io.github.strikerrocker.cleardespawn;

import net.neoforged.neoforge.common.ModConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public class Config {
    public static final ClientConfig CLIENT;
    public static final ModConfigSpec CLIENT_SPEC;

    static {
        final Pair<ClientConfig, ModConfigSpec> specPair = new ModConfigSpec.Builder().configure(ClientConfig::new);
        CLIENT_SPEC = specPair.getRight();
        CLIENT = specPair.getLeft();
    }

    public static class ClientConfig {

        public final ModConfigSpec.IntValue flashStartTime;
        public final ModConfigSpec.BooleanValue urgentFlash;

        ClientConfig(ModConfigSpec.Builder builder) {
            builder.push("general");
            flashStartTime = builder.comment("Blinking start time before the item despawns, in seconds").defineInRange("flashStartTime", 20, 0, 36000);
            urgentFlash = builder.comment("Set to true to have item flash faster as it gets closer to despawning").define("urgentFlash", true);
            builder.pop();
        }
    }
}
