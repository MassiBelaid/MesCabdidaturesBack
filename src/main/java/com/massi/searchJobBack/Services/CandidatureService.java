package com.massi.searchJobBack.Services;

import com.massi.searchJobBack.Entities.Candidature;
import com.massi.searchJobBack.Entities.Etape;
import com.massi.searchJobBack.Exceptions.SearchJobNotExistingException;
import com.massi.searchJobBack.Repositories.CandidatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CandidatureService {

    @Autowired
    private CandidatureRepository candidatureRepository;

    public Iterable<Candidature> findAllCantidatures() {
        return this.candidatureRepository.findAll();
    }

    public Candidature saveCandidature(Candidature candidature) {
        Date date = new Date();
        candidature.setCandidatureDate(date);
        Etape etape = new Etape("Candidature" , "envoie CV", date);
        candidature.addEtape(etape);
        return this.candidatureRepository.save(candidature);
    }

    public Candidature editCandidature(Candidature candidature) {
        return this.candidatureRepository.save(candidature);
    }

    public void deleteCandidature(Long id) {
        this.candidatureRepository.deleteById(id);
    }

    public Candidature findById(Long id) throws SearchJobNotExistingException {
        Optional<Candidature> candidatureOpt = candidatureRepository.findById(id);

        if(!candidatureOpt.isPresent()) {
            throw new SearchJobNotExistingException(id.toString(), Candidature.class.getSimpleName(), "id");
        }

        return candidatureOpt.get();
    }

    public Candidature addEtape(Long id, Etape etape) throws SearchJobNotExistingException {
        Optional<Candidature> candidatureOpt = candidatureRepository.findById(id);

        if(!candidatureOpt.isPresent()) {
            throw new SearchJobNotExistingException(id.toString(), Candidature.class.getSimpleName(), "id");
        }
        Candidature candidature = candidatureOpt.get();

        etape.setDate(new Date());
        candidature.addEtape(etape);
        return this.candidatureRepository.save(candidature);
    }

    public List<Candidature> findByMultiCritera(String ch) {
        return this.candidatureRepository.findByMultCritera(ch.toLowerCase());
    }
}
