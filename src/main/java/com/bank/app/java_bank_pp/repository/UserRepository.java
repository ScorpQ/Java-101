package com.bank.app.java_bank_pp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bank.app.java_bank_pp.entity.User;

// JpaRepository sayesinde User tablosu için built-in CRUD işlemlerini yapabiliriz.
// save(), findById(), findAll(), deleteById(), delete() gibi işlemler yapabiliriz.
public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existsByEmail(String email);
    Boolean existsByAccountNumber(String accountNumber);
    User findByAccountNumber(String accountNumber);
}
