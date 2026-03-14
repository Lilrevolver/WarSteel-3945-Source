package rev.rev.warsteel.init;

import rev.rev.warsteel.WarSteel;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.client.settings.KeyConflictContext;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import org.lwjgl.glfw.GLFW;

/**
 * Key bindings for WarSteel
 */
@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = WarSteel.MODID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModKeyBindings {

    public static final String CATEGORY = "key.categories.warsteel";

    // Targeting camera - T by default
    public static final KeyMapping TARGETING_CAMERA = new KeyMapping(
        "key.warsteel.targeting_camera",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_T,
        CATEGORY
    );

    // Thermal mode - N by default
    public static final KeyMapping THERMAL_TOGGLE = new KeyMapping(
        "key.warsteel.thermal_toggle",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_N,
        CATEGORY
    );

    // Lock target - X by default
    public static final KeyMapping LOCK_TARGET = new KeyMapping(
        "key.warsteel.lock_target",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_X,
        CATEGORY
    );

    // Toggle landing gear - G by default
    public static final KeyMapping TOGGLE_GEAR = new KeyMapping(
        "key.warsteel.toggle_gear",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_G,
        CATEGORY
    );

    // Exit drone - R by default (NOT Alt!)
    public static final KeyMapping EXIT_DRONE = new KeyMapping(
        "key.warsteel.exit_drone",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_R,
        CATEGORY
    );

    // Zoom +
    public static final KeyMapping ZOOM_IN = new KeyMapping(
        "key.warsteel.zoom_in",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_EQUAL,
        CATEGORY
    );

    // Zoom -
    public static final KeyMapping ZOOM_OUT = new KeyMapping(
        "key.warsteel.zoom_out",
        KeyConflictContext.IN_GAME,
        InputConstants.Type.KEYSYM,
        GLFW.GLFW_KEY_MINUS,
        CATEGORY
    );

    @SubscribeEvent
    public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(TARGETING_CAMERA);
        event.register(THERMAL_TOGGLE);
        event.register(LOCK_TARGET);
        event.register(TOGGLE_GEAR);
        event.register(EXIT_DRONE);
        event.register(ZOOM_IN);
        event.register(ZOOM_OUT);
    }
}
