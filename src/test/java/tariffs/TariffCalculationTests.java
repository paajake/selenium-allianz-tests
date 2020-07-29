package tariffs;

import base.BaseTest;
import base.RetryAnalyzer;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.FileApplicationPage;
import pages.OffersPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class TariffCalculationTests extends BaseTest {


    private OffersPage fillHomePageDetails() {
        Date dateOfBirth = faker.date().birthday(18, 50);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");

        String strDate = formatter.format(dateOfBirth);
        homePage.setBirthDateField(strDate);

        String size = String.valueOf(faker.number().numberBetween(10, 200));

        homePage.setHouseSizeField(size);

        String zipCode = homePage.getZipCode(faker.number().numberBetween(0, 14));
        homePage.setZipCodeField(zipCode);

//        homePage.setHabitationDropdownField(faker.number().numberBetween(0, 1));

        return homePage.clickCalculateTariffButton();


    }

    private void assertIsOffersPage(OffersPage offersPage) {
        assertEquals(offersPage.getCurrentUrl(), "https://hausrat.allianz.de/rechner/angebot");
        assertEquals(offersPage.getHeadlineText(), "Unser Angebot für Sie");
    }

    private void assertUpdatedOffer(OffersPage offersPage, int InsurancePlanIndex) {
        assertTotal(offersPage);
        assertPeriodDetails(offersPage, InsurancePlanIndex);
    }

    private void assertPeriodDetails(OffersPage offersPage, int InsurancePlanIndex){
        assertTrue(offersPage.getPlanCardText(InsurancePlanIndex)
                        .contains(BasePage.setTestFields.get("paymentFrequency")),
                "Period Text is Incorrect");

        assertTrue(offersPage.getDeductibleInSummaryText()
                        .contains(BasePage.setTestFields.get("deductible")),
                "Deductible Text is Incorrect");
    }
    private void assertIsFileApplicationPage(FileApplicationPage fileApplicationPage) {
        assertEquals(fileApplicationPage.getCurrentUrl(), "https://hausrat.allianz.de/rechner/antrag");
        assertEquals(fileApplicationPage.getHeadlineText(), "Fast geschafft!");
    }

    private void assertTotal(OffersPage offersPage){

    }

    private void updateOffer(OffersPage offersPage) {
        String paymentFrequency = offersPage.setPaymentFrequencyDropdownField(faker.number().numberBetween(0, 3));
        OffersPage.setTestFields.put("paymentFrequency", paymentFrequency);

        String deductible = offersPage.setDeductibleDropdownField(faker.number().numberBetween(1, 3));
        OffersPage.setTestFields.put("deductible", deductible);

        offersPage.setContractDurationDropdownField(faker.number().numberBetween(0, 1));
    }

    private void addOfferAddons(OffersPage offersPage) {
        offersPage.setFahrradPlusDropdownField(faker.number().numberBetween(0, 3));
        offersPage.clickFahrradPlusButton();
        offersPage.clickFensterPlusButton();
        offersPage.clickHouseProtectionButton();
        offersPage.clickInternetProtectionButton();
    }


    @Test(retryAnalyzer = RetryAnalyzer.class)
    public void testBasicPlan() {
        OffersPage offersPage = fillHomePageDetails();
        assertIsOffersPage(offersPage);

        updateOffer(offersPage);
        offersPage.clickInsurancePlan(0);
        addOfferAddons(offersPage);

        assertUpdatedOffer(offersPage, 0);

        FileApplicationPage fileApplicationPage = offersPage.clickContinueApplicationButton();
        assertIsFileApplicationPage(fileApplicationPage);
    }

}
