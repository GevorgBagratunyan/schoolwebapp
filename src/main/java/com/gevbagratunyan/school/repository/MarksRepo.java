package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.data.PupilYearMarks;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarksRepo extends JpaRepository<PupilYearMarks, Long> {
}
