package com.wu.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class LightBlock extends Block {
    public static BooleanProperty LIT = Properties.LIT;

    public LightBlock(Settings settings, boolean defaultLit) {
        super(settings.luminance(state -> state.get(LIT) ? 15 : 0));
        this.setDefaultState(this.getDefaultState().with(LIT, defaultLit));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }
}
