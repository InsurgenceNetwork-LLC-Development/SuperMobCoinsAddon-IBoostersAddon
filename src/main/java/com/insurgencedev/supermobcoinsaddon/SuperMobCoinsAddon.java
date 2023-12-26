package com.insurgencedev.supermobcoinsaddon;

import com.insurgencedev.supermobcoinsaddon.listeners.SuperMobCoinEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;

@IBoostersAddon(name = "SuperMobcoinsAddon", version = "1.0.0", author = "InsurgenceDev", description = "SuperMobcoins Support")
public class SuperMobCoinsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadablesStart() {
        registerEvent(new SuperMobCoinEventListener());
    }
}
