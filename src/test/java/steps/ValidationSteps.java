package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class ValidationSteps extends TestBase {

    private By chooseCountry = By.id("country-name");

    private By egyCountry = By.id("eg-contry-lable");

    private By aeCountry = By.id("ae-contry-lable");

    private By psCountry = By.id("ps-contry-lable");

    private By planLiteElement = By.id("name-لايت");

    private By priceLiteElement = By.xpath("//*[@id=\"currency-لايت\"]/b");

    private By currencyLiteElement = By.xpath("//*[@id=\"currency-لايت\"]/i");

    private By planBasicElement = By.id("name-الأساسية");

    private By priceBasicElement = By.xpath("//*[@id=\"currency-الأساسية\"]/b");

    private By currencyBasicElement = By.xpath("//*[@id=\"currency-الأساسية\"]/i");

    private By planPremElement = By.id("name-بريميوم");

    private By pricePremElement = By.xpath("//*[@id=\"currency-بريميوم\"]/b");

    private By currencyPremElement = By.xpath("//*[@id=\"currency-بريميوم\"]/i");
    @Given("I navigate to STC TV website")
    public void i_navigate_to_stc_tv_website() {
        startDriver("chrome");
    }

    @When("I select {string} as the country")
    public void i_select_as_the_country(String country) {
        WebElement chooseCntry = driver.findElement(chooseCountry);
        chooseCntry.click();
        if(country.equals("Egypt")) {
            WebElement egyptCountry = driver.findElement(egyCountry);
            egyptCountry.click();
        } else if (country.equals("UAE")) {
            WebElement uaeCountry = driver.findElement(aeCountry);
            uaeCountry.click();
        } else if (country.equals("Palestine")) {
            WebElement plsCountry = driver.findElement(psCountry);
            plsCountry.click();
        }

    }

        @Then("I should see the subscription package details for Egypt")
    public void i_should_see_subscription_packages(DataTable dataTable) {
        List<Map<String, String>> data = dataTable.asMaps(String.class, String.class);
        for (Map<String, String> row : data) {
            String planName = row.get("plan-name");
            String price = row.get("price");
            String currency = row.get("Currency");
            String expectedText = String.format("%s %s %s", planName, price, currency);
//            String expectedText = String.format("%s", planName);
//            String expectedText1 = String.format("%s", price);
//            String expectedText2 = String.format("%s", currency);
            List<String> actualPackageDetails = new ArrayList<String>();
            actualPackageDetails.add(planName + price + currency);

            WebElement element = driver.findElement(planLiteElement);
            WebElement element1 = driver.findElement(priceLiteElement);
            WebElement element2 = driver.findElement(currencyLiteElement);

            String actualText = element.getText();
            String actualTex1 = element1.getText();
            String actualText2 = element2.getText();
            Assert.assertEquals(expectedText, actualText);
//            Assert.assertEquals(expectedText1, actualTex1);
//            Assert.assertEquals(expectedText2, actualText2);
            List<String>[] subscriptionPackages = new List[0];
            for (List<String> packageDetails : subscriptionPackages) {
                if (packageDetails.get(0).equals(planLiteElement)) {
                    Assert.assertEquals(Double.parseDouble(packageDetails.get(1)), priceLiteElement);
                    Assert.assertEquals(packageDetails.get(2), currencyLiteElement);
                    return;
                }
            }
        }

        List<String>[] subscriptionPackages = new List[0];
        for (List<String> packageDetails : subscriptionPackages) {
            if (packageDetails.get(0).equals(planLiteElement)) {
                Assert.assertEquals(Double.parseDouble(packageDetails.get(1)), priceLiteElement);
                Assert.assertEquals(packageDetails.get(2), currencyLiteElement);
                return;
            }
        }


//    @Then("I can assert on all details like bundleType and price and currency for {string}")
//    public void i_can_assert_on_all_details_like_bundle_type_and_price_and_currency_for(String country) {
//        WebElement bundleLite = driver.findElement(planLiteElement);
//        WebElement priceLite = driver.findElement(priceLiteElement);
//        WebElement currencyLite = driver.findElement(currencyLiteElement);
//        WebElement bundleBasic = driver.findElement(planBasicElement);
//        WebElement priceBasic = driver.findElement(priceBasicElement);
//        WebElement currencyBasic = driver.findElement(currencyBasicElement);
//        WebElement bundlePrem = driver.findElement(planPremElement);
//        WebElement pricePrem = driver.findElement(pricePremElement);
//        WebElement currencyPrem = driver.findElement(currencyPremElement);
//
//        Assert.assertTrue(bundleLite.getText().equals("لايت"));
//        System.out.println(bundleLite.getText());
//        if(country.equals("Egypt")) {
//            Assert.assertTrue(priceLite.getText().equals("0.25"));
//            System.out.println(priceLite.getText());
//        } else if (country.equals("UAE")) {
//            Assert.assertTrue(priceLite.getText().equals("5.4"));
//            System.out.println(priceLite.getText());
//        } else if (country.equals("Palestine")) {
//            Assert.assertTrue(priceLite.getText().equals("2.4"));
//            System.out.println(priceLite.getText());
//        }
//        Assert.assertTrue(currencyLite.getText().equals("دولار أمريكي/شهر"));
//        System.out.println(currencyLite.getText());
//        Assert.assertTrue(bundleBasic.getText().equals("الأساسية"));
//        System.out.println(bundleBasic.getText());
//        if(country.equals("Egypt")) {
//            Assert.assertTrue(priceBasic.getText().equals("0.5"));
//            System.out.println(priceBasic.getText());
//        } else if (country.equals("UAE")) {
//            Assert.assertTrue(priceBasic.getText().equals("10.9"));
//            System.out.println(priceBasic.getText());
//        } else if (country.equals("Palestine")) {
//            Assert.assertTrue(priceBasic.getText().equals("4.8"));
//            System.out.println(priceBasic.getText());
//        }
//        Assert.assertTrue(currencyBasic.getText().equals("دولار أمريكي/شهر"));
//        System.out.println(currencyBasic.getText());
//        Assert.assertTrue(bundlePrem.getText().equals("بريميوم"));
//        System.out.println(bundlePrem.getText());
//        if(country.equals("Egypt")) {
//            Assert.assertTrue(pricePrem.getText().equals("1"));
//            System.out.println(pricePrem.getText());
//        } else if (country.equals("UAE")) {
//            Assert.assertTrue(pricePrem.getText().equals("16.3"));
//            System.out.println(pricePrem.getText());
//        } else if (country.equals("Palestine")) {
//            Assert.assertTrue(pricePrem.getText().equals("7.2"));
//            System.out.println(pricePrem.getText());
//        }
//        Assert.assertTrue(currencyPrem.getText().equals("دولار أمريكي/شهر"));
//        System.out.println(currencyPrem.getText());
//    }

//    @Then("close the website")
//    public void close_the_website() {
//        stopDriver();
//    }

}
}
