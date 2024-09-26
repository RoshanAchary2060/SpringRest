package com.rosan.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rosan.entity.Tourist;

public interface ITouristRepo extends JpaRepository<Tourist, Integer> {

}
