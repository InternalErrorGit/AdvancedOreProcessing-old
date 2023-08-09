package net.internalerror.advancedoreprocessing.common.data.recipes;

import net.internalerror.advancedoreprocessing.common.data.recipes.providers.CompressingRecipeProvider;
import net.internalerror.advancedoreprocessing.common.data.recipes.providers.DecompressingRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.function.Consumer;

public final class ModRecipeProvider extends RecipeProvider {
  public ModRecipeProvider(DataGenerator pDataGenerator) {
    super(pDataGenerator);
  }

  @Override
  protected void buildCraftingRecipes(@NotNull Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
    List.of(new CompressingRecipeProvider(pFinishedRecipeConsumer),
            new DecompressingRecipeProvider(pFinishedRecipeConsumer))
        .forEach(ModRecipeSubProvider::buildRecipes);
  }


  public abstract static class ModRecipeSubProvider {

    protected final Consumer<FinishedRecipe> finishedRecipeConsumer;

    protected ModRecipeSubProvider(Consumer<FinishedRecipe> pFinishedRecipeConsumer) {
      this.finishedRecipeConsumer = pFinishedRecipeConsumer;
    }

    protected abstract void buildRecipes();

  }


}
