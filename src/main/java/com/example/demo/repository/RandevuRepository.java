package com.example.demo.repository;

import com.example.demo.model.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface RandevuRepository extends JpaRepository<Randevu, Long> {
    
    // Senaryomuzdaki en kritik kontrol: Aynı tarih ve saatte kayıt var mı?
    // Spring Boot bu metodun isminden (existsBy...) ne yapması gerektiğini anlar.
    boolean existsByTarihAndSaat(LocalDate tarih, LocalTime saat);
}