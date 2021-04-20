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

/**
 * Servlet implementation class ExecuteModificaAbitanteServlet
 */
@WebServlet("/ExecuteModificaAbitanteServlet")
public class ExecuteModificaAbitanteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteModificaAbitanteServlet() {
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

		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idAbitanteDaEliminare");
		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		Abitante result;

		RequestDispatcher rd = null;

		if (nomeParameter != null && !nomeParameter.isEmpty() && cognomeParameter != null && !cognomeParameter.isEmpty()
				&& codiceFiscaleParameter != null && !codiceFiscaleParameter.isEmpty() && etaParameter != null
				&& !etaParameter.isEmpty() && mottoDiVitaParameter != null && !mottoDiVitaParameter.isEmpty()) {

			try {
				result = abitanteServiceInstance
						.caricaSingolo(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
				result.setNome(nomeParameter);
				result.setCognome(cognomeParameter);
				result.setCodiceFiscale(codiceFiscaleParameter);
				result.setEta(Integer.parseInt(etaParameter));
				result.setMottoDiVita(mottoDiVitaParameter);
				abitanteServiceInstance.aggiorna(result);
				System.out.println(result.toString());

			} catch (Exception e) {
				e.printStackTrace();
			}

			rd = request.getRequestDispatcher("searchForm.jsp");
			rd.forward(request, response);
		}

	}

}
