
package rev.rev.warsteel.init;

import com.atsuishio.superbwarfare.item.common.container.ContainerBlockItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import rev.rev.warsteel.WarSteel;

@SuppressWarnings("unused")
public class ModTabs {
    public static final DeferredRegister<CreativeModeTab> TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, WarSteel.MODID);

    public static final RegistryObject<CreativeModeTab> BLOCKTANK_TAB = TABS.register("warsteel-tank",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("item_group.warsteel.ash-tank"))
                    .icon(() -> new ItemStack(ModItem.WARSTEEL_TANK_ICON.get()))
                    .displayItems((param, output) -> {
                        output.accept(ContainerBlockItem.createInstance(ModEntities.TigerH1Sand.get()));
                        output.accept(ContainerBlockItem.createInstance(ModEntities.TigerH1Grey.get()));
                        output.accept(ContainerBlockItem.createInstance(ModEntities.KV_1.get()));
                        output.accept(ContainerBlockItem.createInstance(ModEntities.KV_2.get()));
                    })
                    .build()
    );
}
