package com.keskin.model;

public enum Roles {
    ADMIN("Admin"),
    USER("User");

    private final String role;

    Roles(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String toString() {
        return "Roles{" +
                "role='" + role + '\'' +
                '}';
    }
}
