package com.tfp.artifully.core.other;

import com.google.gson.JsonObject;
import com.tfp.artifully.core.ArtiFullyMod;
import com.tfp.artifully.core.ArtifullyConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class ArtifullyConditons implements ICondition {
    private static final ResourceLocation NAME = new ResourceLocation(ArtiFullyMod.MODID, "enabled");
    private final String name;

    public ArtifullyConditons(String name) {
        this.name = name;
    }

    public ResourceLocation getID() {
            return NAME;
    }

    public boolean test(ICondition.IContext context) {
        ForgeConfigSpec.BooleanValue enabled = (ForgeConfigSpec.BooleanValue) ArtifullyConfig.CONFIG.getValues().get("lanterns." + this.name);
        return (Boolean)enabled.get();
    }

    public static class Serializer implements IConditionSerializer<EnabledCondition> {
        public static final Serializer INSTANCE = new Serializer();

        public Serializer() {
        }

        public void write(JsonObject json, EnabledCondition value) {
        }

        public EnabledCondition read(JsonObject json) {
            return new EnabledCondition(json.get("name").getAsString());
        }

        public ResourceLocation getID() {
            return EnabledCondition.NAME;
        }
    }
    }
}
