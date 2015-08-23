package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;
import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class PmpPodcastMetaDataExtractor {

    //TODO add a logger for logging.

    public static void main(String[] args) {

        ArrayList<String> listOfFiles = getListOfFiles();

        ArrayList<PodcastMetaData> listOfPodcastMetaData = GetAllMetaDataForFiles(listOfFiles);

        generateExcelFile(listOfPodcastMetaData);
    }

    private static ArrayList<String> getListOfFiles() {

        ArrayList<String> listOfMp3Files = new ArrayList<String>();

        String path = ".";

        String files = null;
        File folder = new File(path);

        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {
                files = listOfFiles[i].getName();
                if (files.endsWith(".mp3") || files.endsWith(".MP3")) {
                    System.out.println(files);
                    listOfMp3Files.add(files);
                }
            }
        }

        return listOfMp3Files;
    }

    private static ArrayList<PodcastMetaData> GetAllMetaDataForFiles(ArrayList<String> listOfFiles) {
        ArrayList<PodcastMetaData> listOfPodcastMetaData = new ArrayList<PodcastMetaData>();

        for(String fileLocation : listOfFiles) {
            listOfPodcastMetaData.add(populateMetaData(fileLocation));
        }
        return listOfPodcastMetaData;
    }

    private static PodcastMetaData populateMetaData(String fileLocation) {

        PodcastMetaData podcastMetaData = new PodcastMetaData();

        try {

            InputStream input = new FileInputStream(new File(fileLocation));
            ContentHandler handler = new DefaultHandler();
            Metadata metadata = new Metadata();
            Parser parser = new Mp3Parser();
            ParseContext parseCtx = new ParseContext();
            parser.parse(input, handler, metadata, parseCtx);
            input.close();

            // List all metadata
            String[] metadataNames = metadata.names();

        /*for(String name : metadataNames){
        System.out.println(name + ": " + metadata.get(name));
        }*/

            // Retrieve the necessary info from metadata
            // Names - title, xmpDM:artist etc. - mentioned below may differ based
            System.out.println("----------------------------------------------");
            System.out.println("Title: " + metadata.get("title"));

            podcastMetaData.setTitle(metadata.get("title"));

        /*System.out.println("Artists: " + metadata.get("xmpDM:artist"));*/
            System.out.println("Composer : " + metadata.get("xmpDM:composer"));

            podcastMetaData.setComposer(metadata.get("xmpDM:composer"));
        /*System.out.println("Genre : "+metadata.get("xmpDM:genre"));
        System.out.println("Album : "+metadata.get("xmpDM:album"));*/


            //TODO set data into a pipe delimited file
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (TikaException e) {
            e.printStackTrace();
        }

        return podcastMetaData;
    }

    private static void generateExcelFile(ArrayList<PodcastMetaData> listOfPodcastMetaData) {

        Workbook wb = new HSSFWorkbook();
        //Workbook wb = new XSSFWorkbook();
        CreationHelper createHelper = wb.getCreationHelper();
        Sheet sheet = wb.createSheet("Podcasts");

        // Create a row and put some cells in it. Rows are 0 based.
       /* Row row = sheet.createRow((short)0);
        // Create a cell and put a value in it.
        Cell cell = row.createCell(0);
        cell.setCellValue(1);*/

        //TODO create Title
        Row row = sheet.createRow(0);
        row.createCell(0).setCellValue("Title");
        row.createCell(1).setCellValue("Composer");

        //TODO prep to the excel file
        int i = 0;
        for(PodcastMetaData podcastMetaData : listOfPodcastMetaData) {
            row = sheet.createRow(++i);
            row.createCell(0).setCellValue(podcastMetaData.getTitle());
            row.createCell(1).setCellValue(podcastMetaData.getComposer());
        }

        //TODO write to the excel file
        FileOutputStream fileOut = null;
        Calendar cal = Calendar.getInstance();
        try {
            String fileName = getFileName();
            fileOut = new FileOutputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {

        }
        try {
            wb.write(fileOut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fileOut.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static String getFileName() {
        StringBuffer fileName = new StringBuffer();

        Calendar cal = Calendar.getInstance();

        fileName.append("WorkBook_");
        fileName.append(cal.get(Calendar.MONTH)).append("_");
        fileName.append(cal.get(Calendar.DAY_OF_MONTH)).append("_");
        fileName.append(cal.get(Calendar.YEAR)).append("_");
        fileName.append(cal.get(Calendar.HOUR)).append("_");
        fileName.append(cal.get(Calendar.MINUTE)).append("_");
        fileName.append(cal.get(Calendar.SECOND)).append(".xls");

        return fileName.toString();
    }
}
