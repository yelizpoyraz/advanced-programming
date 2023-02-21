package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.VenueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class VenueController {
    @Autowired
    private VenueRepository venueRepository;

    @GetMapping("/venuedetails/{id}")
    public String venueDetails(Model model, @PathVariable int id) {
        Optional<Venue> optionalVenue = venueRepository.findById(id);
        if (optionalVenue.isPresent()) {
            model.addAttribute("venue", optionalVenue.get());
        }
        return "venuedetails";
    }
//test
    @GetMapping("/venuelist")
    public String venueDetails(Model model) {
        //Iterable<Venue> allVenues = venueRepository.findAll();
        ArrayList<Venue> someVenues = new ArrayList<>();
        Optional<Venue> optional = venueRepository.findById(2);
        someVenues.add(optional.get());
        optional = venueRepository.findById(5);
        someVenues.add(optional.get());
        optional = venueRepository.findById(7);
        someVenues.add(optional.get());
        for (int i=1; i <= someVenues.size(); i++) {
            model.addAttribute("venue"+i, someVenues.get(i-1));
        }
        return "venuelist";
    }
}
