package info.gianlucacosta.moonlicense.licenses.lgpl3;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * The LGPLv3 license.
 */
public class Lgpl3 extends DefaultLicense {
    @Override
    public String getName() {
        return "GNU General Lesser Public License (LGPL) version 3.0";
    }

    @Override
    public String getUrl() {
        return "https://www.gnu.org/licenses/lgpl-3.0.txt";
    }
}
