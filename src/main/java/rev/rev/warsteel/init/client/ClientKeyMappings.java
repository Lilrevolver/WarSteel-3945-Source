package rev.rev.warsteel.init.client;

import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;

import org.lwjgl.glfw.GLFW;

public class ClientKeyMappings {
    public static KeyMapping OPEN_COORDINATE_SCREEN;
    public static KeyMapping TOGGLE_POD;
    public static KeyMapping THERMAL_VISION;
    public static KeyMapping VTOL_TOGGLE;

    public static void register(RegisterKeyMappingsEvent event) {
        OPEN_COORDINATE_SCREEN = new KeyMapping(
                "key.warsteel.open_coordinate",
                GLFW.GLFW_KEY_G,  // Changed to G to avoid conflict
                "key.categories.warsteel"
        );
        event.register(OPEN_COORDINATE_SCREEN);
        
        TOGGLE_POD = new KeyMapping(
                "key.warsteel.toggle_pod",
                GLFW.GLFW_KEY_LEFT_CONTROL,  // Ctrl key for pod toggle
                "key.categories.warsteel"
        );
        event.register(TOGGLE_POD);

        THERMAL_VISION = new KeyMapping(
                "key.warsteel.thermalvision",
                GLFW.GLFW_KEY_F,  // Ctrl key for pod toggle
                "key.categories.warsteel"
        );
        event.register(THERMAL_VISION);

        VTOL_TOGGLE = new KeyMapping(
                "key.warsteel.vtol_toggle",
                GLFW.GLFW_KEY_V,  // Ctrl key for pod toggle
                "key.categories.warsteel"
        );
        event.register(VTOL_TOGGLE);
    }
}

