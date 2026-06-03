package com.tfp.artifully.integrations;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.ModList;

public class ArtifullyCompat {
    public static ForgeConfigSpec.BooleanValue ceramic_ender_lantern;
    public static ForgeConfigSpec.BooleanValue ceramic_cupric_lantern;

    public ArtifullyCompat() {
    }

    public static void init(ForgeConfigSpec.Builder builder) {
        ceramic_ender_lantern = builder.comment("the Ceramic Ender Lantern should be enabled. Requires Endergetic Expansion to be loaded.").define("ceramic_ender_lantern", true);
        ceramic_cupric_lantern = builder.comment("the Ceramic Cupric Lantern should be enabled. Requires Caverns and Chasms to be loaded.").define("ceramic_cupric_lantern", true);
    }

    public static boolean isEnabled(String id) {
        switch (id) {
            case "ceramic_ender_lantern" -> {
                if (ceramic_ender_lantern.get()) {
                    ModList.get().isLoaded("endergetic");
                }
            }
            case "ceramic_cupric_lantern" -> {
                if (ceramic_cupric_lantern.get()) {
                    ModList.get().isLoaded("caverns_and_chasms");
                }
            }
        }
        return true;
    }
}
