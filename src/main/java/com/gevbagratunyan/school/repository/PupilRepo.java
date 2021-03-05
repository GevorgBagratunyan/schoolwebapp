package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.models.Pupil;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PupilRepo extends JpaRepository<Pupil,Long> {
}
