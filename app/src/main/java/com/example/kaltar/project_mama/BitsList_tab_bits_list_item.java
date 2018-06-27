package com.example.kaltar.project_mama;

public class BitsList_tab_bits_list_item {
    private String name, faction,type;
    private int quantity;

    public BitsList_tab_bits_list_item(String bit_name, int bit_quantity, String faction_name, String bit_type) {
        this.name = bit_name;
        this.type = bit_type;
        this.quantity = bit_quantity;
        this.faction = faction_name;
    }

    public String get_name() {
        return name;
    }

    public int get_quantity() {
        return quantity;
    }

    public String get_faction() {
        return faction;
    }

    public String get_type(){
        return type;
    }

    //number peut être négatif
    public void set_quantity(int number) {
        this.quantity += number;
    }
}
