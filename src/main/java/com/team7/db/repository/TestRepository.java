package com.team7.db.repository;
import com.team7.model.Test;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepository extends JpaRepository<Test, Long> {
    Test findTestById(Long id);

}
