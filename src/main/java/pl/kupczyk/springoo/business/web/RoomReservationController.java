package pl.kupczyk.springoo.business.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.kupczyk.springoo.business.domain.RoomReservation;
import pl.kupczyk.springoo.utils.DateUtil;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping()
public class RoomReservationController {

    private final RoomReservationService reservationService;

    @Autowired
    public RoomReservationController(RoomReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @RequestMapping("reservations")
    public String getReservation(@RequestParam(value = "date", required = false)String dateString, Model model){
        Date date = DateUtil.createDate(dateString);

        List<RoomReservation> roomReservations = reservationService.getRoomReservationByDate(date);
        model.addAttribute("roomReservations", roomReservations);

        return "reservations";
    }
}