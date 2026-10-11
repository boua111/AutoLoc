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
import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.service.IReservationService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api/reservations")
@RequiredArgsConstructor
public class ReservationController {
    private final IReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> retrieveAllReservations() {
        return ResponseEntity.ok(reservationService.retrieveAllReservations());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reservation> retrieveReservation(@PathVariable Long id) {
        Reservation reservation = reservationService.retrieveReservation(id);
        return reservation == null ? ResponseEntity.notFound().build() : ResponseEntity.ok(reservation);
    }

    @PostMapping
    public ResponseEntity<Reservation> addReservation(@RequestBody Reservation reservation) {
        Reservation created = reservationService.addReservation(reservation);
        return ResponseEntity.created(URI.create("/api/reservations/" + created.getIdReservation())).body(created);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody Reservation reservation) {
        if (reservationService.retrieveReservation(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reservation.setIdReservation(id);
        return ResponseEntity.ok(reservationService.updateReservation(reservation));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removeReservation(@PathVariable Long id) {
        if (reservationService.retrieveReservation(id) == null) {
            return ResponseEntity.notFound().build();
        }
        reservationService.removeReservation(id);
        return ResponseEntity.noContent().build();
    }
}
