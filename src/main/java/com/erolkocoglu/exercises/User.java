package com.erolkocoglu.exercises;

import java.util.Scanner;

public class User {
    private String name;
    private String surname;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname.toUpperCase();
    }

    public static String removeAfterPunctuation(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (isPunctuation(str.charAt(i))) {
                return str.substring(0, i);
            }
        }
        return str;
    }

    public static boolean isPunctuation(char ch) {
        return ",.!?;:'\"()-[]{}<>@#$%^&*_+=/\\|`~".indexOf(ch) != -1;
    }

    public static void main(String[] args) {
        /*User u = new User();
        u.setName("Erol");
        u.setSurname("Koçoğlu");

        StringBuilder surnameToPrint = new StringBuilder(u.getSurname());
        int length = surnameToPrint.length();
        if(surnameToPrint.length()>3){
            surnameToPrint = new StringBuilder(surnameToPrint.substring(0, 3));
            for(int i=3;i<length;i++){
                surnameToPrint.append("*");
            }

        }

        System.out.println("Surname: "+surnameToPrint);*/
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        name=removeAfterPunctuation(name);
        System.out.println("Your name: " + name);
    }
}
