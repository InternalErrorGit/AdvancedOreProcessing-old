package net.internalerror.advancedoreprocessing.world.item;

import net.internalerror.advancedoreprocessing.AdvancedOreProcessing;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public final class ModCreativeModeTab extends CreativeModeTab {

  public static final ModCreativeModeTab TAB = new ModCreativeModeTab(AdvancedOreProcessing.MOD_ID);

  public ModCreativeModeTab(String pName) {
    super(CreativeModeTab.TABS.length, pName);
  }

  @Override
  public @NotNull ItemStack makeIcon() {
    return new ItemStack(Items.COMMAND_BLOCK.asItem());
  }

}
