package com.br.infrastructure.controller;

import com.br.infrastructure.dto.MessageDTO;
import com.br.infrastructure.dto.ProfessionalCreationDTO;
import com.br.infrastructure.dto.ProfessionalDetailsDTO;
import com.br.infrastructure.services.ProfessionalService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hrs/professional")
public class ProfessionalController {

    private final ProfessionalService professionalService;

    public ProfessionalController(ProfessionalService professionalService){
        this.professionalService = professionalService;
    }

    @PostMapping
    public ResponseEntity<MessageDTO> save(@RequestBody @Valid ProfessionalCreationDTO professionalCreationDTO){
        var uri = professionalService.create(professionalCreationDTO);

        return ResponseEntity.created(uri).body(new MessageDTO("Professional registered sucessfully"));
    }

    @GetMapping
    public ResponseEntity<List<ProfessionalDetailsDTO>> findAll(){
        return ResponseEntity.ok(professionalService.findAll());
    }

    @GetMapping("/id")
    public ResponseEntity<ProfessionalDetailsDTO> findByProfessionalId(Long professionalId){
        return ResponseEntity.ok(professionalService.findByProfessionalId(professionalId));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteByProfessionalId(Long professionalId){
        professionalService.deleteByProfessionalId(professionalId);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<ProfessionalDetailsDTO> update(@RequestParam(value = "professionalId") Long professionalId, @RequestBody ProfessionalCreationDTO professionalCreationDTO){
        return ResponseEntity.ok(professionalService.update(professionalId, professionalCreationDTO));
    }
}
