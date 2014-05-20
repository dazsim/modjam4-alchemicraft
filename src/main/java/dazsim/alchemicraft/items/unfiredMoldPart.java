package dazsim.alchemicraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class unfiredMoldPart extends Item {

	public unfiredMoldPart () 
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("unfiredMoldPartItem");
		setTextureName("alchemicraft:unfiredMoldPart");
	}
	
}
