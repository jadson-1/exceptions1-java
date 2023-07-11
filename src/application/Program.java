package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservation;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Room number: ");
		int roomNumber = sc.nextInt();
		System.out.print("Check-in date (DD/MM/YYYY): ");
		Date checkIn = sdf.parse(sc.next());
		System.out.print("Check-out date (DD/MM/YYYY): ");
		Date checkOut = sdf.parse(sc.next());
		
		Date corrCheckIn = checkIn;
		Date corrCheckOut = checkOut;
		
		if(!checkOut.before(checkIn)) {
			Reservation reservation = new Reservation(roomNumber, checkIn, checkOut);
			System.out.println(reservation.toString());
			
			System.out.println();
			System.out.println("Enter data to update the reservation:");
			System.out.print("Check-in date (DD/MM/YYYY): ");
			checkIn = sdf.parse(sc.next());
			System.out.print("Check-out date (DD/MM/YYYY): ");
			checkOut = sdf.parse(sc.next());
			
			if(checkIn.before(corrCheckIn) || checkOut.before(corrCheckOut)) {
				System.out.println("Error in reservation: Reservation dates for update must be future dates");
			}
			else if(checkIn.after(checkOut)) {
				System.out.println("Error in reservation: Check-out date must be after check-in date");
			}
			else {
				reservation.updateDates(checkIn, checkOut);
				System.out.println(reservation.toString());
			}
		}
		else {
			System.out.println("Error in reservation: Check-out date must be after check-in date");
		}
		
		sc.close();
	}

}
