package com.erolkocoglu.exercises.student_system.controller;

import com.erolkocoglu.exercises.student_system.dao.RegisterDao;
import com.erolkocoglu.exercises.student_system.dao.StudentDao;
import com.erolkocoglu.exercises.student_system.dao.TeacherDao;
import com.erolkocoglu.exercises.student_system.dto.RegisterDto;
import com.erolkocoglu.exercises.utils.SpecialColor;

import java.util.Optional;
import java.util.Scanner;

public class LoginRegisterController {
    // Field
    private final RegisterDao registerDao;
    private final StudentDao studentDao;
    private final TeacherDao teacherDao;
    private final StudentController studentController;
    private final TeacherController teacherController;
    private final Scanner scanner;

    // Constructor
    public LoginRegisterController() {
        registerDao = new RegisterDao();
        studentDao = new StudentDao();
        teacherDao = new TeacherDao();
        studentController = new StudentController();
        teacherController = new TeacherController();
        scanner = new Scanner(System.in);
    }

    /// ///////////////////////////////////////////////////////////
    // Role Method
    public void isUserRole(RegisterDto registerDto) {
        if (registerDto.getRole().equalsIgnoreCase("STUDENT")) {
            studentController.chooise();
        } else if (registerDto.getRole().equalsIgnoreCase("TEACHER")) {
            teacherController.chooise();
        } else if (registerDto.getRole().equalsIgnoreCase("ADMIN")) {
            System.out.println("ADMIN SAYFASINA HOŞGELDİNİZ");
        } else {
            System.out.println("Yetkilendirilme yapılmamıştır lütfen admine başvurunuz. tel: 111-11-11-11");
        }
    }

    /// LOGIN
    public void login() {
        while (true) {
            System.out.println("\n==== GİRİŞ EKRANI ====");
            String email, password, nickname;

            System.out.println("Email adresiniz");
            email = scanner.nextLine().trim();

            System.out.println("Nickname adresiniz");
            email = scanner.nextLine().trim();

            System.out.println("Şifreniz");
            password = scanner.nextLine().trim();

            // Email var mı yok mu ?
            Optional<RegisterDto> findIsEmail = registerDao.findByEmail(email);
            if (findIsEmail.isPresent()) {

                // user bilgileri al
                RegisterDto user = findIsEmail.get();

                // Şifre doğrulama
                if (user.validatePassword(password)) {
                    System.out.println(SpecialColor.GREEN + "Başarıyla giriş yaptınız " + SpecialColor.RESET + SpecialColor.BLUE + "Hoşgeldiniz" + email + SpecialColor.RESET);
                    // Kullanıcı rolüne göre ilgili sayfaya yönlendirmek
                    isUserRole(user);
                    break;
                } else {
                    System.out.println("Hata: Kullanıcı adı veya şifre yanlış");
                    // 3 kez yanlış girme hakkı olsun
                }
            } else {
                System.out.println("Kullanıcı bulunamadı Önce Kayıt olmalısınız");
                register();
            }
        }
    }

    /// REGISTER
    private void register() {
    }

}
