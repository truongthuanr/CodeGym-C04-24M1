package controller;

import entity.Apartments;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.eclipse.tags.shaded.org.apache.xpath.res.XPATHErrorResources_it;
import service.apartmentService;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "homeController",value = "/home")
public class HomeController extends HttpServlet {
    private apartmentService apartmentService = new apartmentService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showHome(req,resp);
    }

    public void showHome(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Apartments> apartments = apartmentService.getAll();

        RequestDispatcher rd = req.getRequestDispatcher("view/home.jsp");
//        System.out.println(apartments.get(0).getStartdate());

        req.setAttribute("apartments",apartments);

        rd.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        showHome(req,resp);
    }
}
