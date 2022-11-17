package com.tyy.jpa.person;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface PersonRepository extends JpaRepository<PersonEntity, Integer> {


    @Modifying
    @Query(value = "update person set age =?1 where id =?2", nativeQuery = true)
    void updateStatus(Integer age, Integer id);

}
