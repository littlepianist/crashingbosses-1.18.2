package net.littlepianist.crashingbosses.entity.render;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Vector3f;
import net.littlepianist.crashingbosses.CrashingBosses;
import net.littlepianist.crashingbosses.entity.custom.NetherHuskEntity;
import net.littlepianist.crashingbosses.entity.model.NetherHuskModel;
import net.littlepianist.crashingbosses.setup.ClientHandler;
import net.minecraft.client.model.ZombieModel;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.HumanoidArm;

import javax.naming.Context;


public class NetherHuskRenderer <Type extends NetherHuskEntity> extends MobRenderer<Type, NetherHuskModel<Type>> {

    public NetherHuskRenderer(Context context) {
       super(context, new NetherHuskModel<>(), 0.5f);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        super.setupAnim(entityIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

     
    }

    @Override
    public void translateToHand(HumanoidArm sideIn, PoseStack matrixStackIn) {
        boolean flag = sideIn == HumanoidArm.LEFT;
        matrixStackIn.translate(flag ? 0.15D : -0.15D, 0.25D, 0.075D);
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(flag ? 25F : -25F));
        super.translateToHand(sideIn, matrixStackIn);
    }
    @Override
    public ResourceLocation getTextureLocation(NetherHuskEntity object) {
        return new ResourceLocation(CrashingBosses.MOD_ID, "textures/entity/nether_husk.png");
    }


}
