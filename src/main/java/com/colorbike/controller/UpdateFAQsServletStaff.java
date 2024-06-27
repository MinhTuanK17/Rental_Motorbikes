/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.colorbike.controller;

import com.colorbike.dao.FAQDAO;
import com.colorbike.dto.FAQ;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "UpdateFAQsServletStaff", urlPatterns = {"/UpdateFAQsServletStaff"})
public class UpdateFAQsServletStaff extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        FAQDAO faqDAO = FAQDAO.getInstance();
        String idStr = request.getParameter("questionID");
        String question = request.getParameter("question");
        String answer = request.getParameter("answer");

        int questionID = Integer.parseInt(idStr);
        FAQ faq = new FAQ();
        faq.setQuestionID(questionID);
        faq.setQuestion(question);
        faq.setAnswer(answer);
        faqDAO.updateFAQs(faq);

        response.sendRedirect("faqs");
    }

}
