package org.example.dolphadventuregame.Entities;

import jakarta.persistence.MappedSuperclass;

//used for inheritance without creating a seperate table for the super class - still includes attributes in sub classes
@MappedSuperclass
public class BaseEntity {

    protected String name;
    protected String description;

    protected int health;
    protected int maxHealth;

    protected int strength;
    protected int agility;
    protected int intelligence;
    protected int stamina;
    protected int wisdom;

    public BaseEntity() {

    }

    public BaseEntity(String name, String description, int health, int maxHealth, int strength, int agility, int intelligence, int stamina, int wisdom) {

        this.name = name;
        this.description = description;
        this.health = health;
        this.maxHealth = maxHealth;
        this.strength = strength;
        this.agility = agility;
        this.intelligence = intelligence;
        this.stamina = stamina;
        this.wisdom = wisdom;
    }

    public BaseEntity(String name, String description) {
        this.name = name;
        this.description = description;
    }




    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    public int getStamina() {
        return stamina;
    }

    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    public int getWisdom() {
        return wisdom;
    }

    public void setWisdom(int wisdom) {
        this.wisdom = wisdom;
    }
}
