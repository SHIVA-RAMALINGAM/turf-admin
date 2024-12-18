package com.example.Trufbooking.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Blob;

@Data
@Entity
@Table(name = "admintable")
public class admintable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "turfid", nullable = false)
    private int turfid;

    @Column(name = "turfname", nullable = false, length = 100)
    private String turfname;

    @Column(name = "location", nullable = false, length = 100)
    private String location;

    @Column(name = "mobilenumber", nullable = false)
    private long mobilenumber;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "sports", columnDefinition = "JSON", nullable = true)
    private String sports; // Storing as JSON string in the database

    @Column(name = "width", nullable = false)
    private double width;

    @Column(name = "breadth", nullable = false)
    private double breadth;

    @Lob
    @Column(name = "image", nullable = true)
    private Blob image;
}
