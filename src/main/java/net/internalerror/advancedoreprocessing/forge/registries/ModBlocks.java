package net.internalerror.advancedoreprocessing.forge.registries;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.function.Supplier;


public final class ModBlocks {
  private static final Logger LOGGER = LogUtils.getLogger();

  private static final DeferredRegister<Block> register = DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedOreProcessing.MOD_ID);

  private static RegistryObject<Block> register(String pName, Supplier<Block> pSupplier) {
    RegistryObject<Block> pObject = register.register(pName, pSupplier);
    LOGGER.info("Registered block '{}'", pObject.getId());
    return pObject;
  }

  public static void init(IEventBus pEventBus) {
    register.register(pEventBus);
  }

}
