package by.epam.library.model.command.admin;

import by.epam.library.model.command.common.ActionCommand;
import by.epam.library.model.command.util.PageFactory;
import by.epam.library.model.exception.CommandException;
import by.epam.library.model.exception.ServiceException;
import by.epam.library.services.BookService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ShowSearchBookCommand implements ActionCommand {

    private static final String ADMIN_TABLE = "admin_table";
    private static final String BOOKS = "Books";
    private static final String CAPTION = "caption";
    private static final String ENTITIES = "entities";

    /**
     * Load all book in page and load it in response
     *
     * @param request
     * @param response
     * @throws CommandException
     * @throws ServiceException
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws CommandException, ServiceException, ServletException, IOException {
        PageFactory pageFactory = new PageFactory( );
        String page = pageFactory.createPage(ADMIN_TABLE);

        BookService bookService = new BookService( );
        List persons = bookService.findAllBook( );

        HttpSession currentSession = request.getSession( );
        currentSession.setAttribute(CAPTION, BOOKS);
        currentSession.setAttribute(ENTITIES, persons);
        response.sendRedirect(page);
    }
}
