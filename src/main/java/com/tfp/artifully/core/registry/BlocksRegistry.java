package com.tfp.artifully.core.registry;

import com.teamabnormals.blueprint.common.block.WoodBlock;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.woodworks.core.registry.WoodworksBlocks;
import com.tfp.artifully.core.ArtiFullyMod;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlocksRegistry {
    public static final BlockSubRegistryHelper HELPER = ArtiFullyMod.REGISTRY_HELPER.getBlockSubHelper();
    public static final RegistryObject<Block> OAK_PANELS = HELPER.createBlock("oak_panels", () -> new Block(WoodworksBlocks.WoodworksProperties.OAK_WOOD.planks()));
    public static final RegistryObject<Block> OAK_PANELS = HELPER.createBlock("oak_panels", () -> new Block(WoodworksBlocks.WoodworksProperties.OAK_WOOD.planks()));



     public static void setupTabEditors() {
         ArtiFullyMod.REGISTRY_HELPER.addToTab(CreativeModeTabs.BUILDING_BLOCKS, HELPER.getEntries().stream().map(RegistryObject::asStack).toArray(ItemStack[]::new));
     }



}
