package acdamy.learnprogramming;

import java.io.File;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws NullPointerException {

        //        create an object of Directory
        Directory directory = new Directory();

        directory.welcome();
        int option = 0;
        int inputChance = 0;
        while (inputChance < 4) {
            System.out.println("Please Enter the path directory :");
            Scanner scanner = new Scanner(System.in);
            String path = scanner.nextLine();
            File file = new File(path);
            if (file.isDirectory()) {
                directory.setDirectory(path);
                inputChance = 4;
                option = 1;

            } else {
                System.out.println("Path is wrong.try again");
                System.out.println("Maximum Chances  4 and you have left " + (3 - inputChance));
                inputChance += 1;
                //filesInDirectory();
                if (inputChance == 3) {
                    option = 2;
                }

            }


        }

        switch (option) {
            case 1:
                //Switch method will be used to give 3 options
                Scanner sca;
                boolean flag = true;


                while (flag) {
                    directory.welcome();
                    System.out.println("-----------------------------------");
                    System.out.println("-----------------------------------");
                    System.out.println("");
                    System.out.println("");

                    System.out.println("Enter the option you want to perform:\t");
                    int chances = 0;
                    while (chances < 3) {
                        System.out.println("1. Retrieve all files ");
                        System.out.println("2. Add/Delete/Search files");
                        System.out.println("3. Close the app");
                        System.out.println("-----------------------------------------------");


                        sca = new Scanner(System.in);

                        try {
                            String input = sca.nextLine();
                            int option1 = Integer.valueOf(input);

                            System.out.println("-----------------------------------------------");

                            if (option1 == 1 || option1 == 2 || option1 == 3) {

                                switch (option1) {
                                    case 1:
                                        directory.filesInDirectory();

                                        break;
                                    case 2:
                                        directory.detailsOfTheUserInterface();
                                        break;
                                    case 3:
                                        System.out.println("Exited from the app!!!");
                                        flag = false;
                                }
                                chances = 3;
                            } else {
                                System.out.println("Please enter a correct option!! ");
                                chances += 1;
                                System.out.println("Maximum Chances  3 and you have left " + (3 - chances));
                                if (chances == 3) {
                                    flag = false;
                                }


                            }


                        } catch (NumberFormatException e) {
                            System.out.println("Please enter a correct option in number 1 or 2 or 3 !! ");
                            System.out.println(" not in number format :" + e.getMessage());
                            chances = 0;
                        }


                    }

                }

            case 2:
                System.out.println("Exited from the app!!!");
                break;

        }


    }


}


