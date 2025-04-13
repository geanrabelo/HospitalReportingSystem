package com.br.infrastructure.controller;

import com.br.infrastructure.dto.ExamsCreationDTO;
import com.br.infrastructure.dto.ExamsDetailsDTO;
import com.br.infrastructure.dto.ExamsDetailsPatientDTO;
import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.services.ExamsService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/hrs/exams")
public class ExamsController {

    private final ExamsService examsService;

    public ExamsController(ExamsService examsService){
        this.examsService = examsService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> save(@RequestBody ExamsCreationDTO examsCreationDTO){
        examsService.create(examsCreationDTO);

        URI uri = UriComponentsBuilder.fromPath("/hrs/exams").buildAndExpand().toUri();

        return ResponseEntity.created(uri).body(new MessageDTO("Exams registered sucessfully"));
    }

    @GetMapping
    public ResponseEntity<List<ExamsDetailsDTO>> findAll(){
        return ResponseEntity.ok(examsService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<ExamsDetailsDTO> findByExamId(@RequestParam(value = "examId") Long examId){
        return ResponseEntity.ok(examsService.findByExamId(examId));
    }

    @GetMapping("/patient")
    public ResponseEntity<List<ExamsDetailsPatientDTO>> findByPatientId(@RequestParam(value = "patientId") Long patientId){
        return ResponseEntity.ok(examsService.findByPatientId(patientId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByExamId(@RequestParam(value = "examId") Long examId){
        examsService.deleteByExamId(examId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ExamsDetailsDTO> update(@RequestParam(value = "examId") Long examId, @RequestBody ExamsCreationDTO examsCreationDTO){
        return ResponseEntity.ok(examsService.update(examId, examsCreationDTO));
    }
}
