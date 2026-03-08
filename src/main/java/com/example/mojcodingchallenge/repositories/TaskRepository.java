package com.example.mojcodingchallenge.repositories;

import com.example.mojcodingchallenge.entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}
