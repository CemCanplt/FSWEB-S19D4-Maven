package com.workintech.s19d1.service;

import com.workintech.s19d1.entity.Actor;

import java.util.List;

public interface ActorService {
    // Buraya servis fonksiyonlarını yazabilirsin.
    // Repository'de yazdıklarını buraya getirmeni öneririm.

    // CRUD Operasyonları

    // Read: Tüm Actor Entity'lerini getir
    List<Actor> findAll();

    // Read: Belirli bir ID'ye sahip Actor'u getir
    // Optional kullanmak, Actor bulunamazsa null yerine boş bir Optional dönmemizi sağlar.
    // Actor ID'sinin Long olduğunu varsayıyoruz
    Actor findById(long id);

    // Create / Update: Yeni bir Actor kaydet veya var olanı güncelle
    // Spring Data JPA'nın save metodu ID varsa günceller, yoksa yeni kaydeder.
    Actor save(Actor instanceOfActor);

    // Delete: Belirli bir ID'ye sahip Actor öğesini sil
    // Actor ID'sinin Long olduğunu varsayıyoruz
    Actor delete(Actor actor);
}
