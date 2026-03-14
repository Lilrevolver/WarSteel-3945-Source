package rev.rev.warsteel.client.model.vehicle;

import rev.rev.warsteel.client.model.VehicleModel;
import rev.rev.warsteel.entity.vehicle.KV1Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;

public class KV1Model extends VehicleModel<KV1Entity> {
    public KV1Model() {
    }

    @Nullable
    public VehicleModel.TransformContext<KV1Entity> collectTransform(String boneName) {
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
    public ResourceLocation getModelResource(KV1Entity object) {
        return new ResourceLocation("warsteel", "geo/kv-1.geo.json");
    }

    @Override
    public ResourceLocation getTextureResource(KV1Entity object) {
        return new ResourceLocation("warsteel", "textures/entity/kv-1.png");
    }

    @Override
    public ResourceLocation getAnimationResource(KV1Entity animatable) {
        return new ResourceLocation("warsteel", "animations/lav_150.animation.json");
    }
}