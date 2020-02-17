package me.kevsal.minecraft.cnsurvival;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryView;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class ModeMenu implements Listener {

    private static String invName = ChatColor.LIGHT_PURPLE + "Mode Selector";
    private final CNSurvival plugin;
    public static Inventory modeMenu = Bukkit.createInventory(null, 9, invName);
    private static ItemStack normal = new ItemStack(Material.GRASS_BLOCK);
    private static ItemStack nopvp = new ItemStack(Material.OBSIDIAN);
    private static ItemStack peaceful = new ItemStack(Material.BEDROCK);
    private static List<String> normalLore = new ArrayList<String>();
    private static List<String> nopvpLore = new ArrayList<String>();
    private static List<String> peacefulLore = new ArrayList<String>();

    public ModeMenu(CNSurvival plugin) {
        this.plugin = plugin;
    }

    static {

        ItemMeta normalMeta = normal.getItemMeta();
        normalMeta.setDisplayName(ChatColor.YELLOW + "" + ChatColor.BOLD + "NORMAL");
        normalLore.add(ChatColor.YELLOW + "Normal combat, no changes");
        normalMeta.setLore(normalLore);
        normal.setItemMeta(normalMeta);

        ItemMeta noPVPMeta = nopvp.getItemMeta();
        noPVPMeta.setDisplayName(ChatColor.RED + "" + ChatColor.BOLD + "NO PVP");
        nopvpLore.add(ChatColor.YELLOW + "No player combat.");
        nopvpLore.add(ChatColor.YELLOW + "Still will take fall damage, etc.");
        noPVPMeta.setLore(nopvpLore);
        nopvp.setItemMeta(noPVPMeta);


        ItemMeta peacefulMeta = peaceful.getItemMeta();
        peacefulMeta.setDisplayName(ChatColor.DARK_RED + "" + ChatColor.BOLD + "PEACEFUL");
        peacefulLore.add(ChatColor.YELLOW + "No combat at all.");
        peacefulLore.add(ChatColor.YELLOW + "Still will take fall damage, etc.");
        peacefulLore.add(ChatColor.GREEN + "Donors (Emerald and higher) only!");
        peacefulMeta.setLore(peacefulLore);
        peaceful.setItemMeta(peacefulMeta);



        modeMenu.setItem(0, normal);
        modeMenu.setItem(4, nopvp);
        modeMenu.setItem(8, peaceful);;
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        ItemStack clicked = e.getCurrentItem();
        InventoryView inv = e.getView();

        if(inv.getTitle().equals(invName)) {
            if(e.getCurrentItem().getType().equals(normal.getType())) {
                e.setCancelled(true);
                p.closeInventory();
                ModeController.switchMode(plugin, p, PlayerMode.NORMAL);
            } else if (e.getCurrentItem().getType().equals(nopvp.getType())) {
                e.setCancelled(true);
                p.closeInventory();
                ModeController.switchMode(plugin, p, PlayerMode.NOPVP);
            } else if(e.getCurrentItem().getType().equals(peaceful.getType())) {
                e.setCancelled(true);
                p.closeInventory();
                ModeController.switchMode(plugin, p, PlayerMode.PEACEFUL);
            }
        }
    }
}
