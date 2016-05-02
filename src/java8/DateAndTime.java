package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoField;

public class DateAndTime {
	public static void main(String[] args) {
		// localDateTime();
		// formatterTest();
		zonedTimeTest();
	}

	private static void localDateTime() {
		LocalDate localDate = LocalDate.now();
		System.out.println("local date " + localDate);
		LocalDate specificDate = LocalDate.of(2014, 1, 10);
		System.out.println("Specific date = " + specificDate);
		LocalTime localTime = LocalTime.now();
		System.out.println("Local Time = " + localTime);
		LocalTime specificTime = LocalTime.of(13, 1, 10);
		System.out.println("Specific time  = "
				+ specificTime.format(new DateTimeFormatterBuilder().appendPattern(" HH:mm:ss a").toFormatter()));

		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println("Local Date Time = " + localDateTime);

		LocalDateTime specificDateTime = LocalDateTime.of(specificDate, specificTime);
		System.out.println("Specific date time = " + specificDateTime);
	}

	private static void formatterTest() {
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ISO_DATE;
		System.out.println("Current date  = " + dateTimeFormatter.format(LocalDateTime.now()));

		DateTimeFormatter dateTimeFormatter1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.LONG);
		System.out.println("Localized Long = " + dateTimeFormatter1.format(LocalDateTime.now()));

		DateTimeFormatter dateTimeFormatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println("Localized Long = " + dateTimeFormatter2.format(LocalDateTime.now()));

		DateTimeFormatterBuilder someBuilder = new DateTimeFormatterBuilder().appendValue(ChronoField.MONTH_OF_YEAR)
				.appendLiteral("::").appendValue(ChronoField.DAY_OF_WEEK);
		System.out.println("Builder formatter = " + someBuilder.toFormatter().format(LocalDateTime.now()));
	}

	private static void zonedTimeTest() {
		DateTimeFormatter dateTimeFormateer = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
		ZonedDateTime zonedDateTime = ZonedDateTime.now(ZoneId.of("America/New_York"));
		System.out.println("Time of new york = " + dateTimeFormateer.format(zonedDateTime));

	}

}
