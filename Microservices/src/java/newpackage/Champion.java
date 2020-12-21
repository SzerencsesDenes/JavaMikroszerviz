/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

/**
 *
 * @author szere
 */
public class Champion {

    private String name;
    private String ability;
    private String description;
    private int damage;
    private String traits;

    
    public String getName() {
        return name;
    }

    public String getAbility() {
        return ability;
    }

    public String getDescription() {
        return description;
    }

    public int getDamage() {
        return damage;
    }

    public String getTraits() {
        return traits;
    }
    
    public void setName(String name) {
        this.name = name;
    }

    public void setAbility(String ability) {
        this.ability = ability;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setTraits(String traits) {
        this.traits = traits;
    }
    
    
}
