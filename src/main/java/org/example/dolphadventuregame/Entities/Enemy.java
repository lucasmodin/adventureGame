package org.example.dolphadventuregame.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Enemy extends BaseEntity {

    @Id
    //auto generates primary keys
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    public Enemy(){
        super();
    }

    public Enemy(String name, String description, int health,
                 int maxHealth, int strength, int agility,
                 int intelligence, int stamina, int wisdom) {
        super(name, description, health, maxHealth, strength, agility, intelligence, stamina, wisdom );
    }
}
