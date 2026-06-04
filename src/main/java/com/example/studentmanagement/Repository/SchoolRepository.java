package com.example.studentmanagement.Repository;

import com.example.studentmanagement.Entity.SchoolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<SchoolEntity,Integer> {
    SchoolEntity findBySchoolname(String schoolName);

}

