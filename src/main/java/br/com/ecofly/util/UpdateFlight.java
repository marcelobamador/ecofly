package br.com.ecofly.util;

import java.text.ParseException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ecofly.model.PirepsEntity;
import br.com.ecofly.service.PirepsService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UpdateFlight {
	
	@Autowired
	private PirepsService pirepsService;

	//private final PersonRepository repository;

    @Scheduled(fixedDelay = 100000)
    public void getPersonsAfterFifty() throws ParseException{
    	List<PirepsEntity> entity = pirepsService.listPirepsToday();
    	for (PirepsEntity pirepsEntity : entity) {
    		pirepsService.updatePirepToday(pirepsEntity);
		}
    }
}
