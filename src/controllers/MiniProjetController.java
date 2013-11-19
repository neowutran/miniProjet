/*
 * @author Martini Didier
 */

package controllers;

import views.View;

/**
 * The Class FroshController.
 */
public class MiniProjetController {

    /**
     * The grid model.
     */

    /**
     * The grid.
     */
    private final View view;

    //TODO ajouter un attribut de classe pour le model

    /**
     * The Constant LOGGER.
     */
    public static final java.util.logging.Logger LOGGER = java.util.logging.Logger.getLogger("MiniProjet");

    /**
     * Instantiates a new frosh controller.
     */
    public MiniProjetController() {

        this.loggingConfig();

        //TODO creer le model ici

        this.view = new View();

    }

    /**
     * Logging config.
     */
    private void loggingConfig() {

        controllers.MiniProjetController.LOGGER.setLevel(java.util.logging.Level.INFO);
        final java.util.logging.XMLFormatter xmlFormatter = new java.util.logging.XMLFormatter();
        java.util.logging.FileHandler logFile = null;
        try {
            logFile = new java.util.logging.FileHandler("log.xml");
        } catch (SecurityException | java.io.IOException e) {

            controllers.MiniProjetController.LOGGER.severe(java.util.Arrays.toString(e.getStackTrace()));
        }

        if (logFile != null) {
            logFile.setFormatter(xmlFormatter);
        }
        controllers.MiniProjetController.LOGGER.addHandler(logFile);

    }

}
