package info.gianlucacosta.moonlicense.licenses.apache2;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * The Apache 2 license.
 */
public class Apache2 extends DefaultLicense {
    @Override
    public String getName() {
        return "Apache License version 2.0";
    }

    @Override
    public String getUrl() {
        return "https://www.apache.org/licenses/LICENSE-2.0";
    }
}
