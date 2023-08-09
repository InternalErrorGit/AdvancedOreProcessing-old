package net.internalerror.advancedoreprocessing.common.data.recipes.providers;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.common.ModTags;
import net.internalerror.advancedoreprocessing.common.data.recipes.ModRecipeProvider;
import net.internalerror.advancedoreprocessing.registries.ModItems;
import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;

import java.util.function.Consumer;

public final class CompressingRecipeProvider extends ModRecipeProvider.ModRecipeSubProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public CompressingRecipeProvider(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
    super(pFinishedRecipeConsumer);
  }

  @Override
  public void buildRecipes() {
    LOGGER.info("Generating compressing recipes");
    recipe(ModItems.TIN_INGOT.get(), ModTags.ModItems.NUGGETS_TIN);
    recipe(ModItems.TIN_BLOCK.get(), ModTags.ModItems.INGOTS_TIN);
    recipe(ModItems.RAW_TIN_BLOCK.get(), ModTags.ModItems.RAW_MATERIALS_TIN);
  }

  private void recipe(ItemLike pResult, TagKey<Item> pIngredient) {
    String recipeId = String.format("compressing/%s_from_%s", pResult.asItem(), pIngredient.location().getPath().replace('/', '_'));
    ShapedRecipeBuilder.shaped(pResult).pattern("###").pattern("###").pattern("###").define('#', Ingredient.of(pIngredient)).group(AdvancedOreProcessing.MOD_ID).unlockedBy("has_item", InventoryChangeTrigger.TriggerInstance.hasItems(pResult)).save(finishedRecipeConsumer, recipeId);
    LOGGER.info("Generated recipe '{}'", recipeId);
  }


}
