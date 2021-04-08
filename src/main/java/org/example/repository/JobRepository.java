package org.example.repository;

import org.example.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a Repository for the Job Object. It extends the JpaRepository Class which is used to perform
 * CRUD operation on the Job Object.
 *
 * The ID for Job is the 'email' which is a string.
 */

@Repository
public interface JobRepository extends JpaRepository<Job, String> {
}
