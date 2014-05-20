package dazsim.alchemicraft.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import dazsim.alchemicraft.tileentities.TESRLightningRod;
import dazsim.alchemicraft.tileentities.TESRPedistal;
import dazsim.alchemicraft.tileentities.TileEntityLightningRod;
import dazsim.alchemicraft.tileentities.TileEntityPedistal;

public class ClientProxy  extends CommonProxy {
	
	@Override
	public void initSounds() {
		//TODO add sound
	}
	
	@Override
	public void initRenderers() {
		//add renderers
	}
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerRendering()
	{
		//register renderers
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedistal.class, new TESRPedistal());
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityLightningRod.class, new TESRLightningRod());
	}

}
