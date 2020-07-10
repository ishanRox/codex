/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package GUI;

import javax.microedition.lcdui.Image;

/**
 *
 * @author Acer
 */
public class ImageResizer {

    public static Image resizeImage(Image image, int ratio) {

        int width = image.getWidth();
        int height = image.getHeight();

        int resizedWidth = width * ratio / 100;
        int resizedHeight = height * ratio / 100;

        int[] in = new int[width];
        int[] out = new int[resizedWidth * resizedHeight];

        int dy, dx;
        for (int y = 0; y < resizedHeight; y++) {

            dy = y * height / resizedHeight;
            image.getRGB(in, 0, width, 0, dy, width, 1);

            for (int x = 0; x < resizedWidth; x++) {
                dx = x * width / resizedWidth;
                out[(resizedWidth * y) + x] = in[dx];
            }

        }
        return Image.createRGBImage(out, resizedWidth, resizedHeight, true);
    }
}
