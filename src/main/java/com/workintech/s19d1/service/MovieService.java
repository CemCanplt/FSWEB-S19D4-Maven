package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Movie;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    // Buraya servis fonksiyonlarını yazabilirsin.
    // Repository'de yazdıklarını buraya getirmeni öneririm.

    // CRUD Operasyonları

    // Read: Tüm Movie Entity'lerini getir
    List<Movie> findAll();

    // Read: Belirli bir ID'ye sahip Movie'u getir
    // Optional kullanmak, Movie bulunamazsa null yerine boş bir Optional dönmemizi sağlar.
    // Movie ID'sinin Long olduğunu varsayıyoruz
    Movie findById(long id);

    // Create / Update: Yeni bir Movie kaydet veya var olanı güncelle
    // Spring Data JPA'nın save metodu ID varsa günceller, yoksa yeni kaydeder.
    Movie save(Movie instanceOfMovie);

    // Delete: Belirli bir ID'ye sahip Movie öğesini sil
    // Movie ID'sinin Long olduğunu varsayıyoruz
    Movie delete(Movie movie);
}
