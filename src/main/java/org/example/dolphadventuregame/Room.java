package org.example.dolphadventuregame;

import jakarta.persistence.*;

import java.util.HashMap;
import java.util.Map;

@Entity
public class Room {

    //coordinates for the room in the map
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int x;
    private int y;
    private String name;


    @ElementCollection
    @CollectionTable(name = "room_connections", joinColumns = @JoinColumn(name = "room_id"))
    @MapKeyColumn(name = "direction")
    @Column(name ="connected_room_id")
    private Map<String, Integer> connection = new HashMap<>();

    public Room() {

    }

    public Room(String name, int x, int y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addConnection(String direction, Integer integer) {
        connection.put(direction, integer);
    }

    public Integer getConnection(String direction) {
        return connection.get(direction);
    }

    public Map<String, Integer> getConnections() {
        return connection;
    }
}
