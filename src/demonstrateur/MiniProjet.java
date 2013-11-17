/*
 * @author Martini Didier
 */

package demonstrateur;
import com.google.gson.*;
import lib.*;

import java.nio.file.*;

/**
 * The Class Frosh.
 */
public class MiniProjet {

    /**
     * The Constant FOLDER. Config folder of the game
     */
    public static final String FOLDER = "MiniProjet" + java.io.File.separator;

    /**
     * The Constant CONFIG. Config file of the game
     */
    public static final String CONFIG = "config.json";

    /**
     * The main method.
     *
     * @param args not used
     */
    public static void main(final String[] args) {

        new demonstrateur.MiniProjet();

    }

    /**
     * Instantiates a new frosh.
     */
    public MiniProjet() {

        // Create the config folder
        if (!new java.io.File(demonstrateur.MiniProjet.FOLDER).isDirectory()) {
            this.createConfigFolder();
        }
        // Copy the default config file into the folder if no config file was
        // found
        if (!new java.io.File(demonstrateur.MiniProjet.FOLDER + demonstrateur.MiniProjet.CONFIG).exists()) {
            final CopyFile lib = new CopyFile();
            lib.copyfile(demonstrateur.MiniProjet.FOLDER + demonstrateur.MiniProjet.CONFIG);
        }
        demonstrateur.MiniProjet.loadConfigFile(Paths.get(demonstrateur.MiniProjet.FOLDER, demonstrateur.MiniProjet.CONFIG));
        new controllers.MiniProjetController();


    }

    /**
     * Creates the config folder.
     */
    private void createConfigFolder() {

        new java.io.File(demonstrateur.MiniProjet.FOLDER).mkdirs();
    }

    /**
     * Load config file.
     *
     * @param configFile the config file
     */
    private static void loadConfigFile(final Path configFile) {

        // Read the file
        final java.nio.charset.Charset charset = java.nio.charset.Charset.forName("UTF-8");
        try (java.io.BufferedReader reader = Files.newBufferedReader(configFile,
                charset)) {
            String line;
            String text = "";
            while ((line = reader.readLine()) != null) {
                text += line;
            }
            // Convert the JSON file to an java object
            final Gson gson = new Gson();
            config.Config.setConfiguration(gson.fromJson(text, java.util.Map.class));
        } catch (final java.io.IOException x) {

            System.err.format("IOException: %s%n", x);
        }
    }
}
