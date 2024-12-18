package com.example.Trufbooking.controller;
import com.example.Trufbooking.entity.admintable;
import com.example.Trufbooking.service.adminfunservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/turf")
public class adminfuncontroller {

    @Autowired
    private adminfunservice adminService;

    // Add a new turf
    @PostMapping("/addTurf")
    public ResponseEntity<admintable> addTurf(@RequestBody admintable turf) {
        return ResponseEntity.ok(adminService.addTurf(turf));
    }



    // Update a turf
    @PutMapping("/update-turf/{turfid}")
    public ResponseEntity<admintable> updateTurf(@PathVariable Integer turfid, @RequestBody admintable turf) {
        admintable updatedTurf = adminService.updateTurf(turfid, turf);
        if (updatedTurf != null) {
            return ResponseEntity.ok(updatedTurf);
        }
        return ResponseEntity.notFound().build();
    }

    // Fetch turfs by location and sports
    @GetMapping("/getturfs/{location}/{sports}")
    public ResponseEntity<List<admintable>> getTurfsByLocationAndSports(
            @PathVariable String location, @PathVariable String sports) {
        return ResponseEntity.ok(adminService.getTurfsByLocationAndSports(location, sports));
    }

    @DeleteMapping("/remove-turf/{turfid}")
    public ResponseEntity<Void> removeTurf(@PathVariable Integer turfid) {
        boolean isRemoved = adminService.removeTurf(turfid);
        if (isRemoved) {
            return ResponseEntity.noContent().build();  // Turf removed successfully
        } else {
            return ResponseEntity.notFound().build();   // Turf not found
        }
    }
}
