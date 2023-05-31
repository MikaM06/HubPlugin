package mika.olicube.hub;

import mika.olicube.hub.Listeners.*;
import mika.olicube.hub.Listeners.EventManager.*;
import mika.olicube.hub.ScoreBoard.ScoreboardManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main extends JavaPlugin {
    private static Main instance;
    private ScoreboardManager scoreboardManager;

    private ScheduledExecutorService executorMonoThread;
    private ScheduledExecutorService scheduledExecutorService;

    @Override
    public void onEnable() {
        instance = this;

        registersManager();

        scheduledExecutorService = Executors.newScheduledThreadPool(16);
        executorMonoThread = Executors.newScheduledThreadPool(1);
        scoreboardManager = new ScoreboardManager();

        System.out.println("§8§m-----------------------");
        System.out.println("§3§lOpiHub Start !");
        System.out.println("§8§m-----------------------");

        Bukkit.getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");
    }

    public void registersManager(){
        Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerQuit(), this);
        Bukkit.getPluginManager().registerEvents(new PlayerEventManager(), this);
        Bukkit.getPluginManager().registerEvents(new GUIJeuxManager(), this);
        Bukkit.getPluginManager().registerEvents(new GUIBoutiqueManager(), this);
        Bukkit.getPluginManager().registerEvents(new GUIProfilManager(), this);
        Bukkit.getPluginManager().registerEvents(new GUIHubManager(), this);
        Bukkit.getPluginManager().registerEvents(new GUIOpenManager(), this);
    }

    @Override
    public void onDisable() {
        getScoreboardManager().onDisable();
    }

    public static Main getInstance() {
        return instance;
    }

    public ScoreboardManager getScoreboardManager() {
        return scoreboardManager;
    }

    public ScheduledExecutorService getExecutorMonoThread() {
        return executorMonoThread;
    }

    public ScheduledExecutorService getScheduledExecutorService() {
        return scheduledExecutorService;
    }
}
