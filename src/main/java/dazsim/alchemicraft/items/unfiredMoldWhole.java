package dazsim.alchemicraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class unfiredMoldWhole extends Item{

	public unfiredMoldWhole () 
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("unfiredMoldWholeItem");
		setTextureName("alchemicraft:unfiredMoldWhole");
		
	}
	
}
