package net.internalerror.advancedoreprocessing;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.forge.registries.ModBlocks;
import net.internalerror.advancedoreprocessing.forge.registries.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.ForgeRegistries;
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

  @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
  public static class ClientModEvents {

    @SubscribeEvent
    public static void onClientSetup(FMLClientSetupEvent event) {
      // On Client Setup event
    }
  }
}
