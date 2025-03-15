package com.erolkocoglu.exercises.student_system;

import com.erolkocoglu.exercises.student_system.controller.LoginRegisterController;

public class Project {
    public static void main(String[] args) {
        LoginRegisterController controller = new LoginRegisterController();
        controller.login();
    }
}
