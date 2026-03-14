package rev.rev.warsteel.init;

import rev.rev.warsteel.WarSteel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import rev.rev.warsteel.entity.vehicle.KV1Entity;
import rev.rev.warsteel.entity.vehicle.KV2Entity;
import rev.rev.warsteel.entity.vehicle.TigerH1GreyEntity;
import rev.rev.warsteel.entity.vehicle.TigerH1SandEntity;

public class ModEntities {

    public static final DeferredRegister<EntityType<?>> REGISTRY =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, WarSteel.MODID);

    // ===== サイズ定数 =====
    private static final float AIRCRAFT_W = 2.0f, AIRCRAFT_H = 2.0f;
    private static final float SHIP_W = 3.0f, SHIP_H = 3.0f;
    private static final float TANK_W = 3.5f, TANK_H = 2.5f;
    private static final float TANK_H_LARGE = 4.0f;
    private static final float IFV_W = 3.0f, IFV_H = 2.0f;
    private static final float SMALL_W = 1.0f, SMALL_H = 1.0f;

    // ===== 共通ビルダー =====
    private static <T extends Entity> EntityType.Builder<T> vehicle(EntityType.EntityFactory<T> factory, float w, float h) {
        return EntityType.Builder.of(factory, MobCategory.MISC)
                .setTrackingRange(1028)
                .setUpdateInterval(1)
                .fireImmune()
                .sized(w, h);
    }

    // ===== register ショート化 =====
    private static <T extends Entity> RegistryObject<EntityType<T>> reg(String name, EntityType.EntityFactory<T> factory, float w, float h) {
        return REGISTRY.register(name, () -> vehicle(factory, w, h).build(name));
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> weapon(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, SMALL_W, SMALL_H);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> aircraft(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, AIRCRAFT_W, AIRCRAFT_H);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> tank(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, TANK_W, TANK_H);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> largeTank(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, TANK_W, TANK_H_LARGE);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> ifv(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, IFV_W, IFV_H);
    }

    private static <T extends Entity> RegistryObject<EntityType<T>> ship(String name, EntityType.EntityFactory<T> factory) {
        return reg(name, factory, SHIP_W, SHIP_H);
    }

    // ===== 実際の登録 =====
    //Weapons

    //Vehicles

    public static final RegistryObject<EntityType<TigerH1SandEntity>> TigerH1Sand = ifv("tiger-h1-sand", TigerH1SandEntity::new);
    public static final RegistryObject<EntityType<TigerH1GreyEntity>> TigerH1Grey = ifv("tiger-h1-grey", TigerH1GreyEntity::new);
    public static final RegistryObject<EntityType<KV1Entity>> KV_1 = ifv("kv-1", KV1Entity::new);
    public static final RegistryObject<EntityType<KV2Entity>> KV_2 = ifv("kv-2", KV2Entity::new);
}
