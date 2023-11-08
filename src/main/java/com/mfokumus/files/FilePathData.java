package com.mfokumus.files;

import java.io.File;
import java.util.Date;
import java.util.UUID;

public class FilePathData {

    // Variables
    private String id;
    private String pathFileName;
    private String pathDirectoryName;
    private String url;
    private String path;
    private File file;
    private Date systemCreatedDate;

    // Constructor (Parametresiz)
    public FilePathData() {
        this.id = UUID.randomUUID().toString();
        systemCreatedDate = new Date(System.currentTimeMillis());
        pathFileName = "\\secretkey.txt";
        // C:\\io\\techcareer\\full_file
        this.pathDirectoryName = FilePathUrl.MY_FILE_PATH_URL;
        // C:\\io\\techcareer\\full_file\\secretkey.txt

    }
}
