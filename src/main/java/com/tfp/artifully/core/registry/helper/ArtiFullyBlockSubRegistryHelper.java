package com.tfp.artifully.core.registry.helper;

import com.teamabnormals.blueprint.client.BlueprintChestMaterials;
import com.teamabnormals.blueprint.client.renderer.block.ChestBlockEntityWithoutLevelRenderer;
import com.teamabnormals.blueprint.common.block.chest.BlueprintChestBlock;
import com.teamabnormals.blueprint.common.block.chest.BlueprintTrappedChestBlock;
import com.teamabnormals.blueprint.common.block.entity.BlueprintChestBlockEntity;
import com.teamabnormals.blueprint.common.block.entity.BlueprintTrappedChestBlockEntity;
import com.teamabnormals.blueprint.common.item.BEWLRBlockItem;
import com.teamabnormals.blueprint.common.item.BEWLRFuelBlockItem;
import com.teamabnormals.blueprint.core.util.registry.BlockSubRegistryHelper;
import com.teamabnormals.blueprint.core.util.registry.RegistryHelper;
import com.teamabnormals.woodworks.client.renderer.block.DrawerBlockEntityWithoutLevelRenderer;
import com.teamabnormals.woodworks.common.block.ClosetBlock;
import com.teamabnormals.woodworks.common.block.TrappedClosetBlock;
import com.teamabnormals.woodworks.common.block.entity.ClosetBlockEntity;
import com.teamabnormals.woodworks.common.block.entity.TrappedClosetBlockEntity;
import com.teamabnormals.woodworks.core.registry.WoodworksBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;

public class ArtiFullyBlockSubRegistryHelper extends BlockSubRegistryHelper {
    public ArtiFullyBlockSubRegistryHelper(RegistryHelper parent) {
        super(parent);
    }

    public RegistryObject<BlueprintChestBlock> createNonFuelChestBlock(String name, BlockBehaviour.Properties properties) {
        String modId = this.parent.getModId();
        String chestMaterialsName = BlueprintChestMaterials.registerMaterials(modId, name, false);
        RegistryObject<BlueprintChestBlock> block = this.deferredRegister.register(name + "_chest", () -> new BlueprintChestBlock(chestMaterialsName, properties));
        this.itemRegister.register(name + "_chest", () -> new BEWLRBlockItem((Block)block.get(), new Item.Properties(), () -> () -> chestBEWLR(false)));
        return block;
    }

    public RegistryObject<BlueprintTrappedChestBlock> createTrappedChestBlock(String name, BlockBehaviour.Properties properties) {
        String modId = this.parent.getModId();
        RegistryObject<BlueprintTrappedChestBlock> block = this.deferredRegister.register("trapped_" + name + "_chest", () -> new BlueprintTrappedChestBlock(modId + ":" + name + "_trapped", properties));
        BlueprintChestMaterials.registerMaterials(modId, name, true);
        this.itemRegister.register("trapped_" + name + "_chest", () -> new BEWLRFuelBlockItem((Block)block.get(), new Item.Properties(), () -> () -> chestBEWLR(true), 300));
        return block;
    }

    public RegistryObject<BlueprintTrappedChestBlock> createNonFuelTrappedChestBlock(String name, BlockBehaviour.Properties properties) {
        String modId = this.parent.getModId();
        RegistryObject<BlueprintTrappedChestBlock> block = this.deferredRegister.register("trapped_" + name + "_chest", () -> new BlueprintTrappedChestBlock(modId + ":" + name + "_trapped", properties));
        BlueprintChestMaterials.registerMaterials(modId, name, true);
        this.itemRegister.register("trapped_" + name + "_chest", () -> new BEWLRBlockItem((Block)block.get(), new Item.Properties(), () -> () -> chestBEWLR(true)));
        return block;
    }

    public RegistryObject<ClosetBlock> createClosetBlock(String name, BlockBehaviour.Properties properties) {
        String modId = this.parent.getModId();
        String chestMaterialsName = BlueprintChestMaterials.registerMaterials(modId, name, false);
        RegistryObject<ClosetBlock> block = this.deferredRegister.register(name + "_closet", () -> new ClosetBlock(chestMaterialsName, properties));
        this.itemRegister.register(name + "_closet", () -> new BEWLRFuelBlockItem((Block)block.get(), new Item.Properties(), () -> () -> closetBEWLR(false), 300));
        return block;
    }

    public RegistryObject<TrappedClosetBlock> createTrappedClosetBlock(String name, BlockBehaviour.Properties properties) {
        String modId = this.parent.getModId();
        RegistryObject<TrappedClosetBlock> block = this.deferredRegister.register("trapped_" + name + "_closet", () -> new TrappedClosetBlock(modId + ":" + name + "_trapped", properties));
        BlueprintChestMaterials.registerMaterials(modId, name, true);
        this.itemRegister.register("trapped_" + name + "_closet", () -> new BEWLRFuelBlockItem((Block)block.get(), new Item.Properties(), () -> () -> closetBEWLR(true), 300));
        return block;
    }

    @OnlyIn(Dist.CLIENT)
    private static BEWLRBlockItem.LazyBEWLR chestBEWLR(boolean trapped) {
        return trapped ? new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> new ChestBlockEntityWithoutLevelRenderer(dispatcher, entityModelSet, new BlueprintTrappedChestBlockEntity(BlockPos.ZERO, Blocks.TRAPPED_CHEST.defaultBlockState()))) : new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> new ChestBlockEntityWithoutLevelRenderer(dispatcher, entityModelSet, new BlueprintChestBlockEntity(BlockPos.ZERO, Blocks.CHEST.defaultBlockState())));
    }

    @OnlyIn(Dist.CLIENT)
    private static BEWLRBlockItem.LazyBEWLR closetBEWLR(boolean trapped) {
        return trapped ? new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> new DrawerBlockEntityWithoutLevelRenderer(dispatcher, entityModelSet, new TrappedClosetBlockEntity(BlockPos.ZERO, ((TrappedClosetBlock) WoodworksBlocks.TRAPPED_BAMBOO_CLOSET.get()).defaultBlockState()))) : new BEWLRBlockItem.LazyBEWLR((dispatcher, entityModelSet) -> new DrawerBlockEntityWithoutLevelRenderer(dispatcher, entityModelSet, new ClosetBlockEntity(BlockPos.ZERO, ((ClosetBlock)WoodworksBlocks.BAMBOO_CLOSET.get()).defaultBlockState())));
    }
}
