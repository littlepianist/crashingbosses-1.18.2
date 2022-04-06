package net.littlepianist.crashingbosses.setup;

import net.littlepianist.crashingbosses.CrashingBosses;
import net.littlepianist.crashingbosses.entity.model.NetherHuskModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientHandler {

    private static ModelLayerLocation loc(String name) {
        return new ModelLayerLocation(CrashingBosses.res(name), name);
    }

    public static ModelLayerLocation NETHER_HUSK = loc("nether_husk");


    @SubscribeEvent
    public static void layerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(NETHER_HUSK, () -> NetherHuskModel.createMesh(0, 64));

    }

    @SubscribeEvent
    public static void entityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModRegistry.NETHERHUSK.get(), NetherHuskRenderer::new);

    }
}
