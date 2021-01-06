package net.minecraft.src.reforged;

import java.util.Random;

import net.minecraft.src.Block;
import net.minecraft.src.ItemStack;

public interface ICustomDrop {

	public int getIdDropped(Block block, int md, Random rand, ItemStack stack);
	
	public int getDamageDropped(Block block, int md, ItemStack stack);
	
	public int getQuantityDropped(Block block, int md, Random rand, ItemStack stack);
}
