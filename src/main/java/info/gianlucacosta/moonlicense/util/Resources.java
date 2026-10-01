package info.gianlucacosta.moonlicense.util;

import java.io.*;
import java.util.regex.Pattern;

/**
 * Utility class to deal with resources.
 */
public class Resources {
    /**
     * Given a class, returns a related resource as a string.
     *
     * @param referenceClass The class whose package (or a subpackage) contains the resource.
     * @param resourcePath   The relative path of the resource. File.separator will be replaced by "/"
     * @return The content of the resource file, as a string. It never returns null.
     * @throws java.io.IOException Thrown in case of errors - for example, if the resource is missing
     */
    public static String getResourceAsString(Class<?> referenceClass, String resourcePath) throws IOException {
        StringBuilder result = new StringBuilder();

        String uniformResourcePath = resourcePath.replaceAll(
                Pattern.quote(File.separator),
                "/"
        );

        InputStream resourceStream = referenceClass.getResourceAsStream(uniformResourcePath);

        if (resourceStream == null) {
            throw new IOException(String.format("Missing resource: '%s'", resourcePath));
        }

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(
                        resourceStream
                )
        )) {
            reader.lines()
                    .forEach(line -> {
                        result.append(line);
                        result.append(System.lineSeparator());
                    });

            return result.toString();
        }
    }
}
