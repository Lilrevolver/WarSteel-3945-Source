package rev.rev.warsteel.init;

import rev.rev.warsteel.WarSteel;
import rev.rev.warsteel.client.particle.AfterburnerFlameParticleProvider;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WarSteel.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ParticleRegistry {
    @SubscribeEvent
    public static void registerParticleProviders(RegisterParticleProvidersEvent event) {
        event.registerSpriteSet(ModParticleTypes.AFTERBURNER_FLAME.get(), AfterburnerFlameParticleProvider::new);
    }
}
