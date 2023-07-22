package ru.andrew.test11.controllers;
import ru.andrew.test11.dao.InventDAO;
import ru.andrew.test11.models.Invent;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "inventController", value = "/invent-controller")
public class InventController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InventDAO inventDAO = new InventDAO();
        if(req.getParameter("id") != null) {
            //Вывод карточки товара
            Invent invent;
            invent = (Invent)inventDAO.show(Integer.parseInt(req.getParameter("id")));
            req.setAttribute("invent", invent);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/invents/show.jsp");
            requestDispatcher.forward(req, resp);
        }
        else {
            //Вывод полного списка товаров
            List<Invent> inventList;
            inventList = inventDAO.index();
            req.setAttribute("inventList", inventList);
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/views/invents/index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Invent invent = new Invent();
        InventDAO inventDAO = new InventDAO();
        String operationParm = (String)req.getParameter("operation");
        switch (operationParm){
            case "edit":
            case "add":
                invent.setItem_id(Integer.parseInt(req.getParameter("item_id")));
                invent.setItem_name(req.getParameter("item_name"));
                invent.setItem_price(Integer.parseInt(req.getParameter("item_price")));
                invent.setItem_img(req.getParameter("item_img"));
                break;
            case "delete":
                invent.setItem_id(Integer.parseInt(req.getParameter("item_id")));
                invent.setItem_name(req.getParameter("item_name"));
                break;
        }
        switch (operationParm){
            case "edit":
                inventDAO.edit(invent);
                break;
            case "delete":
                inventDAO.delete(invent);
                break;
            case "add":
                inventDAO.add(invent);
                break;
        }
        resp.sendRedirect("/invent-controller");
    }
}
