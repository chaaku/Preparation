
public class BookMyShow {
	
	
	public static void main(String[] args) {
				//1,2,3,4, 5, 6 ,7 ,8 ,9, 10
	int arr [] = {1,4,5,23,21,34,52,66,13};
	
	//            1 4 5 34 23 52 21 66 13 
	
	// o = 0
	// e = 1
	int evenIndex= -1;
	int oddIndex = -2;
	
	
	for(int i=0; i<arr.length;i++) {
		if(arr[i]%2==0) {
			if ( i%2 !=0)
			evenIndex+=2;
			else {
				evenIndex+=2;
				swap(arr, i, evenIndex);
			}
		}
		if(arr[i]%2!=0) {
			if(i%2 ==0 && i!=0)
				oddIndex+=2;
			else {
				oddIndex+=2;
				swap(arr, i, oddIndex);
			}
		}
	}
	
	for(int m:arr)
		System.out.print(m+" ");
		
	}

	private static void swap(int[] arr, int i, int oddIndex) {
		// TODO Auto-generated method stub
		int temp = arr[i];
		arr[i]=arr[oddIndex];
		arr[oddIndex] = temp;
	}

	
	/*
	 * The Main Classes to be used for the user persons :

User
Movie
Theater
Booking
Address
Facilities
filter_none


// Java skeleton code to design an online movie 
// booking system. 
Enums : 
  
    public enum SeatStatus { 
    SEAT_BOOKED, 
    SEAT_NOT_BOOKED; 
} 
  
public enum MovieStatus { 
    Movie_Available, 
    Movie_NotAvailable; 
} 
  
public enum MovieType { 
    ENGLISH, 
    HINDI; 
} 
  
public enum SeatType { 
    NORMAL, 
    EXECUTIVE, 
    PREMIUM, 
    VIP; 
} 
  
public enum PaymentStatus { 
    PAID, 
    UNPAID; 
} 
  
class User { 
  
    int userId; 
    String name; 
    Date dateOfBirth; 
    String mobNo; 
    String emailId; 
    String sex; 
} 
  
class Movie { 
  
    int movieId;
    String movieName; 
    int theaterId; 
    MovieType movieType; 
    
    MovieStatus movieStatus; 
} 
  
class Theater { 
  
    int theaterId; 
    String theaterName; 
    Adress adress; 
  
    List<Movie> movies; 
    float rating; 
} 
  
class Booking { 
    int bookingId; 
    int userId; 
    int movieId; 
    List<Movie> bookedSeats; 
    int amount; 
    PaymentStatus status_of_payment; 
    Date booked_date; 
    Time movie_timing; 
} 
  
class Address { 
  
    String city; 
    String pinCode; 
    String state; 
    String streetNo; 
    String landmark; 
} 


	 */
}
