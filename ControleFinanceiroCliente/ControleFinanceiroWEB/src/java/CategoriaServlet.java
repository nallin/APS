import com.webservice.dbfinance.ClassNotFoundException_Exception;
import com.webservice.dbfinance.WebServiceServidor_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author Vanessa Márcia
 */
@WebServlet(name = "ControleFinanServlet", urlPatterns = {"/ControleFinanServlet"})
public class CategoriaServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/dbfinance/WebServiceServidor.wsdl")
    private WebServiceServidor_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws com.webservice.dbfinance.ClassNotFoundException_Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException_Exception {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String nome_cat = request.getParameter("nome_cat");
            inserirCat(nome_cat);
        
        }
    }


    private String inserirCat(String categoria) throws ClassNotFoundException_Exception {      
        com.webservice.dbfinance.WebServiceServidor port = service.getWebServiceServidorPort();
        return port.inserirCat(categoria);
    }

}
