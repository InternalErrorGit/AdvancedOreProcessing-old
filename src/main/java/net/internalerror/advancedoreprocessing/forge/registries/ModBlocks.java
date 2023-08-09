package net.internalerror.advancedoreprocessing.forge.registries;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

import java.util.function.Supplier;

public final class ModBlocks {
  private static final Logger LOGGER = LogUtils.getLogger();

  private static final DeferredRegister<Block> register = DeferredRegister.create(ForgeRegistries.BLOCKS, AdvancedOreProcessing.MOD_ID);

  public static final RegistryObject<Block> TIN_ORE = register("tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)));
  public static final RegistryObject<Block> DEEPSLATE_TIN_ORE = register("deepslate_tin_ore", () -> new DropExperienceBlock(BlockBehaviour.Properties.copy(TIN_ORE.get()).color(MaterialColor.DEEPSLATE).strength(4.5F, 3.0F).sound(SoundType.DEEPSLATE)));
  public static final RegistryObject<Block> TIN_BLOCK = register("tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.METAL, MaterialColor.METAL).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)));
  public static final RegistryObject<Block> RAW_TIN_BLOCK = register("raw_tin_block", () -> new Block(BlockBehaviour.Properties.of(Material.STONE, MaterialColor.RAW_IRON).requiresCorrectToolForDrops().strength(5.0F, 6.0F)));

  private static RegistryObject<Block> register(String pName, Supplier<Block> pSupplier) {
    RegistryObject<Block> pObject = register.register(pName, pSupplier);
    LOGGER.info("Registered block '{}'", pObject.getId());
    return pObject;
  }

  public static void init(IEventBus pEventBus) {
    register.register(pEventBus);
  }

}
