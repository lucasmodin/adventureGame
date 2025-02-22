package org.example.dolphadventuregame;

import org.example.dolphadventuregame.repository.RoomRepository;
import org.springframework.stereotype.Component;

import java.awt.Point;
import java.util.HashMap;
import java.util.Map;


@Component
public class GameMap {


    private final RoomRepository roomRepository;
    private final Map<Point, Room> grid = new HashMap<>();

    public GameMap(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void loadFromDatabase() {
        grid.clear();
        for(Room room : roomRepository.findAll()) {
            grid.put(new Point(room.getX(), room.getY()), room);
        }
    }





}
