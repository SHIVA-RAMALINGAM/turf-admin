//package com.example.Trufbooking.repository;
//
//
//
//import com.example.Trufbooking.entity.Booking;
//import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
////public interface BookingRepository extends JpaRepository<Booking, Long> {
////    List<Booking> findByTurf_Id(Integer turfid);  // Find bookings by turf id
////}
//@Repository
//public interface BookingRepository extends JpaRepository<Booking, Long> {
//    List<Booking> findByTurf_Id(Integer turfid);
//}
package com.example.Trufbooking.repository;

import com.example.Trufbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Long> {
    // Query to find bookings by turfid (id of the turf)
    List<Booking> findByTurf_Turfid(Integer turfid);
}
