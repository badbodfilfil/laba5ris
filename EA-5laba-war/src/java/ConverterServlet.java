import java.io.IOException;
import java.math.BigDecimal;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import stateless.ConverterBeanLocal;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "submit", urlPatterns = {"/submit"})
public class ConverterServlet extends HttpServlet {

    @EJB
    ConverterBeanLocal converter;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String amount = request.getParameter("amount");
        if (amount != null && amount.length() > 0) {
            BigDecimal d = new BigDecimal(amount);
            BigDecimal yenAmount = converter.dollarToYen(d);
            BigDecimal euroAmount = converter.yenToEuro(yenAmount);
            String text = "<p>" + amount + " dollars are " + yenAmount.toPlainString() + " yen.</p><br/><p>" + yenAmount.toPlainString() + " yen are " + euroAmount.toPlainString() + " Euro.</p>";
            request.setAttribute("context", text);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
    }

}

