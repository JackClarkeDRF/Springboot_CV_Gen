package org.example.repository;

import org.example.model.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * This is a Repository for the BasicInfo Object. It extends the JpaRepository Class which is used to perform
 * CRUD operation on the BasicInfo Object.
 *
 * The ID for BasicInfo is the 'email' which is a string.
 */

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfo, String> {

@Query("SELECT count(u) From BasicInfo u")
    public long countAll();


public List<BasicInfo> findAll();


}
