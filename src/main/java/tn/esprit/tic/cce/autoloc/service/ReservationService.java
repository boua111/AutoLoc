package tn.esprit.tic.cce.autoloc.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tic.cce.autoloc.domain.Reservation;
import tn.esprit.tic.cce.autoloc.repository.ReservationRepository;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService implements IReservationService {
    private final ReservationRepository reservationRepository;
    public List<Reservation> retrieveAllReservations() { return reservationRepository.findAll(); }
    public Reservation addReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation updateReservation(Reservation reservation) { return reservationRepository.save(reservation); }
    public Reservation retrieveReservation(Long id) { return reservationRepository.findById(id).orElse(null); }
    public void removeReservation(Long id) { reservationRepository.deleteById(id); }
    public List<Reservation> addReservations(List<Reservation> reservations) { return reservationRepository.saveAll(reservations); }
}
