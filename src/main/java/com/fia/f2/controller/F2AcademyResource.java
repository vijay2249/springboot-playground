package com.fia.f2.controller;

import com.fia.f2.model.ContractDetails;
import com.fia.f2.model.Driver;
import com.fia.f2.service.DriverService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
public class F2AcademyResource {

    private DriverService driverService;

    public F2AcademyResource(DriverService driverService){
        this.driverService = driverService;
    }

    // GET - /drivers
    @RequestMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    //POST - /drivers/new
    @PostMapping("/drivers/new")
    public ResponseEntity<Object> addNewDriver(@RequestBody Driver driver){
        String id = driverService.addNewDriver(driver);
//        URI location =
        return ResponseEntity.created(null).build();
    }

    //DELETE -/driver/{name}
    @DeleteMapping("/drivers/{name}")
    public ResponseEntity<Object> deleteDriverByName(@PathVariable String name){
        if(!driverService.deleteDriverByName(name)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.noContent().build();
    }

    //PUT - /driver/{name}
    @PutMapping("/drivers/{name}")
    public ResponseEntity<Object> updateDriverByName(@PathVariable String name, @RequestBody Driver driver){
        driverService.updateDriverByName(name, driver);
        return ResponseEntity.ok().build();
    }

    // GET - /drivers/{name}
    @RequestMapping("/drivers/{name}")
    public Driver getDriverByName(@PathVariable String name){
        Driver driver = driverService.getDriverByName(name);
        if(driver == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return driver;
    }

    //GET - /drivers/{name}/career
    @RequestMapping("/drivers/{name}/career")
    public List<ContractDetails> getDriverCareer(@PathVariable String name){
        List<ContractDetails> career = driverService.getDriverCareer(name);
        if(career == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return career;
    }

    //GET - /drivers/{name}/career/{teamName}
    @RequestMapping("/drivers/{name}/career/{teamName}")
    public List<ContractDetails> getDriverCareerWithTean(@PathVariable String name, @PathVariable String teamName){
        List<ContractDetails> career = driverService.getDriverCareerWithTeam(name, teamName);
        if(career == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return career;
    }

    //POST - /drivers/{name}/career
    @PostMapping("/drivers/{name}/career")
    public boolean updateDriverCareer(@PathVariable String name, @RequestBody ContractDetails contractDetails){
        driverService.updateDriverCareer(name, contractDetails);

//        if(!isUpdated) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return true;
    }

}


/*
APIs to create
	GET /drivers - done
	GET /drivers/{name} - done

	GET /drivers/{name}/career - done

	GET /drivers/{name}/career/{teamName} - done

	POST /drivers/{name}/carrer
	DELETE /drivers/{name}/carrer/{teamName}
	PUT /drivers/{name}
	PUT /drivers/{name}/career/{teamName}
 */