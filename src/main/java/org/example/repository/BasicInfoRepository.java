package org.example.repository;

import org.example.model.BasicInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BasicInfoRepository extends JpaRepository<BasicInfo, String> {

   // @Query("SELECT u FROM BasicInfo u WHERE u.email = email")
   //List<BasicInfo> findBasicInfoByEmail(String email);

}
