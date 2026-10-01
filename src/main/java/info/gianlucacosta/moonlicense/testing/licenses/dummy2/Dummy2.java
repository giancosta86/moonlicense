package info.gianlucacosta.moonlicense.testing.licenses.dummy2;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * Another dummy license.
 */
public class Dummy2 extends DefaultLicense {
    @Override
    public String getName() {
        return "Another dummy license";
    }

    @Override
    public String getUrl() {
        return "http://gianlucacosta.info/licenses/dummy2";
    }
}
