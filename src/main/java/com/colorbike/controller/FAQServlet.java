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
import java.util.List;

@WebServlet(name = "FAQServlet", urlPatterns = {"/FAQ"})
public class FAQServlet extends HttpServlet {

    private FAQDAO faqDAO;

    @Override
    public void init() throws ServletException {
        // Khởi tạo DAO. Giả định FAQDAO có phương thức getInstance() để lấy instance.
        faqDAO = FAQDAO.getInstance(); 
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Lấy danh sách các FAQs từ DAO
        List<FAQ> FAQList = faqDAO.getAllFAQ();
        // Đặt danh sách vào request attribute để chuyển tiếp tới JSP
        request.setAttribute("FAQ", FAQList);
        // Chuyển tiếp yêu cầu tới trang JSP để hiển thị
        request.getRequestDispatcher("faqs.jsp").forward(request, response);
    }
}

