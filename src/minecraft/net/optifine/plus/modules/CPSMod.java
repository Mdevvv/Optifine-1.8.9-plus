package net.optifine.plus.modules;

import java.util.LinkedList;
import java.util.Queue;

import org.lwjgl.input.Mouse;

import net.minecraft.client.Minecraft;

public class CPSMod extends Module
{
    private static String name = "CPS";

    private Queue<Long> clicks = new LinkedList<>();

    private boolean wasPressed;
    private long lastPressed;

    public CPSMod(Minecraft mcIn)
    {
        super(mcIn);
    }

    public void addCpsClick()
    {
        if (this.getIsToggled())
        {
            this.clicks.add(System.currentTimeMillis());
        }
    }

    @Override
    public boolean getIsToggled()
    {
        return super.mc.gameSettings.cpsMod;
    }

    private int getCPS()
    {
        final long time = System.currentTimeMillis();
        this.clicks.removeIf(aLong -> aLong + 1000L < time);
        return this.clicks.size();
    }

    public static String getName()
    {
        return name;
    }

    @Override
    public void showProcess(int x, int y)
    {
        super.guiString = this.name + " : " + getCPS();
        super.showProcess(x, y);
    }
}
