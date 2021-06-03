package com.massi.searchJobBack.Controllers;

import com.massi.searchJobBack.Entities.Candidature;
import com.massi.searchJobBack.Entities.Etape;
import com.massi.searchJobBack.Exceptions.SearchJobNotExistingException;
import com.massi.searchJobBack.Services.CandidatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class CandidatureControllers {

    @Autowired
    private CandidatureService candidatureService;

    @PostMapping("candidature")
    public @ResponseBody ResponseEntity createCandidature(@RequestBody Candidature candidature) {
        return ResponseEntity.ok(candidatureService.saveCandidature(candidature));
    }

    @PutMapping("candidature")
    public @ResponseBody ResponseEntity editCandidature(@RequestBody Candidature candidature) {
        return ResponseEntity.ok(candidatureService.editCandidature(candidature));
    }

    @GetMapping("candidature")
    public @ResponseBody ResponseEntity findAllCandidatures() {
        return ResponseEntity.ok(candidatureService.findAllCantidatures());
    }

    @DeleteMapping("candidature/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteCandidature(@PathVariable Long id) {
        this.candidatureService.deleteCandidature(id);
    }

    @GetMapping("candidature/{id}")
    public @ResponseBody ResponseEntity getById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(candidatureService.findById(id));
        } catch (SearchJobNotExistingException e) {
            return ResponseEntity.status(e.getCode()).body(e.getMessage());
        }
    }

    @GetMapping("candidature/filter/{ch}")
    public @ResponseBody ResponseEntity filter(@PathVariable String ch) {
        return ResponseEntity.ok(candidatureService.findByMultiCritera(ch));
    }

    @PostMapping("candidature/{id}/etape")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public @ResponseBody ResponseEntity addEtape(@PathVariable Long id, @RequestBody Etape etape) {
        try {
            return ResponseEntity.ok(candidatureService.addEtape(id, etape));
        } catch (SearchJobNotExistingException e) {
            return ResponseEntity.status(e.getCode()).body(e.getMessage());
        }
    }
}
