package by.epam.library.services;

import by.epam.library.dao.BookDAO;
import by.epam.library.dao.ConnectionPool;
import by.epam.library.model.entity.Book;
import by.epam.library.model.exception.DAOException;
import by.epam.library.model.exception.ServiceException;

import java.sql.Connection;
import java.util.List;

public class BookService {

    private static final String BOOK_TABLE = "library.book";
    private static final String AMOUNT_FIELD = "amount";
    private static final String BOOK_ID = "id_book";

    public Book findBookByID(int id) throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            connectionPool.returnConnection(connection);
            return null;//bookDAO.findBookByID(id);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public List findAllBook() throws ServiceException {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            connectionPool.returnConnection(connection);
            return bookDAO.findAll();
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
    }

    public void decrementAmountBook(int id) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
//            Book book = bookDAO.findBookByID(id);
//
//            int amountBook = book.getAmount( );
//            int newAmountBook = amountBook - 1;
//
//            bookDAO.updateByID(BOOK_TABLE, AMOUNT_FIELD, BOOK_ID, newAmountBook, id);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        }
    }

    public void incrementAmountBook(int id) {
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            //Book book = bookDAO.findBookByID(id);

           // int amountBook = book.getAmount( );
            //int newAmountBook = amountBook + 1;

            //bookDAO.updateByID(BOOK_TABLE, AMOUNT_FIELD, BOOK_ID, newAmountBook, id);

            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            e.printStackTrace( );
        }
    }

    public List findBookByLastNameAuthorAndNameBook(String lastNameAuthor, String nameBook) throws ServiceException {
        List catalog;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            catalog = bookDAO.findBookByLastNameAuthorAndNameBook(lastNameAuthor, nameBook);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
        return catalog;
    }

    public List findBookByLastNameAuthor(String lastNameAuthor) throws ServiceException {
        List catalog;
        try {
            ConnectionPool connectionPool = ConnectionPool.getInstance( );
            Connection connection = connectionPool.getConnection( );
            BookDAO bookDAO = new BookDAO(connection);
            catalog = bookDAO.findBookByLastNameAuthor(lastNameAuthor);
            connectionPool.returnConnection(connection);
        } catch (DAOException e) {
            throw new ServiceException(e.getMessage( ), e);
        }
        return catalog;
    }
}