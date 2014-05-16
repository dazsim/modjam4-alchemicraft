package dazsim.alchemicraft.models;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class modelPedistal extends ModelBase
{
  //fields
    ModelRenderer Shape1;
    ModelRenderer Shape2;
    ModelRenderer Shape3;
    ModelRenderer Shape5;
    ModelRenderer Shape6;
    ModelRenderer Shape7;
    ModelRenderer Shape8;
    ModelRenderer Shape9;
  
  public modelPedistal()
  {
    textureWidth = 256;
    textureHeight = 256;
    
      Shape1 = new ModelRenderer(this, 0, 0);
      Shape1.addBox(0F, 0F, 0F, 16, 2, 16);
      Shape1.setRotationPoint(-8F, 24F, -8F);
      Shape1.setTextureSize(256, 256);
      Shape1.mirror = true;
      setRotation(Shape1, 0F, 0F, 0F);
      Shape2 = new ModelRenderer(this, 0, 22);
      Shape2.addBox(0F, 0F, 0F, 8, 1, 8);
      Shape2.setRotationPoint(-4F, 26F, -4F);
      Shape2.setTextureSize(256, 256);
      Shape2.mirror = true;
      setRotation(Shape2, 0F, 0F, 0F);
      Shape3 = new ModelRenderer(this, 0, 31);
      Shape3.addBox(0F, 0F, 0F, 4, 5, 4);
      Shape3.setRotationPoint(-2F, 27F, -2F);
      Shape3.setTextureSize(256, 256);
      Shape3.mirror = true;
      setRotation(Shape3, 0F, 0F, 0F);
      Shape5 = new ModelRenderer(this, 0, 45);
      Shape5.addBox(0F, 0F, 0F, 6, 1, 6);
      Shape5.setRotationPoint(-3F, 32F, -3F);
      Shape5.setTextureSize(256, 256);
      Shape5.mirror = true;
      setRotation(Shape5, 0F, 0F, 0F);
      Shape6 = new ModelRenderer(this, 0, 52);
      Shape6.addBox(0F, 0F, 0F, 10, 1, 10);
      Shape6.setRotationPoint(-5F, 33F, -5F);
      Shape6.setTextureSize(256, 256);
      Shape6.mirror = true;
      setRotation(Shape6, 0F, 0F, 0F);
      Shape7 = new ModelRenderer(this, 0, 63);
      Shape7.addBox(0F, 0F, 0F, 12, 1, 12);
      Shape7.setRotationPoint(-6F, 34F, -6F);
      Shape7.setTextureSize(256, 256);
      Shape7.mirror = true;
      setRotation(Shape7, 0F, 0F, 0F);
      Shape8 = new ModelRenderer(this, 0, 77);
      Shape8.addBox(0F, 0F, 0F, 14, 1, 14);
      Shape8.setRotationPoint(-7F, 35F, -7F);
      Shape8.setTextureSize(256, 256);
      Shape8.mirror = true;
      setRotation(Shape8, 0F, 0F, 0F);
      Shape9 = new ModelRenderer(this, 0, 93);
      Shape9.addBox(0F, 0F, 0F, 16, 6, 16);
      Shape9.setRotationPoint(-8F, 36F, -8F);
      Shape9.setTextureSize(256, 256);
      Shape9.mirror = true;
      setRotation(Shape9, 0F, 0F, 0F);
  }
  
  public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5)
  {
    super.render(entity, f, f1, f2, f3, f4, f5);
    setRotationAngles(f, f1, f2, f3, f4, f5, entity);
    Shape1.render(f5);
    Shape2.render(f5);
    Shape3.render(f5);
    Shape5.render(f5);
    Shape6.render(f5);
    Shape7.render(f5);
    Shape8.render(f5);
    Shape9.render(f5);
  }
  
  private void setRotation(ModelRenderer model, float x, float y, float z)
  {
    model.rotateAngleX = x;
    model.rotateAngleY = y;
    model.rotateAngleZ = z;
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5, Entity entity)
  {
    super.setRotationAngles(f, f1, f2, f3, f4, f5, entity);
  }

}
