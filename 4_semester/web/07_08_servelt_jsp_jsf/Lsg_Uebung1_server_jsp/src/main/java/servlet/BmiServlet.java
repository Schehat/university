package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "bmiServlet", urlPatterns = {"/bmiServlet"})
public class BmiServlet extends HttpServlet {

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        float kg = 0, meter = 0, bmi;
        boolean valid = true;

        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println(" <head>");
        out.println(" <title>You called the BMI Servlet </title> ");
        out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"myWt.css\"/>");
        out.println("</head>");
        out.println(" <body>");

        try {
            kg = Float.parseFloat(req.getParameter("kilos"));
            meter = Float.parseFloat(req.getParameter("meter"));
        } catch (Exception e) {
            valid = false;
        }
        if (valid) {
            bmi = kg / (meter * meter);
            bmi = Math.round(bmi);
            out.println("<h1> Simple Servlet  </h1>");
            out.println("<h1> Dein BMi hat den Wert:" + bmi + "</h1>");
            out.println("<br/>");
            if (bmi < 20) {
                out.println("<h2> du hast Untergewicht </h2>");
            }
            if (20 <= bmi && bmi <= 24) {
                out.println("<h2> du hast Normalgewicht </h2>");
            }
            if (bmi > 24) {
                out.println("<h2> du hast Übergewicht </h2>");
            }
        } else {
            out.println("Die Eingabe war nicht korekt!! <br/> Das Gewicht und die Größe müssen  Gleitpunktzahlen sein.");
            
        }
        out.println(" </body>");
        out.println("</html>");
    }
}
