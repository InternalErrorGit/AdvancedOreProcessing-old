package net.internalerror.advancedoreprocessing;

import net.internalerror.advancedoreprocessing.client.model.generators.ModBlockStateProvider;
import net.internalerror.advancedoreprocessing.client.model.generators.ModItemModelProvider;
import net.internalerror.advancedoreprocessing.common.data.recipes.ModRecipeProvider;
import net.internalerror.advancedoreprocessing.common.data.tags.ModBlockTagsProvider;
import net.internalerror.advancedoreprocessing.common.data.tags.ModItemTagsProvider;
import net.internalerror.advancedoreprocessing.registries.ModBlocks;
import net.internalerror.advancedoreprocessing.registries.ModItems;
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

@Mod(AdvancedOreProcessing.MOD_ID)
public class AdvancedOreProcessing {

  public static final String MOD_ID = "advancedoreprocessing";

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

    private ModDataGenerator() {
      // private constructor
    }

    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
      final DataGenerator dataGenerator = event.getGenerator();
      final ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

      final boolean run = event.includeServer();

      dataGenerator.addProvider(run, new ModBlockStateProvider(dataGenerator, existingFileHelper));
      dataGenerator.addProvider(run, new ModItemModelProvider(dataGenerator, existingFileHelper));
      ModBlockTagsProvider blockTagsProvider = new ModBlockTagsProvider(dataGenerator, existingFileHelper);
      dataGenerator.addProvider(run, blockTagsProvider);
      dataGenerator.addProvider(run, new ModItemTagsProvider(dataGenerator, blockTagsProvider, existingFileHelper));
      dataGenerator.addProvider(run, new ModRecipeProvider(dataGenerator));
    }

  }
}
