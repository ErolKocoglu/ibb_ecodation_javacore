package com.erolkocoglu.exercises.week5;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

// Java Record Kullanımı
// Extends yapamazsınız. Import
public record StudentRecord(
        Integer id,
        String name,
        String surname,
        EStudentType eStudentType, // Enum Öğrenci Türü
        Double midTerm,      // Vize notu
        Double finalTerm,    // Final notu
        Double resultTerm,   // Sonuç Notu: (Vize%40 + Final%60)
        LocalDate birthDate, // Doğum günü
        Date createdDate     // Sistem otomatik tarihi
) implements Serializable {

    // Serileştirme
    private static final long serialVersionUID = 5563646556456565465L;

    // Constructor (Vize ve Final notuna göre otomatik result hesaplama)
    public StudentRecord(Integer id, String name, String surname, Double midTerm, Double finalTerm, LocalDate birthDate, EStudentType eStudentType) {
        this(id, name, surname, eStudentType, midTerm, finalTerm, calculateResult(midTerm, finalTerm), birthDate, new Date(System.currentTimeMillis()));
    }

    // Not hesaplama metodu
    private static Double calculateResult(Double midTerm, Double finalTerm) {
        if (midTerm == null || finalTerm == null) return 0.0;
        return (midTerm * 0.4 + finalTerm * 0.6);
    }
}
