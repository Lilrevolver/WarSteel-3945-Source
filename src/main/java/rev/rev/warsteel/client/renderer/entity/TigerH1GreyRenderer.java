package rev.rev.warsteel.client.renderer.entity;

import rev.rev.warsteel.client.model.vehicle.TigerH1GreyModel;
import rev.rev.warsteel.entity.vehicle.TigerH1GreyEntity;
import com.atsuishio.superbwarfare.client.renderer.entity.VehicleRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.util.Mth;
import software.bernie.geckolib.cache.object.GeoBone;

public class TigerH1GreyRenderer extends VehicleRenderer<TigerH1GreyEntity> {
    public TigerH1GreyRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new TigerH1GreyModel());
        this.shadowRadius = 0.5F;
        float scale = 1.2f;
        scaleHeight = scale;
        scaleWidth = scale;
    }

    @Override
    public void renderRecursively(PoseStack poseStack, TigerH1GreyEntity animatable, GeoBone bone, RenderType renderType,
                                  MultiBufferSource bufferSource, VertexConsumer buffer, boolean isReRender,
                                  float partialTick, int packedLight, int packedOverlay,
                                  float red, float green, float blue, float alpha) {
        String name = bone.getName();

        // Wheel rotation speed (slower for realistic tank movement)
        float wheelSpeed = 0.5F;
        float leftWheelRot = wheelSpeed * Mth.lerp(partialTick, animatable.leftWheelRotO, animatable.getLeftWheelRot());
        float rightWheelRot = wheelSpeed * Mth.lerp(partialTick, animatable.rightWheelRotO, animatable.getRightWheelRot());

        // Left wheels (wheel1-wheel8)
        for (int i = 1; i <= 9; i++) {
            if (name.equals("wheel" + i)) {
                bone.setRotX(leftWheelRot);
            }
        }

        // Right wheels (wheel9-wheel16)
        for (int i = 10; i <= 18; i++) {
            if (name.equals("wheel" + i)) {
                bone.setRotX(rightWheelRot);
            }
        }

        super.renderRecursively(poseStack, animatable, bone, renderType, bufferSource, buffer, isReRender,
                partialTick, packedLight, packedOverlay, red, green, blue, alpha);
    }
}
