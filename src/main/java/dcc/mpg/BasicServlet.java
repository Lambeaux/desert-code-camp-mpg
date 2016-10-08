package dcc.mpg;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * This is a basic example of a standard, Java {@link HttpServlet}.
 */
public class BasicServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        resp.setStatus(200);
        resp.getOutputStream()
                .print(String.format("I am a basic servlet%n"));
        if (req.getPathInfo() != null) {
            resp.getOutputStream()
                    .print(req.getPathInfo());
        }
    }
}
