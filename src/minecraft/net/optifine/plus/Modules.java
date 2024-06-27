package net.optifine.plus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import net.minecraft.client.Minecraft;
import net.optifine.plus.modules.CPSMod;
import net.optifine.plus.modules.Module;
import net.optifine.plus.modules.ToggleSprint;

public class Modules {
	
	private Map<String, Module> mapModules;
	
	public Modules(Minecraft mcIn) {
		
		this.mapModules = new HashMap();
		
		mapModules.put(ToggleSprint.getName(), new ToggleSprint(mcIn));
		mapModules.put(CPSMod.getName(), new CPSMod(mcIn));
	}
	
	public ArrayList<Module> getModules() {
        return new ArrayList<>(mapModules.values());
    }
	
	public Module getModule(String name) {
		return mapModules.getOrDefault(name, null);
	}
	
	public void show() {
		int y = 5;

		
		for(Module current : this.getModules()) {
			if(current.getIsToggled()) {
				current.showProcess(5, y);
				y += 15;
			}
        }
		
	}
}
