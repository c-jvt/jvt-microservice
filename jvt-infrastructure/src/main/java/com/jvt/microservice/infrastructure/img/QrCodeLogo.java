package com.jvt.microservice.infrastructure.img;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public final class QrCodeLogo {
    /**
     * 二维码绘制logo
     *
     * @param content 二维码图片内容
     * @param logoUrl logo图片url
     */
    public static BufferedImage encodeImgLogo(String content, URL logoUrl) {
        BufferedImage qrCode = QrCode.encodeImg(content);//生成二维码图片
        try {
            //获取画笔
            Graphics2D g = qrCode.createGraphics();
            //读取logo图片
            BufferedImage logo = ImageIO.read(logoUrl);
            //设置二维码大小，太大，会覆盖二维码，此处20%
            int logoWidth = logo.getWidth(null) > qrCode.getWidth() * 2 / 10 ? (qrCode.getWidth() * 2 / 10) : logo.getWidth(null);
            int logoHeight = logo.getHeight(null) > qrCode.getHeight() * 2 / 10 ? (qrCode.getHeight() * 2 / 10) : logo.getHeight(null);
            //设置logo图片放置位置
            //中心
            int x = (qrCode.getWidth() - logoWidth) / 2;
            int y = (qrCode.getHeight() - logoHeight) / 2;
            //开始合并绘制图片
            g.drawImage(logo, x, y, logoWidth, logoHeight, null);
            g.drawRoundRect(x, y, logoWidth, logoHeight, 15, 15);
            //logo边框大小
            g.setStroke(new BasicStroke(0));
            //logo边框颜色
      /*      g.setColor(Color.WHITE);*/
            g.drawRect(x, y, logoWidth, logoHeight);
            g.dispose();
            logo.flush();
            qrCode.flush();
        } catch (Exception e) {
            System.out.println("二维码绘制logo失败");
        }
        return qrCode;
    }

    /**
     * 二维码输出到文件
     *
     * @param content 二维码图片内容
     * @param logoUrl logo图片Url
     * @param format  图片格式
     * @param file    输出文件
     */
    public static void writeToFile(String content, URL logoUrl, String format, File file) {
        BufferedImage image = encodeImgLogo(content, logoUrl);
        try {
            ImageIO.write(image, format, file);
        } catch (IOException e) {
            System.out.println("二维码写入文件失败" + e.getMessage());
        }
    }

    /**
     * 二维码流式输出
     *
     * @param content 二维码图片文件
     * @param logoUrl logo图片Url
     * @param format  图片格式
     * @param stream  输出流
     */
    public static void writeToStream(String content, URL logoUrl, String format, OutputStream stream) {
        BufferedImage image = encodeImgLogo(content, logoUrl);
        try {
            ImageIO.write(image, format, stream);
        } catch (IOException e) {
            System.out.println("二维码写入流失败" + e.getMessage());
        }
    }
}
