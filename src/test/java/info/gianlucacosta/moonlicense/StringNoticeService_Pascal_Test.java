package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.noticeformats.PascalNoticeFormat;
import org.junit.Test;


public class StringNoticeService_Pascal_Test extends NoticeServiceTestCase {
    public StringNoticeService_Pascal_Test() {
        super("pascal", new PascalNoticeFormat());
    }


    @Test
    public void testRemoveNotice_1() throws Exception {
        testRemoveNotice(1);
    }

    @Test
    public void testSetNotice_1() throws Exception {
        testSetNotice(1);
    }

    @Test
    public void testSetNotice_2() throws Exception {
        testSetNotice(2);
    }
}
