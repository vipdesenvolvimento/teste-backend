package com.vipdev.backend.controller;

import com.vipdev.backend.model.Lead;
import com.vipdev.backend.response.Erro;
import com.vipdev.backend.service.LeadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/leads")
public class LeadController {
    @Autowired
    private LeadService leadsService;

    @GetMapping("")
    public List<Lead> allLeads(){
        return leadsService.findAll();
    }

    @GetMapping("sort/name")
    public List<Lead> allLeadsOrderName(){
        List<Lead> leads =leadsService.findAll();

        // Orderna por Nome
        Collections.sort(leads, new Comparator<Lead>() {
            @Override
            public int compare(Lead l1, Lead l2) {
                return l1.getNome().toLowerCase(Locale.ROOT).compareTo(l2.getNome().toLowerCase(Locale.ROOT));
            }
        });

        return leads;
    }

    @GetMapping("sort/lastname")
    public List<Lead> allLeadsOrderLastName(){
        List<Lead> leads =leadsService.findAll();
        // Orderna por Sobrenome
        Collections.sort(leads, new Comparator<Lead>() {
            @Override
            public int compare(Lead l1, Lead l2) {
                return l1.getSobrenome().toLowerCase().compareTo(l2.getSobrenome().toLowerCase());
            }
        });

        return leads;
    }

    @PostMapping("")
    public ResponseEntity<?> newLead(@RequestBody Lead lead){
        String telefone = lead.getTelefone();
        if(telefone.length() < 10){
            return ResponseEntity.badRequest().body(new Erro("Telefone invalido", 401));
        }
        try{
            Lead resposta = leadsService.CreateLead(lead);
            return ResponseEntity.ok(lead);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new Erro(e.getMessage(), 500));
        }
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable int id){
        if(leadsService.exists(id)){

            try{
                Lead lead = leadsService.getById(id);
                if(lead == null){
                    return ResponseEntity.notFound().build();
                }else{
                    return ResponseEntity.ok(lead);
                }
            } catch (HttpMessageNotWritableException e){
                return ResponseEntity.notFound().build();
            } catch (Exception e){
                return ResponseEntity.notFound().build();
            }
        }else{
            return ResponseEntity.notFound().build();
        }
    }


    @PutMapping("{id}")
    public ResponseEntity<?> updateLead(@PathVariable int id, @RequestBody Lead lead){
        try{
            String telefone = lead.getTelefone();
            if(telefone.length() < 10){
                return ResponseEntity.badRequest().body(new Erro("Telefone invalido", 401));
            }
            if(lead.getNome().length()<3){
                return ResponseEntity.badRequest().body(new Erro("Nome invalido", 401));
            }
            if(lead.getSobrenome().length()<3){
                return ResponseEntity.badRequest().body(new Erro("Sobrenome invalido", 401));
            }
            lead.setId(id);
            Lead resposta = leadsService.CreateLead(lead);
            return ResponseEntity.ok(resposta);

        }catch (Exception e){
            return ResponseEntity.badRequest().body(new Erro(e.getMessage(), 500));
        }
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteLead(@PathVariable int id){
        try {
            leadsService.deleteLead(id);
            return ResponseEntity.ok().build();
        }catch (EmptyResultDataAccessException e){
            return ResponseEntity.badRequest().body(new Erro("Id não existe", 404));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(new Erro(e.getMessage(), 500));
        }
    }
}
