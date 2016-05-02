package java8;

import java.time.Duration;
import java.time.Instant;

public class InstantAndDuration {

	public static void main(String[] args) {
		instantDurationTest();
	}

	private static void instantDurationTest() {
		Instant instant1 = Instant.now();
		System.out.println("Instant 1 "+instant1);
		System.out.println("Instant test");
		Instant instant2 = Instant.now();
		System.out.println("Instant 2 "+instant2);
		Duration duration = Duration.between(instant1, instant2);
		System.out.println("The main duratin = "+duration.toString());
	}

}
