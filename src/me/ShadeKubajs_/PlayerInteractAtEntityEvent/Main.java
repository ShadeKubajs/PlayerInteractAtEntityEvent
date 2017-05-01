package me.ShadeKubajs_.PlayerInteractAtEntityEvent;

import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin
	{

	public void onEnable()
		{
		saveDefaultConfig();
		getCommand("armorstand").setExecutor(new Prikazy(null));
		getServer().getPluginManager().registerEvents(new Eventy(this), this);
		
		}
	
}
