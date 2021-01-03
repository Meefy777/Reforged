// Decompiled by Jad v1.5.8g. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.kpdus.com/jad.html
// Decompiler options: packimports(3) braces deadcode 

package net.minecraft.src.reforged;

import net.minecraft.src.ItemStack;

// Referenced classes of package net.minecraft.src:
//            ItemStack

public interface IReachEntity
{
    public abstract boolean reachEntityItemMatches(ItemStack itemstack);

    public abstract float getReachEntity(ItemStack itemstack);
}
