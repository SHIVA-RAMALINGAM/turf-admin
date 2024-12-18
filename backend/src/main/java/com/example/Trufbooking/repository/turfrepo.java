package com.example.Trufbooking.repository;//package com.example.Trufbooking.repository;
//
//import com.example.Trufbooking.entity.admintable;
//
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public interface turfrepo extends JpaRepository<admintable, Integer> {
//
////    // Assuming 'sports' field is a JSON String, you might want to update this query accordingly.
////    List<admintable> findByLocationAndSportsContaining(String location, String sport);
//
////    @Query(value = "SELECT * FROM admintable a WHERE JSON_CONTAINS(a.sports, :sport, '$') AND a.location = :location", nativeQuery = true)
////    List<admintable> findByLocationAndSport(@Param("location") String location, @Param("sport") String sport);
////
////}
//
//    @Query("SELECT t FROM admintable t WHERE t.sports IN :sports AND t.location = :location")
//    List<admintable> findByLocationAndSports(@Param("location") String location, @Param("sports") List<String> sports);
//}
//package com.example.Trufbooking.repository;

import com.example.Trufbooking.entity.admintable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository
//public interface turfrepo extends JpaRepository<admintable, Integer> {
//
////    @Query("SELECT t FROM admintable t WHERE t.sports IN :sports AND t.location = :location")
////    List<admintable> findByLocationAndSports(@Param("location") String location, @Param("sports") List<String> sports);
////}
//@Repository
//public interface turfrepo extends JpaRepository<admintable, Integer> {
//
//    @Query("SELECT t FROM admintable t WHERE t.location = :location AND t.sports IN :sports")
//    List<admintable> findByLocationAndSports(@Param("location") String location,
//                                             @Param("sports") List<String> sports);
//}

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
//
//public interface turfrepo extends JpaRepository<admintable, Integer> {
//
//    @Query("SELECT t FROM admintable t WHERE t.location = :location AND t.sports LIKE %:sport%")
//    List<admintable> findByLocationAndSports(@Param("location") String location, @Param("sport") String sport);
//
//    boolean existsById(Integer id);
//}




import com.example.Trufbooking.entity.admintable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface turfrepo extends CrudRepository<admintable, Integer> {

    @Query(
            value = "SELECT * FROM admintable WHERE location = :location AND JSON_CONTAINS(sports, :sports)",
            nativeQuery = true
    )
    List<admintable> findByLocationAndSports(@Param("location") String location, @Param("sports") String sports);

}


