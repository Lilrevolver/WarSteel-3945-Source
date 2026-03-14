package rev.rev.warsteel.init;

import rev.rev.warsteel.WarSteel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

/**
 * Класс для регистрации звуков, используемых в моде
 */
public class ModSounds {
    // Создаем регистр для звуков
    public static final DeferredRegister<SoundEvent> REGISTRY = 
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, WarSteel.MODID);
    
    // Регистрируем звуки для M1A1 Abrams
    public static final RegistryObject<SoundEvent> TIGER_FIRE_1P = register("tiger1_1p_fire");
    public static final RegistryObject<SoundEvent> TIGER_FIRE_3P = register("tiger1_3p_fire");
    public static final RegistryObject<SoundEvent> KV1_FIRE_1P = register("kv1_1p_fire");
    public static final RegistryObject<SoundEvent> KV1_FIRE_3P = register("kv1_3p_fire");
    public static final RegistryObject<SoundEvent> KV2_FIRE_1P = register("kv2_1p_fire");
    public static final RegistryObject<SoundEvent> KV2_FIRE_3P = register("kv2_3p_fire");
    public static final RegistryObject<SoundEvent> KV_ENGINE = register("kv_engine");
    public static final RegistryObject<SoundEvent> TIGER_H1_ENGINE = register("tiger_engine");
    public static final RegistryObject<SoundEvent> TIGER_2_ENGINE = register("tiger2_engine");
    public static final RegistryObject<SoundEvent> DEFAULT_RELOAD = register("default_reload");

    
    // Дополнительные звуковые события для совместимости с базовым модом
    public static final RegistryObject<SoundEvent> WHEEL_STEP = register("wheel_step");

    public static final RegistryObject<SoundEvent> YX_100_VERY_FAR = register("yx_100_veryfar");
    public static final RegistryObject<SoundEvent> YX_100_RELOAD = register("yx_100_reload");
    
    /**
     * Вспомогательный метод для регистрации звуков
     * @param name Название звука (без пространства имен)
     * @return RegistryObject для звукового события
     */
    private static RegistryObject<SoundEvent> register(String name) {
        return REGISTRY.register(name, () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(WarSteel.MODID, name)));
    }
} 