package is.gussi.bukkit.plugin.infinitedurability;

import java.util.logging.Logger;

import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteDurability extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft.InfiniteDurability");
	private Listener blockListener = new InfiniteDurabilityBlockListener();

	@Override
	public void onDisable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " disabled.");

	}

	@Override
	public void onEnable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " enabled.");
		this.getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, this.blockListener , Event.Priority.Highest, this);
	}
}