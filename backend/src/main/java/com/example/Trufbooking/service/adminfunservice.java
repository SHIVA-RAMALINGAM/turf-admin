package com.example.Trufbooking.service;

import com.example.Trufbooking.entity.admintable;
import com.example.Trufbooking.repository.turfrepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class adminfunservice {

    @Autowired
    private turfrepo turfRepository;

    // Add a new turf
    public admintable addTurf(admintable turf) {
        // No validation for sports field as it's now a string in JSON format
        return turfRepository.save(turf);
    }

//    // Update a turf
//    public admintable updateTurf(Integer turfid, admintable updatedTurf) {
//        if (turfRepository.existsById(turfid)) {
//            updatedTurf.setTurfid(turfid);
//            return turfRepository.save(updatedTurf);
//        }
//        return null;
//    }

    // Update a turf
    public admintable updateTurf(Integer turfid, admintable updatedTurf) {
        // Check if the turf exists
        if (turfRepository.existsById(turfid)) {
            // Retrieve the existing turf entity from the database
            admintable existingTurf = turfRepository.findById(turfid).get();

            // Update the fields if they are not null
            if (updatedTurf.getTurfname() != null) {
                existingTurf.setTurfname(updatedTurf.getTurfname());
            }
            if (updatedTurf.getLocation() != null) {
                existingTurf.setLocation(updatedTurf.getLocation());
            }
            if (updatedTurf.getMobilenumber() != 0) {
                existingTurf.setMobilenumber(updatedTurf.getMobilenumber());
            }
            if (updatedTurf.getPrice() != 0) {
                existingTurf.setPrice(updatedTurf.getPrice());
            }
            if (updatedTurf.getSports() != null && !updatedTurf.getSports().isEmpty()) {
                existingTurf.setSports(updatedTurf.getSports());
            }

            // Save the updated turf object
            return turfRepository.save(existingTurf);
        }
        return null;  // Return null if turf doesn't exist
    }


    // Fetch turfs by location and sports
    public List<admintable> getTurfsByLocationAndSports(String location, String sports) {
        return turfRepository.findByLocationAndSports(location, sports);
    }

    public boolean removeTurf(Integer turfid) {
        // Logic to remove turf from database, for example:
        Optional<admintable> turf = turfRepository.findById(turfid);
        if (turf.isPresent()) {
            turfRepository.delete(turf.get());
            return true;  // Turf removed successfully
        }
        return false; // Turf not found
    }
}




















