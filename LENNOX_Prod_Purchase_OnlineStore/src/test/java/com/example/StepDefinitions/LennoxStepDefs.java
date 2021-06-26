package com.example.StepDefinitions;


import java.io.IOException;

import com.example.ActionClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class LennoxStepDefs extends ActionClass {

    @Before
    public void setup(){
        setDriver();
    }

    @Given("I want navigate to product URL {string}")
	public void i_want_navigate_to_product_url(String URL) throws IOException {
		ActionClass.LaunchLENNOX_Website(URL);
	}

	@When("I Enter login credentials {string} and {string}")
	public void i_enter_login_credentials_and(String UserName, String Password) throws InterruptedException, IOException {
		ActionClass.SignOn(UserName,Password);
	    
	}

	@When("I Click Menu button in top left side")
	public void i_click_menu_button_in_top_left_side() throws InterruptedException, IOException {
		ActionClass.Verify_Landing_Page_and_ClickMenu();
	}
	

	@When("I Click Parts and Supplies and click Compressors option")
	public void i_click_parts_and_supplies_and_click_compressors_option() throws InterruptedException, IOException {
		ActionClass.Click_PartsandSupplies_and_CopressorsButton();
	    
	}

	@When("I Verify compressor landing page and Click compressors option")
	public void i_verify_compressor_landing_page_and_click_compressors_option() throws IOException {
		ActionClass.ClickCompressorLink();
	    
	}

	@When("I Verify and Select 10T46 product from list")
	public void i_verify_and_select_10t46_product_from_list() throws IOException, InterruptedException {
		ActionClass.SelectProduct();
	    
	}

	@Then("I verify product details and compare it with the details from the previous page")
	public void i_verify_product_details_and_compare_it_with_the_details_from_the_previous_page() throws IOException {
		ActionClass.VerifyAndCompareProducts();
	    
	}
	
	@After
    public void teardown(){
       closeDriver();
    }
}
