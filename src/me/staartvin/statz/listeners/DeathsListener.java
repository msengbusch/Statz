package me.staartvin.statz.listeners;

import me.staartvin.statz.Statz;
import me.staartvin.statz.datamanager.player.PlayerStat;
import me.staartvin.statz.datamanager.player.specification.DeathsSpecification;
import me.staartvin.statz.datamanager.player.specification.PlayerStatSpecification;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class DeathsListener implements Listener {

	private final Statz plugin;

	public DeathsListener(final Statz plugin) {
		this.plugin = plugin;
	}

	@EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
	public void onDie(final PlayerDeathEvent event) {

		final PlayerStat stat = PlayerStat.DEATHS;

		// Get player
		final Player player = event.getEntity();

		// Do general check
		if (!plugin.doGeneralCheck(player, stat))
			return;

		PlayerStatSpecification specification = new DeathsSpecification(player.getUniqueId(), 1,
				player.getWorld().getName());


		// Update value to new stat.
		plugin.getDataManager().setPlayerInfo(player.getUniqueId(), stat, specification.constructQuery());

	}
}
