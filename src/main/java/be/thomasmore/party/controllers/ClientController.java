package be.thomasmore.party.controllers;

import be.thomasmore.party.model.Client;
import be.thomasmore.party.model.Venue;
import be.thomasmore.party.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private ClientRepository clientRepository;

    @GetMapping("/greeting")
    public String greetingNewClient(Model model) {
        Optional<Client> optionalClient = clientRepository.findById(1);
        if (optionalClient.isPresent()) {
            Client client = optionalClient.get();
            model.addAttribute("client", client);
            String groet = "Goedemorgen ";
            if (client.getGender().equals("M")) {
                groet += "meneer ";
            } else if (client.getGender().equals("F")) {
                groet += "mevrouw ";
            } else {
                groet += "beste ";
            }
            groet += client.getName();
            model.addAttribute("groet", groet);
            model.addAttribute("code", generateClientCode(client));
        }
        return "newclient";
    }

    private String generateClientCode(Client client) {
        String code = "";
        code = client.getName().substring(0, 2) +
                client.getName().charAt(client.getName().length() - 1);
        return code;
    }
}
