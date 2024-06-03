/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.colorbike.dao;

import java.util.List;

/**
 *
 * @author huypd
 */
public interface DAO<T> { //cái nào cần những hàm này thì impl, sẽ update thêm những hàm đc dùng nhiều lần
    List<T> getAll();
    void insert(T t);
    void update(T t);
    void delete(T t);
}
