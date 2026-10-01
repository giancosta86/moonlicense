package info.gianlucacosta.moonlicense;

import info.gianlucacosta.moonlicense.noticeformats.HtmlNoticeFormat;
import info.gianlucacosta.moonlicense.noticeformats.JavaNoticeFormat;
import info.gianlucacosta.moonlicense.testing.TestTreeService;
import info.gianlucacosta.moonlicense.testing.licenses.dummy.Dummy;
import info.gianlucacosta.moonlicense.testing.licenses.dummy2.Dummy2;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Year;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;


public class TreeNoticeServiceTest {
    private interface TestRunnable {
        void run() throws Exception;
    }

    private final ProductInfo productInfo = new TestProductInfo();

    private final TestTreeService testTreeService = new TestTreeService();

    private TreeNoticeService treeNoticeService;


    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();


    @Before
    public void setUp() throws Exception {
        treeNoticeService = new DefaultTreeNoticeService(new DefaultStringNoticeService(), true);


        Map<String, NoticeFormat> highPriorityIncludes = new HashMap<>();
        highPriorityIncludes.put("/Omicron\\.java\\.txt$", new JavaNoticeFormat());

        ProductInfo highPriorityProductInfo = new ProductInfo("Special product", Year.now().getValue(), "Special copyright holder");


        treeNoticeService.addLicensedFileSet(new LicensedFileSet(
                new Dummy2(),
                highPriorityProductInfo,
                highPriorityIncludes,
                new ArrayList<>()
        ));


        Map<String, NoticeFormat> includes = new HashMap<>();
        includes.put("\\.java\\.txt$", new JavaNoticeFormat());
        includes.put("\\.html?$", new HtmlNoticeFormat());

        List<String> excludes = new ArrayList<>();
        excludes.add("/Sigma\\.java\\.txt$");

        treeNoticeService.addLicensedFileSet(new LicensedFileSet(
                new Dummy(),
                productInfo,
                includes,
                excludes
        ));
    }


    private void runTreeTest(String treeName, TestRunnable actionCode) throws Exception {
        testTreeService.copyInitialTreeToDirectory(treeName, tempFolder.getRoot());

        actionCode.run();

        checkTempFolderTree(treeName);
    }


    private void checkTempFolderTree(String treeName)
            throws IOException {

        ProductInfoInjector productInfoInjector = new ProductInfoInjector(productInfo);
        Path tempPath = tempFolder.getRoot().toPath();

        Files.walk(tempPath).forEach(currentPath -> {
            if (!currentPath.toFile().isFile()) {
                return;
            }

            Path relativePath = tempPath.relativize(currentPath);


            try {
                String expectedTemplate = testTreeService.getExpectedFileContent(treeName, relativePath.toString());
                String expectedContent = productInfoInjector.inject(expectedTemplate);

                String fileContent = new String(Files.readAllBytes(currentPath));

                assertEquals("Difference found in file: " + relativePath, expectedContent, fileContent);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });
    }


    @Test
    public void testSetNotices() throws Exception {
        runTreeTest("setNotices", () -> treeNoticeService.setNotices(
                tempFolder.getRoot(),
                Year.now().getValue()
        ));
    }

    @Test
    public void testRemoveNotices() throws Exception {
        runTreeTest("removeNotices", () -> treeNoticeService.removeNotices(
                tempFolder.getRoot()
        ));
    }
}