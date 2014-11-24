package com.anactualbird.letsmodreboot.init;

import com.anactualbird.letsmodreboot.block.BlockFlag;
import com.anactualbird.letsmodreboot.block.BlockLMRB;
import com.anactualbird.letsmodreboot.reference.Reference;
import cpw.mods.fml.common.registry.GameRegistry;

@GameRegistry.ObjectHolder(Reference.MOD_ID)
public class ModBlocks
{
    public static final BlockLMRB flag = new BlockFlag();

    public static void init()
    {
        GameRegistry.registerBlock(flag, "flag");
    }
}
