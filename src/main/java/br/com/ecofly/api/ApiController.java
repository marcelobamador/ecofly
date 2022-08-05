package br.com.ecofly.api;

import java.util.Collection;
import java.util.Optional;
import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.ecofly.dto.UserDTO;
import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.service.AircraftService;
import br.com.ecofly.service.PilotService;
import br.com.ecofly.service.PirepsService;
import br.com.ecofly.service.SecurityService;
import br.com.ecofly.service.UserService;
import br.com.ecofly.util.UserValidator;

@org.springframework.stereotype.Controller
public class ApiController {

	@Autowired
	private UserValidator userValidator;

	@Autowired
	private UserService userService;

	@Autowired
	private AircraftService aircraftService;

	@Autowired
	private PirepsService pirepsService;

	@Autowired
	private SecurityService securityService;

	PilotService pilotService;

	public ApiController(PilotService pilotService) {
		this.pilotService = pilotService;
	}
	
	/* =================== PÁGINA INICIAL =================== */
	@RequestMapping(value = "")
	public String index(ModelMap model) {
		if (securityService.isAuthenticated()) {
			model.addAttribute("logged", 1);
		} else {
			model.addAttribute("logged", 0);
		}
		
		model.addAttribute("countPilots", this.pilotService.getCountPilots());
		model.addAttribute("countAircrafts", aircraftService.getCountAircraft());
		model.addAttribute("lastPireps", pirepsService.listPiperps());
		return "index";
	}

	@RequestMapping(value = "/index")
	public String indexOther(ModelMap model) {
		if (securityService.isAuthenticated()) {
			model.addAttribute("logged", 1);
		} else {
			model.addAttribute("logged", 0);
		}
		
		model.addAttribute("countPilots", this.pilotService.getCountPilots());
		model.addAttribute("countAircrafts", aircraftService.getCountAircraft());
		model.addAttribute("lastPireps", pirepsService.listPiperps());
		return "index";
	}
	/* =================== FIM PÁGINA INICIAL =================== */

	/* =================== LOGIN =================== */
	@RequestMapping(value = "/login")
	public String login(Model model, String error, String logout) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}

		if (error != null)
			model.addAttribute("error", "Usuário ou senha inválidos.");

		if (logout != null)
			model.addAttribute("message", "Deslogado com sucesso.");

		return "login";
	}
	/* =================== FIM LOGIN =================== */

	/* =================== TELA DE CADASTRO =================== */
	@GetMapping("/registration")
	public String registration(Model model) {
		if (securityService.isAuthenticated()) {
			model.addAttribute("logged", 1);
		} else {
			model.addAttribute("logged", 0);
		}
		model.addAttribute("userForm", new UserDTO());
		return "registration";
	}
	/* =================== FIM TELA DE CADASTRO =================== */

	/* =================== FORM DE CADASTRO =================== */
	@PostMapping(value = "/registration")
	public String registration(@ModelAttribute("userForm") UserDTO userForm, BindingResult bindingResult) {
		userValidator.validate(userForm, bindingResult);

		if (bindingResult.hasErrors()) {
			return "registration";
		}

		userService.save(userForm);

		return "redirect:/success";
	}
	/* =================== FIM FORM DE CADASTRO =================== */

	/* =================== PÁGINA DE SUCESSO DE CADASTRO =================== */
	@GetMapping({ "/success" })
	public String success(Model model) {
		return "success";
	}
	/* =================== FIM PÁGINA DE SUCESSO DE CADASTRO =================== */

	/* =================== PÁGINA INICIAL DO PILOTO =================== */
	@GetMapping({ "/homepilot" })
	public String homePilot(ModelMap model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = (User) auth.getPrincipal();
		
		Optional<PilotEntity> optional = this.pilotService.getPilotUserName(user.getUsername());
		optional.ifPresent((opt) -> {
			Integer number = opt.getPilotId();
			String formatted = opt.getCode() + String.format("%04d", number);
			
			model.addAttribute("name", formatted + " - " + opt.getFirstName() + " " + opt.getLastName());
			model.addAttribute("rank", opt.getRank());
			model.addAttribute("totalFlights", opt.getTotalFlights());
			model.addAttribute("totalHours", opt.getTotalHours());
			model.addAttribute("totalPayment", opt.getTotalPay());
			model.addAttribute("cracha", "img/uploads/" + formatted + ".png");
			model.addAttribute("awards", opt.getLikes());
			
			if (securityService.isAuthenticated()) {
				Collection<GrantedAuthority> credentials = (Collection<GrantedAuthority>) auth.getAuthorities();
				for (GrantedAuthority authority : credentials) {
					if (authority.getAuthority().contains("Administrators")) {
						model.addAttribute("group", 1);
						break;
					}
				}
			}
			
		});
		return "main_login";
	}
	/* =================== FIM PÁGINA INICIAL DO PILOTO =================== */
	
	/* =================== EDITAR PILOTO =================== */
	@GetMapping({ "/editpilot" })
	public String editPilot(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();

		User user = (User) auth.getPrincipal();
		
		Optional<PilotEntity> optional = this.pilotService.getPilotUserName(user.getUsername());
		optional.ifPresent((opt) -> {
			Integer number = opt.getPilotId();
			String formatted = opt.getCode() + String.format("%04d", number);
			
			model.addAttribute("name", formatted + " - " + opt.getFirstName() + " " + opt.getLastName());
			model.addAttribute("rank", opt.getRank());
			model.addAttribute("totalFlights", opt.getTotalFlights());
			model.addAttribute("totalHours", opt.getTotalHours());
			model.addAttribute("totalPayment", opt.getTotalPay());
			model.addAttribute("cracha", "img/uploads/" + formatted + ".png");
			model.addAttribute("awards", opt.getLikes());
			
			if (securityService.isAuthenticated()) {
				Collection<GrantedAuthority> credentials = (Collection<GrantedAuthority>) auth.getAuthorities();
				for (GrantedAuthority authority : credentials) {
					if (authority.getAuthority().contains("Administrators")) {
						model.addAttribute("group", 1);
						break;
					}
				}
			}
			
		});
		return "editar_piloto";
	}
	/* =================== FIM EDITAR PILOTO =================== */
	
	/* =================== PÁGINA DE REGULAMENTO =================== */
	@GetMapping("/regulamento")
	public String regulamento(Model model) {
		if (securityService.isAuthenticated()) {
			model.addAttribute("logged", 1);
		} else {
			model.addAttribute("logged", 0);
		}
		return "regulamento";
	}
	/* =================== FIM PÁGINA DE REGULAMENTO =================== */
}
