package com.wu.block.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.RedstoneBlock;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class TitaniumAlloyBlock extends LightBlock{

    public TitaniumAlloyBlock(Settings settings) {
        super(settings, false, 15);
    }

    @Override
    public void onPlaced(World world, BlockPos pos, BlockState state, LivingEntity placer, ItemStack itemStack) {
        if (!world.isClient()) {
            world.scheduleBlockTick(pos, this, 1);
        }
    }

    @Override
    public void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        boolean found = false;

        for (Direction direction : Direction.Type.HORIZONTAL) {
            if (check(world, pos, direction, 15)) break;
        }

        if (found != state.get(LIT)) {
            world.setBlockState(pos, state.with(LIT, found));
        }
        world.scheduleBlockTick(pos, this, 4);
    }

    private boolean check( World world, BlockPos pos, Direction direction, int far){
        for (int i = 1; i <= far; i++) {
            BlockPos checkPos = pos.offset(direction, i);
            BlockState blockState = world.getBlockState(checkPos);

            if (blockState.getBlock() instanceof RedstoneBlock ||
                    blockState.getBlock() instanceof TitaniumAlloyBlock && blockState.get(LIT)) {
                return true;
            }
        }
        return false;
    }
}
