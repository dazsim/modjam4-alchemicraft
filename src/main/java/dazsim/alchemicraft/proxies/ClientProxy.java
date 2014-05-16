package dazsim.alchemicraft.proxies;

import cpw.mods.fml.client.registry.ClientRegistry;
import dazsim.alchemicraft.tileentities.TESRPedistal;
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
	public void registerRendering()
	{
		//register renderers
		ClientRegistry.bindTileEntitySpecialRenderer(TileEntityPedistal.class, new TESRPedistal());
	}

}
