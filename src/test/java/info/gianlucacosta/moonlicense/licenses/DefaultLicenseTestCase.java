package info.gianlucacosta.moonlicense.licenses;

import info.gianlucacosta.moonlicense.DefaultLicense;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;


public abstract class DefaultLicenseTestCase {
    private final DefaultLicense license;

    public DefaultLicenseTestCase(DefaultLicense license) {
        this.license = license;
    }

    @Test
    public void testGetNoticeTemplate() throws Exception {
        String noticeTemplate = license.getNoticeTemplate();

        assertNotNull(noticeTemplate);
    }


    @Test
    public void testGetFullTemplate() throws Exception {
        String fullTemplate = license.getFullTemplate();

        assertNotNull(fullTemplate);
    }
}
