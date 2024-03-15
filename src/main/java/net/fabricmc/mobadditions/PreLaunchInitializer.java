package net.fabricmc.mobadditions;

import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;
import com.itlesports.mobadditions.MobAdditions;

public class PreLaunchInitializer implements PreLaunchEntrypoint {
    /**
     * Runs the PreLaunch entrypoint to register BTW-Addon.
     * Don't initialize anything else here, use
     * the method Initialize() in the Addon.
     */
    @Override
    public void onPreLaunch() {
        MobAdditions.getInstance();
    }
}
