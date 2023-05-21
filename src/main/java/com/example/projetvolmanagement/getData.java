package com.example.projetvolmanagement;


public class getData {
    public static String login_username;
    public static String path;
    private static String role;

    public static void setRole(String newRole) {
        role = newRole;
    }

    public static String getRole() {
        return role;
    }
}
