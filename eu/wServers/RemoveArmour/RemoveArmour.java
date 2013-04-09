package eu.wServers.RemoveArmour;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class RemoveArmour extends JavaPlugin
{
	String bad = ChatColor.GOLD + "[RemoveArmour] " + ChatColor.RED;
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) 
	{
		if(sender instanceof Player)
		{
			if(sender.hasPermission("removearmour.use"))
			{
				sender.sendMessage(bad + "You do not have permissions to use this command.");
				return true;
			}
		}
		
		if(args.length != 1)
		{
			sender.sendMessage(bad + "Syntax: /removearmour [Player]");
			return true;
		}
		
		Player player = getServer().getPlayer(args[0]);
		
		if(player != null)
		{
			player.getInventory().setArmorContents(null);
		}
		
		return true;
	}
}
