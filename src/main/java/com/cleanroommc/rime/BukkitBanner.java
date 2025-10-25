package com.cleanroommc.rime;

import com.cleanroommc.common.CleanroomVersion;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BukkitBanner {
    private static final Logger LOGGER = LogManager.getLogger();
    
    public static void printBanner() {
        String[] banner = {
            "",
            "    ________                 ____  ______  _________",
            "  / ____/ /__  ____ _____  / __ \\/  _/  |/  / ____/",
            " / /   / / _ \\/ __ `/ __ \\/ /_/ // // /|_/ / __/   ",
            "/ /___/ /  __/ /_/ / / / / _, _// // /  / / /___   ",
            "\\____/_/\\___/\\__,_/_/ /_/_/ |_/___/_/  /_/_____/   ",
            "                                                   ",
            "",
            "  CleanRIME - Cleanroom + Spigot Hybrid Server",
            "  Minecraft: 1.12.2 | Cleanroom: " + CleanroomVersion.BUILD_VERSION,
            ""
        };
        
        for (String line : banner) {
            LOGGER.info(line);
        }
    }
}

