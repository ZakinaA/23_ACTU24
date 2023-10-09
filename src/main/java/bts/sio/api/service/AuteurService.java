package bts.sio.api.service;

import bts.sio.api.model.*;
import bts.sio.api.repository.AthleteRepository;
import bts.sio.api.repository.AuteurRepository;
import bts.sio.api.repository.SportRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class AuteurService {

    @Autowired
    private AuteurRepository auteurRepository;

    public Optional<Auteur> getAuteur(final Long id) {
        return auteurRepository.findById(id);
    }

    public Iterable<Auteur> getAuteurs() {
        return auteurRepository.findAll();
    }

    public void deleteAuteur(final Long id) {
        auteurRepository.deleteById(id);
    }

    public Auteur saveAuteur(Auteur auteur) {
        Auteur savedAuteur = auteurRepository.save(auteur);
        return savedAuteur;
    }
}
