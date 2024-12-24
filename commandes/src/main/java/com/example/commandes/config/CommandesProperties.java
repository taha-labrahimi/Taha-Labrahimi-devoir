package com.example.commandes.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "mes-config-ms")
public class CommandesProperties {

    private int commandesLast = 10; // Default value

    public int getCommandesLast() {
        return commandesLast;
    }

    public void setCommandesLast(int commandesLast) {
        if (commandesLast < 1) {
            throw new IllegalArgumentException("commandesLast must be greater than 0");
        }
        this.commandesLast = commandesLast;
    }
}
