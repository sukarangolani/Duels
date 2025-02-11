package me.realized.duels.hook.hooks;

import com.earth2me.essentials.Essentials;
import com.earth2me.essentials.User;
import me.realized.duels.DuelsPlugin;
import me.realized.duels.config.Config;
import me.realized.duels.util.hook.PluginHook;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class EssentialsHook extends PluginHook<DuelsPlugin> {

    public static final String NAME = "Essentials";

    private final Config config;

    public EssentialsHook(final DuelsPlugin plugin) {
        super(plugin, NAME);
        this.config = plugin.getConfiguration();
    }

    public void tryUnvanish(final Player player) {
        if (!config.isAutoUnvanish()) {
            return;
        }

        final Essentials plugin = (Essentials) getPlugin();
        final User user = plugin.getUser(player);

        if (user != null && user.isVanished()) {
            user.setVanished(false);
        }
    }

    public void setBackLocation(final Player player, final Location location) {
        if (!config.isSetBackLocation()) {
            return;
        }

        final Essentials plugin = (Essentials) getPlugin();
        final User user = plugin.getUser(player);

        if (user != null) {
            user.setLastLocation(location);
        }
    }
}
