package com.anactualbird.letsmodreboot.init;

import com.anactualbird.letsmodreboot.item.ItemCrossBow;
import com.anactualbird.letsmodreboot.item.ItemLMRB;
import com.anactualbird.letsmodreboot.item.ItemLightningWand;
import com.anactualbird.letsmodreboot.item.ItemMapleLeaf;
import com.anactualbird.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();
    public static final ItemLMRB crossBow = new ItemCrossBow();
    public static final ItemLMRB lightningWand = new ItemLightningWand();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(crossBow, "crossBow");
        GameRegistry.registerItem(lightningWand, "lightningWand");
    }
}
