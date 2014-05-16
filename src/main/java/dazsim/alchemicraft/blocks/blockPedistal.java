package dazsim.alchemicraft.blocks;



import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dazsim.alchemicraft.tileentities.TileEntityPedistal;

public class blockPedistal extends Block{
	
	public blockPedistal ()
	{
		super (Material.iron);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("pedistal");
		setBlockBounds(0.0F,0.0F,0.0F,1.0F,1.0F,1.0F);
		
	}
	
	@Override public int getRenderType(){
		return RenderingRegistry.getNextAvailableRenderId();
	}
	/*
	@Override public boolean shouldSideBeRendered(IBlockAccess iblockaccess,int i, int j, int k, int l)
	{
		return false;
	}*/
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerBlockIcons(IIconRegister register)
	{
		blockIcon = register.registerIcon("alchemicraft:pedistal");
	}
	
	public boolean renderAsNormalBlock()
	{
		return false;
	}
	
	public boolean isOpaqueCube()
	{
		return false;
	}
	
	@Override
	public TileEntity createTileEntity(World world,int i) {
		return new TileEntityPedistal();
	}
}
