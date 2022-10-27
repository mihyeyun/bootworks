package com.shop.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.shop.dto.OrderDto;
import com.shop.service.OrderService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class OrderController {

	private final OrderService orderService;
	
	//주문하기
	@PostMapping("/order")
	public @ResponseBody ResponseEntity<Long> order(@RequestBody @Valid OrderDto orderDto,
			BindingResult bindingResult, Principal principal){
		
		String email = principal.getName();
		Long orderId;
		
		orderId = orderService.order(orderDto, email);
		
		return new ResponseEntity<Long>(orderId, HttpStatus.OK);
		
	}
}
