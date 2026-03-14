package rev.rev.warsteel.init.client;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.common.Mod;
import rev.rev.warsteel.WarSteel;
import com.atsuishio.superbwarfare.init.ModEntities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Mod.EventBusSubscriber(modid = WarSteel.MODID, value = Dist.CLIENT)
public class ClientEntityHighlighter {

    // 定数を事前計算してキャッシュ
    private static final float BULLET_SPEED = 35f;
    private static final double DETECTION_RANGE = 1028.0;
    private static final double MIN_Z_THRESHOLD = 0.01;
    private static final double EPSILON = 1e-6;
    private static final int STEALTH_SIZE = 6;
    private static final int NORMAL_SIZE = 10;
    private static final int LOCKED_COLOR = 0xFFFFFF00; // 黄色
    private static final int UNLOCKED_COLOR = 0xFF00FF00; // 緑
    private static final int INTERCEPT_COLOR = 0xFFFF0000; // 赤
    private static final float INTERCEPT_ROTATION = 35f;
    private static final int MAX_TARGETS = 4;

    // 遅延初期化用のフラグ
    private static Set<EntityType<?>> excludedTypes = null;
    private static Set<EntityType<?>> stealthTypes = null;

    private static final Set<String> ALLOWED_NAMESPACES = Set.of("superbwarfare", "warsteel", "vvp");

    // キャッシュ用変数（フレーム間で再利用）
    private static Vec3 cachedShooterPos = Vec3.ZERO;
    private static double cachedFovScale = 0;
    private static int cachedScreenWidth = 0;
    private static int cachedScreenHeight = 0;

    // ターゲット情報のキャッシュ（ガベージコレクション削減）
    private static final List<TargetCache> targetCaches = new ArrayList<>(MAX_TARGETS);
    static {
        for (int i = 0; i < MAX_TARGETS; i++) {
            targetCaches.add(new TargetCache());
        }
    }

    // ターゲット情報をキャッシュするクラス（オブジェクト生成を削減）
    private static class TargetCache {
        Entity entity;
        double distanceSq;
        Vec3 screenPos;
        Vec3 interceptScreenPos;
        boolean isStealth;
        boolean isLocked;
        int size;

        void reset() {
            entity = null;
            screenPos = null;
            interceptScreenPos = null;
        }
    }

    // 遅延初期化メソッド（初回アクセス時のみ実行）
    private static void ensureInitialized() {
        if (excludedTypes == null) {
            excludedTypes = Set.of(
                    ModEntities.SMALL_CANNON_SHELL.get(),
                    ModEntities.SMALL_ROCKET.get(),
                    ModEntities.CANNON_SHELL.get(),
                    ModEntities.GUN_GRENADE.get(),
                    ModEntities.PROJECTILE.get(),
                    ModEntities.AGM_65.get(),
                    ModEntities.JAVELIN_MISSILE.get(),
                    ModEntities.HAND_GRENADE.get(),
                    ModEntities.RGO_GRENADE.get(),
                    ModEntities.MELON_BOMB.get(),
                    ModEntities.MORTAR_SHELL.get(),
                    ModEntities.MORTAR.get(),
                    ModEntities.LASER.get(),
                    ModEntities.FLARE_DECOY.get(),
                    ModEntities.SMOKE_DECOY.get(),
                    ModEntities.CLAYMORE.get(),
                    ModEntities.BLU_43.get(),
                    ModEntities.TM_62.get(),
                    ModEntities.TASER_BULLET.get(),
                    ModEntities.MK_82.get(),
                    ModEntities.MK_42.get()
            );
        }

    }
}