package dazsim.alchemicraft.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class philosphersCore extends Item{
	
	public philosphersCore () 
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("philosphersCoreItem");
		setTextureName("alchemicraft:philospherscore");
	}

}
