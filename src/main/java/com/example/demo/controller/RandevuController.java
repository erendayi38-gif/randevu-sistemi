package com.example.demo.controller;

import com.example.demo.model.Randevu;
import com.example.demo.repository.RandevuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Controller
public class RandevuController {

    @Autowired
    private RandevuRepository randevuRepository;

    // 1. Ana Sayfa: Randevu Listesi
    @GetMapping("/")
    public String anaSayfa(Model model) {
        List<Randevu> randevular = randevuRepository.findAll();
        model.addAttribute("randevular", randevular);
        return "liste"; // liste.html sayfasına git
    }

    // 2. Yeni Randevu Formu
    @GetMapping("/randevu-al")
    public String randevuFormu(Model model) {
        model.addAttribute("randevu", new Randevu());
        return "randevu-al"; // randevu-al.html sayfasına git
    }

    // 3. Randevu Kaydetme
    @PostMapping("/kaydet")
    public String randevuKaydet(@ModelAttribute Randevu randevu, Model model) {
        
        // Geçmiş tarih kontrolü
        if (randevu.getTarih().isBefore(LocalDate.now())) {
            model.addAttribute("hata", "Geçmiş tarihe randevu alamazsınız!");
            return "randevu-al";
        }

        // Çakışma kontrolü
        if (randevuRepository.existsByTarihAndSaat(randevu.getTarih(), randevu.getSaat())) {
            model.addAttribute("hata", "Bu tarih ve saatte başka bir randevu mevcuttur!");
            return "randevu-al";
        }

        randevuRepository.save(randevu);
        return "redirect:/";
    }

    // 4. Randevu İptal
    @GetMapping("/iptal/{id}")
    public String randevuIptal(@PathVariable Long id) {
        randevuRepository.deleteById(id);
        return "redirect:/";
    }

    // --- TEST METODU: Sorunun nerede olduğunu anlamak için ekledik ---
    @GetMapping("/test")
    @ResponseBody
    public String testMesaji() {
        return "<h1>Java Calisiyor!</h1><p>Eger bu yaziyi goruyorsan, Spring Boot projeni okuyor demektir. Beyaz ekranin sebebi HTML kütüphanesinin (Thymeleaf) yüklenmemesidir.</p>";
    }
}