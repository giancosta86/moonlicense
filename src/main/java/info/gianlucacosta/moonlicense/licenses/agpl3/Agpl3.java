package info.gianlucacosta.moonlicense.licenses.agpl3;

import info.gianlucacosta.moonlicense.DefaultLicense;

/**
 * The AGPLv3 license.
 */
public class Agpl3 extends DefaultLicense {
    @Override
    public String getName() {
        return "GNU Affero General Public License (AGPL) version 3.0";
    }

    @Override
    public String getUrl() {
        return "https://www.gnu.org/licenses/agpl-3.0.txt";
    }
}
