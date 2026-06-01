package com.tfp.artifully.core.registry;


import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.tfp.artifully.common.blocks.CeramicLanternBlock;
import com.tfp.artifully.core.ArtiFullyMod;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.registries.RegistryObject;


public class ArtiFullyBlocksRegistry {
    public static final BlockSubRegistryHelper HELPER = ArtiFullyMod.REGISTRY_HELPER.getBlockSubHelper();

    public static final RegistryObject<Block> CERAMIC_LANTERN;
    public static final RegistryObject<Block> CERAMIC_SOUL_LANTERN;
    public static final RegistryObject<Block> CERAMIC_ENDER_LANTERN;
    public static final RegistryObject<Block> CERAMIC_CUPRIC_LANTERN;

    /*public static void init() {
        register();
        HELPER.getDeferredRegister()
        HELPER.createBlock(FMLJavaModLoadingContext.get().getModEventBus());
        //ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }*/

    static {
        CERAMIC_LANTERN = HELPER.createBlock("ceramic_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,15));
        CERAMIC_SOUL_LANTERN = HELPER.createBlock("ceramic_soul_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,10));
        CERAMIC_ENDER_LANTERN = HELPER.createBlock("ceramic_ender_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,15));
        CERAMIC_CUPRIC_LANTERN = HELPER.createBlock("ceramic_cupric_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN, 10));
    }

    public static class ArtiFullyBlocksProperties {
        public static final Properties CERAMIC_LANTERN;
        static{
            CERAMIC_LANTERN = Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.DECORATED_POT).noOcclusion().pushReaction(PushReaction.DESTROY);
        }

    }

    /*public static void setupTabEditors() {
        CreativeModeTabContentsPopulator.mod(ArtiFullyMod.MODID)
                .tab(FUNCTIONAL)
     }*/
}
