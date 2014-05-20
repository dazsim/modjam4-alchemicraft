package dazsim.alchemicraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class firedMoldWhole extends Item{

	
	public firedMoldWhole () 
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("firedMoldWholeItem");
		setTextureName("alchemicraft:firedMoldWhole");
	}
}
