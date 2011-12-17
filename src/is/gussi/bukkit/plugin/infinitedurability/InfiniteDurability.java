package is.gussi.bukkit.plugin.infinitedurability;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteDurability extends JavaPlugin {
	public Logger log = Logger.getLogger("Minecraft.InfiniteDurability");
	public HashSet<Integer> items = new HashSet<Integer>();
	private Listener blockListener = new InfiniteDurabilityBlockListener(this);

	@Override
	public void onDisable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " disabled.");

	}

	@Override
	public void onEnable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " enabled.");
		this.getServer().getPluginManager().registerEvent(Event.Type.BLOCK_BREAK, this.blockListener , Event.Priority.Highest, this);
		this.loadItems();
	}

	private void loadItems() {
		this.items.add(Material.WOOD_PICKAXE.getId());
		this.items.add(Material.WOOD_SPADE.getId());
		this.items.add(Material.WOOD_AXE.getId());
		this.items.add(Material.WOOD_HOE.getId());
		this.items.add(Material.WOOD_SWORD.getId());
		
		this.items.add(Material.IRON_PICKAXE.getId());
		this.items.add(Material.IRON_SPADE.getId());
		this.items.add(Material.IRON_AXE.getId());
		this.items.add(Material.IRON_HOE.getId());
		this.items.add(Material.IRON_SWORD.getId());
		
		this.items.add(Material.GOLD_PICKAXE.getId());
		this.items.add(Material.GOLD_SPADE.getId());
		this.items.add(Material.GOLD_AXE.getId());
		this.items.add(Material.GOLD_HOE.getId());
		this.items.add(Material.GOLD_SWORD.getId());
		
		this.items.add(Material.DIAMOND_PICKAXE.getId());
		this.items.add(Material.DIAMOND_SPADE.getId());
		this.items.add(Material.DIAMOND_AXE.getId());
		this.items.add(Material.DIAMOND_HOE.getId());
		this.items.add(Material.DIAMOND_SWORD.getId());
	}
}