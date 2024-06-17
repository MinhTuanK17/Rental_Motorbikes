/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

package com.colorbike.controller;

import com.colorbike.dao.BrandDAO;
import com.colorbike.dao.CategoryDAO;
import com.colorbike.dao.MotorcycleDAO;
import com.colorbike.dao.PriceListDAO;
import com.colorbike.dto.Brand;
import com.colorbike.dto.Category;
import com.colorbike.dto.Motorcycle;
import com.colorbike.dto.PriceList;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

/**
 *
 * @author DiepTCNN
 */
@WebServlet(name="MotorbikeManagementServlet", urlPatterns={"/motorManage"})
public class MotorbikeManagementServlet extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        MotorcycleDAO md = MotorcycleDAO.getInstance();
        PriceListDAO pd = PriceListDAO.getInstance();
        BrandDAO bd = BrandDAO.getInstance();
        CategoryDAO cd = CategoryDAO.getInstance();
        
                
        List<Motorcycle> listM = md.getAll();
        List<PriceList> listP = pd.getAllPriceList();
        List<Brand> listB = bd.getAllBrand();
        List<Category> listC = cd.getAllCategory();
          
        request.setAttribute("listM", listM);
        request.setAttribute("listP", listP);
        request.setAttribute("listB", listB);
        request.setAttribute("listC", listC);
        
        request.getRequestDispatcher("motorbikeManagement.jsp").forward(request, response);
        
    } 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
