package info.gianlucacosta.moonlicense.testing.licenses.dummy;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * A dummy license, just for testing.
 */
public class Dummy extends DefaultLicense {
    @Override
    public String getName() {
        return "Dummy license";
    }

    @Override
    public String getUrl() {
        return "http://gianlucacosta.info/licenses/dummy";
    }
}
