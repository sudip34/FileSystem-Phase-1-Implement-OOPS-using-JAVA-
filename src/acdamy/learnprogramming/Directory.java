package acdamy.learnprogramming;
import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.util.Scanner;

import java.util.stream.Stream;

public class Directory {
    private String directory;



    public Directory() {


    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }


    public void welcome() {
        System.out.println("=======Lockers Pvt. Ltd.=========== ");
        System.out.println("====App created by sudip saha====== ");
        System.out.println("===Email:sudipcep2006@gmail.com==== ");
        System.out.println("=================================== ");
        System.out.println("");
        System.out.println("");
    }


    public void filesInDirectory() {


//            String filepath = getPath();
        String filepath = getDirectory();

        //Creating a File object for directory
        File folder = new File(filepath);

        if (folder.isDirectory()) {
            File[] listOfFiles = folder.listFiles();

            for (File files : listOfFiles) {
                if (files.isFile()) {

                    System.out.println(files.getName());


                } else if (files.isDirectory()) {

                    System.out.println("directory " + files.getName());

                } else {
                    System.out.println("Please check your Entered Directory again");
                }
            }
        }
    }


    public void addFile(String name) {
        //            String filepath = getPath();
        String path = getDirectory();
        StringBuilder stringBuilder = new StringBuilder(path);
        stringBuilder.append("\\\\").append(name).append(".txt");
        String newFilePath = (String.valueOf(stringBuilder));
        File file = new File(newFilePath);
        try {
            if (!file.exists()) {
                file.createNewFile();
                System.out.println(file.getName() + " file has created");
            } else {
                System.out.println(file.getName() + " file is already existed");
            }
        } catch (Exception e) {
            System.out.println("FILED Exception");
            e.printStackTrace();
        }
    }


    public void deleteFile(String name) {

        String pathString = getDirectory();
        StringBuilder stringBuilder = new StringBuilder(pathString);
        stringBuilder.append("\\\\").append(name);
        String newFilePath = (String.valueOf(stringBuilder));
        File file = new File(newFilePath);

        if (file.exists()) {
            try {
                Path path = Paths.get(newFilePath);
                Files.delete(path);
                System.out.println(name + " file is deleted");


            } catch (NoSuchFileException x) {
                System.out.println(" no such" + " file or directory");

            } catch (DirectoryNotEmptyException x) {
                System.out.println("not empty");
                x.printStackTrace();

            } catch (IOException x) {
                // File permission problems are caught here.
                System.out.println(x);

            }

        } else {
            System.out.println(name + "  can not be deleted. File is not in this directory!!!");

        }

    }
    public void findFile(String name) {
        //            String filepath = getPath();

        String pathString = getDirectory();


        try (Stream<Path> stream = Files.find(Paths.get(pathString), 5,
                (path, attr) -> path.getFileName().toString().equals(name))) {
            // (path, attr) -> path.getFileName().toString().equals(name) )) {
            if (stream.findAny().isPresent()) {
                System.out.println(name + " is found !!");
                System.out.println( " ");
            } else {
                System.out.println(name + " is not found in the directory!!!");
                System.out.println( " ");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public void detailsOfTheUserInterface() {
        boolean isTrue = true;
        while (isTrue) {

            Scanner scanner = new Scanner(System.in);
            welcome();
            System.out.println("Select to Add, Delete or Search");
            int chances = 0;
            while (chances < 3) {
                System.out.println("1. ADD File:");
                System.out.println("2. Delete File:");
                System.out.println("3. Search File:");
                System.out.println("4. Exit App:");
                try {
                    String input = scanner.nextLine();
                    int c = Integer.valueOf(input);
                    if (c == 1 || c == 2 || c == 3 || c == 4) {
                        System.out.println("---------------------");
                        switch (c) {
                            case 1:
                                System.out.println("Enter the file name you want to add");
                                Scanner scanner0 = new Scanner(System.in);
                                String fName = scanner0.nextLine();
                                addFile(fName);
                                filesInDirectory();
                                break;

                            case 2:
                                System.out.println("Enter the file name you want to delete: ");
                                Scanner scanner1 = new Scanner(System.in);
                                String fName1 = scanner1.nextLine();

                                StringBuilder stringBuilder = new StringBuilder(fName1);
                                stringBuilder.append(".txt");
                                String fileName= (String.valueOf(stringBuilder)).toLowerCase();
                                deleteFile(fileName);
                                System.out.println("-------------------------------------------------");
                                filesInDirectory();

                                break;
                            case 3:
                                System.out.println("Enter the file name you are searching for:");
                                Scanner scanner2 = new Scanner(System.in);
                                String fName2 = scanner2.nextLine();
                                StringBuilder SB= new StringBuilder(fName2);
                                SB.append(".txt");
                                String newFileName= (String.valueOf(SB)).toLowerCase();
                                findFile(newFileName);
                                break;
                            case 4:
                                System.out.println("Exit the app");

                                isTrue = false;
                        }
                        chances = 3;

                    } else {
                        System.out.println("Please enter a correct option!! (1/2/3/4)");
                        chances += 1;
                        System.out.println("Maximum Chances  3 and you have left " + (3 - chances));
                        if (chances == 3) {
                            isTrue = false;
                        }


                    }
                } catch (NumberFormatException ex) {
                    System.out.println("not in Number format:" + ex.getMessage());
                    System.out.println("--------------------------------------");
                    chances = 0;
                }

            }
        }
    }



}

