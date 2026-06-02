package com.example.studentmanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public class SchoolRepository {
    public interface SchoolRepsoitory extends JpaRepository{

    }
}
