/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package railwayreservationsystem;

/**
 *
 * @author Munish kumar
 */
public class Booking {
    private int bookingId;
    private Passengers passenger = null;
    private String ticketType;

    public Booking(int bookingId, String ticketType) {
        this.bookingId = bookingId;
        this.ticketType = ticketType;
    }

    public void setPassenger(Passengers passenger) {
        this.passenger = passenger;
    }

    public void setTicketType(String ticketType) {
        this.ticketType = ticketType;
    }

    public int getBookingId() {
        return bookingId;
    }

    public Passengers getPassenger() {
        return passenger;
    }

    public String getTicketType() {
        return ticketType;
    }
    
}
