package br.com.ecofly.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ecofly.dto.PirepsDTO;
import br.com.ecofly.model.AircraftEntity;
import br.com.ecofly.model.PilotEntity;
import br.com.ecofly.model.PirepsEntity;
import br.com.ecofly.repository.PirepsRepository;
import br.com.ecofly.service.AircraftService;
import br.com.ecofly.service.PilotService;
import br.com.ecofly.service.PirepsService;

@Service
public class PirepsServiceImpl implements PirepsService {

	@Autowired
	private PirepsRepository pirepsRepository;

	@Autowired
	private PilotService pilotService;

	@Autowired
	private AircraftService aircraftService;

	@Override
	public List<PirepsDTO> listPiperps() {
		List<PirepsEntity> entity = pirepsRepository.findLastPireps();
		List<PirepsDTO> pirepsList = new ArrayList<>();
		PirepsDTO pirepsDTO;
		for (PirepsEntity pirepsEntity : entity) {
			pirepsDTO = new PirepsDTO();

			String flightNumber = String.format("%04d", Integer.parseInt(pirepsEntity.getFlightNum()));
			pirepsDTO.setFlight(pirepsEntity.getCode() + flightNumber);

			Optional<PilotEntity> pilot = pilotService.getPilot(pirepsEntity.getPilotId());
			pirepsDTO.setPilot(pilot.get().getFirstName() + " " + pilot.get().getLastName());

			pirepsDTO.setOrigem(pirepsEntity.getDepicao());
			pirepsDTO.setDestino(pirepsEntity.getArricao());

			Optional<AircraftEntity> aircraft = aircraftService
					.getAircraftById(Integer.parseInt(pirepsEntity.getAircraft()));
			pirepsDTO.setAeronave(aircraft.get().getIcao() + " / " + aircraft.get().getRegistration());
			pirepsDTO.setDuracao(pirepsEntity.getFlightTime());
			pirepsDTO.setVs(pirepsEntity.getLandingRate() + " ft/m");

			if (pirepsEntity.getAccepted() == 0) {
				pirepsDTO.setInfo("Aguardando");
			} else if (pirepsEntity.getAccepted() == 1) {
				pirepsDTO.setInfo("Aprovado");
			} else {
				pirepsDTO.setInfo("Rejeitado");
			}
			pirepsList.add(pirepsDTO);
		}
		return pirepsList;
	}

	@Override
	public List<PirepsEntity> listPirepsToday() throws ParseException {
		/* FORMAT DATE */
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String date = dtf.format(LocalDateTime.now());

		return pirepsRepository.findPirepsToday(date);

	}

	@Override
	public PirepsEntity updatePirepToday(PirepsEntity pirep) {
		float landingRate = Float.parseFloat(pirep.getLandingRate());
		if(landingRate > -400 || landingRate < 400) {
			/* FORMAT DATE */
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String date = dtf.format(LocalDateTime.now());
			pirepsRepository.updatePirepToday(pirep.getPirepId());
		}
		return null;
	}

}
