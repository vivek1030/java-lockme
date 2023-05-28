package com.lockme.utils;

import java.util.Arrays;
import java.util.Scanner;

public class FileOperationV1 extends FileManager {
    Scanner scanner = new Scanner(System.in);

    public FileOperationV1(String rootDir) {
        super(rootDir);
    }

    public void showMainMenu() {
        System.out.println("MAIN MENU");
        System.out.println("1. Display current file names in ascending order");
        System.out.println("2. File operations");
        System.out.println("3. Close application");

        int choice = getUserChoice(1, 3);

        switch (choice) {
            case 1 -> displayAllFile();
            case 2 -> showFileOperationsMenu();
            case 3 -> {
                System.out.println("Closing application...");
                System.exit(0);
            }
        }
        showMainMenu();
    }

    private int getUserChoice(int minChoice, int maxChoice) {
        int choice;

        while (true) {
            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
                if (choice >= minChoice && choice <= maxChoice) {
                    break;
                } else {
                    System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        return choice;
    }

    private void showFileOperationsMenu() {
        System.out.println("FILE OPERATIONS MENU");
        System.out.println("1. Add a file");
        System.out.println("2. Delete a file");
        System.out.println("3. Search a file");
        System.out.println("4. Return to main menu");

        int choice = getUserChoice(1, 4);

        String fileName = "";

        if (choice != 4) {
            System.out.print("Enter the file name: ");
            fileName = scanner.nextLine();
        }

        switch (choice) {
            case 1 -> addFile(fileName);
            case 2 -> deleteFile(fileName);
            case 3 -> searchFile(fileName);
            case 4 -> showMainMenu();
        }
        if (choice != 4) {
            showFileOperationsMenu();
        }
    }

    private void displayAllFile() {
        String[] fileNames = getFileNamesInAscendingOrder();
        System.out.println(Arrays.toString(fileNames));
    }
}
