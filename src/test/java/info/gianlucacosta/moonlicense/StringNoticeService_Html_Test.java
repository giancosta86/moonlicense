package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.noticeformats.HtmlNoticeFormat;
import org.junit.Test;


public class StringNoticeService_Html_Test extends NoticeServiceTestCase {
    public StringNoticeService_Html_Test() {
        super("html", new HtmlNoticeFormat());
    }

    @Test
    public void testRemoveNotice_1() throws Exception {
        testRemoveNotice(1);
    }

    @Test
    public void testRemoveNotice_2() throws Exception {
        testRemoveNotice(2);
    }


    @Test
    public void testRemoveNotice_3() throws Exception {
        testRemoveNotice(3);
    }


    @Test
    public void testSetNotice_1() throws Exception {
        testSetNotice(1);
    }

    @Test
    public void testSetNotice_2() throws Exception {
        testSetNotice(2);
    }

    @Test
    public void testSetNotice_3() throws Exception {
        testSetNotice(3);
    }

    @Test
    public void testSetNotice_4() throws Exception {
        testSetNotice(4);
    }


    @Test
    public void testSetNotice_5() throws Exception {
        testSetNotice(5);
    }
}
