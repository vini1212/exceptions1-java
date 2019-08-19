package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import model.exceptions.DomainException;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //esse dado é como static é para que esse dado não seja instanciado um novo SimpleDateFormat para cada objeto Reservation que minha aplicação tiver
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut){
		if (!checkOut.after(checkIn)) { //se chama programação defensiva por estar sendo tratado no começo do método
			throw new DomainException("Check-out date must be after check-in date");
		}
		this.roomNumber = roomNumber;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}

	public Integer getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(Integer roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Date getCheckIn() { //apagamos o setCheckIn e o setCheckOut porque temos um método responsável por atualizar as datas que é o updateDates
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() { //fazer o cálculo de datas vai retornar um long aqui então já criamos um método long (inteiro mais long), diferença entre datas
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o TimeUnit em milisegundos para dias 
	}
	
	public void updateDates(Date checkIn, Date checkOut){ // vai propagar a exceção e o meu programa principal vai tratar essas exceções
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			throw new DomainException("Reservation dates for update must be future dates"); //erros nos argumentos do método
		}

		if (!checkOut.after(checkIn)) {
			throw new DomainException("Check-out date must be after check-in date");
		}
		//atualiza a lógica de checkIn e checkOut
		this.checkIn = checkIn;
		this.checkOut = checkOut;
	}
	
	@Override //toString é uma sobreposição
	public String toString() {
		return "Room " 
			+  roomNumber
			+  ", check-in: "
			+  sdf.format(checkIn)
			+  ", check-out: "
			+  sdf.format(checkOut)
			+  ", "
			+  duration()
			+  " nights";	
	}
	
	
	
	

}
