package org.example.dolphadventuregame.repository;

import org.example.dolphadventuregame.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    Optional<Room> findByXAndY(int x, int y);
}
