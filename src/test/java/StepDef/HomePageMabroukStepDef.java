package StepDef;

import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Helper.Utils;
import Pages.HomePageMabrouk;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePageMabroukStepDef {

	@Given("utilisateur est sur la page d'accueil")
	public void utilisateur_est_sur_la_page_d_accueil() throws Exception {
		 Config.driver = new ChromeDriver();
			Config.maximizeWindow();
			Config.driver.get(Utils.getProperty("homeMabrouk"));
	}
	@When("utilisateur survole sur le menu {string} puis clique sur le submenu {string}")
	public void utilisateur_survole_sur_le_menu_puis_clique_sur_le_submenu(String menuTitle, String subMenuTitle) {
	    HomePageMabrouk page = new HomePageMabrouk();
	    page.mouseHouverAndClick(menuTitle, subMenuTitle);
	}
	@Then("utilisateur est sur la page {string}")
	public void utilisateur_est_sur_la_page(String subMenuTitle) {
	    HomePageMabrouk page= new HomePageMabrouk();
	    page.verif1(subMenuTitle);
	    Config.driver.quit();
	}


}
