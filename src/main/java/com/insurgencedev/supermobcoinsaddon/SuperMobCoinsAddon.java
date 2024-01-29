package com.insurgencedev.supermobcoinsaddon;

import com.insurgencedev.supermobcoinsaddon.listeners.SuperMobCoinEventListener;
import org.insurgencedev.insurgenceboosters.api.addon.IBoostersAddon;
import org.insurgencedev.insurgenceboosters.api.addon.InsurgenceBoostersAddon;
import org.insurgencedev.insurgenceboosters.libs.fo.Common;

@IBoostersAddon(name = "SuperMobcoinsAddon", version = "1.0.2", author = "InsurgenceDev", description = "SuperMobcoins Support")
public class SuperMobCoinsAddon extends InsurgenceBoostersAddon {

    @Override
    public void onAddonReloadAblesStart() {
        if (Common.doesPluginExist("SuperMobcoins")) {
            registerEvent(new SuperMobCoinEventListener());
        }
    }
}
