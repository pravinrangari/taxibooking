package tech.codehunt.service;

import java.util.List;

import org.springframework.stereotype.Service;

import tech.codehunt.model.BookingForm;
import tech.codehunt.model.ContactForm;



public interface BookingFormService {
	
	public  BookingForm savebookingFormService(BookingForm bookingForm);
	
	   public  List<BookingForm> readAllBookingService();

	    public	void deletebookingFormService(int id);
	

}
