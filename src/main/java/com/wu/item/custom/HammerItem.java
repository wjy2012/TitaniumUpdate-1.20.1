package com.wu.item.custom;

import com.wu.sound.modSoundEvents;
import com.wu.tag.modBlockTags;
import net.minecraft.block.BlockState;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class HammerItem extends AxeItem {

    public HammerItem(ToolMaterial material, float attackDamage, float attackSpeed, Settings settings) {
        super(material, attackDamage, attackSpeed, settings);
    }

    @Override
    public float getMiningSpeedMultiplier(ItemStack stack, BlockState state) {
        return state.isIn(modBlockTags.HAMMER_MINEABLE) ? this.miningSpeed : 1.0F;
    }

    @Override
    public boolean isSuitableFor(BlockState state) {
        return state.isIn(modBlockTags.HAMMER_MINEABLE);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        super.appendTooltip(stack, world, tooltip, context);
        if (Screen.hasShiftDown()){
            tooltip.add(Text.translatable("tooltip.titanium-update.titanium_hammer.shift"));
        } else {
            tooltip.add(Text.translatable("tooltip.titanium-update.titanium_hammer"));
        }
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        super.useOnBlock(context);
        if (!context.getWorld().isClient){
            BlockState state = context.getWorld().getBlockState(context.getBlockPos());
            if (state.isIn(modBlockTags.HAMMER_MINEABLE)){
                context.getWorld().playSound(null, context.getBlockPos(), modSoundEvents.HAMMER_USE, SoundCategory.BLOCKS, 1.0F, 1.0F);
            }
        }
        return ActionResult.SUCCESS;
    }
}