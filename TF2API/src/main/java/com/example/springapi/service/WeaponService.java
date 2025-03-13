package com.example.springapi.service;


import com.example.springapi.api.model.User;
import com.example.springapi.api.model.Weapon;
import com.example.springapi.api.repository.WeaponRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WeaponService {


    private List<Weapon> weaponList;
    @Autowired
    private WeaponRepository weaponRepository;

    public WeaponService() {
    }

    public void addWeapon(Weapon weapon){
        weaponRepository.save(weapon);
    }

    public boolean deleteWeaponByName(String name) {
        if(weaponRepository.existsByName(name)){
            weaponRepository.deleteByName(name);
            return true;
        }

        return false;
    }


    public Optional<Weapon> getWeapon(String name) {

        Optional<Weapon> optional = Optional.empty();

        return weaponRepository.findByName(name);
    }
}
