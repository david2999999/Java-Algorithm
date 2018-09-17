package Redo.OOD.ParkingLot;

import java.util.Date;

public class Ticket {
    private int ticketId;
    private String licencePlate;
    private Date date;
    private Date expirationDate;

    public Ticket(int ticketId, String licencePlate, Date date) {
        this.ticketId = ticketId;
        this.licencePlate = licencePlate;
        this.date = date;
    }
}
