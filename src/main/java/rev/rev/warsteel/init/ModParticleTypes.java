package rev.rev.warsteel.init;

import rev.rev.warsteel.WarSteel;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {
    public static final DeferredRegister<ParticleType<?>> PARTICLES =
            DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, WarSteel.MODID);

    public static final RegistryObject<SimpleParticleType> AFTERBURNER_FLAME =
            PARTICLES.register("afterburner_flame", () -> new SimpleParticleType(true));

    public static void register(IEventBus bus) {
        PARTICLES.register(bus);
    }
}
