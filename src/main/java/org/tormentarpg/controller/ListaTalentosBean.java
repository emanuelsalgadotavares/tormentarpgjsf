package org.tormentarpg.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.tormentarpg.model.Talento;
import org.tormentarpg.service.TalentoService;

@Controller
@Scope("view")
public class ListaTalentosBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private TalentoService talentoService = new TalentoService();
	
	private List<Talento> talentos;
	private List<Talento> talentosFiltrados = new ArrayList<>();

	@PostConstruct
	public void init() {
		talentos = talentoService.findAll();
	}

	/* GET & SET */
	public List<Talento> getTalentos() {
		return talentos;
	}
	public void setTalentos(List<Talento> talentos) {
		this.talentos = talentos;
	}

	public List<Talento> getTalentosFiltrados() {
		return talentosFiltrados;
	}
	public void setTalentosFiltrados(List<Talento> talentosFiltrados) {
		this.talentosFiltrados = talentosFiltrados;
	}
}
