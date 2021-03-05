package com.gevbagratunyan.school.repository;

import com.gevbagratunyan.school.entity.data.EmployeeBanking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankingRepo extends JpaRepository<EmployeeBanking, Long> {
}
