package org.example.repository;

import org.example.model.CertOrAward;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is a Repository for the CertOrAward Object. It extends the JpaRepository Class which is used to perform
 * CRUD operation on the CertOrAward Object.
 *
 * The ID for CertOrAward is the 'email' which is a string.
 */

public interface CertOrAwardRepository extends JpaRepository<CertOrAward, String> {
}
