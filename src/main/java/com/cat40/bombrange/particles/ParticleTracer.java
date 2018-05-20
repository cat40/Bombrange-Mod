package com.cat40.bombrange.particles;

import org.lwjgl.opengl.GL11;

import com.cat40.bombrange.Main;

import net.minecraft.client.Minecraft;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class ParticleTracer extends EntityFX
{
	private static final ResourceLocation texture = new ResourceLocation(Main.modid_without_colon, "textures/particles/TracerFX.png");// "TracerFX.png");//"textures/particle/TracerFX.png");
	public static boolean flagRotate = false;
	
	public ParticleTracer(World world, double x, double y, double z) 
	{
		super(world, x, y, z);
		this.setMaxAge(250);
		this.setGravity((float) (-1*Math.random()/10F));//-0.1F);
		this.setScale(1F);
		this.flagRotate = ! this.flagRotate;
	}
	
	@Override
	public void renderParticle(Tessellator tess, float partialTicks, float f3, float f4, float f5, float f6, float f7)
	{
		Minecraft.getMinecraft().renderEngine.bindTexture(texture);
		GL11.glDepthMask(false);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.003921569F);
		tess.startDrawingQuads();
		tess.setBrightness(this.getBrightnessForRender(partialTicks));
		float scale = 0.1F*this.particleScale;
		float x = (float) (this.prevPosX + ((this.posX-this.prevPosX)*partialTicks - this.interpPosX));
		float y = (float) (this.prevPosY + ((this.posY-this.prevPosY)*partialTicks - this.interpPosY));
		float z = (float) (this.prevPosZ + ((this.posZ-this.prevPosZ)*partialTicks - this.interpPosZ));
		tess.addVertexWithUV(x - f3*scale - f6*scale, y - f4*scale, z - f5*scale - f7 *scale, 0, 0);
		tess.addVertexWithUV(x - f3*scale + f6*scale, y + f4*scale, z - f5*scale + f7 *scale, 1, 0);
		if(this.flagRotate)
		{
			tess.addVertexWithUV(x + f3*scale + f6*scale, y + f4*scale, z + f5*scale + f7 *scale, 1, 1);
			tess.addVertexWithUV(x + f3*scale - f6*scale, y - f4*scale, z + f5*scale - f7 *scale, 0, 1);
		}
		else
		{
			tess.addVertexWithUV(x + f3*scale + f6*scale, y + f4*scale, z - f5*scale + f7 *scale, 1, 1);
			tess.addVertexWithUV(x + f3*scale - f6*scale, y - f4*scale, z - f5*scale - f7 *scale, 0, 1);
		}
		tess.draw();
		GL11.glDisable(GL11.GL_BLEND);
		GL11.glDepthMask(true);
		GL11.glAlphaFunc(GL11.GL_GREATER, 0.1F);
	}
	
	@Override
	public int getFXLayer()
	{
		return 3; //1? (!= 0; != 2)
	}
	
	public ParticleTracer setMaxAge(int maxAge)
	{
		this.particleMaxAge = maxAge;
		return this;
	}
	
	public ParticleTracer setGravity(float gravity)
	{
		this.particleGravity = gravity;
		return this;
	}
	
	public ParticleTracer setScale(float scale)
	{
		this.particleScale = scale;
		return this;
	}

}