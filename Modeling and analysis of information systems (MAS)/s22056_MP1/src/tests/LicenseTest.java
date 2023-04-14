package tests;

import elements.License;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LicenseTest {

    @Test
    public void testLicenseCreation() {
        License license = new License("FAA", 313131, "Plane's License", LocalDate.of(2023, 12, 31));
        Assertions.assertEquals("FAA", license.getAuthority());
        Assertions.assertEquals(313131, license.getId());
        Assertions.assertEquals("Plane's License", license.getType());
        Assertions.assertEquals(LocalDate.of(2031, 12, 31), license.getExpiration());
    }

    @Test
    public void testLicenseExtent() {
        License license1 = new License("FAA", 31963000, "Federal authority approval", LocalDate.of(2023, 12, 31));
        License license2 = new License("ACME Inc.", 31961800, "Professional Nuclear Bomb carriage license", LocalDate.of(2022, 6, 30));
        License license3 = new License("Secret Moon base authority", 31961871, "Certification and Access", LocalDate.of(2074, 9, 30));

        List<License> extent = license1.getExtent();
        Assertions.assertEquals(3, extent.size());
        Assertions.assertEquals(license1, extent.get(0));
        Assertions.assertEquals(license2, extent.get(1));
        Assertions.assertEquals(license3, extent.get(2));
    }

    @Test
    public void testLicenseSorting() {
        List<License> licenses = new ArrayList<>();
        licenses.add(new License("FAA", 123, "Federal authority approval", LocalDate.of(2023, 12, 31)));
        licenses.add(new License("ACME Inc.", 31961800, "Professional Nuclear Bomb carriage license", LocalDate.of(2022, 6, 30)));
        licenses.add(new License("Secret Moon base authority", 31961871, "Certification and Access", LocalDate.of(2074, 9, 30)));

        Collections.sort(licenses);
        Assertions.assertEquals("ACME Inc.", licenses.get(0).getAuthority());
        Assertions.assertEquals("FAA", licenses.get(1).getAuthority());
        Assertions.assertEquals("Secret Moon base authority", licenses.get(2).getAuthority());
    }

}
