package tn.esprit.tic.cce.autoloc.service;

import tn.esprit.tic.cce.autoloc.domain.Reservation;
import java.util.List;

public interface IReservationService {
    List<Reservation> retrieveAllReservations();
    Reservation addReservation(Reservation reservation);
    Reservation updateReservation(Reservation reservation);
    Reservation retrieveReservation(Long id);
    void removeReservation(Long id);
    List<Reservation> addReservations(List<Reservation> reservations);
}
