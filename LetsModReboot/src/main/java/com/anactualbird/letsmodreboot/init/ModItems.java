package com.anactualbird.letsmodreboot.init;

import com.anactualbird.letsmodreboot.item.*;
import com.anactualbird.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModItems
{
    public static final ItemLMRB mapleLeaf = new ItemMapleLeaf();
    public static final ItemLMRB deathWand = new ItemDeathWand();
    public static final ItemLMRB lightningWand = new ItemLightningWand();
    public static final ItemLMRB beaconEgg = new ItemBeaconEgg();
    public static final ItemLMRB teleportWand = new ItemTeleportWand();

    public static void init()
    {
        GameRegistry.registerItem(mapleLeaf, "mapleLeaf");
        GameRegistry.registerItem(deathWand, "deathWand");
        GameRegistry.registerItem(lightningWand, "lightningWand");
        GameRegistry.registerItem(beaconEgg, "beaconEgg");
        GameRegistry.registerItem(teleportWand, "teleportWand");
    }
}
