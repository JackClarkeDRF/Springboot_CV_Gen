package org.example.repository;

import org.example.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * This is a Repository for the Skill Object. It extends the JpaRepository Class which is used to perform
 * CRUD operation on the Skill Object.
 *
 * The ID for Skill is the 'email' which is a string.
 */

@Repository
public interface SkillRepository extends JpaRepository<Skill, String> {
}
