package Pages;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Helper.Config;

public class ChemisesBlousesPage {

	@FindBy(xpath="/html/body/div[5]/div[3]/div[4]/main/div/div[4]/div/ul/li/div/div[2]/div[5]/div[1]/h6/a")
	List<WebElement> produits;

	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/h1")
	WebElement verif;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[1]/div[2]/div[3]/span")
	List<WebElement> couleurs;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[1]/div[3]/span/ul/li/div/span")
	List<WebElement> tailles;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[4]/div[2]/a")
	WebElement clickok;
	
	@FindBy(xpath="/html/body/div[5]/div[3]/div[2]/div/main/div[1]/div[1]/div[3]/div[2]/div/div[2]/div/form/div/div[4]/div[2]/a[2]")
	WebElement viewCrd;
	
	@FindBy(xpath="/html/body/div[4]/div[3]/div[4]/div/div/main/article/div/div/div/div/div/div/div[1]/div/div/div[1]/div/form/div[3]/div/div/a")
	WebElement verifPanier; 
	

	public ChemisesBlousesPage () {
		PageFactory.initElements(Config.driver, this);
	}

	public void clickOnProduct (String productName) {	
		Config.attente(10);
		try {
			for (WebElement produit : produits) {
				System.out.println(produits);
				if (produit.getText().toLowerCase().contains(productName.toLowerCase())) {
					System.out.println("le produit choisi: "+produit.getText());
					Config.attente(10);
					JavascriptExecutor ex = (JavascriptExecutor) Config.driver;
					ex.executeScript("arguments[0].click();", produit);
				//((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", produit);
				//produit.click();
				}			
			}
		} catch (Exception e) {
			// TODO: handle exception
		} 	
	}
	public void verifProduit(String productName) {
		Config.attente(5);
		System.out.println("Titre affiché : " + verif.getText());
		Assert.assertEquals(verif.getText().toLowerCase(), productName.toLowerCase());
	}
	public void addtocard (String color, String taille, String ajout) {
		try {
			for(WebElement couleur: couleurs)  {
				String couleurAffichee = couleur.getAttribute("data-option");
				if (couleurAffichee.equals(color)) {
					System.out.println("Couleur : " + couleurAffichee);
				couleur.click();
			} }
				Config.attente(2);
				for(WebElement t: tailles)  {
					if (t.getText().equals(taille)) {
						System.out.println("Taille: " + t.getText());
					t.click();
				}	 
				} 
				Config.attente(2);
				System.out.println("Bouton : " + clickok.getText());
				((JavascriptExecutor) Config.driver).executeScript("arguments[0].click();", clickok);			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}

	public void clickViewCard () {
		JavascriptExecutor ex = (JavascriptExecutor) Config.driver;
		Config.attente(10);
		try {
			viewCrd.click();
		} catch (Exception e) {
			System.out.println("Clic normal impossible : " + e.getMessage());
			ex.executeScript("arguments[0].click();", viewCrd);
		}
	}
	public void verifPanier(String panierVerif) {
		Config.attente(5);
		System.out.println("Titre affiché : " + verifPanier.getText());
		Assert.assertEquals(verifPanier.getText().toLowerCase(), panierVerif.toLowerCase());
	}
	
}
