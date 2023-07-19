import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "PageViewCount", urlPatterns = "/count")
public class PageViewCount extends HttpServlet {
    private int viewCount = 0;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        try{
            String reset = req.getParameter("reset");
            if(reset != null){
                if(reset.equals("true") || reset.equals("t")){
                    viewCount = 0;
                }
            }
            viewCount++;
            out.println(String.format("<h1>Page viewed %d times!</h1>", viewCount));
        } catch (Exception e){
            out.println("Error in page view count!");
        }
    }
}