package model.entities;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Reservation {
	private Integer roomNumber;
	private Date checkIn;
	private Date checkOut;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy"); //esse dado � como static � para que esse dado n�o seja instanciado um novo SimpleDateFormat para cada objeto Reservation que minha aplica��o tiver
	
	public Reservation(Integer roomNumber, Date checkIn, Date checkOut) {
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

	public Date getCheckIn() { //apagamos o setCheckIn e o setCheckOut porque temos um m�todo respons�vel por atualizar as datas que � o updateDates
		return checkIn;
	}

	public Date getCheckOut() {
		return checkOut;
	}
	
	public long duration() { //fazer o c�lculo de datas vai retornar um long aqui ent�o j� criamos um m�todo long (inteiro mais long), diferen�a entre datas
		long diff = checkOut.getTime() - checkIn.getTime();
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS); //converte o TimeUnit em milisegundos para dias 
	}
	
	public String updateDates(Date checkIn, Date checkOut) {
		
		Date now = new Date();
		if (checkIn.before(now) || checkOut.before(now)) {
			return "Reservation dates for update must be future dates";
		}

		if (!checkOut.after(checkIn)) {
			return "Check-out date must be after check-in date";
		}
		//atualiza a l�gica de checkIn e checkOut
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		
		return null;//crit�rio que n�o deu nenhum erro 
	}
	
	@Override //toString � uma sobreposi��o
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
