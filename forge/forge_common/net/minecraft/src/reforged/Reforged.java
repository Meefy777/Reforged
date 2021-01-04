/**
 * This software is provided under the terms of the Minecraft Forge Public 
 * License v1.0.
 */

package net.minecraft.src.reforged;

import java.util.ArrayList;
import java.util.Iterator;

import net.minecraft.src.BaseMod;
import net.minecraft.src.EntityPlayer;
import net.minecraft.src.ItemStack;
import net.minecraft.src.ModLoader;
import net.minecraft.src.forge.MinecraftForge;

public class Reforged {
	
	private static boolean searchedForIDResolver; 
	private static boolean foundIDResolver;
	private static boolean searchedForSAPI;
	private static boolean foundSAPI;
	
	public static boolean hasIDResolver() {
		if (!searchedForIDResolver) {
			searchedForIDResolver = true;
			foundIDResolver = ModLoader.isModLoaded("mod_IDResolver");
		}
		return foundIDResolver;
	}
	
	public static boolean hasSAPI() {
		if (!searchedForSAPI) {
			searchedForSAPI = true;
			foundSAPI = hasClass("SAPI");
		}
		return foundSAPI;
	}
	
	
	 private static boolean hasClass(String s)
	    {
	        Class class1 = null;
	        try
	        {
	            class1 = Class.forName(s);
	            return true;
	        }
	        catch(ClassNotFoundException classnotfoundexception)
	        {
	            return false;
	        }
	    }
	
	

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
    
    public static boolean disableVersionCheckCrash = false;
    
    /**
     * Version checking.  Ensures that a sufficiently recent version of Reforged
     * is installed.  Will result in a fatal error if the major versions
     * mismatch or if the version is too old.  Will print a warning message if
     * the minor versions don't match.
     */
    public static void versionDetect(String modname,
		    int major, int minor, int revision) {
    	
    	if (disableVersionCheckCrash) {
    		// invoke static constructor for reforgedhooks
    		ReforgedHooks.touch();
    		System.out.println(modname + ": Reforged version detect was called, but strict crashing is disabled. Expected version "+major+"."+minor+"."+revision);
    		return;
    	}
    	
	    if(major!=ReforgedHooks.majorVersion) {
	    	MinecraftForge.killMinecraft(modname,"Reforged Major Version Mismatch, expecting "+major+".x.x");
	    } else if(minor!=ReforgedHooks.minorVersion) {
		    if(minor>ReforgedHooks.minorVersion) {
		    	MinecraftForge.killMinecraft(modname,"Reforged Too Old, need at least "+major+"."+minor+"."+revision);
		    } else {
			    System.out.println(modname + ": Reforged minor version mismatch, expecting "+major+"."+minor+".x, may lead to unexpected behavior");
		    }
	    } else if(revision>ReforgedHooks.revisionVersion) {
		    MinecraftForge.killMinecraft(modname,"Reforged Too Old, need at least "+major+"."+minor+"."+revision);
	    }
    }

    /**
     * Strict version checking.  Ensures that a sufficiently recent version of
     * Reforged is installed.  Will result in a fatal error if the major or minor 
     * versions mismatch or if the version is too old.  Use this function for
     * mods that use recent, new, or unstable APIs to prevent
     * incompatibilities.
     */
    public static void versionDetectStrict(String modname,
		    int major, int minor, int revision) {
    	
    	if (disableVersionCheckCrash) {
    		// invoke static constructor for reforgedhooks
    		ReforgedHooks.touch();
    		System.out.println(modname + ": Reforged version detect was called, but strict crashing is disabled. Expected version "+major+"."+minor+"."+revision);
    		return;
    	}
    	
	    if(major!=ReforgedHooks.majorVersion) {
	    	MinecraftForge.killMinecraft(modname,"Reforged Major Version Mismatch, expecting "+major+".x.x");
	    } else if(minor!=ReforgedHooks.minorVersion) {
		    if(minor>ReforgedHooks.minorVersion) {
		    	MinecraftForge.killMinecraft(modname,"Reforged Too Old, need at least "+major+"."+minor+"."+revision);
		    } else {
		    	MinecraftForge.killMinecraft(modname,"Reforged minor version mismatch, expecting "+major+"."+minor+".x");
		    }
	    } else if(revision>ReforgedHooks.revisionVersion) {
	    	MinecraftForge.killMinecraft(modname,"Reforged Too Old, need at least "+major+"."+minor+"."+revision);
	    }
    }
}
