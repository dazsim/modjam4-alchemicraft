package dazsim.alchemicraft.items;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.IIcon;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class firedMoldPart extends Item{
	
	
	
	public firedMoldPart () 
	{
		setMaxStackSize(64);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("firedMoldPartItem");
		setTextureName("alchemicraft:firedMoldPart");
	}
	
	

}
