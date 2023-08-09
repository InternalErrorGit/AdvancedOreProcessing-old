package net.internalerror.advancedoreprocessing.forge.client.model.generators;

import com.mojang.logging.LogUtils;
import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.internalerror.advancedoreprocessing.forge.registries.ModBlocks;
import net.internalerror.advancedoreprocessing.forge.registries.ModItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.slf4j.Logger;

public final class ModItemModelProvider extends ItemModelProvider {
  private static final Logger LOGGER = LogUtils.getLogger();

  public ModItemModelProvider(DataGenerator pDataGenerator, ExistingFileHelper pExistingFileHelper) {
    super(pDataGenerator, AdvancedOreProcessing.MOD_ID, pExistingFileHelper);
  }

  @Override
  protected void registerModels() {

    item(ModItems.RAW_TIN);
    item(ModItems.TIN_CRYSTAL);
    item(ModItems.TIN_DUST);
    item(ModItems.TIN_INGOT);
    item(ModItems.TIN_NUGGET);
    item(ModItems.TIN_POWDER);
    item(ModItems.TIN_SHARD);

    blockItem(ModBlocks.TIN_ORE);
    blockItem(ModBlocks.DEEPSLATE_TIN_ORE);
    blockItem(ModBlocks.TIN_BLOCK);
    blockItem(ModBlocks.RAW_TIN_BLOCK);

  }

  private void item(RegistryObject<Item> pItem) {
    withExistingParent(pItem.getId().getPath(),
        new ResourceLocation("item/generated")).texture("layer0",
        new ResourceLocation(AdvancedOreProcessing.MOD_ID, "item/" + pItem.getId().getPath()));
    LOGGER.info("Generated itemmodel '{}'", pItem.getId());
  }

  public void blockItem(RegistryObject<Block> pBlock) {
    withExistingParent(pBlock.getId().toString(), modLoc("block/" + pBlock.getId().getPath()));
    LOGGER.info("Generated itemmodel '{}'", pBlock.getId());
  }

}
