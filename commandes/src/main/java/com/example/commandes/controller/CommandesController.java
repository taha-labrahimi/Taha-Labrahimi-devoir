package com.example.commandes.controller;

import com.example.commandes.entity.Commande;
import com.example.commandes.service.CommandeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/commandes")
public class CommandesController {

    private static final Logger logger = LoggerFactory.getLogger(CommandesController.class);
    private final CommandeService commandeService;

    public CommandesController(CommandeService commandeService) {
        this.commandeService = commandeService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<Commande> creerCommande(@RequestBody Commande commande) {
        logger.info("Création d'une nouvelle commande: {}", commande);
        Commande nouvelleCommande = commandeService.save(commande);
        return ResponseEntity.ok(nouvelleCommande);
    }

    // READ (Get All)
    @GetMapping
    public List<Commande> listeDesCommandes() {
        logger.info("Récupération de toutes les commandes.");
        return commandeService.findAll();
    }

    // READ (Get By ID)
    @GetMapping("/{id}")
    public ResponseEntity<Commande> obtenirCommandeParId(@PathVariable Long id) {
        logger.info("Récupération de la commande avec l'ID: {}", id);
        Optional<Commande> commande = commandeService.findById(id);
        return commande.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Commande> mettreAJourCommande(@PathVariable Long id, @RequestBody Commande commande) {
        logger.info("Mise à jour de la commande avec l'ID: {}", id);
        Commande updatedCommande = commandeService.update(id, commande);
        return ResponseEntity.ok(updatedCommande);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCommande(@PathVariable Long id) {
        logger.info("Suppression de la commande avec l'ID: {}", id);
        commandeService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
