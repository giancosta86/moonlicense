package info.gianlucacosta.moonlicense.licenses.mit;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * The MIT license.
 */
public class Mit extends DefaultLicense {
    @Override
    public String getName() {
        return "MIT License";
    }

    @Override
    public String getUrl() {
        return "http://opensource.org/licenses/MIT";
    }
}
