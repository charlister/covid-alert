package fr.tp.springboottp.controllers;

import fr.tp.springboottp.models.Location;
import fr.tp.springboottp.models.User;
import fr.tp.springboottp.repositories.LocationRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/v1/locations")
public class LocationsController {
    @Autowired
    private LocationRepository locationRepository;

    @GetMapping
    public List<Location> list() {
        return locationRepository.findAll();
    }

    @GetMapping
    @RequestMapping("{id}")
    public Location get(@PathVariable Long id) {
        if(locationRepository.findById(id).isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Aucune localisation d'ID "+id);
        }
        return locationRepository.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Location create(@RequestBody final Location location) {
        return locationRepository.saveAndFlush(location);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        locationRepository.deleteById(id);
    }

    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Location update(@PathVariable Long id, @RequestBody Location location) {
        Location existingLocation = locationRepository.getById(id);
        BeanUtils.copyProperties(location, existingLocation, "location_id");
        return locationRepository.saveAndFlush(existingLocation);
    }
}
