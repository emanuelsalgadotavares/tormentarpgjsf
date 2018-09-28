package org.tormentarpg.service;

import java.util.List;

import org.tormentarpg.dao.TalentoDAO;
import org.tormentarpg.model.Talento;

public class TalentoService {

	TalentoDAO talentoDAO = new TalentoDAO();
	
	public List<Talento> findAll() {
		return talentoDAO.findAll();
	}
	
}
