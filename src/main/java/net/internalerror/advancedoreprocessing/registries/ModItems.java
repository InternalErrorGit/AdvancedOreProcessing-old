package net.internalerror.advancedoreprocessing.registries;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.function.Supplier;

public final class ModItems {
  private static final Logger LOGGER = LogUtils.getLogger();

  private static final DeferredRegister<Item> register = DeferredRegister.create(ForgeRegistries.ITEMS, AdvancedOreProcessing.MOD_ID);

  public static final RegistryObject<Item> RAW_TIN = register("raw_tin", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_CRYSTAL = register("tin_crystal", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_DUST = register("tin_dust", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_INGOT = register("tin_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_NUGGET = register("tin_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_POWDER = register("tin_powder", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_SHARD = register("tin_shard", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS)));
  public static final RegistryObject<Item> TIN_ORE = register("tin_ore", () -> new BlockItem(ModBlocks.TIN_ORE.get(), new Item.Properties()));
  public static final RegistryObject<Item> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () -> new BlockItem(ModBlocks.DEEPSLATE_TIN_ORE.get(), new Item.Properties()));
  public static final RegistryObject<Item> TIN_BLOCK = register("tin_block", () -> new BlockItem(ModBlocks.TIN_BLOCK.get(), new Item.Properties()));
  public static final RegistryObject<Item> RAW_TIN_BLOCK = register("raw_tin_block", () -> new BlockItem(ModBlocks.RAW_TIN_BLOCK.get(), new Item.Properties()));


  private static RegistryObject<Item> register(String pName, Supplier<Item> pSupplier) {
    RegistryObject<Item> pObject = register.register(pName, pSupplier);
    LOGGER.info("Registered item '{}'", pObject.getId());
    return pObject;
  }

  public static void init(IEventBus pEventBus) {
    register.register(pEventBus);
  }

  private ModItems() {
    // private constructor
  }
}
