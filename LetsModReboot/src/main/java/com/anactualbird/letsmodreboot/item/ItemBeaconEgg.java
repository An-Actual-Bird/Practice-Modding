package com.anactualbird.letsmodreboot.item;

import com.anactualbird.letsmodreboot.entity.projectile.EntityBeaconEgg;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBeaconEgg extends ItemLMRB
{
    public ItemBeaconEgg()
    {
        super();
        this.setUnlocalizedName("beaconEgg");
        this.setMaxStackSize(1);
        setMaxDamage(400);
    }

    public ItemStack onItemRightClick(ItemStack itemstack, World world, EntityPlayer player)
    {
        world.spawnEntityInWorld(new EntityBeaconEgg(world, player));

        return itemstack;
    }
}
