package it.helloabitante.service.abitante;

import java.util.List;

import it.helloabitante.dao.abitante.AbitanteDAO;
import it.helloabitante.model.Abitante;

public class AbitanteServiceImpl implements AbitanteService {

	private AbitanteDAO abitanteDAO;

	public void setAbitanteDAO(AbitanteDAO abitanteDAO) {
		this.abitanteDAO = abitanteDAO;
	}

	@Override
	public List<Abitante> cercaPerNomeECognome(String nome, String cognome) {
		// abitanteDAO.setConnection(MyConnection.getConnection());
		return abitanteDAO.findByNomeAndCognome(nome, cognome);
	}

	public List<Abitante> lista() throws Exception {
		return abitanteDAO.list();
	}

	public Abitante caricaSingolo(Long id) throws Exception {
		if (id != null) {
			return abitanteDAO.get(id);
		}
		return null;
	}

	public int aggiorna(Abitante input) throws Exception {
		if (input != null) {
			return abitanteDAO.update(input);
		}
		return 0;
	}

	public int inserisci(Abitante input) throws Exception {
		if (input != null) {
			return abitanteDAO.insert(input);
		}
		return 0;

	}

	public int rimuovi(Abitante input) throws Exception {

		if (input != null) {
			return abitanteDAO.delete(input);
		}
		return 0;
	}

}
