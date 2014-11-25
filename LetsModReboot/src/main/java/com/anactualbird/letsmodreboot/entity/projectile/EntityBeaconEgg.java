package com.anactualbird.letsmodreboot.entity.projectile;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class EntityBeaconEgg extends EntityThrowable
{
    private static final String __OBFID = "CL_00001724";

    public EntityBeaconEgg(World world)
    {
        super(world);
    }

    public EntityBeaconEgg(World world, EntityLivingBase p_i1780_2_)
    {
        super(world, p_i1780_2_);
    }

    public EntityBeaconEgg(World world, double p_i1781_2_, double p_i1781_4_, double p_i1781_6_)
    {
        super(world, p_i1781_2_, p_i1781_4_, p_i1781_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition p_70184_1_)
    {
        if (p_70184_1_.entityHit != null)
        {
            p_70184_1_.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        if (!this.worldObj.isRemote)
        {
            int x = (int) this.posX;
            int y = (int) this.posY;
            int z = (int) this.posZ;
            for (int stack = -3; stack < 3; stack++)
            {
                for (int stack1 = -3; stack1 < 3; stack1++)
                {
                    for (int stack2 = -3; stack2 < 3; stack2++)
                    {
                        worldObj.setBlock(x + stack, y + stack1, z + stack2, Blocks.glowstone);
                    }
                }
            }
        }

        for (int j = 0; j < 8; ++j)
        {
            this.worldObj.spawnParticle("snowballpoof", this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D);
        }

        if (!this.worldObj.isRemote)
        {
            this.setDead();
        }
    }
}