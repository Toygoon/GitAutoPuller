package com.toygoon.gitautopuller;

import lombok.Getter;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * Reads the secret key from 'config.txt'
 * If the file not exists, generates the file.
 */
@Setter
@Getter
public class Configuration {
    private final String FILE_NAME = "config.txt";
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public String secret;
    public String location;
    public String actions;

    /**
     * Reads the config and save the secret file to the current instance.
     * @throws IOException
     */
    public void readConfig() throws IOException {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(FILE_NAME));
        } catch (FileNotFoundException e) {
            writeFile();
            logger.error("\'config.txt\' file doesn't exist.");
            logger.error("Generating \'config.txt\' file.");
            System.exit(1);
        }

        String read = br.readLine();
        this.secret = read.replaceAll("secret=", "");
        this.location = read.replaceAll("repository-location=", "");
        this.actions = read.replaceAll("needed-actions=", "");
    }

    /**
     * Writes empty config.txt file.
     * @throws IOException
     */
    private void writeFile() throws IOException {
        BufferedWriter bw = new BufferedWriter(new FileWriter(FILE_NAME));
        bw.write("secret=");
        bw.write("repository-location=");
        bw.write("needed-actions=");
        bw.newLine();
        bw.flush();
        bw.close();
    }
}
