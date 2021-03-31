package org.example.repository;

import org.example.model.CertOrAward;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertOrAwardRepository extends JpaRepository<CertOrAward, String> {
}
