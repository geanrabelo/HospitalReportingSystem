package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.PatientCreationDTO;
import com.br.infrastructure.dto.PatientDetailsDTO;
import com.br.infrastructure.services.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hrs/patient")
public class PatientController {

    private final PatientService patientService;

    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> create(@RequestBody PatientCreationDTO patientCreationDTO) {
        URI uri = patientService.create(patientCreationDTO);

        return ResponseEntity.created(uri).body(new MessageDTO("Patient registered sucessfully"));
    }

    @GetMapping
    public ResponseEntity<List<PatientDetailsDTO>> findAll(){
        return ResponseEntity.ok(patientService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<PatientDetailsDTO> findById(@RequestParam(value = "patientId") Long patientId){
        return ResponseEntity.ok(patientService.findByPatientId(patientId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteById(@RequestParam(value = "patientId") Long patientId){
        patientService.deleteByPatientId(patientId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<PatientDetailsDTO> update(@RequestParam(value = "patientId") Long patientId, @RequestBody PatientCreationDTO patientCreationDTO){
        return ResponseEntity.ok(patientService.update(patientId, patientCreationDTO));
    }
}
