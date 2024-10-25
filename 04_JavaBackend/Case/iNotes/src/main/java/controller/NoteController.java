package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import service.NoteService;


import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entity.Note;

@WebServlet(name="noteController", value="/notes")
public class NoteController  extends HttpServlet {

    private final NoteService noteService = new NoteService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteService.getAll();

        RequestDispatcher rd = req.getRequestDispatcher("/view/home.jsp");
        req.setAttribute("notes", notes);
        rd.forward(req, resp);
    }
}

//@jakarta.servlet.annotation.WebServlet(name = "helloServlet", value = "/h")
//public class NoteController extends HttpServlet {
//    private String message;
//
//    public void init() {
//        message = "Hello World!";
//    }
//
//    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        response.setContentType("text/html");
//
//        // Hello
//        PrintWriter out = response.getWriter();
//        out.println("<html><body>");
//        out.println("<h1>" + message + "</h1>");
//        out.println("</body></html>");
//    }
//
//    public void destroy() {
//    }
//}
