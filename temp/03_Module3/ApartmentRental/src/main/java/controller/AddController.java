package controller;

import entity.Apartments;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.apartmentService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@WebServlet(name = "addController",value = "/add")
public class AddController extends HttpServlet {

    private service.apartmentService apartmentService = new apartmentService();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showAdd(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            addApartment(req,resp);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    private void showAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("view/add.jsp");


        rd.forward(req,resp);
    }

    public void addApartment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, ParseException {
        // Get  param from web view
        String name =  req.getParameter("name");
        String tel = req.getParameter("tel");
        String startdate_s = req.getParameter("startdate");
        String paytype = req.getParameter("paytype");
        String note = req.getParameter("note");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date startdate = formatter.parse(startdate_s);
//        System.out.println(startdate.getClass().getName());



        Apartments apartment = new Apartments(0,name,tel,startdate,paytype,note);
        apartmentService.add(apartment);
        resp.sendRedirect(req.getContextPath() + "/home");
    }
}
