package by.epam.library.model.command.common;

import by.epam.library.model.command.admin.*;
import by.epam.library.model.command.librarian.HandOutCommand;
import by.epam.library.model.command.librarian.LibrarianCommand;
import by.epam.library.model.command.librarian.ReturnBookCommand;
import by.epam.library.model.command.librarian.ShowPageReturnBookCommand;
import by.epam.library.model.command.reader.*;

public class ActionFactory {

    /**
     * Find necessary command
     *
     * @param typeCommand
     * @return
     */
    public ActionCommand defineCommand(String typeCommand) {
        if (typeCommand == null || typeCommand.equals("")) {
            return new EmptyCommand( );
        }
        CommandEnum currentEnum = CommandEnum.getCommandEnum(typeCommand);

        switch (currentEnum) {
            case LOGIN:
                return new LoginCommand( );
            case LIBRARIAN:
                return new LibrarianCommand( );
            case ADMIN:
                return new AdminCommand( );
            case READER:
                return new ReaderCommand( );
            case LOGOUT:
                return new LogoutCommand( );
            case HAND:
                return new HandOutCommand( );
            case SEARCH_BOOK:
                return new SearchBookCommand( );
            case ORDER:
                return new OrderBookCommand( );
            case ARCHIVE_BOOK:
                return new ArchiveBookCommand( );
            case CURRENT_BOOK:
                return new CurrentBookCommand( );
            case ORDERED_BOOK:
                return new ShowOrderedBookCommand( );
            case SHOW_PAGE_RETURN_BOOK:
                return new ShowPageReturnBookCommand( );
            case RETURN_BOOK:
                return new ReturnBookCommand( );
            case SHOW_SEARCH_BOOK:
                return new ShowSearchBookCommand( );
            case SHOW_SEARCH_PERSON:
                return new ShowSearchPersonCommand( );
            case SHOW_ADD_OR_EDIT_BOOK:
                return new ShowAddOrEditBookCommand( );
            case SHOW_ADD_OR_EDIT_PERSON:
                return new ShowAddOrEditPersonCommand( );
            case SHOW_ADD_PUBLISHER:
                return new ShowAddPublisherCommand();
            case SHOW_ADD_AUTHOR:
                return new ShowAddAuthorCommand();
            case ADD_AUTHOR:
                return new AddAuthorCommand();
            case ADD_PUBLISHER:
                return new AddPublisherCommand();
            default:
                return new EmptyCommand( );
        }
    }
}