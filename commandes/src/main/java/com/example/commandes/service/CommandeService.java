package com.example.commandes.service;

import com.example.commandes.entity.Commande;
import com.example.commandes.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommandeService {

    private final CommandeRepository commandeRepository;

    @Autowired
    public CommandeService(CommandeRepository commandeRepository) {
        this.commandeRepository = commandeRepository;
    }

    // Retrieve all commandes
    public List<Commande> findAll() {
        return commandeRepository.findAll();
    }

    // Check if commandes exist
    public boolean hasCommandes() {
        return !commandeRepository.findAll().isEmpty();
    }

    // Retrieve last commandes with pagination
    public List<Commande> findLastCommandes(int limit) {
        Pageable pageable = PageRequest.of(0, limit);
        return commandeRepository.findAll(pageable).getContent();
    }

    // Create or save a commande
    public Commande save(Commande commande) {
        return commandeRepository.save(commande);
    }

    // Find a commande by ID
    public Optional<Commande> findById(Long id) {
        return commandeRepository.findById(id);
    }

    // Update an existing commande
    public Commande update(Long id, Commande updatedCommande) {
        return commandeRepository.findById(id)
                .map(existingCommande -> {
                    existingCommande.setDescription(updatedCommande.getDescription());
                    existingCommande.setQuantite(updatedCommande.getQuantite());
                    existingCommande.setDate(updatedCommande.getDate());
                    existingCommande.setMontant(updatedCommande.getMontant());
                    return commandeRepository.save(existingCommande);
                })
                .orElseThrow(() -> new RuntimeException("Commande not found with ID: " + id));
    }

    // Delete a commande by ID
    public void delete(Long id) {
        if (commandeRepository.existsById(id)) {
            commandeRepository.deleteById(id);
        } else {
            throw new RuntimeException("Commande not found with ID: " + id);
        }
    }
}
