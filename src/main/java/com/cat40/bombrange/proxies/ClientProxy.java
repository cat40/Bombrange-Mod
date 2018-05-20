package com.cat40.bombrange.proxies;

import com.cat40.bombrange.blocks.arrow.ArrowPrime;
import com.cat40.bombrange.blocks.arrow.RenderArrowPrime;
import com.cat40.bombrange.blocks.delay.*;
import com.cat40.bombrange.blocks.fire.FirePrime;
import com.cat40.bombrange.blocks.fire.RenderFirePrime;
import com.cat40.bombrange.blocks.largefire.LargeFirePrime;
import com.cat40.bombrange.blocks.largefire.RenderLargeFirePrime;
import com.cat40.bombrange.blocks.potion.PotionPrime;
import com.cat40.bombrange.blocks.potion.RenderPotionPrime;
import com.cat40.bombrange.blocks.powder.PowderPrime;
import com.cat40.bombrange.blocks.powder.RenderPowderPrime;
import com.cat40.bombrange.blocks.substrate.FallingSubstrate;
import com.cat40.bombrange.blocks.substrate.RenderFallingSubstrate;
import com.cat40.bombrange.blocks.tracer.RenderTracerPrime;
import com.cat40.bombrange.blocks.tracer.TracerPrime;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends CommonProxy
{
	public void registerRenders()
	{
		RenderingRegistry.registerEntityRenderingHandler(ArrowPrime.class, new RenderArrowPrime());
		RenderingRegistry.registerEntityRenderingHandler(FirePrime.class, new RenderFirePrime());
		RenderingRegistry.registerEntityRenderingHandler(PowderPrime.class, new RenderPowderPrime());
		RenderingRegistry.registerEntityRenderingHandler(DelayPrime1.class, new RenderDelay1());
		RenderingRegistry.registerEntityRenderingHandler(DelayPrime5.class, new RenderDelay5());
		RenderingRegistry.registerEntityRenderingHandler(DelayPrime10.class, new RenderDelay10());
		RenderingRegistry.registerEntityRenderingHandler(DelayPrime30.class, new RenderDelay30());
		RenderingRegistry.registerEntityRenderingHandler(TracerPrime.class, new RenderTracerPrime());
		RenderingRegistry.registerEntityRenderingHandler(PotionPrime.class, new RenderPotionPrime());
		RenderingRegistry.registerEntityRenderingHandler(LargeFirePrime.class, new RenderLargeFirePrime());
		RenderingRegistry.registerEntityRenderingHandler(FallingSubstrate.class, new RenderFallingSubstrate());
	}
}