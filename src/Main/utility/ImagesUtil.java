package Main.utility;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;

public class ImagesUtil {
    public static BufferedImage flipImageHorizontally(BufferedImage image) {

        /* Create a new clean image of the same size/type */
        BufferedImage flipped = new BufferedImage(image.getWidth(), image.getHeight(), image.getType());

        /* Instantiate Affine transformation for flipping and translating */
        AffineTransform tran = AffineTransform.getTranslateInstance(image.getWidth(), 0);
        AffineTransform flip = AffineTransform.getScaleInstance(-1d, 1d);

        /* Merge these */
        tran.concatenate(flip);

        /* Creates a Graphics2D object linked  */
        Graphics2D g = flipped.createGraphics();

        /* Set the transformation on the graphic */
        g.setTransform(tran);

        /* Draw the image onto the graphic */
        g.drawImage(image, 0, 0, null);

        /* Now dispose of the graphic */
        g.dispose();

        /* Return the flipped image */
        return flipped;
    }
    
}
