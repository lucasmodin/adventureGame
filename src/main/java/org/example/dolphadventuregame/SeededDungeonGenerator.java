package org.example.dolphadventuregame;
import java.util.*;
import java.awt.Point;


public class SeededDungeonGenerator {
    public final int MAX_ROOMS = 20;
    private final Map<Point, Room> grid = new HashMap<>();
    private final Random random;
    private int roomCount = 0;

    public SeededDungeonGenerator(long seed) {
        this.random = new Random(seed);
    }

    public Map<Point, Room> generateDungeon() {
        grid.clear();

        Point startPoint = new Point(0, 0);
        Room startingRoom = new Room("Starting room", 0, 0);
        grid.put(startPoint, startingRoom);

        roomCount++;
        Point currentPosition = startPoint;

        while (roomCount < MAX_ROOMS) {
            Point nextPosition = getRandomAdjacentPosition(currentPosition);

            if (!grid.containsKey(nextPosition)) {
                Room newRoom = new Room("Room" + roomCount, nextPosition.x, nextPosition.y);
                grid.put(nextPosition, newRoom);

                connectRooms(currentPosition, nextPosition);

                currentPosition = nextPosition;
                roomCount++;
            }


        }
        return grid;
    }

    private void connectRooms(Point p1, Point p2) {
        Room room1 = grid.get(p1);
        Room room2 = grid.get(p2);

        if (p1.x == p2.x) { //for vertical movement
            if (p1.y > p2.y) { //here p2 is North of p1
                room1.addConnection("north", room2.getId());
                room2.addConnection("south", room1.getId());
            } else { //here p2 is south of p1
                room1.addConnection("south", room2.getId());
                room2.addConnection("north", room1.getId());
            }
        } else { //horizontal movement
            if (p1.x > p2.x) {
                room1.addConnection("west", room2.getId());
                room2.addConnection("east", room1.getId());
            } else {
                room1.addConnection("east", room2.getId());
                room2.addConnection("west", room1.getId());
            }
        }
    }


    private Point getRandomAdjacentPosition(Point current) {
        List<Point> possibleMoves = Arrays.asList(
            new Point(current.x, current.y -1), //north
            new Point(current.x, current.y + 1), //south
            new Point(current.x + 1, current.y), //east
            new Point(current.x - 1, current.y) //west
            );

        return possibleMoves.get(random.nextInt(possibleMoves.size()));
        }



        public void printDungeon(){
        for (Point p : grid.keySet()) {
            System.out.println("Room at ("+ p.x + ", " + p.y + ") -> " + grid.get(p).getName());
        }
        }

}
