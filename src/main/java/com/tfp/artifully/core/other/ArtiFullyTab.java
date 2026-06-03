package com.tfp.artifully.core.other;

import com.google.common.collect.Iterables;
import com.tfp.artifully.core.ArtiFullyMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

import java.rmi.registry.RegistryHandler;

public class ArtiFullyTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB_DEFERRED_REGISTER;
    public static final RegistryObject<CreativeModeTab> SKINNED_LANTERNS_TAB;

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(eventBus);
    }

    private static ItemStack getIcon() {
        return RegistryHandler.ITEMS.getEntries().size() <= 0 ? new ItemStack(Blocks.DIRT) : new ItemStack((ItemLike)((RegistryObject) Iterables.get(RegistryHandler.ITEMS.getEntries(), 0)).get());
    }

    static {
        CREATIVE_MODE_TAB_DEFERRED_REGISTER = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ArtiFullyMod.MODID);
        SKINNED_LANTERNS_TAB = CREATIVE_MODE_TAB_DEFERRED_REGISTER.register(ArtiFullyMod.MODID+"tab", () -> CreativeModeTab.builder().icon(ArtiFullyTab::getIcon).title(Component.translatable(ArtiFullyMod.MODID+"tab")).displayItems((params, out) -> RegistryHandler.ITEMS.getEntries().forEach((item) -> {
            if (LanternConfig.isEnabled(item.getId().getPath())) {
                out.accept((ItemLike)item.get());
            }

        })).build());
    }
}
