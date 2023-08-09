package net.internalerror.advancedoreprocessing.common;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.versions.forge.ForgeVersion;

public final class ModTags extends Tags {

  private ModTags() {
    // private constructor
  }

  public static class ModBlocks extends Blocks {

    public static final TagKey<Block> STORAGE_BLOCKS_TIN = forge("storage_blocks/tin");
    public static final TagKey<Block> STORAGE_BLOCKS_RAW_TIN = forge("storage_blocks/raw_tin");
    public static final TagKey<Block> ORES_TIN = forge("ores/tin");

    private static TagKey<Block> forge(String pName) {
      return BlockTags.create(new ResourceLocation(ForgeVersion.MOD_ID, pName));
    }

    private ModBlocks() {
      // private constructor
    }

  }

  public static class ModItems extends Items {

    public static final TagKey<Item> CRYSTALS = forge("crystals");
    public static final TagKey<Item> POWDERS = forge("powders");
    public static final TagKey<Item> SHARDS = forge("shards");

    public static final TagKey<Item> RAW_MATERIALS_TIN = forge("raw_materials/tin");
    public static final TagKey<Item> CRYSTALS_TIN = forge("crystals/tin");
    public static final TagKey<Item> DUSTS_TIN = forge("dusts/tin");
    public static final TagKey<Item> INGOTS_TIN = forge("ingots/tin");
    public static final TagKey<Item> NUGGETS_TIN = forge("nuggets/tin");
    public static final TagKey<Item> POWDERS_TIN =  forge("powders/tin");
    public static final TagKey<Item> SHARDS_TIN = forge("shards/tin");
    public static final TagKey<Item> ORES_TIN = forge("ores/tin");
    public static final TagKey<Item> STORAGE_BLOCKS_TIN = forge("storage_blocks/tin");
    public static final TagKey<Item> STORAGE_BLOCKS_RAW_TIN = forge("storage_blocks/raw_tin");


    private static TagKey<Item> forge(String pName) {
      return ItemTags.create(new ResourceLocation(ForgeVersion.MOD_ID, pName));
    }

    private ModItems() {
      // private constructor
    }


  }


}
