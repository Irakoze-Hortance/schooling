package com.example.schooling.repositories;

import com.example.schooling.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long> {
    //query by dynamic finders
    List<Student> findBFirstName(String firstName);
    List<Student> findByFirstNameAndLastName(String firstName,String lastName);
    List<Student> findByFirstNameOrLastName(String firstName,String lastName);

    //query by sql
    @Query(value = "select * from student stb where stb.firstNAme=:firstName and stb.lastName=:lastName")
    List<Student> findByFirstNameAndLastNameHQL(String firstName,String lastName);
    @Query(value = "select * from student stb where  stb.first_name=:firstNameParam and stb.last_name=lastNameParam" , nativeQuery=true)
    List<Student> findByFirstNameAndLastNameSQL(@Param("firstNameParam")  String firstName, @Param("lastNameParam") String lastName);
}
