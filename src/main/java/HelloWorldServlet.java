import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")
public class HelloWorldServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();
        try{
            String name = req.getParameter("name");
            if(name != null){
                out.println(String.format("<h1>Hello, %s!</h1>", name));
            } else {
                out.println("<h1>Hello, World!</h1>");
            }
        } catch (Exception e){
            out.println("Error in hello servlet!");
        }
    }
}