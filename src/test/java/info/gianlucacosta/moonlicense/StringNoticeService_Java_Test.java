package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.noticeformats.JavaNoticeFormat;
import org.junit.Test;


public class StringNoticeService_Java_Test extends NoticeServiceTestCase {

    public StringNoticeService_Java_Test() {
        super("java", new JavaNoticeFormat());
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
    public void testRemoveNotice_4() throws Exception {
        testRemoveNotice(4);
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


    @Test
    public void testSetNotice_6() throws Exception {
        testSetNotice(6);
    }
}
