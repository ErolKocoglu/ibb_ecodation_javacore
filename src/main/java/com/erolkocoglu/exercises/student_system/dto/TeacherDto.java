package com.erolkocoglu.exercises.student_system.dto;

import java.io.Serializable;
import java.time.LocalDate;

public record TeacherDto(
        Integer id,
        String name,// Adı
        String surname, //Soyadı
        LocalDate birthDate, //Doğum Tarihi
        //String subject, // Öğretmenin Uzmanlık Alanı Branşı
        ETeacherSubject subject, // Öğretmenin Uzmanlık Alanı Branşı
        int yearsOfExperience, // Öğretmenin toplam deneyim yılı
        boolean isTenured,  // Kadrolu mu? (true,false)
        double salary// Öğretmenin maaşı
) implements Serializable {

    // Varsayılan Constructorlar ile Veri doğrulaması
    public TeacherDto {
        if (id == null || id < 0) throw new IllegalArgumentException("ID negatif olamaz");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("İsim boş olamaz");
        if (surname == null || surname.isBlank()) throw new IllegalArgumentException("Soyisim boş olamaz");
        if (birthDate == null) throw new IllegalArgumentException("Doğum tarihi boş olamaz");
        if (subject == null ) throw new IllegalArgumentException("Uzmanlık alanı boş olamaz");
        if (yearsOfExperience < 0) throw new IllegalArgumentException("Deneyim yılı negatif olamaz");
        if (salary < 0) throw new IllegalArgumentException("Maaş negatif olamaz");
    }

    // Method
    public String fullName() {
        return id+ " "+ name + " " + surname+" "+salary+" "+yearsOfExperience;
    }

    public String experienceLevel() {
        return (yearsOfExperience > 10) ? "Kıdemli Öğretmen" : "Deneyimli Öğretmen";
    }

} // Record TeacherDto
