package bts.sio.api.controller;

import bts.sio.api.model.EpreuveAthlete;
import bts.sio.api.service.EpreuveAthleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class EpreuveAthleteController {

    @Autowired
    private EpreuveAthleteService epreuveAthleteService;


    @GetMapping("/epreuveAthlete/{id}")
    public EpreuveAthlete getEpreuveAthlete(@PathVariable("id") final Long id) {
        Optional<EpreuveAthlete> epreuveAthlete = epreuveAthleteService.getEpreuveAthlete(id);
        if(epreuveAthlete.isPresent()) {
            return epreuveAthlete.get();
        } else {
            return null;
        }
    }

    @GetMapping("/epreuveAthletes")
    public Iterable<EpreuveAthlete> getEpreuveAthletes() {
        return epreuveAthleteService.getEpreuveAthletes();
    }

    @DeleteMapping("/epreuveAthlete/{id}")
    public void deleteEpreuveAthlete(@PathVariable("id") final Long id) {
        epreuveAthleteService.deleteEpreuveAthlete(id);
    }
}
