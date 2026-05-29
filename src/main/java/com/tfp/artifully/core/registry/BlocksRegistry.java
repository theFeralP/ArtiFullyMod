package com.tfp.artifully.core.registry;

import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.tfp.artifully.core.ArtiFullyMod;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksRegistry {
    public static final BlockSubRegistryHelper HELPER = ArtiFullyMod.REGISTRY_HELPER.getBlockSubHelper();

     public static void setupTabEditors() {
         ArtiFullyMod.REGISTRY_HELPER.addToTab(CreativeModeTabs.BUILDING_BLOCKS, HELPER.getEntries().stream().map(RegistryObject::asStack).toArray(ItemStack[]::new));
     }

}
