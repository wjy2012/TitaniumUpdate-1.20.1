package com.wu;

import com.wu.block.modBlocks;
import com.wu.entity.SeatEntityRenderer;
import com.wu.entity.modEntities;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;

public class TitaniumUpdateClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.PINE_DOOR, RenderLayer.getTranslucent());
        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.PINE_TRAPDOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.STRAWBERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(modBlocks.BLUEBERRY_BUSH, RenderLayer.getCutout());

        EntityRendererRegistry.register(modEntities.SEAT, SeatEntityRenderer::new);
    }
}