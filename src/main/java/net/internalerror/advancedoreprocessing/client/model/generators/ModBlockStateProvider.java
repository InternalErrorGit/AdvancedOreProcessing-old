package net.internalerror.advancedoreprocessing.client.model.generators;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.registries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public final class ModBlockStateProvider extends BlockStateProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public ModBlockStateProvider(DataGenerator pDataGenerator, ExistingFileHelper pExistingFileHelper) {
    super(pDataGenerator, AdvancedOreProcessing.MOD_ID, pExistingFileHelper);
  }

  @Override
  protected void registerStatesAndModels() {
    simpleBlock(ModBlocks.TIN_ORE);
    simpleBlock(ModBlocks.DEEPSLATE_TIN_ORE);
    simpleBlock(ModBlocks.TIN_BLOCK);
    simpleBlock(ModBlocks.RAW_TIN_BLOCK);
  }

  private void simpleBlock(RegistryObject<Block> pBlock) {
    simpleBlock(pBlock.get());
    LOGGER.info("Generated blockstate '{}'", pBlock.getId());
  }
}
