package bts.sio.api.service;

import bts.sio.api.model.Epreuve;
import bts.sio.api.model.EpreuveAthlete;
import bts.sio.api.repository.EpreuveAthleteRepository;
import bts.sio.api.repository.EpreuveRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Data
@Service
public class EpreuveAthleteService {

    @Autowired
    private EpreuveAthleteRepository epreuveAthleteRepository;

    public Optional<EpreuveAthlete> getEpreuveAthlete(final Long id) {
        return epreuveAthleteRepository.findById(id);
    }

    public Iterable<EpreuveAthlete> getEpreuveAthletes() {
        return epreuveAthleteRepository.findAll();
    }

    public void deleteEpreuveAthlete(final Long id) {
        epreuveAthleteRepository.deleteById(id);
    }

}
