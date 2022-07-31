package com.vipdev.backend.service;

import com.vipdev.backend.model.Lead;
import com.vipdev.backend.repository.LeadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {

    @Autowired
    private LeadRepository leadsRepository;

    public List<Lead> findAll(){
        var it = leadsRepository.findAll();
        var leads = new ArrayList<Lead>();
        it.forEach(e -> leads.add(e));
        return leads;
    }


    public Lead CreateLead(Lead lead){
        return leadsRepository.save(lead);
    }

    public Lead getById(int id){
        return leadsRepository.findById(id).get();
    }

    public boolean exists(int id){
        return leadsRepository.existsById(id);
    }

    public void deleteLead(int id){
        leadsRepository.deleteById(id);
    }

}
