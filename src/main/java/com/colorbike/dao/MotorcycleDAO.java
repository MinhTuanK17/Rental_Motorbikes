/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.colorbike.dao;

import com.colorbike.dto.Account;
import com.colorbike.dto.Motorcycle;
import com.colorbike.util.DBUtil;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author huypd
 */
public class MotorcycleDAO implements Serializable, DAO<Motorcycle> {

    private static MotorcycleDAO instance;
    private Connection conn = DBUtil.makeConnection();

    // Cấm new trực tiếp DAO
    //Chỉ new DAO qua hàm static getInstance() để quản lí được số object/instance đã new - SINGLETON DESIGN PATTERN
    private MotorcycleDAO() {
    }

    public static MotorcycleDAO getInstance() {

        if (instance == null) {
            instance = new MotorcycleDAO();
        }
        return instance;
    }

    //Lấy tất cả các xe máy
    @Override
    public List<Motorcycle> getAll() {
        List<Motorcycle> list = new ArrayList<>();
        PreparedStatement stm;
        ResultSet rs;
        try {
            String sql = "SELECT \n"
                    + "    MotorcycleID,\n"
                    + "    Model,\n"
                    + "    Image,\n"
                    + "    Description,\n"
                    + "    [Min Age],\n"
                    + "    BrandID,\n"
                    + "    CategoryID,\n"
                    + "    PriceListID\n"
                    + "FROM \n"
                    + "    dbo.Motorcycle;";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Motorcycle(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    //Lấy xe máy theo id ==> xem detail
    public Motorcycle getMotorcycleByid(String id) {
        PreparedStatement stm;
        ResultSet rs;
        try {
            String sql = "SELECT \n"
                    + "    MotorcycleID,\n"
                    + "    Model,\n"
                    + "    Image,\n"
                    + "    Description,\n"
                    + "    [Min Age],\n"
                    + "    BrandID,\n"
                    + "    CategoryID,\n"
                    + "    PriceListID\n"
                    + "FROM \n"
                    + "    dbo.Motorcycle WHERE MotorcycleID = ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, id);
            rs = stm.executeQuery();
            while (rs.next()) {
                return new Motorcycle(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    //liệt kê 5 xe máy được thuê nhiều nhất trong tháng
    public List<Motorcycle> getTop5MotorcycleTheMostRental() {
        List<Motorcycle> list = new ArrayList<>();
        PreparedStatement stm;
        ResultSet rs;
        try {
            String sql = "SELECT TOP 5\n"
                    + "  m.MotorcycleID, m.Model, m.Image, m.Description, m.MinAge, m.BrandID, m.CategoryID, m.PriceListID, \n"
                    + "  COUNT(m.MotorcycleID) AS totalRent\n"
                    + "FROM Motorcycle m\n"
                    + "INNER JOIN [Motorcycle Detail] md ON m.MotorcycleID = md.MotorcycleID\n"
                    + "INNER JOIN [Booking Detail] bd ON md.MotorcycleDetailID = bd.MotorcycleDetailID\n"
                    + "INNER JOIN Booking b ON bd.BookingID = b.BookingID\n"
                    + "WHERE MONTH(b.bookingDate) = MONTH(GETDATE())  \n"
                    + "GROUP BY m.MotorcycleID, m.Model, m.Image, m.Description, m.MinAge, m.BrandID, m.CategoryID, m.PriceListID\n"
                    + "ORDER BY totalRent DESC";
            stm = conn.prepareStatement(sql);
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Motorcycle(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Tìm kiếm xe theo tên
    public List<Motorcycle> searchMotorcycleByName(String key) {
        List<Motorcycle> list = new ArrayList<>();
        PreparedStatement stm;
        ResultSet rs;
        try {
            String sql = "SELECT * FROM Motorcycle WHERE Model LIKE ?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, "%" + key + "%");
            rs = stm.executeQuery();
            while (rs.next()) {
                list.add(new Motorcycle(rs.getString(1), rs.getString(2), rs.getString(3),
                        rs.getString(4), rs.getInt(5), rs.getInt(6), rs.getInt(7),
                        rs.getInt(8)));
            }
        } catch (Exception ex) {
            Logger.getLogger(AccountDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    //Thanh lọc cơ thể (giá, hãng, loại, phân khối, nhu cầu, xe đc thuê nhiều nhất) 
//    public List<Motorcycle> searchMotorcycleByCriteria() {
//        
//    }
    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
   

    @Override
    public void insert(Motorcycle t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(Motorcycle t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Motorcycle t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public static void main(String[] args) {
        MotorcycleDAO dao = getInstance();
//        List<Motorcycle> list = dao.getAll();
//        for (Motorcycle x : list) {
//            System.out.println(x);
//        }
        List<Motorcycle> list = dao.searchMotorcycleByName("maha");
        for (Motorcycle x : list) {
            System.out.println(x);
        }
    }

}
