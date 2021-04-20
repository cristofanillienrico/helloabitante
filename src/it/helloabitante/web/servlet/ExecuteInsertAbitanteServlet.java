package it.helloabitante.web.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.helloabitante.dao.DB_Mock;
import it.helloabitante.model.Abitante;
import it.helloabitante.service.MyServiceFactory;
import it.helloabitante.service.abitante.AbitanteService;

@WebServlet("/ExecuteInsertAbitanteServlet")
public class ExecuteInsertAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteInsertAbitanteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nomeParameter = request.getParameter("nomeInput");
		String cognomeParameter = request.getParameter("cognomeInput");
		String codiceFiscaleParameter = request.getParameter("codiceFiscaleInput");
		String etaParameter = request.getParameter("etaInput");
		String mottoDiVitaParameter = request.getParameter("mottoDiVitaInput");

		AbitanteService serviceAbitante = MyServiceFactory.getAbitanteServiceInstance();

		RequestDispatcher rd = null;

		if (nomeParameter != null && !nomeParameter.isEmpty() && cognomeParameter != null && !cognomeParameter.isEmpty()
				&& codiceFiscaleParameter != null && !codiceFiscaleParameter.isEmpty() && etaParameter != null
				&& !etaParameter.isEmpty() && mottoDiVitaParameter != null && !mottoDiVitaParameter.isEmpty()) {

			rd = request.getRequestDispatcher("searchForm.jsp");

			// inserisco abitante qui
			try {
				serviceAbitante.inserisci(new Abitante(nomeParameter, cognomeParameter, codiceFiscaleParameter,
						Integer.valueOf(etaParameter), mottoDiVitaParameter));
				// verifico che sia stato inserito
				System.out.println(DB_Mock.LISTA_ABITANTI.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}

		} else {
			rd = request.getRequestDispatcher("insert.jsp");

		}

		rd.forward(request, response);
	}

}
