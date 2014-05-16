package dazsim.alchemicraft;




import net.minecraft.block.Block;
import net.minecraft.item.crafting.CraftingManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dazsim.alchemicraft.blocks.blockLightningrod;
import dazsim.alchemicraft.blocks.blockPedistal;
import dazsim.alchemicraft.proxies.CommonProxy;
import dazsim.alchemicraft.tileentities.TileEntityLightningRod;
import dazsim.alchemicraft.tileentities.TileEntityPedistal;

@Mod(modid = Alchemicraft.MODID,name= Alchemicraft.NAME, version = Alchemicraft.VERSION)
//@NetworkMod(channels = ("alchemicraft",clientSideRequired = true, serverSideRequired = true, packetHandler = PacketHandler.class))
public class Alchemicraft 
{
	@Instance static Alchemicraft instance;
	
	
	
	public static final String MODID = "alchemicraft";
    public static final String VERSION = "0.1";
    public static final String NAME = "Alchemicraft";
    private static Block bLightningRod;
    private static Block bPedistal;
    
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
		// some example code
       
    }
    @SidedProxy(clientSide = "dazsim.alchemicraft.proxies.ClientProxy", serverSide = "dazsim.alchemicraft.proxies.CommonProxy")
    public static CommonProxy proxy;
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
    	//
    	proxy.initSounds();
    	proxy.initRenderers();
    	proxy.registerRendering();
    	bLightningRod = new blockLightningrod();
    	bPedistal = new blockPedistal();
    	//LanguageRegistry.addName(bLightningRod,"LightningRod");
    	GameRegistry.registerTileEntity(TileEntityLightningRod.class,"TileEntityLightningRod");
    	GameRegistry.registerTileEntity(TileEntityPedistal.class,"TileEntityPedistal");
    	GameRegistry.registerBlock(bLightningRod, "LightningRod");
    	GameRegistry.registerBlock(bPedistal, "Pedistal");
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	//register renderers, add language registry, crafting etc.
    	
    	CraftingManager cm1;
    }
    
   
    
    
}
