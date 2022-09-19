package com.toygoon.gitautopuller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class GitAutoPullerApplication {
    public static void main(String[] args) throws IOException {
        Configuration config = new Configuration();
        config.readConfig();

        SpringApplication.run(GitAutoPullerApplication.class, args);1
    }
}
