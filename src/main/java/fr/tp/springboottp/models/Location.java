package fr.tp.springboottp.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;

@Entity(name="locations")
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long location_id;

    private double latitude, longitude;
    private Timestamp location_date;

    @ManyToMany(mappedBy = "locations")
    private List<User> users;

    public Location() {
    }

    public Location(double latitude, double longitude, Timestamp location_date) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.location_date = location_date;
    }

    public long getLocation_id() {
        return location_id;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public Timestamp getLocation_date() {
        return location_date;
    }

    public List<User> getUsers() {
        return users;
    }
}
