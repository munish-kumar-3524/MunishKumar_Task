/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package railwayreservationsystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 *
 * @author Munish kumar
 */
public class RailwayReservationSystem {

    /**
     * @param args the command line arguments
     */
    final static Scanner SC = new Scanner(System.in);
    final static InputStreamReader ISR = new InputStreamReader(System.in);
    final static BufferedReader BR = new BufferedReader(ISR);
    static int bookingId = 1;
    static int lowerBerth;
    static int upperBerth;
    static int middleBerth;
    static int rac;
    static int waitingList;
    static int availableLowerBerth;
    static int availableUpperBerth;
    static int availableMiddleBerth;
    static int racBerth;
    static int racSeat;
    static int availableWaitingList;
    static Queue<Booking> ticketQueue = new LinkedList<>();
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        try{
            int berth = 0;
            System.out.print("Enter the total number of berth : ");
            berth = SC.nextInt();
            float temp = (float)((float)berth * (0.1));
            if(berth % 10 == 0){
                rac =  (int)temp;
            }else{
                rac = (int)temp + 1;
            }
            waitingList = (int)((float)berth * (0.25));
            berth = berth - rac;
            rac = rac*2;
            racBerth = rac/2;
            racSeat = rac/2;
            availableWaitingList = waitingList;
            upperBerth = berth/3;
            middleBerth = berth/3;
            lowerBerth = berth/3 + berth%3;
            availableUpperBerth = berth/3;
            availableMiddleBerth = berth/3;
            availableLowerBerth = berth/3 + berth%3; 
            

            boolean check = true;
            while(check){
                displayDetails();
                System.out.print("Do you want to continue yes-1 no-0 : ");
                int choice = SC.nextInt();
                if(choice == 0) check = false;
            }
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
    
    public static void displayDetails() throws IOException{
        System.out.println("1.Book\n2.Cancel\n3.Print booked tickets\n4.Print available tickets");
        System.out.print("Enter your choice : ");
        try{
            int choice = SC.nextInt();
            switch(choice){
                case 1 ->{
                    bookticket();
                }
                case 2 ->{
                    cancelticket();
                }
                case 3 ->{
                    printBookedTickets();
                }
                case 4 ->{
                    printAvailableTickets();
                }
                default -> System.out.println("Enter between 1 to 4");
            }
        }catch(InputMismatchException e){
            System.out.println(e);
        }
    }
    
    private static void bookticket() throws IOException {
        String passengerName, passengerGender, berth = "";
        String ticketType;
        int passengerAge;
        Children child = null;
        System.out.print("Enter your name : ");
        passengerName = BR.readLine();
        System.out.print("Enter your age : ");
        passengerAge = SC.nextInt();
        System.out.print("Enter your gender male/female/others : ");
        passengerGender = BR.readLine();
        
        System.out.print("Do you have a child age under 5 travelling with you (yes-1/No-0) : ");
        int choice = SC.nextInt();
        if(choice == 1){
            System.out.print("Enter your child name : ");
            String childName = BR.readLine();
            System.out.print("Enter your child age : ");
            int childAge = SC.nextInt();
            if(childAge <= 5){
                System.out.print("Enter your child gender male/female : ");
                String childGender = BR.readLine();
                Children tempChild = new Children(childName, childAge, childGender);
                child = tempChild;
            }else{
                System.out.println("Your child age is above 5 so book seperate ticket for your child");
            }     
        }
        
        if((passengerAge >= 60 || ("female".equals(passengerGender) && child != null)) && availableLowerBerth > 0){
            System.out.println("Considering your condition we automatically alloted lower berth to you");
            berth = "lower";
            availableLowerBerth--;
        }else{
            if(availableUpperBerth+availableMiddleBerth+availableLowerBerth>0){
                System.out.print("Enter your prefered berth lower/upper/middle: ");
                String tempBerth = BR.readLine();
                if("lower".equals(tempBerth)){
                    if(availableLowerBerth>0){
                        berth = "lower";
                        availableLowerBerth--;
                    }
                    else{
                        boolean check = true;
                        System.out.print("Sorry lower berth is not available we have ");
                        if(availableUpperBerth>0) System.out.print("upper ");
                        if(availableMiddleBerth>0) System.out.print("middle ");
                        System.out.println("berth only");
                        while(check){
                            System.out.print("Enter your prefered berth : ");
                            tempBerth = BR.readLine();
                            if("upper".equals(tempBerth) && availableUpperBerth>0){
                                berth = "upper";
                                availableUpperBerth--;
                                 check = false;
                            }else if("middle".equals(tempBerth) && availableMiddleBerth>0){
                                berth = "middle";
                                availableMiddleBerth--;
                                check = false;
                            }else{
                                System.out.println(tempBerth + " is not available");
                            }
                        }
                    }
                }else if("upper".equals(tempBerth)){
                    if(availableUpperBerth>0){
                        berth = "upper";
                        availableUpperBerth--;
                    }
                    else{
                        boolean check = true;
                        System.out.print("Sorry upper berth is not available we have ");
                        if(availableLowerBerth>0) System.out.print("lower ");
                        if(availableMiddleBerth>0) System.out.print("middle ");
                        System.out.println("berth only");
                        while(check){
                            System.out.print("Enter your prefered berth : ");
                            tempBerth = BR.readLine();
                            if("lower".equals(tempBerth) && availableLowerBerth>0){
                                berth = "lower";
                                availableLowerBerth--;
                                 check = false;
                            }else if("middle".equals(tempBerth) && availableMiddleBerth>0){
                                berth = "middle";
                                availableMiddleBerth--;
                                check = false;
                            }else{
                                System.out.println(tempBerth + " is not available");
                            }
                        }
                    }
                }else if("middle".equals(tempBerth)){
                    if(availableMiddleBerth>0){
                        berth = "middle";
                        availableMiddleBerth--;
                    }
                    else{
                        boolean check = true;
                        System.out.print("Sorry middle berth is not available we have ");
                        if(availableLowerBerth>0) System.out.print("lower ");
                        if(availableUpperBerth>0) System.out.print("upper ");
                        System.out.println("berth only");
                        while(check){
                            System.out.print("Enter your prefered berth : ");
                            tempBerth = BR.readLine();
                            if("lower".equals(tempBerth) && availableLowerBerth>0){
                                berth = "lower";
                                availableLowerBerth--;
                                 check = false;
                            }else if("upper".equals(tempBerth) && availableUpperBerth>0){
                                berth = "upper";
                                availableUpperBerth--;
                                check = false;
                            }else{
                                System.out.println(tempBerth + " is not available");
                            }
                        }
                    }
                }
            }else if(racBerth+racSeat>0){
                System.out.println("Berths are not available so your ticket have alloted under RAC");
                if(bookingId % 2 == 0){
                    berth = "rac berth";
                    racBerth--;
                }
                else{
                    berth = "rac seat";
                    racSeat--;
                }
            }else if(availableWaitingList>0){
                System.out.println("Seats are not available so your ticket have alloted under waiting list");
                berth = "waiting";
                availableWaitingList--;
            }else{
                System.out.println("No tickets available");
                return;
            }
        }
        Passengers passenger = new Passengers(passengerName, passengerAge, passengerGender, berth);
        passenger.setChildren(child);
        if("rac berth".equals(berth) || "rac seat".equals(berth)) ticketType = "rac";
        else if("waiting".equals(berth)) ticketType = "waiting";
        else ticketType = "confirmed";
        Booking book = new Booking(bookingId, ticketType);
        book.setPassenger(passenger);
        ticketQueue.add(book);
        System.out.print("Your Pnr is ");
        System.out.println(bookingId);
        if(!"waiting".equals(berth)) System.out.println("Ticket has been booked successfully");
        bookingId++;
    }

    private static void printAvailableTickets() {
        System.out.print("Available lower berth : ");
        System.out.println(availableLowerBerth);
        System.out.print("Available middle berth : ");
        System.out.println(availableMiddleBerth);
        System.out.print("Available upper berth : ");
        System.out.println(availableUpperBerth);
        System.out.print("Available rac berth : ");
        System.out.println(racBerth);
        System.out.print("Available rac seat : ");
        System.out.println(racSeat);
        System.out.print("Available Waiting List : ");
        System.out.println(availableWaitingList);
        System.out.print("Total available tickets : ");
        System.out.println(availableUpperBerth+availableMiddleBerth+availableLowerBerth+racBerth+racSeat+availableWaitingList);
    }

    private static void cancelticket() {
        if(ticketQueue.isEmpty()){
            System.out.println("no booking to cancel");
            return;
        }
        System.out.print("Enter your Pnr : ");
        int bookingId = SC.nextInt();
        Booking ticket = null;
        for(Booking book : ticketQueue){
            if(book.getBookingId() == bookingId) ticket = book;
        }
        if(ticket.getTicketType().equals("confirmed") && racBerth+racSeat != rac && availableWaitingList != waitingList){
            Booking tempTicket1 = null;
            for(Booking book:ticketQueue){
                if(book.getTicketType().equals("rac")){
                    tempTicket1 = book;
                    break;
                }
                
            }
            if(availableWaitingList != waitingList){
                Booking tempTicket2 = null;
                for(Booking book:ticketQueue){
                    if(book.getTicketType().equals("waiting")){
                        tempTicket2 = book;
                        break;
                    }
                }
                if(tempTicket1.getPassenger().getBerthPreference().equals("rac berth")){
                    Booking tempTicket3 = null;
                    for(Booking book:ticketQueue){
                        if(book.getPassenger().getBerthPreference().equals("rac seat")){
                            tempTicket3 = book;
                            break;
                        }
                    }
                    if(tempTicket3 != null){
                        tempTicket2.setTicketType(tempTicket3.getTicketType());
                        tempTicket2.getPassenger().setBerthPreference(tempTicket3.getPassenger().getBerthPreference());
                        availableWaitingList++;
                        tempTicket3.setTicketType(tempTicket1.getTicketType());
                        tempTicket3.getPassenger().setBerthPreference(tempTicket1.getPassenger().getBerthPreference());
                    }else{
                        tempTicket2.setTicketType(tempTicket1.getTicketType());
                        tempTicket2.getPassenger().setBerthPreference(tempTicket1.getPassenger().getBerthPreference());
                        availableWaitingList++;
                    }
                }else{
                    tempTicket2.setTicketType(tempTicket1.getTicketType());
                    tempTicket2.getPassenger().setBerthPreference(tempTicket1.getPassenger().getBerthPreference());
                    availableWaitingList++;
                }
            }
            tempTicket1.setTicketType(ticket.getTicketType());
            tempTicket1.getPassenger().setBerthPreference(ticket.getPassenger().getBerthPreference());

        }else if(ticket.getTicketType().equals("confirmed") && racBerth+racSeat != rac && availableWaitingList == waitingList){
            Booking tempTicket1 = null;
            for(Booking book:ticketQueue){
                if(book.getTicketType().equals("rac")){
                    tempTicket1 = book;
                    break;
                }
            }
            tempTicket1.setTicketType(ticket.getTicketType());
            tempTicket1.getPassenger().setBerthPreference(ticket.getPassenger().getBerthPreference());
            if(ticket.getBookingId() % 2 == 0) racBerth++;
            else racSeat++;
            
        }else if(ticket.getTicketType().equals("rac") && availableWaitingList != waitingList){
            Booking tempTicket2 = null;
            for(Booking book:ticketQueue){
                if(book.getTicketType().equals("waiting")){
                    tempTicket2 = book;
                    break;
                }
            }
            if(ticket.getPassenger().getBerthPreference().equals("rac berth")){
                Booking tempTicket3 = null;
                for(Booking book:ticketQueue){
                    if(book.getPassenger().getBerthPreference().equals("rac seat")){
                        tempTicket3 = book;
                        break;
                    }
                }
                if(tempTicket3 != null){
                    tempTicket2.setTicketType(tempTicket3.getTicketType());
                    tempTicket2.getPassenger().setBerthPreference(tempTicket3.getPassenger().getBerthPreference());
                    availableWaitingList++;
                    tempTicket3.setTicketType(ticket.getTicketType());
                    tempTicket3.getPassenger().setBerthPreference(ticket.getPassenger().getBerthPreference());
                }else{
                    tempTicket2.setTicketType(ticket.getTicketType());
                    tempTicket2.getPassenger().setBerthPreference(ticket.getPassenger().getBerthPreference());
                    availableWaitingList++;
                }
            }else{
                tempTicket2.setTicketType(ticket.getTicketType());
                tempTicket2.getPassenger().setBerthPreference(ticket.getPassenger().getBerthPreference());
                availableWaitingList++;
            }
            
        }else if(ticket.getTicketType().equals("confirmed") && racBerth+racSeat == rac){
            if(ticket.getPassenger().getBerthPreference().equals("upper")) availableUpperBerth++;
            else if(ticket.getPassenger().getBerthPreference().equals("lower")) availableLowerBerth++;
            else if(ticket.getPassenger().getBerthPreference().equals("middle")) availableMiddleBerth++;
            
        }else if(ticket.getTicketType().equals("rac") && availableWaitingList == waitingList){
            if(ticket.getBookingId() % 2 == 0) racBerth++;
            else racSeat++;
            
        }
        ticketQueue.remove(ticket);
        System.out.println("Booking cancled successfully");
    }

    private static void printBookedTickets() {
        System.out.println("Details:\tPnr\tName\tAge\tGender\tBerthpreference");
        for(Booking book:ticketQueue){
            System.out.println("Person:\t"+'\t'+book.getBookingId()+'\t'+book.getPassenger().getName()+'\t'+book.getPassenger().getAge()+'\t'+book.getPassenger().getGender()+'\t'+book.getPassenger().getBerthPreference());
            if(book.getPassenger().getChildren()!=null){
                System.out.println("Children of person:"+book.getBookingId()+'\t'+book.getPassenger().getChildren().getName()+'\t'+book.getPassenger().getChildren().getAge()+'\t'+book.getPassenger().getChildren().getGender());
            }
        }
        System.out.print("Total number of booking : ");
        System.out.println(ticketQueue.size());
    }
}
