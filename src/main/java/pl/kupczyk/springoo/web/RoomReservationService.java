package pl.kupczyk.springoo.web;

import org.springframework.stereotype.Service;
import pl.kupczyk.springoo.domain.RoomReservation;
import pl.kupczyk.springoo.model.Guest;
import pl.kupczyk.springoo.model.Reservation;
import pl.kupczyk.springoo.model.Room;
import pl.kupczyk.springoo.repo.GuestRepository;
import pl.kupczyk.springoo.repo.ReservationRepository;
import pl.kupczyk.springoo.repo.RoomRepository;

import java.util.*;

@Service
public class RoomReservationService {
    private final GuestRepository guestRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;

    public RoomReservationService(GuestRepository guestRepository, ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.guestRepository = guestRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    public List<RoomReservation> getRoomReservationByDate(Date date){
        Iterable<Room> rooms = this.roomRepository.findAll();
        Map<Long, RoomReservation> roomReservationMap = new HashMap<>();

        rooms.forEach(room -> {
            RoomReservation roomReservation = new RoomReservation();

            roomReservation.setRoomId(room.getRoomId());
            roomReservation.setRoomName(room.getRoomName());
            roomReservation.setRoomNumber(room.getRoomNumber());

            roomReservationMap.put(room.getRoomId(), roomReservation);
        });

        Iterable<Reservation> reservations = this.reservationRepository.findByDate(new java.sql.Date(date.getTime()));

        reservations.forEach(reservation -> {
            RoomReservation roomReservation = roomReservationMap.get(reservation.getRoomId());

            roomReservation.setDate(date);

            Guest guest = this.guestRepository.findById(reservation.getGuestId()).get();

            roomReservation.setFirstName(guest.getFirstName());
            roomReservation.setLastName(guest.getLastName());
            roomReservation.setGuestId(guest.getGuestId());
        });

        List<RoomReservation> roomReservations = new ArrayList<>();

        for (Long i: roomReservationMap.keySet()){
            roomReservations.add(roomReservationMap.get(i));
        }

        return roomReservations;
    }
}