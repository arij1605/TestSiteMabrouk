package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class HomePageMabrouk {

	@FindBy(xpath="/html/body/div[5]/header/div/div/div[2]/nav/div/div[2]/div[1]/ul/li/a/div")
	WebElement menu;
	
	@FindBy(xpath="/html/body/div[5]/header/div/div/div[2]/nav/div/div[2]/div[1]/ul/li[2]/div/ul/li/a/span")
	List<WebElement> submenus;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div[2]/div/h1")
	WebElement verif;
	
	public HomePageMabrouk() {
		PageFactory.initElements(Config.driver, this);
	}

	public void mouseHouverAndClick(String menuTitle, String subMenuTitle) {
		Actions actions = new Actions(Config.driver);
		actions.moveToElement(menu).perform();
		try {
			for (WebElement submenu:submenus) {
						if(submenu.getText().contains(subMenuTitle)) {
							submenu.click();
						}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void verif1(String subMenuTitle) {
		System.out.println("Titre affiché : " + verif.getText());
		Assert.assertTrue(verif.getText().toLowerCase().contains(subMenuTitle.toLowerCase()));
	}
	
	
}

