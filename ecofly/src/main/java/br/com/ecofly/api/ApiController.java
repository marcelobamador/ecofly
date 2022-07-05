package br.com.ecofly.api;

import java.util.Optional;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.service.PilotService;

@org.springframework.stereotype.Controller
public class ApiController {

	PilotService pilotService;

	public ApiController(PilotService pilotService) {
		this.pilotService = pilotService;
	}

	@RequestMapping(value = "/")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}

	@RequestMapping(value = "/adminlogin")
	public String adminlogin(ModelMap model) {
		Optional<PilotEntity> optional = this.pilotService.getPilot(3);
		optional.ifPresent((opt) -> {
			model.addAttribute("name", opt.getFirstName() + " " + opt.getLastName());
			model.addAttribute("rank", opt.getRank());
			model.addAttribute("totalFlights", opt.getTotalFlights());
			model.addAttribute("totalHours", opt.getTotalHours());
			model.addAttribute("totalPayment", opt.getTotalPay());
		});
		return "main_login";
	}
}
