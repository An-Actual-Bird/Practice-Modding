package com.anactualbird.letsmodreboot.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import static net.minecraft.item.ItemMonsterPlacer.spawnCreature;

public class ItemLightningWand extends ItemLMRB
{
    public ItemLightningWand()
    {
        super();
        this.setUnlocalizedName("lightningWand");
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer entityplayer)
    {

        int xm = entityplayer.rayTrace(200, 1.0F).blockX;
        int ym = entityplayer.rayTrace(200, 1.0F).blockY;
        int zm = entityplayer.rayTrace(200, 1.0F).blockZ;

        for (double count2 = -5; count2 < 5; count2++) {
            for(double count1 = -5; count1<5; count1++)
            {
                world.spawnEntityInWorld(new EntityLightningBolt(world, xm + count1, ym, zm + count2));
            }
        }

        return itemstack;
    }
}
