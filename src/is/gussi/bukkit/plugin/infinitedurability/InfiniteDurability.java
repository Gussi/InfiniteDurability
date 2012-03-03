package is.gussi.bukkit.plugin.infinitedurability;

import java.util.HashSet;
import java.util.logging.Logger;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class InfiniteDurability extends JavaPlugin implements Listener {
	public Logger log = Logger.getLogger("Minecraft.InfiniteDurability");
	public HashSet<Integer> items = new HashSet<Integer>();

	@Override
	public void onDisable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " disabled.");
	}

	@Override
	public void onEnable() {
		this.log.info(this.getDescription().getName() + " v" + this.getDescription().getVersion() + " enabled.");
		this.getServer().getPluginManager().registerEvents(this, this);
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
	
	@EventHandler(priority = EventPriority.HIGH)
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.isCancelled()) {
            return;
        }

		Player player = event.getPlayer();
		ItemStack held = player.getItemInHand();
        if ( this.items.contains(held.getTypeId()) ) {
            held.setDurability((short) 0);
            player.setItemInHand(held);
        }
	}
}