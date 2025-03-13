package com.example.springapi.api.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Weapon")
public class Weapon {

    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private String type;
    @Column
    private String damage;
    @Column
    private String image;
    @Column
    private String weaponclass;

    public Weapon(int id, String name, String description, String type, String damage, String image, String weaponclass) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.type = type;
        this.damage = damage;
        this.image = image;
        this.weaponclass = weaponclass;
    }

    public Weapon(){};

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public String getDamage() {
        return damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public String getWeaponclass() {
        return weaponclass;
    }
    public void setWeaponclass(String weaponclass) {
        this.weaponclass = weaponclass;
    }





}
