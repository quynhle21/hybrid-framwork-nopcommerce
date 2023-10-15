package javaBasic;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class Topic_06_Assert {
	@Test
	public void TC_01() {
		Topic_06_Assert frodo = new Topic_06_Assert();
		Topic_06_Assert sauron = new Topic_06_Assert();
	// basic assertions
	assertThat(frodo.getName()).isEqualTo("Frodo");
	assertThat(frodo).isNotEqualTo(sauron);

	// chaining string specific assertions
	assertThat(frodo.getName()).startsWith("Fro")
	                           .endsWith("do")
	                           .isEqualToIgnoringCase("frodo");

}
	
	
	public String getName() {
		return "Frodo";
	}
}