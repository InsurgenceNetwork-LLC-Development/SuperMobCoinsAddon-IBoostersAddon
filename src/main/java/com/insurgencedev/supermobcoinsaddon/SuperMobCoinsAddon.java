package com.insurgencedev.supermobcoinsaddon;

import com.insurgencedev.supermobcoinsaddon.listeners.SuperMobCoinEventListener;
import org.bukkit.Bukkit;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "SuperMobcoinsAddon", version = "1.0.1", author = "InsurgenceDev", description = "SuperMobcoins Support")
public class SuperMobCoinsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        if (Bukkit.getPluginManager().isPluginEnabled("SuperMobcoins")) {
            registerEvent(new SuperMobCoinEventListener());
        }
    }
}
