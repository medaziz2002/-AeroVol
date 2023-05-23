package com.example.projetvolmanagement;


public class getData {
    public static String login_username;
    public static String path;
    private static String role;

    public static String email;

    public static Integer userId;

    public static void setRole(String newRole) {
        role = newRole;
    }

    public static String getRole() {
        return role;
    }


    public static void setUserId(Integer userId)
    {
        getData.userId=userId;
    }

    public static Integer getUserId()
    {
        return userId;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        getData.email = email;
    }


}
