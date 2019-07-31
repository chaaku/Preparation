import java.util.Arrays;
import java.util.Collections;

public class PaymentSystem {
	
	public static void main(String[] args) {
	System.out.println(10%100000007);
	Collections.sort(Arrays.asList());
	}
	
	
	/*


In a minimal version of payment gateway system, we need to collect account details from the client and pass the information to banking service and communicate back the status of the transaction. 

So we need a secure channel to pass the data in between multiple modules. We have to maintain the reliability as well as system should handle concurrent transactions. 

Presentation layer collects the data and pass details as a message to an asynchronous message queuing system, so we can maintain a reliability and concurrency. Controller layer can asynchronously process and communicate back to the presentation layer the status as response message. It may be an error message or a successful status message. Controller layer can invoke reprocessing a limited time if it is error out during the transaction. 

In controller layer we can develop a adapter design pattern and depends on the target system we can reprocess the input message and pass the message depends on each target system's API.


	 */
}
