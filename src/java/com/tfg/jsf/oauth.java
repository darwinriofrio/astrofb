/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tfg.jsf;

import com.restfb.Connection;
import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.types.User;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
/**
 *
 * @author darwin
 */
public class oauth extends HttpServlet {

    private FacebookClient facebookClient;
    //public static Usuario usuario = new Usuario();

    /**
     * Processes requests for both HTTP
     * <code>GET</code> and
     * <code>POST</code> methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String signedRequest = (String) request.getParameter("signed_request");
        FacebookSignedRequest facebookSR = null;

        try {
            facebookSR = FacebookSignedRequest.getFacebookSignedRequest(signedRequest);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        String oauthToken = facebookSR.getOauth_token();
        //String oauthToken = null;
        PrintWriter writer = response.getWriter();
        if (oauthToken == null) {

            response.setContentType("text/html");
            String authURL = "https://www.facebook.com/dialog/oauth?client_id="
                    + Constantes.API_KEY + "&redirect_uri=https://apps.facebook.com/astro-app/&scope=";
            writer.print("<script> top.location.href='" + authURL + "'</script>");
            writer.close();

        } else {

            facebookClient = new DefaultFacebookClient(oauthToken);
            User user = facebookClient.fetchObject("me", User.class);
            //usuario.setNombre(user.getName());
            //System.out.println(usuario.getNombre());
            //response.sendRedirect("/faces/inicio.xhtml");
            
            //HttpSession session = request.getSession();
            //session.setAttribute(exp1Bean.name, user.getName());
            request.setAttribute(exp1Bean.name, user.getName());
            request.setAttribute("username", user.getName());
            RequestDispatcher rd = request.getRequestDispatcher("/faces/inicio.xhtml");
            rd.forward(request, response);
            
            
            

            //writer.print("<tr><td><img src=\"https://graph.facebook.com/" + user.getId() + "/picture\"/></td><td>" + user.getName() +"</td><td>" + user.getId() + "</td></tr>");

            /*Connection<User> myFriends = facebookClient.fetchConnection("me/friends", User.class);
             writer.print("<table><tr><th>Photo</th><th>Name</th><th>Id</th></tr>");
             for (List<User> myFriendsList : myFriends) {
	
             for(User user: myFriendsList)
             writer.print("<tr><td><img src=\"https://graph.facebook.com/" + user.getId() + "/picture\"/></td><td>" + user.getName() +"</td><td>" + user.getId() + "</td></tr>");
	
             }
             writer.print("</table>"); */
            //writer.close();

        }



        /*response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
         try {
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet oauth</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet oauth at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         } finally {            
         out.close();
         }*/
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP
     * <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
