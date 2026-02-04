package com.wu.block.custom;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;

public class LightBlock extends Block {
    public static BooleanProperty LIT = Properties.LIT;
    public static int LightLevel;

    public LightBlock(Settings settings, boolean defaultLit, int lightLevel) {
        super(settings.luminance(state -> state.get(LIT) ? lightLevel : 0));
        LightLevel = lightLevel;
        this.setDefaultState(this.getDefaultState().with(LIT, defaultLit));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(LIT);
    }

    public static int getMaxLightLevel() {
        return LightLevel;
    }
}
