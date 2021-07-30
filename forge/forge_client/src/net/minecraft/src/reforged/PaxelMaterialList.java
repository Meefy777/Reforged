package net.minecraft.src.reforged;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.src.Block;
import net.minecraft.src.Material;

public class PaxelMaterialList {
	
	public static List<Material> matList = new ArrayList<Material>();
	
	public static boolean canPaxelHarvest(Block block) {
		return matList.contains(block.blockMaterial);
	}
	
	static {
		matList.add(Material.rock);
		matList.add(Material.iron);
		matList.add(Material.ice);
		matList.add(Material.grassMaterial);
		matList.add(Material.ground);
		matList.add(Material.sand);
		matList.add(Material.clay);
		matList.add(Material.snow);
		matList.add(Material.builtSnow);
		matList.add(Material.wood);
		matList.add(Material.leaves);
		matList.add(Material.plants);
		matList.add(Material.cactus);
		matList.add(Material.pumpkin);
	}
	
}
