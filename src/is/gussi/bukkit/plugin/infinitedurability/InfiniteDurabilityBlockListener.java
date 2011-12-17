package is.gussi.bukkit.plugin.infinitedurability;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class InfiniteDurabilityBlockListener extends BlockListener {
	private InfiniteDurability plugin;

	public InfiniteDurabilityBlockListener(InfiniteDurability instance) {
		this.plugin = instance;
	}

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.isCancelled()) {
            return;
        }

		Player player = event.getPlayer();
		ItemStack held = player.getItemInHand();
        if ( this.plugin.items.contains(held.getTypeId()) ) {
            held.setDurability((short) 0);
            player.setItemInHand(held);
        }
	}
}
