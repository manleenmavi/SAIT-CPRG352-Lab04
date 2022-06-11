package servlets;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Note;

public class NoteServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.setAttribute("note", readNoteFile(getServletContext().getRealPath("/WEB-INF/note.txt")));
        
        if(request.getParameter("edit") == null) {
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
            return;
        }
        
        getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String noteTitle = request.getParameter("edit_title");
        String noteContent = request.getParameter("edit_content");
        
        PrintWriter noteFileWriter = new PrintWriter(new BufferedWriter(new FileWriter(getServletContext().getRealPath("/WEB-INF/note.txt"))));
        noteFileWriter.println(noteTitle);
        noteFileWriter.print(noteContent);
        noteFileWriter.close();
        
        request.setAttribute("note", readNoteFile(getServletContext().getRealPath("/WEB-INF/note.txt")));
        
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
    }

    //Private Method for reading Note file
    private Note readNoteFile(String path) throws FileNotFoundException {
        String noteTitle;
        String noteContent;
        BufferedReader noteFileReader = new BufferedReader(new FileReader(path));
        
        //Reading Title
        try {
            noteTitle = noteFileReader.readLine();
        } catch (IOException e) {
            noteTitle = "";
        }
        
        //Reading Conetnt
        noteContent = noteFileReader.lines().collect(Collectors.joining(System.lineSeparator()));

        //Closing Reader
        try {
            noteFileReader.close();
        } catch (IOException e) {
        }
        
        return new Note(noteTitle, noteContent);
    }
    
    // Private Method for saving Note file
    private void saveNoteFile(String path, String noteTitle, String noteContent) throws IOException {
        
        
        
    }
}
