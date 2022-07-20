package com.educandoweb.workshop.entities.enums;

public enum OrderStatus {

	WAITING_PAYMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
   private int code;
   
   private OrderStatus(int code) {
	   this.code = code;
   }
   
   public int getcode() {
	   return code;
   }
   
   public static OrderStatus valueof(int code) {
	   for(OrderStatus value : OrderStatus.values()) {
		   if(value.getcode() == code) {
			   return value;
		   }
	   }
	   throw new IllegalArgumentException("ERRO, CODIGO NÃO EXISTENTE");
   }
}
