package com.tfp.artifully.core.registry;

import com.teamabnormals.blueprint.core.util.item.CreativeModeTabContentsPopulator;
import com.tfp.artifully.common.blocks.CeramicLanternBlock;
import com.tfp.artifully.core.ArtiFullyMod;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;


public class ArtiFullyBlocksRegistry {
    public static final DeferredRegister<Block> BLOCKS;


    public static RegistryObject<Block> CERAMIC_LANTERN;
    public static RegistryObject<Block> CERAMIC_SOUL_LANTERN;
    public static RegistryObject<Block> CERAMIC_ENDER_LANTERN;
    public static RegistryObject<Block> CERAMIC_CUPRIC_LANTERN;

    public static void init() {
        register();
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    private static void register() {
        CERAMIC_LANTERN = BLOCKS.register("ceramic_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,15));
        CERAMIC_SOUL_LANTERN = BLOCKS.register("ceramic_soul_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,10));
        CERAMIC_ENDER_LANTERN = BLOCKS.register("ceramic_ender_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN,15));
        CERAMIC_CUPRIC_LANTERN = BLOCKS.register("ceramic_cupric_lantern", () -> new CeramicLanternBlock(ArtiFullyBlocksProperties.CERAMIC_LANTERN, 10));
    }

    public static class ArtiFullyBlocksProperties {
        public static final Properties CERAMIC_LANTERN;
        static{
            CERAMIC_LANTERN = Properties.of().mapColor(MapColor.COLOR_ORANGE).forceSolidOn().requiresCorrectToolForDrops().strength(0.2F).sound(SoundType.DECORATED_POT).noOcclusion().pushReaction(PushReaction.DESTROY);
        }

    }

    static {
        BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ArtiFullyMod.MODID);
    }
}
