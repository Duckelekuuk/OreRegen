package me.chickenpowerrr.oreregenerator;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

public class BlockBreakListener implements Listener {

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        if(!event.getPlayer().getGameMode().equals(GameMode.CREATIVE)) {
            Block block = event.getBlock();
            if(OreRegeneratorPlugin.getOres().keySet().contains(block.getType())) {
                event.setDropItems(false);
                event.getPlayer().getInventory().addItem(OreRegeneratorPlugin.getOres().get(block.getType()));
            }
            if(OreRegeneratorPlugin.getRespawnTime().keySet().contains(block.getType())) {
                final Location location = block.getLocation();
                final Material type = block.getType();
                Bukkit.getServer().getScheduler().runTaskLater(OreRegeneratorPlugin.getPlugin(), () -> location.getBlock().setType(type), 20 * OreRegeneratorPlugin.getRespawnTime().get(type));
            }
        }
    }
}
