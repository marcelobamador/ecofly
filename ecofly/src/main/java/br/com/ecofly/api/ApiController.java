package br.com.ecofly.api;

import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecofly.dto.User;
import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.service.PilotService;

@org.springframework.stereotype.Controller
public class ApiController {

	PilotService pilotService;

	public ApiController(PilotService pilotService) {
		this.pilotService = pilotService;
	}

	@RequestMapping(value = "")
	public String index() {
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String indexOther() {
		return "index";
	}

	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/registration")
	public String registration(Model model) {
		/*if (securityService.isAuthenticated()) {
			return "redirect:/";
		}*/

		model.addAttribute("userForm", new User());

		return "registration";
	}
	
	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
		System.out.println(userForm);
		return "registration";
	}
	
	@RequestMapping(value = "/efetuarlogin")
	public String efetuarlogin() {
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
			
			//Carregar Cracha
			Integer number = opt.getPilotId();
			String formatted = opt.getCode() + String.format("%04d", number);
			model.addAttribute("cracha", "img/uploads/" + formatted + ".png");
		});
		return "main_login";
	}
}
