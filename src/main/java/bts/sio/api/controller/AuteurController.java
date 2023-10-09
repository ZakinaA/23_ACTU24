package bts.sio.api.controller;

import bts.sio.api.model.Article;
import bts.sio.api.model.Athlete;
import bts.sio.api.model.Auteur;
import bts.sio.api.model.Pays;
import bts.sio.api.service.AuteurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;

@RestController
public class AuteurController {

    @Autowired
    private AuteurService auteurService;

    @PostMapping("/auteur")
    public Auteur createAuteur(@RequestBody Auteur auteur) {
        return auteurService.saveAuteur(auteur);
    }

    @GetMapping("/auteur/{id}")
    public Auteur getAuteur(@PathVariable("id") final Long id) {
        Optional<Auteur> auteur = auteurService.getAuteur(id);
        if(auteur.isPresent()) {
            return auteur.get();
        } else {
            return null;
        }
    }

    @GetMapping("/auteurs")
    public Iterable<Auteur> getAuteurs() {
        return auteurService.getAuteurs();
    }

    @DeleteMapping("/auteur/{id}")
    public void deleteAuteur(@PathVariable("id") final Long id) {
        auteurService.deleteAuteur(id);
    }

    @PutMapping("/auteur/{id}")
    public Auteur updateAuteur(@PathVariable("id") final Long id, @RequestBody Auteur auteur) {
        Optional<Auteur> e = auteurService.getAuteur(id);
        if(e.isPresent()) {
            Auteur currentAuteur = e.get();

            String nom = auteur.getNom();
            if(nom != null) {
                currentAuteur.setNom(nom);
            }
            String prenom = auteur.getPrenom();
            if(prenom != null) {
                currentAuteur.setPrenom(prenom);
            }

            auteurService.saveAuteur(currentAuteur);
            return currentAuteur;
        } else {
            return null;
        }
    }

}
