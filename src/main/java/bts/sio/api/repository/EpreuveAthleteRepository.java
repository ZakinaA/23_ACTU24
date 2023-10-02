package bts.sio.api.repository;

import bts.sio.api.model.Athlete;
import bts.sio.api.model.EpreuveAthlete;
import org.springframework.data.repository.CrudRepository;

public interface EpreuveAthleteRepository extends CrudRepository<EpreuveAthlete, Long> {
}