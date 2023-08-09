package net.internalerror.advancedoreprocessing.common.data.recipes.providers;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.common.ModTags;
import net.internalerror.advancedoreprocessing.common.data.recipes.ModRecipeProvider;
import net.internalerror.advancedoreprocessing.registries.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;

import java.util.function.Consumer;

public final class DecompressingRecipeProvider extends ModRecipeProvider.ModRecipeSubProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public DecompressingRecipeProvider(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
    super(pFinishedRecipeConsumer);
  }

  @Override
  public void buildRecipes() {
    LOGGER.info("Generating decompressing recipes");
    recipe(ModItems.TIN_NUGGET.get(), ModTags.ModItems.INGOTS_TIN);
    recipe(ModItems.TIN_INGOT.get(), ModTags.ModItems.STORAGE_BLOCKS_TIN);
    recipe(ModItems.RAW_TIN.get(), ModTags.ModItems.STORAGE_BLOCKS_RAW_TIN);
  }

  private void recipe(ItemLike pResult, TagKey<Item> pIngredient) {
    String recipeId = String.format("decompressing/%s_from_%s", pResult.asItem(), pIngredient.location().getPath().replace('/', '_'));
    ShapelessRecipeBuilder.shapeless(pResult, 9).requires(pIngredient).group(AdvancedOreProcessing.MOD_ID).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(pResult)).save(finishedRecipeConsumer, recipeId);
    LOGGER.info("Generated recipe '{}'", recipeId);
  }


}
