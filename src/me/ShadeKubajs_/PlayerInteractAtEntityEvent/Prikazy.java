package me.ShadeKubajs_.PlayerInteractAtEntityEvent;

import java.io.IOException;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;

public class Prikazy implements CommandExecutor
	{
		public Main plugin;
		
		public Prikazy(Main pl)
		{
			plugin = pl;
		}
		
		public boolean onCommand1(CommandSender sender, Command cmd, String label, String[] args)
		{
			if (cmd.getName().equalsIgnoreCase("armorstand"))
			{
				if (sender instanceof Player)
				{
					Player p = (Player) sender;
					
					if (args[0].equalsIgnoreCase("create"))
					{
						if (args.length == 2)
						{
							String nazev = args[1];
							
							Location loc =p.getLocation();
							
							ArmorStand st = (ArmorStand) loc.getWorld().spawnEntity(loc, EntityType.ARMOR_STAND);
							
							st.setCustomName(ChatColor.GREEN + nazev);
							st.setCustomNameVisible(true);
							
							plugin.getConfig().createSection(nazev);
							
							try
							{
								plugin.getConfig().save("plugins/ArmorStand/config.yml");
							}
							catch (IOException e)
							{
								e.printStackTrace();
							}
							
							plugin.getConfig().set(nazev, "say Prikaz nenastaven");
							
							try
							{
								plugin.getConfig().save("plugins/ArmorStand/config.yml");
							}
							catch (IOException e)
							{
								e.printStackTrace();
							}
							p.sendMessage(ChatColor.GREEN + "ArmordStand vytvoren");
						}
					}
				}
			}
			
			
			return false;
			
		}
		


	@Override
	public boolean onCommand(CommandSender arg0, Command arg1, String arg2, String[] arg3) {
		// TODO Auto-generated method stub
		return false;
	}
}
