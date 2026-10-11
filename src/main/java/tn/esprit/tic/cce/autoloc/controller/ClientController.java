package tn.esprit.tic.cce.autoloc.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.tic.cce.autoloc.domain.Client;
import tn.esprit.tic.cce.autoloc.service.IClientService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/clients")
@RequiredArgsConstructor
public class ClientController {
    private final IClientService clientService;

    @GetMapping
    public ResponseEntity<List<Client>> retrieveAllClients() {
        return ResponseEntity.ok(clientService.retrieveAllClients());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Client> retrieveClient(@PathVariable Long id) {
        Client client = clientService.retrieveClient(id);
        return client == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(client);
    }

    @PostMapping
    public ResponseEntity<Client> addClient(@RequestBody Client client) {
        Client created = clientService.addClient(client);
        return ResponseEntity.created(URI.create("/api/clients/" + created.getIdClient())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Client> updateClient(@PathVariable Long id, @RequestBody Client client) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        client.setIdClient(id);
        return ResponseEntity.ok(clientService.updateClient(client));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeClient(@PathVariable Long id) {
        if (clientService.retrieveClient(id) == null) {
            return ResponseEntity.notFound().build();
        }
        clientService.removeClient(id);
        return ResponseEntity.noContent().build();
    }
}
