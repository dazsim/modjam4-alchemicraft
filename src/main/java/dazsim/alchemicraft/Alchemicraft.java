package dazsim.alchemicraft;




import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.GameRegistry;
import dazsim.alchemicraft.blocks.blockLightningrod;
import dazsim.alchemicraft.blocks.blockPedistal;
import dazsim.alchemicraft.items.firedMoldPart;
import dazsim.alchemicraft.items.firedMoldWhole;
import dazsim.alchemicraft.items.firedPhilosphersStone;
import dazsim.alchemicraft.items.philosophersStone;
import dazsim.alchemicraft.items.philosphersCore;
import dazsim.alchemicraft.items.unfiredMoldPart;
import dazsim.alchemicraft.items.unfiredMoldWhole;
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
    //Items go here
    public static Item firedMoldPartItem;
    public static Item firedMoldWholeItem;
    public static Item firedPhilosphersStoneItem;
    public static Item philosphersCoreItem;
    public static Item unfiredMoldPartItem;
    public static Item unfiredMoldWholeItem;
    public static Item philosophersStoneItem;
    
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
    	
    	/*
    	 * 		HERE COMES THE ITEMS
    	 */
    	firedMoldPartItem = new firedMoldPart();
    	GameRegistry.registerItem(firedMoldPartItem, firedMoldPartItem.getUnlocalizedName());
    	
    	firedMoldWholeItem = new firedMoldWhole();
    	GameRegistry.registerItem(firedMoldWholeItem, firedMoldWholeItem.getUnlocalizedName());
    	firedPhilosphersStoneItem = new firedPhilosphersStone();
    	GameRegistry.registerItem(firedPhilosphersStoneItem, firedPhilosphersStoneItem.getUnlocalizedName());
    	philosphersCoreItem = new philosphersCore();
    	GameRegistry.registerItem(philosphersCoreItem, philosphersCoreItem.getUnlocalizedName());
    	unfiredMoldPartItem = new unfiredMoldPart();
    	GameRegistry.registerItem(unfiredMoldPartItem, unfiredMoldPartItem.getUnlocalizedName());
    	unfiredMoldWholeItem = new unfiredMoldWhole();
    	GameRegistry.registerItem(unfiredMoldWholeItem, unfiredMoldWholeItem.getUnlocalizedName());
    	philosophersStoneItem = new philosophersStone();
    	GameRegistry.registerItem(philosophersStoneItem, philosophersStoneItem.getUnlocalizedName());
    	GameRegistry.addRecipe(new ItemStack(unfiredMoldWholeItem), new Object[] {"###","#X#","###",'#',Items.clay_ball,'X',Items.ender_pearl});
    	GameRegistry.addRecipe(new ItemStack(unfiredMoldPartItem,2), new Object[] {"#X",'#',unfiredMoldWholeItem,'X',Items.string});
    	ItemStack  myskull = new ItemStack(Items.skull,1,1);
    	ItemStack mydye = new ItemStack(Items.dye,1,4);
    	ItemStack mystone = new ItemStack(philosophersStoneItem);
    	mystone.stackTagCompound = new NBTTagCompound();
    	
    	
    	GameRegistry.addRecipe(new ItemStack(philosphersCoreItem), new Object[] {
    		"ABC","DEF","GHI",
    		'A',myskull,
    		'B',Items.gold_ingot,
    		'C',Items.emerald,
    		'D',Items.diamond,
    		'E',Items.nether_star,
    		'F',Items.redstone,
    		'G',Items.blaze_rod,
    		'H',mydye,
    		'I',Items.porkchop});
    	GameRegistry.addSmelting(unfiredMoldPartItem,new ItemStack(firedMoldPartItem), 1);
    	GameRegistry.addRecipe(new ItemStack(firedMoldWholeItem), new Object [] {"#O#",'#',firedMoldPartItem,'O',philosphersCoreItem});
    	GameRegistry.addSmelting(firedMoldWholeItem, new ItemStack(philosophersStoneItem), 50);
    	
    	
    	
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event) {
    	//register renderers, add language registry, crafting etc.
    
    }
    
   
    
    
}
