package Steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;

import com.stc.pages.SubscriptionPage;

import java.io.IOException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class SubscriptionSteps  {
	public SubscriptionPage SubscriptionPage = new SubscriptionPage();
    public SubscriptionSteps() throws IOException {
    }

    @Given("I am on the STC TV subscriptions page and click on the country drop down")
    public void givenIAmOnSubscriptionsPage() {
    	SubscriptionPage.clickOncountryDropdown();
    }

    @When("I select the country {string}")
    public void whenISelectCountry(String country) {
    	if (country.equals("Saudi")) {
            SubscriptionPage.clickOnsaudiCountryOption();
        }
        else if (country.equals("Kuwait")) {
            SubscriptionPage.clickOnkuwaitCountryOption();
        }
        else if (country.equals("Bahrain")) {
            SubscriptionPage.clickOnbahrainCountryOption();
        }
        else {
    	    String errorMessage = "Invalid country: " + country;
    	    throw new RuntimeException(errorMessage);
        }    
    }

    @Then("I should see the subscription packages with correct {string}, {string}, and {string}")
    public void thenIShouldSeeSubscriptionPackagesForCountryWithTypePriceAndCurrency(String type, String price, String currency) {
    		Assert.assertEquals(SubscriptionPage.getsubscriptionTypeText(), type, "Wrong subscription type");
    		Assert.assertEquals(SubscriptionPage.getsubsubscriptionPriceText(), price, "Wrong subscription price");
    		Assert.assertEquals(SubscriptionPage.getsubsubscriptionCurrencyText(), currency, "Wrong subscription currency");

    }
}
