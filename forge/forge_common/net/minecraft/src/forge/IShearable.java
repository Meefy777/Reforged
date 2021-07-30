package net.minecraft.src.forge;

import java.util.ArrayList;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;
import net.minecraft.src.World;

/**
 * 
 * This allows for mods to create there own Shear-like items
 * and have them interact with Blocks/Entities without extra work.
 * Also, if your block/entity supports the Shears, this allows you 
 * to support mod-shears as well. 
 *
 */
public interface IShearable 
{
    /**
     * Checks if the object is currently shearable 
     * Example: Sheep return false when they have no wool
     * 
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param X The X Position
     * @param Y The Y Position
     * @param Z The Z Position
     * @return If this is shearable, and onSheared should be called.
     */
    public boolean isShearable(ItemStack item, World world, int X, int Y, int Z);

    /**
     * Performs the shear function on this object.
     * This is called for both client, and server.
     * The object should perform all actions related to being sheared,
     * except for dropping of the items. 
     * 
     * Returns a list of items that resulted from the shearing process.
     * 
     * For entities, they should trust there internal location information
     * over the values passed into this function.
     * 
     * @param item The itemstack that is being used, Possible to be null
     * @param world The current world
     * @param X The X Position
     * @param Y The Y Position
     * @param Z The Z Position
     * @param fortune The fortune level of the shears being used
     * @return A ArrayList containing all items from this shearing. Possible to be null.
     */
    public ArrayList<ItemStack> onSheared(ItemStack item, World world, int X, int Y, int Z);
    
    /**
     * Returns the speed that a block should be mined at
     * 
     * @param item The itemstack that is being used, Possible to be null
     * @param block The block being mined
     * @return Efficiency vs the block being mined
     */
    public float getStrVsBlock(ItemStack item, Block block, int md);
}