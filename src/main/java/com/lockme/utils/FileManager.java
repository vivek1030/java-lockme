package com.lockme.utils;

import java.util.Arrays;
import java.io.File;

import com.lockme.prototype.AbstractFileManager;

public class FileManager extends AbstractFileManager {
    private String rootDir;

    public FileManager(String rootDir){
        this.rootDir = rootDir;
    }

    public String getRootDir() {
        return rootDir;
    }

    public void setRootDir(String rootDir) {
        this.rootDir = rootDir;
    }


    @Override
    protected String[] getFileNames() {
        String[] fileNames = new String[0];

        try {
            fileNames = new File(getRootDir()).list();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fileNames;
    }

    @Override
    protected String[] getFileNamesInAscendingOrder() {
        String[] fileNames;
        fileNames = this.getFileNames();
        Arrays.sort(fileNames);
        return fileNames;
    }

    @Override
    protected void addFile(String fileName) {

        try {
            File file = new File(getRootDir() + fileName);
            if (file.createNewFile()) {
                System.out.println("File added successfully.");
            } else {
                System.out.println("File already exists.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void deleteFile(String fileName) {

        File file = new File(getRootDir() + fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File deleted successfully.");
            } else {
                System.out.println("Failed to delete file.");
            }
        } else {
            System.out.println("File not found.");
        }

    }

    @Override
    protected void searchFile(String fileName) {
        String[] fileNames = getFileNamesInAscendingOrder();
        int index = Arrays.binarySearch(fileNames, fileName);

        if (index >= 0) {
            System.out.println("File found.");
        } else {
            System.out.println("File not found.");
        }
    }


}