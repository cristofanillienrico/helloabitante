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

@WebServlet("/ExecuteDeleteServlet")
public class ExecuteDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ExecuteDeleteServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String parametroIdDellAbitanteDiCuiVoglioIlDettaglio = request.getParameter("idAbitanteDaEliminare");

		AbitanteService abitanteServiceInstance = MyServiceFactory.getAbitanteServiceInstance();

		Abitante result;

		RequestDispatcher rd = null;
		try {
			result = abitanteServiceInstance
					.caricaSingolo(Long.parseLong(parametroIdDellAbitanteDiCuiVoglioIlDettaglio));
			DB_Mock.LISTA_ABITANTI.remove(result);
			System.out.println(DB_Mock.LISTA_ABITANTI.toString());

			rd = request.getRequestDispatcher("searchForm.jsp");
			rd.forward(request, response);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
