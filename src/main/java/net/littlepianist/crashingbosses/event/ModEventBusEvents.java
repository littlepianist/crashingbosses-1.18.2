package net.littlepianist.crashingbosses.event;

import net.littlepianist.crashingbosses.CrashingBosses;
import net.littlepianist.crashingbosses.entity.custom.NetherHuskEntity;
import net.littlepianist.crashingbosses.setup.EntityInit;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;

@Mod.EventBusSubscriber(modid = CrashingBosses.MOD_ID, bus = Bus.MOD)
public class CommonModEvents {

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(EntityInit.NETHER_HUSK.get(), NetherHuskEntity.createAttributes().build());
    }
}
