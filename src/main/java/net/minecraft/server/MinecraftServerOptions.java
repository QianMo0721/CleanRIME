package net.minecraft.server;

import joptsimple.OptionParser;
import joptsimple.OptionSet;
import joptsimple.OptionSpec;

import java.io.File;

/**
 * Wrapper for command-line options parsed by JOptSimple.
 * Compatible with Bukkit/CraftBukkit's org.bukkit.craftbukkit.Main OptionSet parsing.
 */
public class MinecraftServerOptions {
    
    private final OptionSet options;
    private final OptionSpec<Void> helpSpec;
    private final OptionSpec<Void> noguiSpec;
    private final OptionSpec<Integer> portSpec;
    private final OptionSpec<String> singleplayerSpec;
    private final OptionSpec<File> universeSpec;
    private final OptionSpec<String> worldSpec;
    private final OptionSpec<Void> demoSpec;
    private final OptionSpec<Void> bonusChestSpec;
    
    public MinecraftServerOptions(String[] args) {
        OptionParser parser = new OptionParser();
        parser.allowsUnrecognizedOptions();
        
        // Define options compatible with Bukkit/CraftBukkit
        this.helpSpec = parser.accepts("help", "Show the help").forHelp();
        this.noguiSpec = parser.accepts("nogui", "Disable the GUI");
        this.portSpec = parser.accepts("port", "Port to listen on")
                .withRequiredArg()
                .ofType(Integer.class)
                .defaultsTo(-1);
        this.singleplayerSpec = parser.accepts("singleplayer", "Single player mode")
                .withRequiredArg()
                .ofType(String.class);
        this.universeSpec = parser.accepts("universe", "Universe/container folder")
                .withRequiredArg()
                .ofType(File.class)
                .defaultsTo(new File("."));
        this.worldSpec = parser.accepts("world", "World folder")
                .withRequiredArg()
                .ofType(String.class);
        this.demoSpec = parser.accepts("demo", "Demo mode");
        this.bonusChestSpec = parser.accepts("bonusChest", "Enable bonus chest");
        
        this.options = parser.parse(args);
    }
    
    public boolean has(String option) {
        return options.has(option);
    }
    
    public boolean hasGui() {
        return !options.has(noguiSpec);
    }
    
    public int getPort() {
        return options.valueOf(portSpec);
    }
    
    public String getSingleplayer() {
        return options.valueOf(singleplayerSpec);
    }
    
    public File getUniverse() {
        return options.valueOf(universeSpec);
    }
    
    public String getWorld() {
        return options.valueOf(worldSpec);
    }
    
    public boolean isDemo() {
        return options.has(demoSpec);
    }
    
    public boolean hasBonusChest() {
        return options.has(bonusChestSpec);
    }
    
    public OptionSet getOptionSet() {
        return options;
    }
}

