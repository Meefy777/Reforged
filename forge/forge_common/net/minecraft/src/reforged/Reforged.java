package net.minecraft.src.reforged;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;

public class Reforged {

	private static ArrayList<IReachEntity> reachesEntity = new ArrayList<IReachEntity>();

	/* Entity Reach - reachAdd
	 * Registers an IReachEntity interface provider to the list to be used when
	 * reachGetEntityPlayer is called
	 */
    public static void reachAdd(IReachEntity ireachentity)
    {
        reachesEntity.add(ireachentity);
    }

    /* Entity Reach - reachGetEntityPlayer
	 * Returns the max reach distance provided by an interface provider
	 * added by reachAdd
	 */
    public static float reachGetEntityPlayer(EntityPlayer player)
    {
        ItemStack itemstack = player.inventory.getCurrentItem();
        
        for(Iterator<IReachEntity> iterator = reachesEntity.iterator(); iterator.hasNext();)
        {
            IReachEntity ireachentity = iterator.next();
            if(ireachentity.reachEntityItemMatches(itemstack))
            {
                return ireachentity.getReachEntity(itemstack);
            }
        }
		
        return 3F;
    }
}
