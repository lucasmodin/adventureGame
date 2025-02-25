package org.example.dolphadventuregame;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DolphAdventureGameApplication {

    public static void main(String[] args) {
        SpringApplication.run(DolphAdventureGameApplication.class, args);
        int seed = 50;
        SeededDungeonGenerator generator = new SeededDungeonGenerator(seed);
        generator.generateDungeon();
        generator.printDungeon();
    }

}
