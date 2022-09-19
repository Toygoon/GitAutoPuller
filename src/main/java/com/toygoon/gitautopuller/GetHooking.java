package com.toygoon.gitautopuller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Receive the hook from the data
 */
@RestController
public class GetHooking {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Detects the hook, and pull the changes.
     * @param body
     * @throws IOException
     */
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public void getHook(@RequestBody String body) throws IOException {
        // Reads the configuration file.
        Configuration config = new Configuration();
        config.readConfig();

        // Creates the command line.
        StringBuilder cmd = new StringBuilder();
        // Change directory to the repository folder.
        cmd.append("cd ");
        cmd.append(config.location);
        cmd.append(" && ");

        // If the additional action exists, executes it.
        if (config.actions.length() > 2)
            cmd.append(config.actions).append(" && ");

        // Finally, git pull
        cmd.append("git pull");

        // Executes the command line created.
        logger.info("Executing " + cmd.toString());
        Process process = Runtime.getRuntime().exec(cmd.toString());
    }
}
