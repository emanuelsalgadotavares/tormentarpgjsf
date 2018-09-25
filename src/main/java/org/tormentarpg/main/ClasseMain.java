package org.tormentarpg.main;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tormentarpg.model.Talento;

import com.opencsv.CSVReader;

public class ClasseMain {

	public static void main(String[] args) throws IOException {
		/*ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("application.xml");*/

		String caminho = "C:\\Users\\emanuel.tavares\\Downloads\\t\\TALENTOS.csv";

		CSVReader reader = null;
		FileReader r = null;

		try {
			r = new FileReader(caminho);
			reader = new CSVReader(r, ';');

			List<Talento> talentos = new ArrayList<>();

			// read line by line
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

			System.out.println(talentos.size());
		} finally {
			if(r != null )
				r.close();
			if(reader != null)
				reader.close();
		}
	}
}
