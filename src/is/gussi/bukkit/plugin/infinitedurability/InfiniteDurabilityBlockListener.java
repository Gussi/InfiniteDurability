package is.gussi.bukkit.plugin.infinitedurability;

import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockListener;
import org.bukkit.inventory.ItemStack;

public class InfiniteDurabilityBlockListener extends BlockListener {

	@Override
	public void onBlockBreak(BlockBreakEvent event) {
		if (event.isCancelled()) {
            return;
        }
		Player player = event.getPlayer();
		ItemStack held = player.getItemInHand();
        if ((held.getTypeId() >= 276 && held.getTypeId() <= 279) || held.getTypeId() >= 283 && held.getTypeId() <= 286) {
            held.setDurability((short) 0);
            player.setItemInHand(held);
        }
	}
}
