package net.optifine.plus.modules;

import java.awt.Color;

import net.minecraft.client.Minecraft;

public class ToggleSprint extends Module {
	private static String name = "Toggle Sprint";
	
	public ToggleSprint(Minecraft mcIn) {
		super(mcIn);
		
	}
	
	@Override
	public boolean getIsToggled() {
		return super.mc.gameSettings.toggleSprint;
	}
	
	private boolean getIsRunningToggled() {
		return super.mc.gameSettings.isToggledSprint;
	}

	public static String getName() {
		return name;
	}
	
	@Override
	public void showProcess(int x, int y) {
		super.guiString = "[" + this.name  + (this.getIsRunningToggled() ? " (Toggled)" : " (Vanilla)" ) + "]";
		super.showProcess(x, y);
		
	}
}
