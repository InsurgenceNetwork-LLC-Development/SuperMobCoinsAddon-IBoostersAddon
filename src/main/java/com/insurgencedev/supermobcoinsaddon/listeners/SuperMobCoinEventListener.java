package com.insurgencedev.supermobcoinsaddon.listeners;

import me.swanis.mobcoins.events.MobCoinsReceiveEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.insurgencedev.insurgenceboosters.api.IBoosterAPI;
import org.insurgencedev.insurgenceboosters.data.BoosterFindResult;

public final class SuperMobCoinEventListener implements Listener {

    @EventHandler
    public void onReceive(MobCoinsReceiveEvent event) {
        final String TYPE = "Mobcoins";
        final String NAMESPACE = "SUPER_MOBCOINS";
        final double[] totalMulti = {1};

        BoosterFindResult pResult = IBoosterAPI.INSTANCE.getCache(event.getProfile().getPlayer()).getBoosterDataManager().findActiveBooster(TYPE, NAMESPACE);
        if (pResult instanceof BoosterFindResult.Success boosterResult) {
            totalMulti[0] += boosterResult.getBoosterData().getMultiplier();
        }

        IBoosterAPI.INSTANCE.getGlobalBoosterManager().findGlobalBooster(TYPE, NAMESPACE, globalBooster -> {
            totalMulti[0] += globalBooster.getMultiplier();
            return null;
        }, () -> null);

        event.setAmount(calculateAmount(event.getAmount(), totalMulti[0]));
    }

    private long calculateAmount(double amount, double multi) {
        return (long) (amount * (multi < 1 ? 1 + multi : multi));
    }
}
