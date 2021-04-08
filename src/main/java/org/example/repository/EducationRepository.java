package org.example.repository;

import org.example.model.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a Repository for the Education Object. It extends the JpaRepository Class which is used to perform
 * CRUD operation on the Education Object.
 *
 * The ID for Education is the 'email' which is a string.
 */

@Repository
public interface EducationRepository extends JpaRepository<Education, String> {
}
