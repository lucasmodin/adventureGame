package org.example.dolphadventuregame.controller;


import org.example.dolphadventuregame.Room;
import org.example.dolphadventuregame.SeededDungeonGenerator;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/dungeon")
public class DungeonController {

    private SeededDungeonGenerator dungeonGenerator;
    private Map<Point, Room> currentDungeon;
    private Point playerPosition;


    public DungeonController() {
        this.dungeonGenerator = new SeededDungeonGenerator(50);
        this.currentDungeon = dungeonGenerator.generateDungeon();
        this.playerPosition = new Point(0, 0);
    }

    @PostMapping("/generate")
    public Map<Point, Room> generateDungeon(@RequestParam int seed) {
        dungeonGenerator = new SeededDungeonGenerator(seed);
        currentDungeon = dungeonGenerator.generateDungeon();
        playerPosition = new Point(0, 0);
        return currentDungeon;
    }

    @GetMapping("/layout")
    public Map<Point, Room> getDungeonLayout() {
        return currentDungeon;
    }

    @GetMapping("/room/{x}/{y}")
    public Optional<Room> getRoom(@PathVariable int x, @PathVariable int y) {
        return Optional.ofNullable(currentDungeon.get(new Point(x, y)));
    }
}
