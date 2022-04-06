package net.littlepianist.crashingbosses.entity;

import net.littlepianist.crashingbosses.CrashingBosses;
import net.littlepianist.crashingbosses.entity.custom.NetherHuskEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("unused")
public class ModRegistry {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, CrashingBosses.MOD_ID);
    public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITIES, CrashingBosses.MOD_ID);

    public static void init(IEventBus bus) {
        ITEMS.register(bus);
        ENTITIES.register(bus);
    }

public class ModEntityTypes {
    public static DeferredRegister<EntityType<?>> ENTITY_TYPES
            = DeferredRegister.create(ForgeRegistries.ENTITIES, CrashingBosses.MOD_ID);

    public static final RegistryObject<EntityType<NetherHuskEntity>> NETHER_HUSK =
            ENTITY_TYPES.register("nether_husk",
                    () -> register("nether_husk", EntityType.Builder.<NetherHuskEntity>of(NetherHuskEntity::new, MobCategory.MONSTER)
                            .sized(0.6F, 1.96F).clientTrackingRange(8)));

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder, boolean sendVelocityUpdates) {
        return builder.setShouldReceiveVelocityUpdates(sendVelocityUpdates).build(id);
    }

    public static <T extends Entity> EntityType<T> register(String id, EntityType.Builder<T> builder) {
        return register(id, builder, true);
    }


public static void register(IEventBus eventBus) {
    ENTITY_TYPES.register(eventBus);
}
}
