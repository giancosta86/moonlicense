package info.gianlucacosta.moonlicense.testing;

import info.gianlucacosta.moonlicense.util.Resources;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Provides utility functions related to the file trees employed for testing.
 */
public class TestTreeService {
    /**
     * Copies one of the testing directory trees to a target directory.
     *
     * @param treeName        The name of the test tree (e.g: <i>setNotices</i> or <i>removeNotices</i>).
     * @param targetDirectory The target directory.
     * @throws IOException Thrown in case of I/O errors.
     */
    public void copyInitialTreeToDirectory(String treeName, File targetDirectory) throws IOException {
        if (!targetDirectory.isDirectory()) {
            throw new IllegalArgumentException();
        }

        copyInitialTreeFile(treeName, targetDirectory, ".hidden/HiddenSource.java.txt");
        copyInitialTreeFile(treeName, targetDirectory, ".hidden/anypackage/StillHidden.java.txt");
        copyInitialTreeFile(treeName, targetDirectory, "Alpha.java.txt");
        copyInitialTreeFile(treeName, targetDirectory, "Beta.htm");
        copyInitialTreeFile(treeName, targetDirectory, "gamma/Sigma.java.txt");
        copyInitialTreeFile(treeName, targetDirectory, "gamma/Omicron.java.txt");
        copyInitialTreeFile(treeName, targetDirectory, "gamma/delta/.HiddenPage.htm");
        copyInitialTreeFile(treeName, targetDirectory, "gamma/delta/Epsilon.java.txt");
    }


    private void copyInitialTreeFile(String treeName, File targetDirectory, String relativePath) throws IOException {
        String resourcePath = String.format("testTrees/%s/initial/%s",
                treeName,
                relativePath
        );
        String resourceContent = Resources.getResourceAsString(getClass(), resourcePath);

        File targetFile = new File(targetDirectory, relativePath);
        targetFile.getParentFile().mkdirs();


        Files.write(targetFile.toPath(), resourceContent.getBytes());
    }


    /**
     * Given a tree name and a relative path, returns the content of the file in the "expected" version of the tree.
     *
     * @param treeName     The name of the test tree (e.g: <i>setNotices</i> or <i>removeNotices</i>).
     * @param relativePath The relative path within the "expected" version of the tree.
     * @return The content of the requested resource file, as a string.
     * @throws IOException Thrown in case of I/O errors.
     */
    public String getExpectedFileContent(String treeName, String relativePath) throws IOException {
        String resourcePath = String.format("testTrees/%s/expected/%s",
                treeName,
                relativePath
        );
        return Resources.getResourceAsString(getClass(), resourcePath);
    }
}
