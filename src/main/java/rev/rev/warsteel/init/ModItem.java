package rev.rev.warsteel.init;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItem {
    // ItemのDeferredRegister
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, "warsteel");

    // 効果なしのシンプルなアイテム
    public static final RegistryObject<Item> WARSTEEL_TANK_ICON = ITEMS.register("warsteel-tank-item",
            () -> new Item(new Item.Properties()));
}
