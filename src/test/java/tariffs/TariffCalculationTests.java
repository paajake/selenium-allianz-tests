package tariffs;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.FileApplicationPage;
import pages.OffersPage;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.testng.Assert.assertEquals;


public class TariffCalculationTests extends BaseTest {
    @Test
    public void testTariffCalculator() {
        Date dateOfBirth = faker.date().birthday(18, 50);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");

        String strDate = formatter.format(dateOfBirth);
        homePage.setBirthDateField(strDate);

        String size = String.valueOf(faker.number().numberBetween(10, 200));
        homePage.setHouseSizeField(size);

        String zipCode = homePage.getZipCode(faker.number().numberBetween(0, 14));
        homePage.setZipCodeField(zipCode);

//        homePage.setHabitationDropdownField(faker.number().numberBetween(0, 1));

        OffersPage offersPage = homePage.clickCalculateTariffButton();
        assertEquals(getCurrentUrl(), "https://hausrat.allianz.de/rechner/angebot");
        assertEquals(offersPage.getHeadlineText(), "Unser Angebot für Sie");

        offersPage.setPaymentFrequencyDropdownField(faker.number().numberBetween(0, 3));
        offersPage.setDeductibleDropdownField(faker.number().numberBetween(1, 3));
        offersPage.setContractDurationDropdownField(faker.number().numberBetween(0,1));

        offersPage.clickInsurancePlan(faker.number().numberBetween(0,2));

        offersPage.setFahrradPlusDropdownField(faker.number().numberBetween(0,3));
        offersPage.clickFahrradPlusButton();
        offersPage.clickFensterPlusButton();
        offersPage.clickHouseProtectionButton();
        offersPage.clickInternetProtectionButton();

        FileApplicationPage fileApplicationPage = offersPage.clickContinueApplicationButton();
        assertEquals(getCurrentUrl(), "https://hausrat.allianz.de/rechner/antrag");
        assertEquals(fileApplicationPage.getHeadlineText(), "Fast geschafft!");

    }
}
