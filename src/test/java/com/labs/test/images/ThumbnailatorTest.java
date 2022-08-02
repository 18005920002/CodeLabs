package com.labs.test.images;

import com.google.common.io.Files;
import net.coobird.thumbnailator.Thumbnails;
import net.coobird.thumbnailator.filters.ImageFilter;
import net.coobird.thumbnailator.geometry.Position;
import net.coobird.thumbnailator.geometry.Positions;
import net.coobird.thumbnailator.resizers.configurations.ScalingMode;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * @author tanyun.zheng
 * @date 2020/11/4 14:10
 */
public class ThumbnailatorTest {

    @Test
    public void waterMark() throws IOException {
        //File skuImage = new File("src/test/resources/images/800_1600.png");
        File skuImage = new File("src/test/resources/images/psmall.jpg");
        //File waterMark = new File("src/test/resources/images/40x20sw.png");
        //BufferedImage biWaterMark = ImageIO.read(waterMark);
        BufferedImage biSku = ImageIO.read(skuImage);
        int max = Math.max(biSku.getHeight(), biSku.getWidth());
        Position position = Positions.CENTER;
        /*Thumbnails.of(biSku)
                //固定宽度
                //.width(200)
                .scalingMode(ScalingMode.BILINEAR).scale(3)
                //.size(biSku.getWidth(),biSku.getHeight())
                //.watermark(position,biWaterMark,0.8f)
        .toFile(new File("src/test/resources/out/4.jpg"));*/

        BufferedImage backGround = ImageIO.read(new File("src/test/resources/images/transparent_blue10x10.png"));
        Thumbnails.of(backGround)
                //固定宽度
                .forceSize(max, max)
                .watermark(position, biSku, 0.8f)
                .toFile(new File("src/test/resources/out/5.png"));
    }
}
