package br.com.meuprojeto.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;

public class ConversaoLocalDate {
	public static LocalDateTime timestampToLocalDateTime(Timestamp dataEmTimestamp) {
		LocalDateTime dataEmLocalDateTime = dataEmTimestamp.toLocalDateTime();
		return dataEmLocalDateTime;
	}

	public static Timestamp localDateTimeToTimestamp(LocalDateTime dataEmLocalDateTime) {
		Timestamp dataEmTimestamp = Timestamp.valueOf(dataEmLocalDateTime);
		return dataEmTimestamp;

	}

	public static LocalDate dateToLocalDate(Date dataEmDate) {
		LocalDate dataEmLocalDate = dataEmDate.toLocalDate();
		return dataEmLocalDate;
	}

	public static Date localDateToDate(LocalDate date) {
		Date dataEmDate = Date.valueOf(date);
		return dataEmDate;

	}

	public static LocalDate addDate(String teclado) { 
		return LocalDate.parse(teclado);

	}

	public static LocalDateTime stringToLocalDateTime(String string) {
		// hh:mm
		String[] vet = string.split(":");
		LocalDate data = LocalDate.of(2023, Month.JANUARY, 20);
		int hora = Integer.parseInt(vet[0]);
		int minutos = Integer.parseInt(vet[1]);
		LocalDateTime time2 = data.atTime(hora,minutos);
		return time2;
	}
	
}
