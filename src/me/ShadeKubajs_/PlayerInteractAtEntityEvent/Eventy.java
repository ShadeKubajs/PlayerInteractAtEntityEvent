package me.ShadeKubajs_.PlayerInteractAtEntityEvent;

import org.bukkit.Bukkit;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import net.md_5.bungee.api.ChatColor;

public class Eventy implements Listener
{
	public Main plugin;
	
	
	public Eventy(Main pl)
	{
		plugin = pl;
	}
	
	
	@EventHandler
	public void onInnn(PlayerInteractAtEntityEvent e)
	{
		
		if (e.getRightClicked() == null) return;
		
		Player p = e.getPlayer();
		Entity en = e.getRightClicked();
		
		if(en.getType() == EntityType.ARMOR_STAND)
		{
			ArmorStand st = (ArmorStand) en;
			
			if (st.getCustomName() != null && st.getCustomName().startsWith(ChatColor.GREEN + ""))
			{
				String h = st.getCustomName().replace(ChatColor.GREEN + "", "");
				
				Bukkit.dispatchCommand(p, plugin.getConfig().getString(h));
				
				
			}
			
		}
		
	}
}
