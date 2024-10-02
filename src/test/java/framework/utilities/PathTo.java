package framework.utilities;

import java.nio.file.Paths;

public class PathTo {

    public static String root() {
        return System.getProperty("user.dir");
    }

    public static String resourcesFolder() {
        return Paths.get(
                PathTo.root(),
                "src",
                "test",
                "resources"
        ).toString();
    }

}
