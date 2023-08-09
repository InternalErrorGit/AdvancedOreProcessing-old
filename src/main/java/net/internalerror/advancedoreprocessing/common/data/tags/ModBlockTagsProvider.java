package net.internalerror.advancedoreprocessing.common.data.tags;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.common.ModTags;
import net.internalerror.advancedoreprocessing.registries.ModBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public final class ModBlockTagsProvider extends BlockTagsProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public ModBlockTagsProvider(DataGenerator pGenerator, @Nullable ExistingFileHelper pExistingFileHelper) {
    super(pGenerator, AdvancedOreProcessing.MOD_ID, pExistingFileHelper);
  }

  @Override
  protected void addTags() {
    tag(ModBlocks.TIN_ORE,
        Tags.Blocks.ORES,
        ModTags.ModBlocks.ORES_TIN,
        Tags.Blocks.ORES_IN_GROUND_STONE,
        Tags.Blocks.ORE_RATES_SINGULAR,
        BlockTags.OVERWORLD_CARVER_REPLACEABLES,
        BlockTags.MINEABLE_WITH_PICKAXE,
        BlockTags.NEEDS_STONE_TOOL);
    tag(ModBlocks.DEEPSLATE_TIN_ORE,
        Tags.Blocks.ORES,
        ModTags.ModBlocks.ORES_TIN,
        Tags.Blocks.ORES_IN_GROUND_DEEPSLATE,
        Tags.Blocks.ORE_RATES_SINGULAR,
        BlockTags.OVERWORLD_CARVER_REPLACEABLES,
        BlockTags.MINEABLE_WITH_PICKAXE,
        BlockTags.NEEDS_STONE_TOOL);
    tag(ModBlocks.TIN_BLOCK,
        Tags.Blocks.STORAGE_BLOCKS,
        ModTags.ModBlocks.STORAGE_BLOCKS_TIN,
        BlockTags.BEACON_BASE_BLOCKS,
        BlockTags.MINEABLE_WITH_PICKAXE,
        BlockTags.NEEDS_STONE_TOOL);
    tag(ModBlocks.RAW_TIN_BLOCK,
        Tags.Blocks.STORAGE_BLOCKS,
        ModTags.ModBlocks.STORAGE_BLOCKS_RAW_TIN,
        BlockTags.MINEABLE_WITH_PICKAXE,
        BlockTags.NEEDS_STONE_TOOL
    );

  }

  @SafeVarargs
  private void tag(TagKey<Block> pTag, RegistryObject<Block>... pBlocks) {
    for (RegistryObject<Block> block : pBlocks) {
      tag(pTag).add(block.get());
      LOGGER.info("Generated tag '{}' for '{}'", pTag.location(), block.getId());
    }
  }

  @SafeVarargs
  private void tag(RegistryObject<Block> pBlock, TagKey<Block>... pTags) {
    for (TagKey<Block> tag : pTags) {
      tag(tag, pBlock);
    }
  }
}
