package com.anactualbird.letsmodreboot.entity.projectile;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class EntityCustomEnderPearl extends EntityThrowable
{
    private static final String __OBFID = "CL_00001725";

    public EntityCustomEnderPearl(World world)
    {
        super(world);
    }

    public EntityCustomEnderPearl(World world, EntityLivingBase entity)
    {
        super(world, entity);
    }

    @SideOnly(Side.CLIENT)
    public EntityCustomEnderPearl(World world, double p_i1784_2_, double p_i1784_4_, double p_i1784_6_)
    {
        super(world, p_i1784_2_, p_i1784_4_, p_i1784_6_);
    }

    /**
     * Called when this EntityThrowable hits a block or entity.
     */
    protected void onImpact(MovingObjectPosition world)
    {
        if (world.entityHit != null)
        {
            world.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, this.getThrower()), 0.0F);
        }

        for (int i = 0; i < 32; ++i)
        {
            this.worldObj.spawnParticle("portal", this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian());
        }

        if (!this.worldObj.isRemote)
        {
            if (this.getThrower() != null && this.getThrower() instanceof EntityPlayerMP)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)this.getThrower();

                if (entityplayermp.playerNetServerHandler.func_147362_b().isChannelOpen() && entityplayermp.worldObj == this.worldObj)
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size
                        if (this.getThrower().isRiding())
                        {
                            this.getThrower().mountEntity((Entity)null);
                        }

                        this.getThrower().setPositionAndUpdate(event.targetX, event.targetY, event.targetZ);
                        this.getThrower().fallDistance = 0.0F;
                        this.getThrower().attackEntityFrom(DamageSource.fall, event.attackDamage);
                    }
                }
            }

            this.setDead();
        }
    }
}