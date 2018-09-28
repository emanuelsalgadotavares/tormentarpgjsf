package org.tormentarpg.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.tormentarpg.model.Talento;

import com.opencsv.CSVReader;

public class TalentoDAO {
	
	CSVReader reader = null;
	InputStreamReader r2 = null;
	
	public List<Talento> findAll() {
		try {
			List<Talento> talentos = new ArrayList<>();
			reader = getCSVReader("C:\\\\Users\\\\emanuel.tavares\\\\Downloads\\\\t\\\\TALENTOS.csv");
	
			String[] record = null;
	
			while ((record = reader.readNext()) != null) {
				Talento t = new Talento();
	
				t.setNome(record[0]);
				t.setDescricao(record[1]);
				t.setPreRequisito(record[2]);
				t.setBeneficio(record[3]);
				t.setObservacao(record[4]);
				t.setTipoMagia(record[5]);
				t.setCusto(record[6]);
				t.setTipoTalento(record[7]);
				t.setManual(record[8]);
	
				talentos.add(t);
			}
	
			fechar();
	
			return talentos;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	private CSVReader getCSVReader(String caminho) throws FileNotFoundException, UnsupportedEncodingException {
		r2 = new InputStreamReader(new FileInputStream(caminho), "UTF-8");
		reader = new CSVReader(r2, ';');
		
		return reader;
	}
	
	private void fechar() throws IOException {
		if(r2 != null )
			r2.close();
		if(reader != null)
			reader.close();
	}
}
