package org.burgerbude.labymod.addons.fullbright;

import net.labymod.api.LabyModAddon;
import net.labymod.settings.elements.BooleanElement;
import net.labymod.settings.elements.ControlElement;
import net.labymod.settings.elements.SettingsElement;
import net.labymod.utils.Material;
import net.minecraft.client.Minecraft;

import java.util.List;

/**
 * The main class of the addon
 *
 * @author Robby
 */
public class FullBrightAddon extends LabyModAddon {

    private boolean enableFullBright;

    @Override
    public void onEnable() {

    }

    @Override
    public void loadConfig() {
        this.enableFullBright = this.getConfig().has("enableFullBright") &&
                this.getConfig().get("enableFullBright").getAsBoolean();
    }

    @Override
    protected void fillSettings(List<SettingsElement> subSettings) {
        //Creates an BooleanElement which turn the full bright mode on or off
        BooleanElement enableFullBrightElement = new BooleanElement("Enable Full Bright", this,
                new ControlElement.IconData(Material.TORCH), "enableFullBright", this.enableFullBright);
        enableFullBrightElement.addCallback(callback -> {
            if (callback) Minecraft.getMinecraft().gameSettings.gammaSetting = 10.0F;
            else Minecraft.getMinecraft().gameSettings.gammaSetting = 1.0F;
        });

        //Adds the BooleanElement to the settings list
        subSettings.add(enableFullBrightElement);
    }
}
