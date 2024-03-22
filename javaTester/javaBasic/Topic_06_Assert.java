package javaBasic;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Topic_06_Assert {
	@Test
	public void TC_01() {
		
		//True/ False: nó sẽ nhận vào tham số là kiểu dữ liệu boolean
		// isDisplayed/ isDisplayed/ isSelected/ isEnable/ isMultiple -> boolean
		// wait trả về boolean
		// isPageLoadedSuccess/ isImageLoaded/ waitForElementInvisible/ waitForListElementInvisible -> boolean
		
		boolean status = true;
		Assert.assertTrue(status);
		
		status = false;
		Assert.assertFalse(status);
		
		// Equals: nó sẽ nhận vào 2 tham số có kiểu dữ liệu tương ứng nhau
		// getText/ getAttribute/ getCss/ getSize
		
		String fullName = "Automation FC";
		
		Assert.assertTrue(fullName.equals("Automation FC"));
		
		Assert.assertEquals(fullName, "Automation FC");
		
		
		
	}
	
	
	
	}
	
	
	
