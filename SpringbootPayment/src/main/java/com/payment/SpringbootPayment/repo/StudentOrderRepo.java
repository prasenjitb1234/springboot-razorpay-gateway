package com.payment.SpringbootPayment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.payment.SpringbootPayment.dto.StudentOrder;


public interface StudentOrderRepo extends JpaRepository<StudentOrder,Integer>{

	public StudentOrder findByRazorpayOrderId(String orderId);
}
