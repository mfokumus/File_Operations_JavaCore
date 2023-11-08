package com.mfokumus.files;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

public class FilePathData {

    // Variables
    private String id;
    private String pathFileName;
    private String pathDirectoryName;
    private String url;
    private File file;
    private Date systemCreatedDate;

    // Constructor (Parametresiz)
    public FilePathData() {
        this.id = UUID.randomUUID().toString();
        this.systemCreatedDate = new Date(System.currentTimeMillis());
        pathFileName = "\\secretkey.txt";
        // C:\\io\\techcareer\\full_file
        pathDirectoryName = FilePathUrl.MY_FILE_PATH_URL;
        // C:\\io\\techcareer\\full_file\\secretkey.txt
        url = pathDirectoryName.concat(pathFileName);
        file = new File(url);
        try {
            // Is there a file in the directory ?
            if (file.createNewFile()){
                System.out.println(pathFileName +" There is a file. It is not created again.");
                System.out.println("Permission: Can it read? " + file.canRead() + " Can it write? " + file.canWrite() + " Can it executed? " + file.canExecute());
                // toString
                System.out.println("ID: "+this.id + " URL: "+this.url+" HASH CODE: "+file.hashCode());
                //Writer
                secretFileWriter();
                //Reader
                secretFileReader();
                //Delete
                fileIsDelete();
            }else{
                String fileName = pathFileName +" There is a file. It is not created again.";
                System.out.println(fileName);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    } // end constructor

    // toString
    @Override
    public String toString() {
        return "FilePathData{" +
                "id='" + id + '\'' +
                ", pathFileName='" + pathFileName + '\'' +
                ", pathDirectoryName='" + pathDirectoryName + '\'' +
                ", url='" + url + '\'' +
                ", file=" + file +
                ", systemCreatedDate=" + systemCreatedDate +
                '}';
    }
    private String localeDateTime(){
        Locale locale = new Locale("tr", "TR");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMM-yyyy",locale);
        Date date = new Date();
        String changeDate = simpleDateFormat.format(date);
        return changeDate;
    }


    // File Write
    private void secretFileWriter(){
        try(BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(this.url, true))){
            String data = "[ " + localeDateTime() + " ]" + " secret-key: ssh-keygen -t rsa -b 4096 -C 'metefurkanokumus@gmail.com'";
            bufferedWriter.write(data);
            bufferedWriter.flush();
        }catch (Exception e){
            e.printStackTrace();
        } // end writer
    }

    // File Reader
    private void secretFileReader() {
        String rows; // read rows
        StringBuilder stringBuilder = new StringBuilder(); // it provides you to sum all rows together
        String builderToString;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(this.url))) {
            while((rows=bufferedReader.readLine())!=null){
                stringBuilder.append(rows); // stringBulder method add the all rows to itself by using append method
            }
            builderToString = stringBuilder.toString(); // they transformed to the string form and assign to the builder.
            System.out.println("It is read: " + builderToString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    } // end reader

    // File Delete
    private void fileIsDelete(){
        Scanner keyboard = new Scanner(System.in);
        char chooise;
        System.out.println(pathFileName+" Do you wanna delete this file? Y / N ");
        chooise = keyboard.nextLine().charAt(0);
        if (chooise == 'E' || chooise == 'e'){
            file.exists();
        }else{
            System.out.println(pathFileName + " File is not deleted.");
        }
    }



} // end class

