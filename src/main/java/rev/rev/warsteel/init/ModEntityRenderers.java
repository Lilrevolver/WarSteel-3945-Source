package rev.rev.warsteel.init;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import rev.rev.warsteel.client.renderer.entity.KV1Renderer;
import rev.rev.warsteel.client.renderer.entity.KV2Renderer;
import rev.rev.warsteel.client.renderer.entity.TigerH1GreyRenderer;
import rev.rev.warsteel.client.renderer.entity.TigerH1SandRenderer;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ModEntityRenderers {

    @SubscribeEvent
    public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
        //weapons

        // Register entity render for tom7
        event.registerEntityRenderer(ModEntities.TigerH1Grey.get(), TigerH1GreyRenderer::new);
        event.registerEntityRenderer(ModEntities.TigerH1Sand.get(), TigerH1SandRenderer::new);
        event.registerEntityRenderer(ModEntities.KV_1.get(), KV1Renderer::new);
        event.registerEntityRenderer(ModEntities.KV_2.get(), KV2Renderer::new);
    }
}

