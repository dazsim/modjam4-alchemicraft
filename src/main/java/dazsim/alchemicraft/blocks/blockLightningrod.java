package dazsim.alchemicraft.blocks;

import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dazsim.alchemicraft.tileentities.TileEntityLightningRod;

public class blockLightningrod extends BlockContainer{
	
	public blockLightningrod ()
	{
		super (Material.iron);
		setCreativeTab(CreativeTabs.tabDecorations);
		setBlockName("lightningrod");
		setBlockBounds(0.45F,0.0F,0.45F,0.55F,1.0F,0.55F);

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
		//blockIcon = register.registerIcon("alchemicraft:LightningRod");
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
	public TileEntity createNewTileEntity(World world,int i) {
		return new TileEntityLightningRod();
	}
}
