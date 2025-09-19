package tech.codehunt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.codehunt.dao.BookingFormCrud;
import tech.codehunt.model.BookingForm;

@Service
public class BookingFormServiceimpl implements BookingFormService {
	
   private BookingFormCrud bookingFormCrud;
   
     @Autowired
	public void setBookingFormCrud(BookingFormCrud bookingFormCrud) {
	   this.bookingFormCrud = bookingFormCrud;
}


	@Override
	public BookingForm savebookingFormService(BookingForm bookingForm) {
		
		return bookingFormCrud.save(bookingForm);
	}


	@Override
	public List<BookingForm> readAllBookingService() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deletebookingFormService(int id) {
		// TODO Auto-generated method stub
		
	}

}
