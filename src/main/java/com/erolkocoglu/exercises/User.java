package com.erolkocoglu.exercises;

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

    public static void main(String[] args) {
        User u = new User();
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

        System.out.println("Surname: "+surnameToPrint);
    }
}
