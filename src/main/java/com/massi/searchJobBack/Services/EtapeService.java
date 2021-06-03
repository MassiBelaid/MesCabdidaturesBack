package com.massi.searchJobBack.Services;


import com.massi.searchJobBack.Entities.Etape;
import com.massi.searchJobBack.Repositories.EtapeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EtapeService {

    @Autowired
    private EtapeRepository etapeRepository;

    public Etape editEtape(Etape etape) {
        return this.etapeRepository.save(etape);
    }

    public void deleteEtape(Long id) {
        this.etapeRepository.deleteById(id);
    }
}
