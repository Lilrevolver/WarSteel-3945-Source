package rev.rev.warsteel.client.model.vehicle;

import rev.rev.warsteel.client.model.VehicleModel;
import rev.rev.warsteel.entity.vehicle.TigerH1SandEntity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class TigerH1SandModel extends VehicleModel<TigerH1SandEntity> {
    public TigerH1SandModel() {
    }

    @Nullable
    public VehicleModel.TransformContext<TigerH1SandEntity> collectTransform(String boneName) {
        TransformContext var1000;
        switch (boneName){
            case "turret" :
                var1000 = (bone, vehicle, state) -> bone.setRotY(this.turretYRot * ((float)Math.PI / 180F));
                break;
            case "barrel":
                float a = this.turretYaw;
                float r = (Mth.abs(a) - 90.0F) / 90.0F;
                float r2;
                if (Mth.abs(a) <= 90.0F) {
                    r2 = a / 90.0F;
                } else if (a < 0.0F) {
                    r2 = -(180.0F + a) / 90.0F;
                } else {
                    r2 = (180.0F - a) / 90.0F;
                }
                var1000 = (bone, vehicle, state) -> bone.setRotX(Mth.clamp(-this.turretXRot - r * this.pitch - r2 * this.roll, vehicle.getTurretMinPitch(), vehicle.getTurretMaxPitch()) * ((float)Math.PI / 180F));
                break;
            default :
                var1000 = null;
                break;
        }
        return var1000;
    }

    @Override
    public ResourceLocation getModelResource(TigerH1SandEntity object) {
        return new ResourceLocation("warsteel", "geo/tiger-h1-sand.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(TigerH1SandEntity object) {
        return new ResourceLocation("warsteel", "textures/entity/tiger-h1-sand.png");
    }

    @Override
    public ResourceLocation getAnimationResource(TigerH1SandEntity animatable) {
        return new ResourceLocation("warsteel", "animations/lav_150.animation.json");
    }
}