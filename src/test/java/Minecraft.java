import net.minecraft.client.main.Main;

import java.io.File;
import java.util.Arrays;

public class Minecraft {
    public static void main(String[] args) {
        // Provide natives (linux, windows)
        String os = System.getProperty("os.name").startsWith("Windows") ? "windows" : "linux";
        System.setProperty("org.lwjgl.librarypath", new File("../native_libraries/" + os).getAbsolutePath());

        Main.main(concat(new String[]{"--version", "MavenMCP", "--accessToken", "0", "--assetsDir", "assets", "--assetIndex", "1.8", "--userProperties", "{}"}, args));
    }

    public static <T> T[] concat(T[] first, T[] second) {
        T[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
