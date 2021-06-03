package com.massi.searchJobBack.Controllers;


import com.massi.searchJobBack.Entities.Etape;
import com.massi.searchJobBack.Services.EtapeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
public class EtapeController {

    @Autowired
    private EtapeService etapeService;

    @PutMapping("etape")
    public @ResponseBody
    ResponseEntity editEtape(@RequestBody Etape etape) {
        return ResponseEntity.ok(etapeService.editEtape(etape));
    }

    @DeleteMapping("etape/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteEtape(@PathVariable Long id) {
        this.etapeService.deleteEtape(id);
    }
}
