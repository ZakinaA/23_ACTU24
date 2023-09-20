package bts.sio.api.service;

import bts.sio.api.model.Sport;
import bts.sio.api.repository.SportRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class SportService {
    @Autowired
    private SportRepository sportRepository;

    public Optional<Sport> getSport(final Long id) {
        return sportRepository.findById(id);
    }

    public Iterable<Sport> getSports() {
        return sportRepository.findAll();
    }

    public void deleteSport(final Long id) {
        sportRepository.deleteById(id);
    }

    public Sport saveSport(Sport sport) {
        Sport savedSport = sportRepository.save(sport);
        return savedSport;
    }
}

