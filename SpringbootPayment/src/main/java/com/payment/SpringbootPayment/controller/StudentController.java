package com.payment.SpringbootPayment.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.payment.SpringbootPayment.dto.StudentOrder;
import com.payment.SpringbootPayment.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService service;
	
	// one method will acts as UI page and 
	@GetMapping("/")
	public String init() {
		return "index";
	}
	
	// second method will act as REST controller
	
	@PostMapping(value="/create-order", produces="application/json")
	@ResponseBody
	public ResponseEntity<StudentOrder> createOrder(@RequestBody StudentOrder studentOrder) throws Exception{
		StudentOrder createdOrder = service.createOrder(studentOrder);
		return new ResponseEntity<>(createdOrder,HttpStatus.CREATED);
	}
	
	
	// call back method to get response from razorpay
	
//	@PostMapping("/handle-payment-callback")
//	public String handlePaymentCallback(@RequestParam Map<String, String> respPayload) {
//		System.out.println(respPayload);
//		service.updateOrder(respPayload);
//		
//		return "success";
//	}
	
	@PostMapping("/handle-payment-callback")
	public String handlePaymentCallback(@RequestParam Map<String, String> respPayload) {
	    System.out.println("Payment callback response: " + respPayload);

	    // Extract Razorpay fields from the callback response
	    String razorpayPaymentId = respPayload.get("razorpay_payment_id");
	    String razorpayOrderId = respPayload.get("razorpay_order_id");
	    String razorpaySignature = respPayload.get("razorpay_signature");

	    // You should validate the signature here using Razorpay secret key (optional for testing but important for production)
	    try {
	        service.updateOrder(respPayload); // Update the order status in the database
	        System.out.println("Payment callback processed successfully!");
	    } catch (Exception e) {
	        System.err.println("Error processing payment callback: " + e.getMessage());
	    }

	    return "success";  // Return the success.html page
	}

	
}
