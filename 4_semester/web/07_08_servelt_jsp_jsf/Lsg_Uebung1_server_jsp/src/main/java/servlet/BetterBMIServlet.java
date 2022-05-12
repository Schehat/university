/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dunkel
 */
@WebServlet(name = "BetterBMIServlet", urlPatterns = {"/betterBMIServlet"})
public class BetterBMIServlet extends HttpServlet {

   @Override
   protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //response.setContentType("text/html;charset=UTF-8");
        int weight;
        double height, bmi;
        String result = "";
        try {
            weight = Integer.parseInt(request.getParameter("kilos"));
            height = Double.parseDouble(request.getParameter("meter"));
            if (weight<0 || weight>300 || height<0.0 || height>4.0) {
                throw new IllegalArgumentException();
            }
            bmi = weight /(height * height);
            result += "Dein BMI beträgt: " + Math.round(bmi) ;
            if (bmi < 20)
                result += " - du hast Untergewicht";
            else if(bmi > 24)
                result += " - du hast Übergewicht";
            else 
                result += " - du hast Normalgewicht"; 
            System.out.println("******** " + result);
        } catch (NumberFormatException e) {
            result = "Nur numerische Werte eingeben!";
        } catch (IllegalArgumentException e) {
            result = "Ungültige Werte!";
        }
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet BMIServlet</title>");  
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"myWt.css\"/>" );
            out.println("</head>");
            out.println("<body");
            out.println("<h1> </h1>");
            out.println("<h1>" + " Better Servlet -  BMI Berechnung: " +  "</h1>");
            System.out.println(result);
            out.println("<h2>   " + result + "</h2>");
            out.println("</body>");
            out.println("</html>");
        }
        catch(Exception e){
            System.out.println(e);
        }
    }
}
