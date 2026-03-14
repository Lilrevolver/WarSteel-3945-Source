package rev.rev.warsteel;

import rev.rev.warsteel.init.*;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(WarSteel.MODID)
public class WarSteel {
    public static final String MODID = "warsteel";
    private static final Logger LOGGER = LogUtils.getLogger();

    public WarSteel() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        // Register entities for your extension mod
        ModEntities.REGISTRY.register(bus);

        // Register a separate tab
        ModTabs.TABS.register(bus);
        ModSounds.REGISTRY.register(bus);
        ModItem.ITEMS.register(bus);
        ModParticleTypes.register(bus);

    }

}
