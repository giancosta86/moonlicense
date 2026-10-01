package info.gianlucacosta.moonlicense;

import java.time.Year;


public class TestProductInfo extends ProductInfo {
    public TestProductInfo() {
        super(
                "HelloTest",
                Year.now().getValue(),
                "Test copyright holder"
        );
    }
}
