package de.dirty.util;

import de.dirty.shop.ShopItems;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Team implements Serializable {
    private List<ShopItems> shopItems = new ArrayList<>();
    private List<String> member;
    private String name;
    private int balance;

    public Team(String name) {
        this.name = name;
    }

    public List<ShopItems> getShopItems() {
        return shopItems;
    }

    public void setShopItems(List<ShopItems> shopItems) {
        this.shopItems = shopItems;
    }

    public List<String> getMember() {
        return member;
    }

    public void setMember(List<String> member) {
        this.member = member;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
