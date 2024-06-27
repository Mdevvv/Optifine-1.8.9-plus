package net.optifine.plus.interfaces;

import net.minecraft.client.gui.FontRenderer;

public interface Imodule {

	public boolean getIsToggled();
	
	public void showProcess(int x, int y);
	
	public FontRenderer getFontRenderer();

}
