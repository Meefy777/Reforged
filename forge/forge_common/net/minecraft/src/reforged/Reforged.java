package net.minecraft.src.reforged;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;

public class Reforged {

	private static ArrayList reachesEntity = new ArrayList();


    public static void reachAdd(IReachEntity ireachentity)
    {
        reachesEntity.add(ireachentity);
    }

    // NEEDS SERVER IMPLEMENTATION, maybe pass the entity as a parameter?
    public static float reachGetEntity()
    {
    	/*
        ItemStack itemstack = ModLoader.getMinecraftInstance().thePlayer.inventory.getCurrentItem();
        for(Iterator iterator = reachesEntity.iterator(); iterator.hasNext();)
        {
            IReachEntity ireachentity = (IReachEntity)iterator.next();
            if(ireachentity.reachEntityItemMatches(itemstack))
            {
                return ireachentity.getReachEntity(itemstack);
            }
        }
		*/
        return 3F;
    }
}
