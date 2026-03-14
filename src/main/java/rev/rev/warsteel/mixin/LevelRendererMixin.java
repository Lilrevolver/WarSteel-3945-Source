package rev.rev.warsteel.mixin;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.LevelRenderer;
import net.minecraft.client.renderer.LightTexture;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Mixin for thermal vision rendering.
 */
@Mixin(LevelRenderer.class)
public class LevelRendererMixin {

    /**
     * Initialize thermal buffers at start of level render.
     */
    @Inject(method = "renderLevel", at = @At("HEAD"))
    private void warsteel$onRenderLevelStartThermal(PoseStack poseStack, float partialTick, long finishNanoTime,
                                     boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer,
                                     LightTexture lightTexture, Matrix4f projectionMatrix, CallbackInfo ci) {
    }
    
    /**
     * Render entity thermal mask and apply thermal composite at end of level render.
     */
    @Inject(method = "renderLevel", at = @At("RETURN"))
    private void warsteel$onRenderLevelEndThermal(PoseStack poseStack, float partialTick, long finishNanoTime,
                                   boolean renderBlockOutline, Camera camera, GameRenderer gameRenderer,
                                   LightTexture lightTexture, Matrix4f projectionMatrix, CallbackInfo ci) {
    }
}
