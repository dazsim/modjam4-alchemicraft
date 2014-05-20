package dazsim.alchemicraft.tileentities;



import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import dazsim.alchemicraft.models.LightningRod;

import org.lwjgl.opengl.GL11;

public class TESRLightningRod extends TileEntitySpecialRenderer {

	private final LightningRod model;

	public TESRLightningRod() {
		this.model = new LightningRod();
	}
	
	private void adjustRoatePivotViaMeta(World world, int x, int y, int z)
	{
		int meta = world.getBlockMetadata(x,y,z);
		GL11.glPushMatrix();
		GL11.glRotatef(meta * (-90),  0.0F,  0.0F, 1.0F);
		GL11.glPopMatrix();
	}
	
	@Override
	public void renderTileEntityAt(TileEntity tileentity, double x, double y, double z, float f) {
		GL11.glPushMatrix();
			//Set initial Location
			GL11.glTranslatef((float) x + 0.5F, (float) y -0.6F , (float) z + 0.5F );
			//GL11.glScalef(-1F,-1F,-1F);
			//This is the texture of your block. Its pathed to be the same place as your other blocks here.
			ResourceLocation textures = (new ResourceLocation("alchemicraft:textures/blocks/LightningRod.png"));
			Minecraft.getMinecraft().renderEngine.bindTexture(textures);
			//This rotation part is very important
			
			//GL11.glRotatef(180F, 0.0F, 0.0F, 1.0F);
			//A reference to your model file.
			this.model.render(null, 0.0F, 0.0F,0.0F,0.0F,0.0F,0.0652F);
			//Stop rendering
			
			GL11.glPopMatrix();
	}
}

