package net.internalerror.advancedoreprocessing;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.forge.client.model.generators.ModBlockStateProvider;
import net.internalerror.advancedoreprocessing.forge.client.model.generators.ModItemModelProvider;
import net.internalerror.advancedoreprocessing.forge.registries.ModBlocks;
import net.internalerror.advancedoreprocessing.forge.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(AdvancedOreProcessing.MOD_ID)
public class AdvancedOreProcessing {

  public static final String MOD_ID = "advancedoreprocessing";
  private static final Logger LOGGER = LogUtils.getLogger();

  public AdvancedOreProcessing() {
    IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
    modEventBus.addListener(this::commonSetup);

    ModBlocks.init(modEventBus);
    ModItems.init(modEventBus);

    MinecraftForge.EVENT_BUS.register(this);
  }

  private void commonSetup(final FMLCommonSetupEvent event) {
    // Common Setup
  }

  @SubscribeEvent
  public void onServerStarting(ServerStartingEvent event) {
    // On Server Start event
  }


  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
  public static class ModDataGenerator {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
      final DataGenerator dataGenerator = event.getGenerator();
      final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

      final boolean run = event.includeServer();

      dataGenerator.addProvider(run, new ModBlockStateProvider(dataGenerator, existingFileHelper));
      dataGenerator.addProvider(run, new ModItemModelProvider(dataGenerator, existingFileHelper));

    }

  }
}
