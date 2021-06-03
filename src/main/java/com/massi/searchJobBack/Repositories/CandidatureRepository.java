package com.massi.searchJobBack.Repositories;

import com.massi.searchJobBack.Entities.Candidature;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CandidatureRepository extends CrudRepository<Candidature, Long> {

    @Query(value = "SELECT c.* FROM candidature c WHERE LOWER(c.titre_offre) LIKE %:ch% OR LOWER(c.company_name) LIKE %:ch%" +
            " OR LOWER(c.lieu) LIKE %:ch% ;", nativeQuery = true)
    public List<Candidature> findByMultCritera(@Param("ch") String ch);
}
