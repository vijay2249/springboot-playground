package com.fia.f2.service;

import com.fia.f2.model.ContractDetails;
import com.fia.f2.model.Driver;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DriverService {


    private static List<Driver> drivers = new ArrayList<>();

    private static String generateRandomId(){
        /*generate random Id*/
        SecureRandom rand = new SecureRandom();
        return new BigInteger(64, rand).toString();
    }

    static {
        ContractDetails Seb1 = new ContractDetails("Redbull", "Horner", LocalDate.of(2009, 1, 1),LocalDate.of(2013, 11, 30));
        ContractDetails Seb2 = new ContractDetails("Redbull", "Horner", LocalDate.of(2015, 1, 1),LocalDate.of(2016, 11, 30));
        ContractDetails Seb3 = new ContractDetails("Ferrari", "Vassuer", LocalDate.of(2017, 1, 1), LocalDate.of(2020, 11, 25));


        ContractDetails lewis1 = new ContractDetails("McLaren", "Zak", LocalDate.of(2008, 1, 1), LocalDate.of(2010, 12, 25));
        ContractDetails lewis2 = new ContractDetails("Mercedes", "Toto", LocalDate.of(2011, 1, 1), LocalDate.of(2025, 12, 25));

        List<ContractDetails> lewisContracts = Arrays.asList(lewis1, lewis2);
        List<ContractDetails> SebContracts = Arrays.asList(Seb1, Seb2, Seb3);

        Driver lewis = new Driver("Lewis", "Mecerdes", 44, "Toto", false, lewisContracts, generateRandomId());
        Driver Sebastian = new Driver("Sebastian", "Ferrari", 5, "Vassuer", true, SebContracts, generateRandomId());

        drivers.add(lewis);
        drivers.add(Sebastian);
    }

    public List<Driver> getAllDrivers() {
        return drivers;
    }

    public Driver getDriverByName(String name) {
        Optional<Driver> optionalDriver = drivers.stream().filter(driver -> driver.getDriverName().equalsIgnoreCase(name)).findFirst();
//        return optionalDriver.orElse(null);
        if(optionalDriver.isEmpty()) return null;
        return optionalDriver.get();
    }

    public List<ContractDetails> getDriverCareer(String name) {
        Driver driver = this.getDriverByName(name);
        if(driver == null) return null;
        return driver.getCareer();
    }

    public List<ContractDetails> getDriverCareerWithTeam(String name, String teamName) {
        Driver driver = this.getDriverByName(name);
        if(driver == null) return null;
        List<ContractDetails> career = driver.getCareer();
        return career.stream().filter(contractDetails -> contractDetails.getTeamName().equalsIgnoreCase(teamName)).collect(Collectors.toList());
    }

    public ResponseEntity<Object> updateDriverCareer(String name, ContractDetails contractDetails) {
        String teamName = contractDetails.getTeamName();
        List<ContractDetails> career = this.getDriverCareerWithTeam(name, teamName);
        if(career.isEmpty()){
            List<ContractDetails> driverCareer = new ArrayList<>(getDriverCareer(name));
            driverCareer.add(contractDetails);
            getDriverByName(name).setCareer(driverCareer);
        }
        return ResponseEntity.created(null).build();
    }

    public String addNewDriver(Driver driver) {
        driver.setId(generateRandomId());
        drivers.add(driver);
        return driver.getId();
    }

    public boolean deleteDriverByName(String name) {
        Driver driver_ = getDriverByName(name);
        if(driver_ == null) return false;
        return drivers.remove(driver_);
//        return drivers.removeIf(driver -> driver.getDriverName().equalsIgnoreCase(name));
    }

    public void updateDriverByName(String name, Driver driver) {
//        Driver driver1 = getDriverByName(name);
        deleteDriverByName(name);
        addNewDriver(driver);
    }
}
