package net.littlepianist.crashingbosses.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties NETHERGETIC_FLESH = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
            .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 500,0),1.0F).meat().build();

}
