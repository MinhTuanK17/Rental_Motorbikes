
package com.colorbike.controller;

import com.colorbike.constant.GoogleLogin;
import com.colorbike.constant.PasswordGenerator;
import com.colorbike.dao.AccountDAO;
import com.colorbike.dto.Account;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.json.JSONObject;

@WebServlet(name="LoginGoogleServlet", urlPatterns={"/login-google"})
public class LoginGoogleServlet extends HttpServlet {
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        HttpSession session = request.getSession();
        String code = request.getParameter("code");
        String accessToken = GoogleLogin.getToken(code);
        //String jsonAcc = GoogleLogin.getUserInfo(accessToken);
        String email = GoogleLogin.getEmail(accessToken);
        Account acc = AccountDAO.getInstance().getAccountByEmail(email);
        if (acc == null) { //chưa có account
            //tạo 1 account mới chỉ bao gồm: email, username (email), password
            AccountDAO.getInstance().createANewAccountForLoginGoogle(email, PasswordGenerator.generatePassword(6));
            acc = AccountDAO.getInstance().getAccountByEmail(email);
        }
        session.setAttribute("account", acc);
        request.getRequestDispatcher("home.jsp").forward(request, response);
    } 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    } 

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        processRequest(request, response);
    }

}
