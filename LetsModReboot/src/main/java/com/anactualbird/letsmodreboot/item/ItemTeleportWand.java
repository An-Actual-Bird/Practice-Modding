package com.anactualbird.letsmodreboot.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class ItemTeleportWand extends ItemLMRB
{
    public ItemTeleportWand()
    {
        super();
        this.setUnlocalizedName("teleportWand");
    }

    public ItemStack onItemRightClick(ItemStack item, World world, EntityPlayer player)
    {

        int x = player.rayTrace(200, 1.0F).blockX;
        int y = player.rayTrace(200, 1.0F).blockY;
        int z = player.rayTrace(200, 1.0F).blockZ;

        try {
            world.playSoundAtEntity(player, "mob.endermen.portal", 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + 0.5F);
        } catch (Exception e) {
            e.printStackTrace();
        }

        player.setPositionAndUpdate(x,y+1,z);

        player.swingItem();

        return item;
    }
}
