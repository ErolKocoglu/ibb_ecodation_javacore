package com.erolkocoglu.exercises.week5;

import java.util.Optional;

public class Optionals {
    public static void main(String[] args) {
        User user1 = new User("Ali", "ali@example.com");
        User user2 = new User("Veli", null);
        User user3 = null;
        System.out.println(getUserEmail(user1));
        System.out.println(getUserEmail(user2));
        System.out.println(getUserName(user3));
    }

    public static String getUserEmail(User user) {
        return Optional.ofNullable(user)
                .map(User::getEmail)
                .orElse("Email adresi bulunamadı");
    }

    public static String getUserName(User user) {
        return Optional.ofNullable(user)
                .map(u -> "Kullanıcı adı: " + u.getName())
                .orElse("Kullanıcı bilgisi bulunamadı");
    }
}

class User {
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }
}
