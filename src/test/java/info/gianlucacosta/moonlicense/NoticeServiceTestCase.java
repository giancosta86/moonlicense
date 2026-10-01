package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.testing.licenses.dummy.Dummy;
import info.gianlucacosta.moonlicense.util.Resources;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public abstract class NoticeServiceTestCase {
    private final String language;
    private final NoticeFormat noticeFormat;


    protected NoticeServiceTestCase(String language, NoticeFormat noticeFormat) {
        this.language = language;
        this.noticeFormat = noticeFormat;
    }


    protected void testSetNotice(int number) throws IOException {
        ProductInfo productInfo = new TestProductInfo();
        ProductInfoInjector productInfoInjector = new ProductInfoInjector(productInfo);

        Dummy dummyLicense = new Dummy();
        String notice = productInfoInjector.inject(dummyLicense.getNoticeTemplate());


        String initialContent = productInfoInjector.inject(
                Resources.getResourceAsString(getClass(), String.format("singleFiles/%s/setNotice_%d_initial.txt", language, number))
        );


        String expectedContent = productInfoInjector.inject(
                Resources.getResourceAsString(getClass(), String.format("singleFiles/%s/setNotice_%d_expected.txt", language, number))
        );

        StringNoticeService stringNoticeService = new DefaultStringNoticeService();
        String resultContent = stringNoticeService.setNotice(initialContent, noticeFormat, notice);

        assertEquals(expectedContent, resultContent);
    }


    protected void testRemoveNotice(int number) throws IOException {
        String initialContent = Resources.getResourceAsString(getClass(), String.format("singleFiles/%s/removeNotice_%d_initial.txt", language, number));
        String expectedContent = Resources.getResourceAsString(getClass(), String.format("singleFiles/%s/removeNotice_%d_expected.txt", language, number));

        StringNoticeService stringNoticeService = new DefaultStringNoticeService();
        String resultContent = stringNoticeService.removeNotice(noticeFormat, initialContent);

        assertEquals(expectedContent, resultContent);
    }
}