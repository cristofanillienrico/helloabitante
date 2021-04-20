package it.helloabitante.dao.abitante;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;

public class AbitanteDAOImpl implements AbitanteDAO {

	private Connection connection;

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

	@Override
	public List<Abitante> findByNomeAndCognome(String nome, String cognome) {
		List<Abitante> result = new ArrayList<>();

		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getNome().startsWith(nome) && abitanteItem.getCognome().startsWith(cognome))
				result.add(abitanteItem);
		}
		return result;
	}

	@Override
	public List<Abitante> list() throws Exception {
		return DB_Mock.LISTA_ABITANTI;
	}

	@Override
	public Abitante get(Long id) throws Exception {
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (abitanteItem.getIdAbitante().equals(id)) {
				return abitanteItem;
			}
		}
		return null;
	}

	@Override
	public int update(Abitante input) throws Exception {
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (input.equals(abitanteItem)) {
				Abitante daModificareAbitante = this.get(input.getIdAbitante());
				daModificareAbitante.setNome(input.getNome());
				daModificareAbitante.setCognome(input.getCognome());
				daModificareAbitante.setCodiceFiscale(input.getCodiceFiscale());
				daModificareAbitante.setEta(input.getEta());
				daModificareAbitante.setMottoDiVita(input.getMottoDiVita());
				return 1;
			}
		}
		return 0;
	}

	@Override
	public int insert(Abitante input) throws Exception {
		if (input != null) {
			Long id=DB_Mock.getNexIdAvailable();
			input.setIdAbitante(id);
			DB_Mock.LISTA_ABITANTI.add(input);
			return 1;
		}
		return 0;
	}

	@Override
	public int delete(Abitante input) throws Exception {
		Integer indice = null;
		for (Abitante abitanteItem : DB_Mock.LISTA_ABITANTI) {
			if (input.equals(abitanteItem)) {
				indice = DB_Mock.LISTA_ABITANTI.indexOf(abitanteItem);

			}
		}

		if (indice != null) {
			DB_Mock.LISTA_ABITANTI.remove(DB_Mock.LISTA_ABITANTI.get(indice));
			return 1;
		}

		return 0;

	}

	

}
