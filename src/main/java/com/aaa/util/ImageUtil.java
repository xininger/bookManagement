package com.aaa.util;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;

public class ImageUtil {

    public static String getImagePath(HttpSession session, String fileName){
        ServletContext servletContext = session.getServletContext();
        String pathPhoto = servletContext.getRealPath("photo");
        File file = new File(pathPhoto);
        String finalPath = pathPhoto + file.separator + fileName;
        System.out.println(finalPath);
        return finalPath;
    }
}
