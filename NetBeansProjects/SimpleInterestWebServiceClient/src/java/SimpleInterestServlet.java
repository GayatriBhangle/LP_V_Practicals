import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.myservice.SimpleInterestService;
import com.myservice.SimpleInterestService_Service;

@WebServlet(name = "SimpleInterestServlet", urlPatterns = {"/SimpleInterestServlet"})
public class SimpleInterestServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        double principal = Double.parseDouble(request.getParameter("principal"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        double time = Double.parseDouble(request.getParameter("time"));
        
        // Call the web service
        SimpleInterestService_Service service = new SimpleInterestService_Service();
        SimpleInterestService port = service.getSimpleInterestServicePort();
        double simpleInterest = port.calculateSimpleInterest(principal, rate, time);
        
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h2>Simple Interest is: " + simpleInterest + "</h2>");
    }
}
