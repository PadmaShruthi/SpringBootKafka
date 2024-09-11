package com.example.springboot.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springboot.kafka.entity.WikimediaData;

public interface WikimediaRepository extends JpaRepository<WikimediaData, Long> {
}
