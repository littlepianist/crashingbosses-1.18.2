package net.littlepianist.crashingbosses.event;

import net.littlepianist.crashingbosses.entity.ModEntityTypes;
import net.littlepianist.crashingbosses.entity.custom.NetherHuskEntity;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;



public class ModEventBusEvents {
    @SubscribeEvent
    public static void entityAttributeEvent(EntityAttributeCreationEvent event) {
        event.put(ModEntityTypes.NETHER_HUSK.get(), NetherHuskEntity.setAttributes());
    }
}