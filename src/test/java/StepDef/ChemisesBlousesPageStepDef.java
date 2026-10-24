package StepDef;


import org.openqa.selenium.chrome.ChromeDriver;

import Helper.Config;
import Helper.Utils;
import Pages.ChemisesBlousesPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ChemisesBlousesPageStepDef {
	
				
		
		@Given("utilisateur est sur chemises et blouses")
		public void utilisateur_est_sur_chemises_et_blouses() throws Exception {
			Config.driver = new ChromeDriver();
			Config.maximizeWindow();
			Config.driver.get(Utils.getProperty("Chemises&Blouses"));   
		}

		@When("utilisateur clique sur le produit {string}")
		public void utilisateur_clique_sur_le_produit(String productName) {
			ChemisesBlousesPage prod = new ChemisesBlousesPage();
			prod.clickOnProduct(productName);
		}

		@Then("utilisateur est sur la page du produit {string}")
		public void utilisateur_est_sur_la_page_du_produit(String productName) {
			  ChemisesBlousesPage prod = new ChemisesBlousesPage();
				 prod.verifProduit(productName);
				}

		@When("utilisateur clique sur le couleur {string}  apres sur la taille {string} apres clique sur {string}")
		public void utilisateur_clique_sur_le_couleur_apres_sur_la_taille_apres_clique_sur(String colorName, String taille, String ajout) {
			ChemisesBlousesPage prod = new ChemisesBlousesPage();
			prod.addtocard(colorName, taille, ajout);
		}

		@When("utilisateur clique sur View Cart")
		public void utilisateur_clique_sur_View_Cart() {
			ChemisesBlousesPage prod = new ChemisesBlousesPage();
			prod.clickViewCard();
		}

		@Then("utilisateur verifie l'ajout du produit par la presence du bouton {string} dans le panier")
		public void utilisateur_verifie_l_ajout_du_produit_par_la_presence_du_bouton_dans_le_panier(String panierVerif) {
			ChemisesBlousesPage prod = new ChemisesBlousesPage();
			 prod.verifPanier(panierVerif);
			 Config.driver.quit();
			}
		
		

}
