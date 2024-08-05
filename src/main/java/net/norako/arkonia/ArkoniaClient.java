package net.norako.arkonia;

import com.terraformersmc.terraform.sign.SpriteIdentifierRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.norako.arkonia.block.ArkoniaBlocks;
import net.norako.arkonia.entity.ArkoniaEntities;
import net.norako.arkonia.entity.client.overworld.illagers.WindCallerRenderer;
import net.norako.arkonia.entity.client.overworld.zombies.FrozenZombieRenderer;
import net.norako.arkonia.entity.client.overworld.illagers.MountaineerRenderer;
import net.norako.arkonia.entity.client.overworld.zombies.JungleZombieRenderer;

public class ArkoniaClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(ArkoniaEntities.FROZEN_ZOMBIE, FrozenZombieRenderer::new);
        EntityRendererRegistry.register(ArkoniaEntities.MOUNTAINEER, MountaineerRenderer::new);
        EntityRendererRegistry.register(ArkoniaEntities.JUNGLE_ZOMBIE, JungleZombieRenderer::new);
        EntityRendererRegistry.register(ArkoniaEntities.WINDCALLER, WindCallerRenderer::new);
        BlockRenderLayerMap.INSTANCE.putBlock(ArkoniaBlocks.MAPLE_LEAVES, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArkoniaBlocks.MAPLE_DOOR, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ArkoniaBlocks.MAPLE_TRAPDOOR, RenderLayer.getCutout());

        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ArkoniaBlocks.MAPLE_SIGN_TEXTURE));
        SpriteIdentifierRegistry.INSTANCE.addIdentifier(new SpriteIdentifier(TexturedRenderLayers.SIGNS_ATLAS_TEXTURE, ArkoniaBlocks.MAPLE_HANGING_SIGN_TEXTURE));
    }
}
