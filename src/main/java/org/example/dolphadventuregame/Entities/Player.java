package org.example.dolphadventuregame.Entities;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Player extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int experiencePoints;

    public Player() {
        super();
    }

    public Player(String name, String description, int health,
                  int maxHealth, int strength, int agility,
                  int intelligence, int stamina, int wisdom,
                  int experiencePoints ) {
        super(name, description, health, maxHealth, strength, agility, intelligence, stamina, wisdom);
        this.experiencePoints = experiencePoints;
    }
}
