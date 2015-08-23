package com.company.dad;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.Parser;
import org.apache.tika.parser.mp3.Mp3Parser;
import org.xml.sax.ContentHandler;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class AudioParser {

    /**
     * @param args
     */
    public static void main(String[] args) {
        String fileLocation = "C:\\Users\\Varun\\Downloads\\PM_Podcast_328_2015_08_07_bill_dow.mp3";

        ArrayList<String> listOfFiles = new ArrayList<>();
        listOfFiles.add(fileLocation);

        //TODO find all mp3 files in a directory
        //ArrayList<String> listOfFiles = getListOfFiles();

        //TODO Get All MetaData
        ArrayList<PodcastMetaData> listOfPodcastMetaData = GetAllMetaDataForFiles(listOfFiles);

        //TODO write to a excel file
        generateExcelFile(listOfPodcastMetaData);
    }

    private static void generateExcelFile(ArrayList<PodcastMetaData> listOfPodcastMetaData) {



    }

    private static ArrayList<PodcastMetaData> GetAllMetaDataForFiles(ArrayList<String> listOfFiles) {
        ArrayList<PodcastMetaData> listOfPodcastMetaData = new ArrayList<>();

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

        for(String name : metadataNames){
        System.out.println(name + ": " + metadata.get(name));
        }

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

    private static ArrayList<String> getListOfFiles() {

        ArrayList<String> listOfMp3Files = new ArrayList<>();

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
}