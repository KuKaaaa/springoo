package pl.kupczyk.springoo.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.kupczyk.springoo.domain.RoomReservation;
import pl.kupczyk.springoo.utils.DateUtil;

import java.util.Date;
import java.util.List;

@RestController
public class RoomReservationController {

    private final RoomReservationService reservationService;

    @Autowired
    public RoomReservationController(RoomReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping("reservations")
    public List<RoomReservation> getReservation(@RequestParam(value = "date", required = false)String dateString, Model model){
        Date date = DateUtil.createDate(dateString);

        List<RoomReservation> roomReservations = reservationService.getRoomReservationByDate(date);
        //model.addAttribute("roomReservations", roomReservations);

        //return "reservations";
        return roomReservations;
    }
}