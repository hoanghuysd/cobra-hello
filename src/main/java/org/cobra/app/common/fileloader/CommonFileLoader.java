package org.cobra.app.common.fileloader;


import org.cobra.web.error.exception.CbIOFileException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

/**
 * Created by Hoang Huy on 11/2/2017.
 */
@Component
public class CommonFileLoader {
    private static final Logger LOGGER = LoggerFactory.getLogger(CommonFileLoader.class);

    /** Pre-path file link to resource */
    private final String PRE_PATH = "classpath:";

    @Autowired
    private ResourceLoader resourceLoader;

    public String reader(String pathFile) throws CbIOFileException {

        StringBuilder classpath =new StringBuilder(PRE_PATH);
        classpath.append(pathFile);
        File file = null;
        StringBuilder contentsFile =new StringBuilder();
        try {
            Resource res =resourceLoader.getResource(classpath.toString());
            file = res.getFile();
            contentsFile.append(new String(Files.readAllBytes(file.toPath())));
        } catch (IOException ioe) {
            throw new CbIOFileException(ioe.getMessage());
        }
     return contentsFile.toString();
    }
}
