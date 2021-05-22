package com.example.person.repository;

import com.example.person.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
public interface PhoneRepository extends JpaRepository<Phone, Long> {
}
