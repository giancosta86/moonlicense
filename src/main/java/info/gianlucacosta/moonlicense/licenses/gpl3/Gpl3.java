package info.gianlucacosta.moonlicense.licenses.gpl3;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * The GPLv3 license.
 */
public class Gpl3 extends DefaultLicense {
    @Override
    public String getName() {
        return "GNU General Public License (GPL) version 3.0";
    }

    @Override
    public String getUrl() {
        return "https://www.gnu.org/licenses/gpl-3.0.txt";
    }
}
