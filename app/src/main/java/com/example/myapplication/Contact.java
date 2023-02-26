package com.example.myapplication;

public class Contact {
    private int id;
    private String name;
    private String phone;
    private String image;

    private boolean checked;

    public Contact() {
    }

    public Contact(int id, String name, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Contact(int i, String name, String phone, String image) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.image = image;
        this.checked = false;
    }

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }
}
