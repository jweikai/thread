package com.thread2.ticket;

public class Main {
	public static void main(String[] args) {
		Cinema cinema = new Cinema();
		TicketOffce1 ticketOffce1 = new TicketOffce1(cinema);
		Thread thread1 = new Thread(ticketOffce1, "TicketOffice1");
		
		TicketOffce2 ticketOffce2 = new TicketOffce2(cinema);
		Thread thread2 = new Thread(ticketOffce2, "TicketOffice2");
		
		thread1.start();
		thread2.start();
		
		try {
			thread1.join();
			thread2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.printf("Room 1 Vacancies: %d\n", cinema.getVacanciesCinema1());
		System.out.printf("Room 2 Vacancies: %d\n", cinema.getVacanciesCinema2());
	}
}
