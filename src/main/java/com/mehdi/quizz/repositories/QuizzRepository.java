package com.mehdi.quizz.repositories;

import com.mehdi.quizz.domain.entitites.Quizz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizzRepository extends JpaRepository<Quizz, Integer> {
}
