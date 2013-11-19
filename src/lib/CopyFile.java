/*
 * @author Martini Didier
 */

package lib;

/**
 * The Class CopyFile.
 */
public class CopyFile {

    /**
     * The destination.
     */
    private String destination;

    /**
     * The sources.
     */
    private final java.io.InputStream sources = this.getClass().getClassLoader().getResourceAsStream("config.json");

    /**
     * The Constant TAILLEBUFFER.
     */
    private static final int TAILLEBUFFER = 1024;

    /**
     * Copyfile.
     *
     * @param destination the destination
     */
    public void copyfile(final String destination) {

        this.setDestination(destination);
        try {
            final java.io.File f2 = new java.io.File(destination);
            final java.io.OutputStream out = new java.io.FileOutputStream(f2);
            final byte[] buf = new byte[lib.CopyFile.TAILLEBUFFER];
            int len;
            while ((len = this.sources.read(buf)) > 0) {
                out.write(buf, 0, len);
            }
            this.sources.close();
            out.close();
        } catch (final java.io.FileNotFoundException ex) {
            controllers.MiniProjetController.LOGGER.severe(java.util.Arrays.toString(ex.getStackTrace()));
            System.exit(0);
        } catch (final java.io.IOException e) {
            controllers.MiniProjetController.LOGGER.severe(java.util.Arrays.toString(e.getStackTrace()));
        }
    }

    /**
     * Gets the destination.
     *
     * @return the destination
     */
    public String getDestination() {

        return this.destination;
    }

    /**
     * Sets the destination.
     *
     * @param destination the new destination
     */
    public void setDestination(final String destination) {

        this.destination = destination;
    }
}
