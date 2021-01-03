/**
 * This software is provided under the terms of the Minecraft Forge Public 
 * License v1.0.
 */

package net.minecraft.src.reforged;

import net.minecraft.src.ItemStack;

public interface IReachEntity
{
	// If this item is applicable to a custom range
    public abstract boolean reachEntityItemMatches(ItemStack itemstack);

    // The maximum distance in meters/blocks
    public abstract float getReachEntity(ItemStack itemstack);
}
