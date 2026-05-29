package com.tfp.artifully.common.blocks;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class PanelBlock  extends Block {

    public static final BooleanProperty VAR = BooleanProperty.create("var");

    public PanelBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any().trySetValue(VAR, false));
    }
}
