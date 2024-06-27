package net.optifine.plus.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiOptionButton;
import net.minecraft.client.gui.GuiOptions;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.settings.GameSettings;
import net.optifine.gui.GuiOptionButtonOF;
import net.optifine.gui.GuiOptionSliderOF;

public class GuiModsOptions extends GuiScreen
{
    private GuiScreen parentScreen;
    protected String screenTitle = "Mods Settings";

    private GameSettings guiGameSettings;

    private static final GameSettings.Options[] modsOptions =  new GameSettings.Options[] {GameSettings.Options.TOGGLESPRINT, GameSettings.Options.CPSMOD};

    public GuiModsOptions(GuiScreen screen, GameSettings guiGameSettings)
    {
        this.parentScreen = screen;
        this.guiGameSettings = guiGameSettings;
    }

    public void initGui()
    {
        this.screenTitle = I18n.format("Mods Settings", new Object[0]);
        this.buttonList.clear();

        for (int i = 0; i < modsOptions.length; ++i)
        {
            GameSettings.Options gamesettings$options = modsOptions[i];

            if (gamesettings$options != null)
            {
                int j = this.width / 2 - 155 + i % 2 * 160;
                int k = (this.height / 2 - 21) - 21 * (i / 2) - 12;

                if (gamesettings$options.getEnumFloat())
                {
                    this.buttonList.add(new GuiOptionSliderOF(gamesettings$options.returnEnumOrdinal(), j, k, gamesettings$options));
                }
                else
                {
                    this.buttonList.add(new GuiOptionButtonOF(gamesettings$options.returnEnumOrdinal(), j, k, gamesettings$options, this.guiGameSettings.getKeyBinding(gamesettings$options)));
                }
            }
        }

        this.buttonList.add(new GuiButton(200, this.width / 2 - 100, this.height / 6 + 168 + 11, I18n.format("gui.done", new Object[0])));
    }

    protected void actionPerformed(GuiButton button) throws IOException
    {
        if (button.id == 200)
        {
            this.mc.displayGuiScreen(this.parentScreen);
        }
        else
        {
            this.guiGameSettings.setOptionValue(((GuiOptionButton)button).returnEnumOptions(), 1);
            button.displayString = this.guiGameSettings.getKeyBinding(GameSettings.Options.getEnumOptions(button.id));
        }
    }

    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();
        this.drawCenteredString(this.fontRendererObj, this.screenTitle, this.width / 2, 15, 16777215);
        super.drawScreen(mouseX, mouseY, partialTicks);
    }
}
