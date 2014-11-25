package com.anactualbird.letsmodreboot.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ArrowLooseEvent;
import net.minecraftforge.event.entity.player.ArrowNockEvent;

public class ItemDeathWand extends ItemLMRB
{
    public ItemDeathWand()
    {
        super();
        this.setUnlocalizedName("deathWand");
        this.setMaxStackSize(1);
        setMaxDamage(400);
    }

    public int getMaxItemUseDuration(ItemStack p_77626_1_)
    {
        return 1000;
    }

    public EnumAction getItemUseAction(ItemStack p_77661_1_)
    {
        return EnumAction.bow;
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {
        int j = this.getMaxItemUseDuration(item);

        ArrowLooseEvent event = new ArrowLooseEvent(player, item, j);
        MinecraftForge.EVENT_BUS.post(event);

        float f = 1.0F;

        EntityArrow entityarrow = new EntityArrow(world, player, f * 200.0F);

        entityarrow.setIsCritical(true);
        entityarrow.setDamage(entityarrow.getDamage() + (double) 1 * 0.5D + 0.5D);
        entityarrow.setKnockbackStrength(1);

        item.damageItem(1, player);
        try {
            try {
                world.playSoundAtEntity(player, "random.fizz", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (!world.isRemote) {
            world.spawnEntityInWorld(entityarrow);

        }

        ArrowNockEvent event1 = new ArrowNockEvent(player, item);
        MinecraftForge.EVENT_BUS.post(event1);

        player.swingItem();

        return item;
    }

    public int getItemEnchantability()
    {
        return 1;
    }

}
