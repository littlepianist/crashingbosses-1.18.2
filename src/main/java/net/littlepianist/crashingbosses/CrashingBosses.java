package net.littlepianist.crashingbosses;

import net.littlepianist.crashingbosses.block.ModBlocks;
import net.littlepianist.crashingbosses.entity.ModEntityTypes;
import net.littlepianist.crashingbosses.item.ModItems;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(CrashingBosses.MOD_ID)
public class CrashingBosses<NetherHuskRenderer> {
    public static final String MOD_ID = "crashingbosses";

    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public CrashingBosses() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.register(eventBus);
        ModBlocks.register(eventBus);

        ModEntityTypes.register(eventBus);

        eventBus.addListener(this::setup);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }


    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

// Add to Constructor
ModEntityTypes.register(eventBus);

// add to clientSetup
EntityRenderers.register(ModEntityTypes.NETHER_HUSK.get(), NetherHuskRenderer::new);
}

