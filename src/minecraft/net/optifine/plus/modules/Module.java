package net.optifine.plus.modules;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.optifine.plus.interfaces.Imodule;

public abstract class Module implements Imodule {
	protected Minecraft mc;
	protected boolean isToggle;
	
	protected String guiString;
	
	public Module(Minecraft mcIn) {
		this.mc = mcIn;
	}
	
	@Override
	public boolean getIsToggled() {
		return this.isToggle;
	}
	
	public static String getName() {
		return "Module";
	}
	
	@Override
	public FontRenderer getFontRenderer()
    {
        return this.mc.fontRendererObj;
    }
	
	@Override
	public void showProcess(int x, int y) {
		this.getFontRenderer().drawString(guiString, x, y+1, Color.BLACK.getRGB());
		this.getFontRenderer().drawString(guiString, x, y, Color.WHITE.getRGB());
	}
}
