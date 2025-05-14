package servlet;

import dao.FasesporEquipo;
import dao.JDBCDaoCruce;
import dao.JDBCDaoDebate;
import dao.JDBCDaoPuntuacion;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.servlet.IServletWebExchange;
import org.thymeleaf.web.servlet.JavaxServletWebApplication;

import java.io.IOException;
import java.util.List;

public class ProyectoServlet extends HttpServlet {
	private static final long serialVersionUID = 2051990309999713971L;
	private TemplateEngine templateEngine;

    private JDBCDaoPuntuacion daoPuntuacion;
    private JDBCDaoDebate daoDebate;
    private JDBCDaoCruce daoCruce;

	@Override
	public void init() throws ServletException {
		System.out.println("En init");
		ServletContext servletContext = getServletContext();
		JavaxServletWebApplication application = JavaxServletWebApplication.buildApplication(servletContext);
		WebApplicationTemplateResolver templateResolver = new WebApplicationTemplateResolver(application);
		templateResolver.setPrefix("/WEB-INF/templates/");
		templateResolver.setSuffix(".html");
		templateResolver.setTemplateMode(TemplateMode.HTML);
		templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);

	}
	

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("En get");

		ServletContext servletContext = getServletContext();
		JavaxServletWebApplication application = JavaxServletWebApplication.buildApplication(servletContext);
		IServletWebExchange webExchange = application.buildExchange(request, response);
		WebContext context = new WebContext(webExchange, request.getLocale());
		response.setContentType("text/html;charset=UTF-8");
		// Datos de ejemplo: lista de nombres

		String pathInfo = request.getPathInfo(); // Ejemplo: /listarUsuarios o null
		
		if (pathInfo == null || pathInfo.trim().isEmpty() || pathInfo.trim().equalsIgnoreCase("/indexE")) {
			// Redirigir a la página de login
			templateEngine.process("indexE", context, response.getWriter());
		} else {
			// Dividimos por segmentos
		    String[] partes = pathInfo.substring(1).split("/");
		    String accion = partes[0]; // ej: "detalleUsuario"
		    String parametro1 = partes.length > 1 ? partes[1] : null;
		    
		    System.out.println("Servlet invocado. accion: " + accion);

		    switch (accion) {
		        
			case "PaginaBase":
				templateEngine.process("PaginaBase", context, response.getWriter());
				break;
			case "RegistroPuntuaciones":
				templateEngine.process("RegistroPuntuaciones", context, response.getWriter());
				break;
			case "ResultadoPorFase":
				templateEngine.process("ResultadoPorFase", context, response.getWriter());
				break;
			default:
				// Ruta no reconocida
				response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ruta no válida: " + pathInfo);
			}
		}
	}
	protected void doPost1(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idequipo1 = Integer.parseInt(request.getParameter("idequipo1"));
        int idequipo2 = Integer.parseInt(request.getParameter("idequipo2"));
        int puntuacion1 = Integer.parseInt(request.getParameter("puntuacion1"));
        int puntuacion2 = Integer.parseInt(request.getParameter("puntuacion2"));
        String observacion1 = request.getParameter("observacion1");
        String observacion2 = request.getParameter("observacion2");
        String penalizacion1 = request.getParameter("penalizacion1");
        String penalizacion2 = request.getParameter("penalizacion2");
        int idprueba = Integer.parseInt(request.getParameter("idprueba"));
        String faseStr = request.getParameter("fase");

        FasesporEquipo fase = FasesporEquipo.valueOf(faseStr); // Enum FasesporEquipo (debe estar definido)

        try {
            JDBCDaoPuntuacion dao = new JDBCDaoPuntuacion();
            dao.insertaPuntuacion(idequipo1, idequipo2, puntuacion1, puntuacion2,
                observacion1, observacion2, penalizacion1, penalizacion2, fase, idprueba);
            response.sendRedirect("indexE"); // o redirige a una página de éxito
        } catch (Exception e) {
            e.printStackTrace();
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al insertar puntuación.");
        }
    }

	
  /*  @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();
        String vista = null;

        switch (path) {
            case "/indexE":
                vista = "/indexE.html";
                break;
            case "/PaginaBase":
                vista = "/WEB-INF/PaginaBase.html";
                break;
            case "/RegistroPuntuaciones":
                vista = "/WEB-INF/RegistroPuntuaciones.html";
                break;
            case "/DebateporFase":
                vista = "/WEB-INF/DebateporFase.html";
                break;
            case "/mostrarCruce":
                try {
                    List<String> datos = daoCruce.consultaCruce("equipo1", 1); // ejemplo
                    request.setAttribute("cruce", datos);
                    request.getRequestDispatcher("/WEB-INF/mostrarCruce.jsp").forward(request, response);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(500, "Error en consulta cruce");
                    return;
                }
            case "/mostrarDebates":
                try {
                    List<?> debates = daoDebate.listarDebates(null); // ajusta el tipo según tu modelo
                    request.setAttribute("debates", debates);
                    request.getRequestDispatcher("/WEB-INF/debates.jsp").forward(request, response);
                    return;
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(500, "Error al listar debates");
                    return;
                }
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Ruta no válida");
                return;
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher(vista);
        dispatcher.forward(request, response);
    }
*/
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();

        switch (path) {
            case "/registrarPuntuacion":
                try {
                    int idequipo1 = Integer.parseInt(request.getParameter("idequipo1"));
                    int idequipo2 = Integer.parseInt(request.getParameter("idequipo2"));
                    int idprueba = Integer.parseInt(request.getParameter("idprueba"));
                    int puntuacion1 = Integer.parseInt(request.getParameter("puntuacion1"));
                    int puntuacion2 = Integer.parseInt(request.getParameter("puntuacion2"));
                    String observacion1 = request.getParameter("observacion1");
                    String observacion2 = request.getParameter("observacion2");
                    String penalizacion1 = request.getParameter("penalizacion1");
                    String penalizacion2 = request.getParameter("penalizacion2");
                    //FasesporEquipo fase = request.getParameter("fase");

                    daoPuntuacion.insertaPuntuacion(idequipo1, idequipo2, puntuacion1, puntuacion2, observacion1, observacion2, penalizacion1, penalizacion2, null, idprueba);
                    response.sendRedirect("RegistroPuntuaciones");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(500, "Error registrando puntuación");
                }
                break;

           /* case "/registrarDebate":
                try {
                    int idFase = Integer.parseInt(request.getParameter("idFase"));
                    int idEquipo = Integer.parseInt(request.getParameter("idEquipo"));
                    daoDebate.insertaDebate(idFase, idEquipo);
                    response.sendRedirect("DebateporFase");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(500, "Error registrando debate");
                }
                break;

            case "/actualizarCruce":
                try {
                    int idCruce = Integer.parseInt(request.getParameter("idCruce"));
                    String campo = request.getParameter("campo");
                    String nuevoValor = request.getParameter("valor");
                    daoCruce.actualizaDatos(campo, idCruce, nuevoValor);
                    response.sendRedirect("mostrarCruce");
                } catch (Exception e) {
                    e.printStackTrace();
                    response.sendError(500, "Error actualizando cruce");
                }
                break;

            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND, "Acción no válida");
                break;
        }*/
    }
}
}
