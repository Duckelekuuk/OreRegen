package me.chickenpowerrr.oreregenerator;

import lombok.Getter;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class OreRegeneratorPlugin extends JavaPlugin {

    @Getter private static OreRegeneratorPlugin plugin;
    @Getter private static Map<Material, Integer> respawnTime;
    @Getter private static Map<Material, ItemStack> ores;

    @Override
    public void onEnable() {
        plugin = this;
        getServer().getPluginManager().registerEvents(new BlockBreakListener(), this);

        respawnTime = new HashMap<>();
        ores = new HashMap<>();

        respawnTime.put(Material.COAL_ORE, getConfig().getInt("Ores.Respawn-Time.Coal"));
        respawnTime.put(Material.DIAMOND_ORE, getConfig().getInt("Ores.Respawn-Time.Diamond"));
        respawnTime.put(Material.EMERALD_ORE, getConfig().getInt("Ores.Respawn-Time.Emerald"));
        respawnTime.put(Material.GLOWING_REDSTONE_ORE, getConfig().getInt("Ores.Respawn-Time.Redstone"));
        respawnTime.put(Material.GOLD_ORE, getConfig().getInt("Ores.Respawn-Time.Gold"));
        respawnTime.put(Material.IRON_ORE, getConfig().getInt("Ores.Respawn-Time.Iron"));
        respawnTime.put(Material.LAPIS_ORE, getConfig().getInt("Ores.Respawn-Time.Lapis"));
        respawnTime.put(Material.QUARTZ_ORE, getConfig().getInt("Ores.Respawn-Time.Quartz"));
        respawnTime.put(Material.REDSTONE_ORE, getConfig().getInt("Ores.Respawn-Time.Redstone"));

        ores.put(Material.COAL_ORE, new ItemStack(Material.COAL));
        ores.put(Material.DIAMOND_ORE, new ItemStack(Material.DIAMOND));
        ores.put(Material.EMERALD_ORE, new ItemStack(Material.EMERALD));
        ores.put(Material.GLOWING_REDSTONE_ORE, new ItemStack(Material.REDSTONE));
        ores.put(Material.GOLD_ORE, new ItemStack(Material.GOLD_INGOT));
        ores.put(Material.IRON_ORE, new ItemStack(Material.IRON_INGOT));
        ores.put(Material.LAPIS_ORE, new ItemStack(Material.INK_SACK, 1, (short) 4));
        ores.put(Material.QUARTZ_ORE, new ItemStack(Material.QUARTZ));
        ores.put(Material.REDSTONE_ORE, new ItemStack(Material.REDSTONE));
    }

    @Override
    public void onDisable() {

    }
}
