package com.wu.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TitaniumAlloyBlock extends LightBlock{
    public TitaniumAlloyBlock(Settings settings) {
        super(settings, false);
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient())  world.setBlockState(pos, state.with(LIT, !state.get(LIT)));
        return ActionResult.SUCCESS;
    }
}
