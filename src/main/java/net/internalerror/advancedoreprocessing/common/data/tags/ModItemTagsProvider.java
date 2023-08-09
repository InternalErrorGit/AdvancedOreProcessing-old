package net.internalerror.advancedoreprocessing.common.data.tags;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.common.ModTags;
import net.internalerror.advancedoreprocessing.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import org.slf4j.Logger;

public final class ModItemTagsProvider extends ItemTagsProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public ModItemTagsProvider(DataGenerator pGenerator, BlockTagsProvider pBlockTagsProvider, @Nullable ExistingFileHelper existingFileHelper) {
    super(pGenerator, pBlockTagsProvider, AdvancedOreProcessing.MOD_ID, existingFileHelper);
  }

  @Override
  protected void addTags() {

    tag(ModItems.RAW_TIN,
        Tags.Items.RAW_MATERIALS,
        ModTags.ModItems.RAW_MATERIALS_TIN);
    tag(ModItems.TIN_CRYSTAL,
        ModTags.ModItems.CRYSTALS,
        ModTags.ModItems.CRYSTALS_TIN);
    tag(ModItems.TIN_DUST,
        Tags.Items.DUSTS,
        ModTags.ModItems.DUSTS_TIN);
    tag(ModItems.TIN_INGOT,
        Tags.Items.INGOTS,
        ModTags.ModItems.INGOTS_TIN);
    tag(ModItems.TIN_NUGGET,
        Tags.Items.NUGGETS,
        ModTags.ModItems.NUGGETS_TIN);
    tag(ModItems.TIN_POWDER,
        ModTags.ModItems.POWDERS,
        ModTags.ModItems.POWDERS_TIN);
    tag(ModItems.TIN_SHARD,
        ModTags.ModItems.SHARDS,
        ModTags.ModItems.SHARDS_TIN);
    tag(ModItems.TIN_ORE,
        Tags.Items.ORES,
        ModTags.ModItems.ORES_TIN,
        Tags.Items.ORE_RATES_SINGULAR,
        Tags.Items.ORES_IN_GROUND_STONE);
    tag(ModItems.DEEPSLATE_TIN_ORE,
        Tags.Items.ORES,
        ModTags.ModItems.ORES_TIN,
        Tags.Items.ORE_RATES_SINGULAR,
        Tags.Items.ORES_IN_GROUND_DEEPSLATE);
    tag(ModItems.TIN_BLOCK,
        Tags.Items.STORAGE_BLOCKS,
        ModTags.ModItems.STORAGE_BLOCKS_TIN);
    tag(ModItems.RAW_TIN_BLOCK,
        Tags.Items.STORAGE_BLOCKS,
        ModTags.ModItems.STORAGE_BLOCKS_RAW_TIN);

  }

  @SafeVarargs
  private void tag(TagKey<Item> pTag, RegistryObject<Item>... pItems) {
    for (RegistryObject<Item> item : pItems) {
      tag(pTag).add(item.get());
      LOGGER.info("Generated tag '{}' for '{}'", pTag.location(), item.getId());
    }
  }

  @SafeVarargs
  private void tag(RegistryObject<Item> pItem, TagKey<Item>... pTags) {
    for (TagKey<Item> tag : pTags) {
      tag(tag, pItem);
    }
  }
}
