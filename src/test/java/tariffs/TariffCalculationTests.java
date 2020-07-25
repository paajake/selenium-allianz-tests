package tariffs;

import base.BaseTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TariffCalculationTests extends BaseTest {
    @Test
    public void testTariffCalculator(){
        Date dateOfBirth = faker.date().birthday(18,50);
        SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyy");
        String strDate= formatter.format(dateOfBirth);

        homePage.setBirthDateField(strDate);

        String size = String.valueOf(faker.number().numberBetween(10,200));
        homePage.setHouseSizeField(size);

        String zipCode = homePage.getZipCode(faker.number().numberBetween(0,14));
        homePage.setZipCodeField(zipCode);

        homePage.clickCalculateTariffButton();
    }
}
