package by.epam.library.model.entity;

import java.sql.Timestamp;
import java.util.Date;

public class Order {
    private Integer id;
    private Person reader;
    private Book book;
    private Timestamp orderDate;
    private Timestamp handOutDate;
    private Timestamp plannedReturnDate;
    private Timestamp actualReturnDate;
    private TypePlace place;

    public Order() {
    }

    public Order(int id, Person reader, Book book, Timestamp orderDate, Timestamp handOutDate, Timestamp plannedReturnDate,
                 Timestamp actualReturnDate, TypePlace place) {
        this.id = id;
        this.reader = reader;
        this.book = book;
        this.orderDate = orderDate;
        this.handOutDate = handOutDate;
        this.plannedReturnDate = plannedReturnDate;
        this.actualReturnDate = actualReturnDate;
        this.place = place;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getReader() {
        return reader;
    }

    public void setReader(Person reader) {
        this.reader = reader;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Timestamp getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Timestamp orderDate) {
        this.orderDate = orderDate;
    }

    public Timestamp getHandOutDate() {
        return handOutDate;
    }

    public void setHandOutDate(Timestamp handOutDate) {
        this.handOutDate = handOutDate;
    }

    public Timestamp getPlannedReturnDate() {
        return plannedReturnDate;
    }

    public void setPlannedReturnDate(Timestamp plannedReturnDate) {
        this.plannedReturnDate = plannedReturnDate;
    }

    public Timestamp getActualReturnDate() {
        return actualReturnDate;
    }

    public void setActualReturnDate(Timestamp actualReturnDate) {
        this.actualReturnDate = actualReturnDate;
    }

    public TypePlace getPlace() {
        return place;
    }

    public void setPlace(TypePlace place) {
        this.place = place;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (object == null || getClass( ) != object.getClass( )) {
            return false;
        }

        Order order = (Order) object;

        return (id == order.id) &&
                (reader == order.reader || reader != null && reader.equals(order.reader)) &&
                (book == order.book || book != null && book.equals(order.book)) &&
                (orderDate.equals(order.orderDate) && orderDate != null || order.orderDate != null) &&
                (handOutDate.equals(order.handOutDate)) &&
                (plannedReturnDate.equals(order.plannedReturnDate)) &&
                (actualReturnDate.equals(order.actualReturnDate)) &&
                (place == order.place);

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (reader != null ? reader.hashCode( ) : 0);
        result = 31 * result + (book != null ? book.hashCode( ) : 0);
        result = 31 * result + (orderDate != null ? orderDate.hashCode( ) : 0);
        result = 31 * result + (handOutDate != null ? handOutDate.hashCode( ) : 0);
        result = 31 * result + (plannedReturnDate != null ? plannedReturnDate.hashCode( ) : 0);
        result = 31 * result + (actualReturnDate != null ? actualReturnDate.hashCode( ) : 0);
        result = 31 * result + (place != null ? place.hashCode( ) : 0);
        return result;
    }
}
