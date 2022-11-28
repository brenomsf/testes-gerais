package br.com.bmsf.demoresp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bmsf.demoresp.usecase.RespService;

@RestController
@RequestMapping("/questoes")
public class RespController {

	@Autowired
	private RespService service;
	
	@PostMapping
	public String consutarQuetoes(@RequestBody QuestaoModel questaoModel) {
		return service.consultarQuestoes(questaoModel);
	}
}
