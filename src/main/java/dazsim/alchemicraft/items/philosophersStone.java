package dazsim.alchemicraft.items;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class philosophersStone extends Item {
	
	
	public philosophersStone () 
	{
		setMaxStackSize(1);
		setCreativeTab(CreativeTabs.tabMisc);
		setUnlocalizedName("philosophersStoneItem");
		setTextureName("alchemicraft:philosophersStone");
	}
	
	@Override
	public boolean onItemUseFirst(ItemStack is, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ)
    {
	
	
		
		if (!world.isRemote)
		{
			if (is.stackTagCompound == null) 
			{
				is.stackTagCompound = new NBTTagCompound();
				is.stackTagCompound.setString("Owner", player.getDisplayName());
				is.stackTagCompound.setInteger("Power", 0);
				is.stackTagCompound.setInteger("Mode",-1);
				return true;
			}
		}
		return false;
		
	}
	
	@Override
	public boolean getShareTag()
	{
		return true;
	}
	public void addInformation(ItemStack is, EntityPlayer player, List list, boolean par4)
	{
		if (is.stackTagCompound != null) {
			String owner = is.stackTagCompound.getString("Owner");
			Integer power = is.stackTagCompound.getInteger("Power");
			Integer mode = is.stackTagCompound.getInteger("Mode");
			list.add(EnumChatFormatting.GREEN + "Owner : " + owner);
			if (power >0)
			{
				list.add(EnumChatFormatting.BLUE + "Power : " + power);
			}
			else
			{
				list.add(EnumChatFormatting.RED + "Power : " + power);
			}
		
			if (mode == -1) 
			{
			list.add("Mode : Absorb");
			}
			else if (mode == 1)
			{
				list.add("Mode : Emit");
			}
			
			
			
		}
	}
	
	
    public boolean onItemUse(ItemStack is, EntityPlayer player, World world, int par4, int par5, int par6, int par7, float par8, float par9, float par10)
    {
    	if (world.isRemote == true)
    	{
    		return false;
    	}
    		NBTTagCompound nbt = is.getTagCompound();
    	if (nbt == null)
    	{
    		
    		
    		return false;
    		
    	}
    	
    	//System.out.println("Mode : " + nbt.getInteger("Mode"));
    	//System.out.println("Power : " + nbt.getInteger("Power"));
    	
    	
    	
    	int p = nbt.getInteger("Power"); 
    	
    	Block b = world.getBlock(par4, par5, par6);
    	//System.out.println(player.getDisplayName() + " : " + nbt.getString("Owner"));
    	
    	
    	
    	if ( nbt.getString("Owner").equals(player.getDisplayName()) )
    	{
    		
    		if (player.isSneaking())
        	{
        		{
        			if (nbt.getInteger("Mode") == -1)
        			{
        				nbt.setInteger("Mode", 1);
        				is.setTagCompound(nbt);
        				System.out.println("Mode is now 1");
        				return true;
        			} else
        			{
        				nbt.setInteger("Mode", -1);
        				is.setTagCompound(nbt);
        				System.out.println("Mode is now -1");
        				return true;
        			}
        			
        		}
        	} else
        	{
    		//System.out.println("OWNER VALID");
    		if (nbt.getInteger("Mode") == 1)
    		{
    		
    			//emit mode
    			if (p>0)
    			{
    				//emit power here
    				if (b== Blocks.cobblestone)
    				{
    					if (p>0)
    					{
    						world.setBlock(par4, par5, par6, Blocks.stone ,0,3);
    						p--;
    						nbt.setInteger("Power", p);
    					}
    				}
    				if (b == Blocks.sand)
    				{
    					if (p>0)
    					{
    						world.setBlock(par4, par5, par6, Blocks.dirt, 0, 3);
    						p--;
    						nbt.setInteger("Power", p);
    					}
    				}
    				if (b == Blocks.dirt)
    				{
    					if (p>1)
    					{
    						world.setBlock(par4, par5, par6, Blocks.grass ,0,3);
    						p-=2;
    						nbt.setInteger("Power", p);
    					}
    				}
    				if (b == Blocks.gravel)
    				{
    					if (p>0)
    					{
    						world.setBlock(par4, par5, par6, Blocks.cobblestone ,0,3);
    						p-=1;
    						nbt.setInteger("Power", p);
    					}
    				}

    				if (b == Blocks.obsidian)
    				{
    					if (p>1023)
    					{
    						world.setBlock(par4, par5, par6, Blocks.lava ,0,3);
    						p-=1024;
    						nbt.setInteger("Power", p);
    					}
    				}

    				if (b == Blocks.melon_block)
    				{
    					if (p>31)
    					{
    						world.setBlock(par4, par5, par6, Blocks.pumpkin ,0,3);
    						p-=32;
    						nbt.setInteger("Power", p);
    					}
    				}
    				if (b == Blocks.pumpkin)
    				{
    					if (p>31)
    					{
    						world.setBlock(par4, par5, par6, Blocks.melon_block ,0,3);
    						p-=32;
    						nbt.setInteger("Power", p);
    					}
    				}
    			}
    			else
    			{
    				//random power drain in area here.
    				return false;
    			}
    		}
    		//System.out.println("Mode : " + nbt.getInteger("Mode"));
    		if (nbt.getInteger("Mode") == -1)
    		{
    		
        	
    			//absorb mode
    			if ((b == Blocks.dirt ) || (b == Blocks.grass))
    			{
    				world.setBlock(par4, par5, par6, Blocks.sand ,0,3);
    				p++;
    				nbt.setInteger("Power", p);
    			
    			} else
    			if (b == Blocks.sand)
    			{
    				world.setBlock(par4,par5,par6, Blocks.air,0,3);
    				p++;
    				nbt.setInteger("Power",p);
    			
    			} else
    			if (b == Blocks.cobblestone)
    			{
    				world.setBlock(par4,par5,par6, Blocks.gravel,0,3);
    				p++;
    				nbt.setInteger("Power",p);
    			
    			} else
    				if (b == Blocks.gravel)
    			{
    				world.setBlock(par4,par5,par6, Blocks.sand,0,3);
    				p++;
    				nbt.setInteger("Power",p);
    			
    			} else
    			if (b == Blocks.lava)
    			{
    				world.setBlock(par4,par5,par6, Blocks.obsidian,0,3);
    				p+=1024;
    				nbt.setInteger("Power",p);
    			
    			} else
    				if (b == Blocks.iron_ore)
    			{
    				world.setBlock(par4,par5,par6, Blocks.stone,0,3);
    				p+=256;
    				nbt.setInteger("Power",p);
    			
    			} else
    			if (b == Blocks.coal_ore)
    			{
    				world.setBlock(par4,par5,par6, Blocks.stone,0,3);
    				p+=64;
    				nbt.setInteger("Power",p);
    			
    			} else
    			if (b == Blocks.gold_ore)
    			{
    				world.setBlock(par4,par5,par6, Blocks.stone,0,3);
    				p+=512;
    				nbt.setInteger("Power",p);
    			
    			} else
    		if (b == Blocks.redstone_ore)
    		{
    			world.setBlock(par4,par5,par6, Blocks.stone,0,3);
    			p+=1024;
    			nbt.setInteger("Power",p);
    			
    		} else
    		if (b == Blocks.lapis_ore)
    		{
    			world.setBlock(par4,par5,par6, Blocks.gravel,0,3);
    			p+=1024;
    			nbt.setInteger("Power",p);
    			
    		} else
    		if (b == Blocks.diamond_ore)
    		{
    			world.setBlock(par4,par5,par6, Blocks.gravel,0,3);
    			p+=2048;
    			nbt.setInteger("Power",p);
    			
    		}else
    		if (b == Blocks.log)
    		{
    			world.setBlock(par4,par5,par6, Blocks.air,0,3);
    			p+=64;
    			nbt.setInteger("Power",p);
    			
    		}else
    		if (b == Blocks.stone)
    		{
    			world.setBlock(par4,par5,par6, Blocks.cobblestone,0,3);
    			p+=1;
    			nbt.setInteger("Power",p);
    			
    		}else
   			if (b == Blocks.pumpkin)
       		{
       			world.setBlock(par4,par5,par6, Blocks.air,0,3);
       			p+=16;
       			nbt.setInteger("Power",p);
        			
       		}else
      		if (b == Blocks.melon_block)
        	{
      			world.setBlock(par4,par5,par6, Blocks.air,0,3);
        		p+=16;
        		nbt.setInteger("Power",p);
        			
        	} 
    		}

    		

    		

    		
    	}
    		
    		
    		is.setTagCompound(nbt);
    	}
    	return true;
    	}
    	
    
    
    
	
}
