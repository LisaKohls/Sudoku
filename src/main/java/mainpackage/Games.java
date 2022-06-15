package mainpackage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Games {

    static Board solution_board = new Board(); // ausgefülltes Brett (Lösung)
    static Board puzzle_board = new Board(); // teilweise leeres Brett (Rätsel)

    /***
     * Spielbrett wird mit einem zufälligen Schema befüllt
     */
    public Games() {

        gameController levelInitialized=new gameController();

        int randomNumber = (int) (10 * Math.random());
        System.out.println("Random Number: " + randomNumber);
        System.out.println("level hat nr."+levelInitialized.getCurrentlevel());

        //if Funktion mit Level nr soll die Sudokos nach Schwierigkeitsgrad auswählen
        if(levelInitialized.getCurrentlevel()==1) {
            switch (randomNumber) {
                //leicht:
                case 1:

                    int[][] gameSolutionValues1 = {
                            {8, 3, 1, 6, 9, 5, 7, 4, 2},
                            {7, 5, 4, 8, 1, 2, 6, 9, 3},
                            {9, 2, 6, 3, 7, 4, 8, 5, 1},
                            {2, 6, 7, 9, 5, 3, 4, 1, 8},
                            {5, 4, 3, 7, 8, 1, 2, 6, 9},
                            {1, 9, 8, 2, 4, 6, 3, 7, 5},
                            {6, 7, 9, 5, 3, 8, 1, 2, 4},
                            {4, 8, 2, 1, 6, 9, 5, 3, 7},
                            {3, 1, 5, 4, 2, 7, 9, 8, 6},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues1);

                    int[][] gamePuzzleValues1 = {
                            {8, 3, 1, 0 , 0, 0, 7, 4, 2},
                            {7, 0, 4, 0, 0, 0, 6, 0, 3},
                            {0, 0, 6, 3, 0, 4, 8, 0, 0},
                            {2, 0, 0, 9, 0, 3, 0, 0, 8},
                            {5, 0, 3, 0, 0, 0, 2, 0, 9},
                            {1, 0, 0, 2, 0, 6, 0, 0, 5},
                            {0, 0, 9, 5, 0, 8, 1, 0, 0},
                            {4, 0, 2, 0, 0, 0, 5, 0, 7},
                            {3, 1, 5, 0, 0, 0, 9, 8, 6},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues1);

                    break;


                case 2:
                    int[][] gameSolutionValues2 = {
                            {6, 4, 1, 5, 3, 2, 8, 9, 7},
                            {9, 8, 2, 7, 1, 4, 3, 6, 5},
                            {7, 3, 5, 8, 9, 6, 1, 4, 2},
                            {8, 6, 3, 1, 4, 5, 7, 2, 9},
                            {4, 1, 7, 3, 2, 9, 5, 8, 6},
                            {5, 2, 9, 6, 7, 8, 4, 1, 3},
                            {3, 7, 4, 2, 6, 1, 9, 5, 8},
                            {1, 5, 6, 9, 8, 3, 2, 7, 4},
                            {2, 9, 8, 4, 5, 7, 6, 3, 1},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues2);

                    int[][] gamePuzzleValues2 = {
                            {0, 0, 0, 5, 3, 2, 0, 0, 0},
                            {9, 0, 2, 0, 0, 0, 3, 0, 5},
                            {0, 3, 0, 8, 0, 6, 0, 4, 0},
                            {8, 6, 3, 1, 0, 5, 7, 2, 9},
                            {0, 0, 0, 3, 0, 9, 0, 0, 0},
                            {5, 2, 9, 6, 0, 8, 4, 1, 3},
                            {0, 7, 0, 2, 0, 1, 0, 5, 0},
                            {1, 0, 6, 0, 0, 0, 2, 0, 4},
                            {0, 0, 0, 4, 5, 7, 0, 0, 0},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues2);

                    break;


                case 3:
                    int[][] gameSolutionValues3 = {
                            {3, 7, 4, 5, 1, 6, 9, 8, 2},
                            {1, 5, 8, 9, 3, 2, 7, 4, 6},
                            {9, 2, 6, 7, 4, 8, 3, 5, 1},
                            {4, 3, 7, 1, 2, 9, 5, 6, 8},
                            {2, 1, 9, 6, 8, 5, 4, 7, 3},
                            {6, 8, 5, 4, 7, 3, 1, 2, 9},
                            {8, 4, 1, 3, 6, 7, 2, 9, 5},
                            {5, 6, 3, 2, 9, 4, 8, 1, 7},
                            {7, 9, 2, 8, 5, 1, 6, 3, 4},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues3);

                    int[][] gamePuzzleValues3 = {
                            {3, 7, 0, 0, 0, 0, 0, 8, 2},
                            {1, 0, 8, 0, 0, 0, 7, 0, 6},
                            {0, 2, 6, 7, 0, 8, 3, 5, 0},
                            {0, 0, 7, 1, 0, 9, 5, 0, 0},
                            {0, 0, 9, 6, 0, 5, 4, 0, 0},
                            {0, 0, 5, 4, 0, 3, 1, 0, 0},
                            {0, 4, 1, 3, 0, 7, 2, 9, 0},
                            {5, 0, 3, 0, 0, 0, 8, 0, 7},
                            {7, 9, 0, 0, 0, 0, 0, 3, 4},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues3);

                    break;


                case 4:
                    int[][] gameSolutionValues4 = {
                            {2, 6, 4, 7, 5, 9, 1, 8, 3},
                            {5, 8, 7, 4, 3, 1, 2, 9, 6},
                            {9, 1, 3, 2, 6, 8, 7, 4, 5},
                            {3, 4, 8, 8, 1, 7, 5, 2, 9},
                            {8, 2, 5, 3, 9, 6, 4, 1, 7},
                            {1, 7, 9, 5, 2, 4, 6, 3, 8},
                            {7, 5, 8, 9, 4, 2, 3, 6, 1},
                            {4, 9, 1, 6, 7, 3, 8, 5, 2},
                            {6, 3, 2, 1, 8, 5, 9, 7, 4},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues4);

                    int[][] gamePuzzleValues4 = {
                            {0, 6, 4, 0, 0, 0, 1, 8, 0},
                            {0, 0, 0, 4, 0, 1, 0, 0, 0},
                            {9, 0, 3, 2, 0, 8, 7, 0, 5},
                            {0, 0, 8, 8, 1, 7, 5, 0, 0},
                            {8, 0, 5, 3, 0, 6, 4, 0, 7},
                            {0, 0, 9, 5, 2, 4, 6, 0, 0},
                            {7, 0, 8, 9, 0, 2, 3, 0, 1},
                            {0, 0, 0, 6, 0, 3, 0, 0, 0},
                            {0, 3, 2, 0, 0, 0, 9, 7, 0},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues4);

                    break;


                case 5:
                    int[][] gameSolutionValues5 = {
                            {9, 3, 7, 1, 6, 2, 4, 8, 5},
                            {8, 2, 5, 4, 9, 7, 3, 1, 6},
                            {1, 4, 6, 3, 5, 8, 9, 7, 2},
                            {3, 7, 1, 6, 2, 4, 5, 9, 8},
                            {5, 8, 2, 9, 3, 1, 7, 6, 4},
                            {4, 6, 9, 8, 7, 5, 2, 3, 1},
                            {6, 5, 8, 7, 4, 9, 1, 2, 3},
                            {9, 2, 3, 5, 1, 6, 8, 4, 7},
                            {7, 1, 4, 2, 8, 3, 6, 5, 9},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues5);

                    int[][] gamePuzzleValues5 = {
                            {9, 0, 0, 0, 0, 0, 0, 0, 5},
                            {0, 0, 5, 4, 9, 7, 3, 0, 0},
                            {0, 4, 6, 3, 5, 8, 9, 7, 0},
                            {0, 0, 1, 6, 0, 4, 5, 0, 0},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {0, 0, 9, 8, 0, 5, 2, 0, 0},
                            {0, 5, 8, 7, 4, 9, 1, 2, 0},
                            {0, 0, 3, 5, 1, 6, 8, 0, 0},
                            {7, 0, 0, 0, 0, 0, 0, 0, 9},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues5);

                    break;


                case 6:
                    int[][] gameSolutionValues6 = {
                            {4, 5, 2, 8, 9, 3, 7, 1, 6},
                            {6, 3, 7, 5, 4, 1, 8, 9, 2},
                            {1, 8, 9, 6, 2, 7, 5, 4, 3},
                            {8, 2, 6, 1, 5, 9, 3, 7, 4},
                            {5, 9, 1, 3, 7, 4, 6, 2, 8},
                            {7, 4, 3, 2, 8, 6, 1, 5, 9},
                            {2, 7, 5, 9, 3, 8, 4, 6, 1},
                            {3, 6, 4, 7, 1, 2, 9, 8, 5},
                            {9, 1, 8, 4, 6, 5, 2, 3, 7},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues6);

                    int[][] gamePuzzleValues6 = {
                            {4, 0, 2, 0, 0, 0, 7, 0, 6},
                            {6, 3, 0, 5, 0, 1, 0, 9, 2},
                            {1, 0, 0, 0, 2, 0, 0, 0, 3},
                            {0, 2, 0, 0, 5, 0, 0, 7, 0},
                            {0, 9, 1, 0, 0, 0, 6, 2, 0},
                            {0, 4, 0, 0, 8, 0, 0, 5, 0},
                            {2, 0, 0, 0, 3, 0, 0, 0, 1},
                            {3, 6, 0, 7, 0, 2, 0, 8, 5},
                            {9, 0, 8, 0, 0, 0, 2, 0, 7},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues6);

                    break;


                case 7:
                    int[][] gameSolutionValues7 = {
                            {8, 7, 5, 1, 4, 6, 3, 2, 9},
                            {3, 9, 2, 8, 7, 5, 4, 6, 1},
                            {6, 4, 1, 3, 2, 9, 7, 5, 8},
                            {2, 8, 6, 5, 1, 7, 9, 4, 3},
                            {9, 1, 3, 2, 6, 4, 8, 7, 5},
                            {4, 5, 7, 9, 8, 3, 6, 1, 2},
                            {5, 6, 9, 7, 3, 2, 1, 8, 4},
                            {7, 2, 8, 4, 9, 1, 5, 3, 6},
                            {1, 3, 4, 6, 5, 8, 2, 9, 7},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues7);

                    int[][] gamePuzzleValues7 = {
                            {0, 7, 0, 1, 0, 6, 0, 2, 0},
                            {3, 0, 0, 8, 0, 5, 0, 0, 1},
                            {0, 4, 0, 3, 0, 9, 0, 5, 0},
                            {2, 0, 0, 0, 1, 0, 0, 0, 3},
                            {9, 0, 3, 2, 0, 4, 8, 0, 5},
                            {4, 0, 0, 0, 8, 0, 0, 0, 2},
                            {0, 6, 0, 7, 0, 2, 0, 8, 0},
                            {7, 0, 0, 4, 0, 1, 0, 0, 6},
                            {0, 3, 0, 6, 0, 8, 0, 9, 0},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues7);

                    break;


                case 8:
                    int[][] gameSolutionValues8 = {
                            {4, 8, 6, 3, 5, 2, 9, 7, 1},
                            {2, 3, 9, 1, 7, 4, 5, 6, 8},
                            {7, 1, 5, 8, 3, 6, 2, 4, 3},
                            {1, 5, 7, 4, 2, 9, 3, 8, 6},
                            {9, 6, 4, 7, 8, 3, 1, 2, 5},
                            {8, 2, 3, 6, 1, 5, 4, 9, 7},
                            {3, 7, 2, 5, 4, 8, 6, 1, 9},
                            {6, 4, 8, 9, 3, 1, 7, 5, 2},
                            {5, 9, 1, 2, 6, 7, 8, 3, 4},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues8);

                    int[][] gamePuzzleValues8 = {
                            {0, 0, 0, 3, 0, 2, 0, 0, 0},
                            {2, 3, 9, 0, 0, 0, 5, 6, 8},
                            {0, 1, 0, 8, 0, 6, 0, 4, 0},
                            {0, 0, 7, 4, 0, 9, 3, 0, 0},
                            {0, 6, 4, 0, 0, 0, 1, 2, 0},
                            {0, 0, 3, 6, 0, 5, 4, 0, 0},
                            {0, 7, 0, 5, 0, 8, 0, 1, 0},
                            {6, 4, 8, 0, 0, 0, 7, 5, 2},
                            {0, 0, 0, 2, 0, 7, 0, 0, 0},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues8);

                    break;


                case 9:
                    int[][] gameSolutionValues9 = {
                            {6, 8, 2, 3, 5, 4, 1, 9, 7},
                            {5, 1, 3, 9, 7, 6, 4, 8, 2},
                            {7, 9, 4, 2, 8, 1, 3, 6, 5},
                            {2, 7, 8, 4, 6, 9, 5, 1, 3},
                            {3, 6, 9, 1, 2, 5, 7, 4, 8},
                            {4, 5, 1, 7, 3, 8, 9, 2, 6},
                            {9, 3, 6, 5, 4, 2, 8, 7, 1},
                            {1, 2, 7, 8, 9, 3, 6, 5, 4},
                            {8, 4, 5, 6, 1, 7, 2, 3, 9},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues9);

                    int[][] gamePuzzleValues9 = {
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                            {5, 1, 0, 0, 7, 0, 0, 8, 2},
                            {0, 9, 4, 2, 8, 1, 3, 6, 0},
                            {0, 0, 8, 4, 6, 9, 5, 0, 0},
                            {0, 0, 9, 0, 0, 0, 7, 0, 0},
                            {0, 0, 1, 7, 3, 8, 9, 0, 0},
                            {0, 3, 6, 5, 4, 2, 8, 7, 0},
                            {1, 2, 0, 0, 9, 0, 0, 5, 4},
                            {0, 0, 0, 0, 0, 0, 0, 0, 0},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues9);

                    break;


                case 10:
                    int[][] gameSolutionValues10 = {
                            {8, 4, 2, 7, 5, 6, 9, 3, 1},
                            {7, 3, 9, 4, 1, 8, 2, 5, 6},
                            {5, 1, 6, 9, 2, 3, 7, 4, 8},
                            {4, 5, 1, 2, 6, 7, 3, 8, 9},
                            {6, 2, 3, 5, 8, 9, 1, 7, 4},
                            {9, 8, 7, 3, 4, 1, 6, 2, 5},
                            {2, 9, 4, 6, 3, 5, 8, 1, 7},
                            {1, 6, 5, 8, 7, 2, 4, 9, 3},
                            {3, 7, 8, 1, 9, 4, 5, 6, 2},
                    };
                    solution_board.setGanzesBrett(gameSolutionValues10);

                    int[][] gamePuzzleValues10 = {
                            {8, 0, 0, 7, 0, 6, 0, 0, 1},
                            {0, 3, 9, 0, 1, 0, 2, 5, 0},
                            {0, 0, 6, 0, 0, 0, 7, 0, 0},
                            {4, 5, 0, 2, 0, 7, 0, 8, 9},
                            {0, 0, 3, 0, 0, 0, 1, 0, 0},
                            {9, 8, 0, 3, 0, 1, 0, 2, 5},
                            {0, 0, 4, 0, 0, 0, 8, 0, 0},
                            {0, 6, 5, 0, 7, 0, 4, 9, 0},
                            {3, 0, 0, 1, 0, 4, 0, 0, 2},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValues10);

                    break;

                default:
                    System.out.println("(Default case game:)");

                    int[][] gameSolutionValuesX = {
                            {2, 8, 9, 6, 4, 3, 5, 1, 7},
                            {5, 7, 4, 9, 2, 1, 8, 6, 3},
                            {1, 3, 6, 7, 8, 5, 2, 9, 4},
                            {8, 6, 1, 5, 3, 9, 4, 7, 2},
                            {4, 5, 2, 8, 1, 7, 6, 3, 9},
                            {3, 9, 7, 2, 6, 4, 1, 8, 5},
                            {6, 4, 8, 3, 9, 2, 7, 5, 1},
                            {9, 2, 5, 1, 7, 8, 3, 4, 6},
                            {7, 1, 3, 4, 5, 6, 9, 2, 8},
                    };
                    solution_board.setGanzesBrett(gameSolutionValuesX);

                    int[][] gamePuzzleValuesX = {
                            {2, 8, 0, 0, 0, 0, 0, 1, 7},
                            {0, 0, 0, 9, 0, 1, 0, 0, 0},
                            {0, 0, 6, 0, 8, 0, 0, 0, 4},
                            {0, 6, 0, 5, 0, 0, 0, 7, 0},
                            {0, 0, 0, 0, 1, 0, 0, 0, 9},
                            {0, 0, 7, 0, 0, 0, 0, 8, 0},
                            {0, 0, 0, 3, 0, 0, 0, 5, 0},
                            {0, 0, 5, 0, 0, 0, 3, 0, 0},
                            {0, 1, 0, 4, 0, 0, 9, 0, 8},
                    };
                    puzzle_board.setGanzesBrett(gamePuzzleValuesX);
                    break;
            }
        }else if(levelInitialized.getCurrentlevel() == 2) {
            switch (randomNumber) {

                    //leicht:
                    case 1:
                        //mittel:
                        int[][] gameSolutionValues11 = {
                                {1, 9, 4, 3, 2, 7, 8, 6, 5},
                                {7, 2, 5, 8, 1, 6, 4, 3, 9},
                                {6, 3, 8, 4, 9, 5, 2, 1, 7},
                                {4, 5, 6, 9, 7, 1, 3, 2, 8},
                                {8, 1, 9, 5, 3, 2, 6, 7, 4},
                                {3, 7, 2, 6, 4, 8, 5, 9, 1},
                                {9, 6, 1, 2, 8, 4, 7, 5, 3},
                                {2, 4, 3, 7, 5, 9, 1, 8, 6},
                                {5, 8, 7, 1, 6, 3, 9, 4, 2},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues11);

                        int[][] gamePuzzleValues11 = {
                                {0, 9, 0, 0, 0, 0, 0, 6, 0},
                                {0, 0, 5, 8, 1, 6, 4, 0, 0},
                                {6, 0, 8, 4, 0, 5, 2, 0, 7},
                                {4, 5, 0, 0, 0, 0, 0, 2, 8},
                                {0, 0, 9, 0, 0, 0, 6, 0, 0},
                                {3, 7, 0, 0, 0, 0, 0, 9, 1},
                                {9, 0, 1, 2, 0, 4, 7, 0, 3},
                                {0, 0, 3, 7, 5, 9, 1, 0, 0},
                                {0, 8, 0, 0, 0, 0, 0, 4, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues11);

                        break;


                    case 2:
                        int[][] gameSolutionValues12 = {
                                {1, 4, 9, 3, 5, 7, 8, 6, 2},
                                {3, 2, 7, 1, 6, 8, 5, 9, 4},
                                {8, 5, 6, 4, 2, 9, 1, 7, 3},
                                {5, 1, 8, 6, 3, 2, 7, 4, 9},
                                {9, 7, 2, 8, 4, 1, 3, 5, 6},
                                {4, 6, 3, 7, 9, 5, 2, 1, 8},
                                {7, 9, 1, 2, 8, 6, 4, 3, 5},
                                {2, 3, 5, 9, 1, 4, 6, 8, 7},
                                {6, 8, 4, 5, 7, 3, 9, 2, 1},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues12);

                        int[][] gamePuzzleValues12 = {
                                {0, 4, 0, 0, 5, 0, 0, 6, 0},
                                {0, 2, 0, 1, 0, 8, 0, 9, 0},
                                {8, 0, 0, 0, 2, 0, 0, 0, 3},
                                {0, 0, 8, 6, 3, 2, 7, 0, 0},
                                {0, 0, 2, 0, 0, 0, 3, 0, 0},
                                {0, 0, 3, 7, 9, 5, 2, 0, 0},
                                {7, 0, 0, 0, 8, 0, 0, 0, 5},
                                {0, 3, 0, 9, 0, 4, 0, 8, 0},
                                {0, 8, 0, 0, 7, 0, 0, 2, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues12);

                        break;


                    case 3:
                        int[][] gameSolutionValues13 = {
                                {8, 9, 7, 1, 4, 3, 2, 6, 5},
                                {4, 3, 1, 6, 2, 5, 9, 7, 8},
                                {5, 6, 2, 9, 7, 8, 1, 3, 4},
                                {7, 1, 4, 8, 6, 9, 5, 2, 3},
                                {6, 5, 3, 2, 1, 7, 4, 8, 9},
                                {2, 8, 9, 5, 3, 4, 7, 1, 6},
                                {3, 4, 8, 7, 5, 1, 6, 9, 2},
                                {1, 2, 5, 3, 9, 6, 8, 4, 7},
                                {9, 7, 6, 4, 8, 2, 3, 5, 1},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues13);

                        int[][] gamePuzzleValues13 = {
                                {0, 0, 7, 1, 0, 3, 2, 0, 0},
                                {4, 0, 0, 0, 0, 0, 0, 0, 8},
                                {5, 0, 2, 0, 0, 0, 1, 0, 4},
                                {7, 0, 0, 8, 0, 9, 0, 0, 3},
                                {6, 5, 0, 0, 0, 0, 0, 8, 9},
                                {2, 0, 0, 5, 0, 4, 0, 0, 6},
                                {3, 0, 8, 0, 0, 0, 6, 0, 2},
                                {1, 0, 0, 0, 0, 0, 0, 0, 7},
                                {0, 0, 6, 4, 0, 2, 3, 0, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues13);

                        break;


                    case 4:
                        int[][] gameSolutionValues14 = {
                                {3, 5, 6, 8, 7, 1, 9, 4, 2},
                                {1, 8, 2, 5, 9, 4, 3, 6, 7},
                                {9, 7, 4, 2, 3, 6, 5, 8, 1},
                                {8, 3, 5, 9, 1, 2, 6, 7, 4},
                                {4, 1, 9, 7, 6, 8, 2, 5, 3},
                                {2, 6, 7, 4, 5, 3, 8, 1, 9},
                                {6, 9, 8, 1, 2, 7, 4, 3, 5},
                                {5, 4, 1, 3, 8, 9, 7, 2, 6},
                                {7, 2, 3, 6, 4, 5, 1, 9, 8},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues14);

                        int[][] gamePuzzleValues14 = {
                                {0, 0, 0, 8, 0, 1, 0, 0, 0},
                                {1, 8, 0, 0, 0, 0, 0, 6, 7},
                                {9, 0, 0, 2, 3, 6, 0, 0, 1},
                                {8, 0, 5, 0, 0, 0, 6, 0, 4},
                                {0, 1, 0, 0, 0, 0, 0, 5, 0},
                                {2, 0, 7, 0, 0, 0, 8, 0, 9},
                                {6, 0, 0, 1, 2, 7, 0, 0, 5},
                                {5, 4, 0, 0, 0, 0, 0, 2, 6},
                                {0, 0, 0, 6, 0, 5, 0, 0, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues14);

                        break;


                    case 5:
                        int[][] gameSolutionValues15 = {
                                {6, 8, 3, 4, 7, 1, 9, 5, 2},
                                {2, 7, 9, 5, 8, 6, 4, 3, 1},
                                {4, 5, 1, 2, 3, 9, 6, 7, 8},
                                {3, 4, 2, 6, 5, 7, 1, 8, 9},
                                {9, 1, 5, 3, 2, 8, 7, 4, 6},
                                {7, 6, 8, 1, 9, 4, 5, 2, 3},
                                {1, 2, 6, 7, 4, 3, 8, 9, 5},
                                {5, 9, 7, 8, 6, 2, 3, 1, 4},
                                {8, 3, 4, 9, 1, 5, 2, 6, 7},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues15);

                        int[][] gamePuzzleValues15 = {
                                {6, 0, 3, 0, 0, 0, 9, 0, 2},
                                {0, 7, 0, 0, 8, 0, 0, 3, 0},
                                {0, 0, 0, 2, 0, 9, 0, 0, 0},
                                {0, 4, 2, 6, 0, 7, 1, 8, 0},
                                {0, 1, 0, 0, 0, 0, 0, 4, 0},
                                {0, 6, 8, 1, 0, 4, 5, 2, 0},
                                {0, 0, 0, 7, 0, 3, 0, 0, 0},
                                {0, 9, 0, 0, 6, 0, 0, 1, 0},
                                {8, 0, 4, 0, 0, 0, 2, 0, 7},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues15);

                        break;


                    case 6:
                        int[][] gameSolutionValues16 = {
                                {8, 5, 6, 9, 3, 4, 1, 2, 7},
                                {3, 2, 9, 5, 1, 7, 8, 4, 6},
                                {4, 1, 7, 8, 6, 2, 3, 9, 5},
                                {2, 6, 4, 3, 7, 8, 9, 5, 1},
                                {1, 9, 3, 6, 2, 5, 4, 7, 8},
                                {5, 7, 8, 4, 9, 1, 6, 3, 2},
                                {9, 3, 5, 7, 8, 6, 2, 1, 4},
                                {7, 8, 1, 2, 4, 9, 5, 6, 3},
                                {6, 4, 2, 1, 5, 3, 7, 8, 9},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues16);

                        int[][] gamePuzzleValues16 = {
                                {0, 5, 0, 0, 0, 0, 0, 2, 0},
                                {0, 2, 9, 5, 0, 7, 8, 4, 0},
                                {4, 0, 0, 0, 0, 0, 0, 0, 5},
                                {0, 0, 4, 3, 7, 8, 9, 0, 0},
                                {0, 0, 0, 6, 0, 5, 0, 0, 0},
                                {0, 0, 8, 4, 9, 1, 6, 0, 0},
                                {9, 0, 0, 0, 0, 0, 0, 0, 4},
                                {0, 8, 1, 2, 0, 9, 5, 6, 0},
                                {0, 4, 0, 0, 0, 0, 0, 8, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues16);

                        break;


                    case 7:
                        int[][] gameSolutionValues17 = {
                                {3, 5, 7, 2, 4, 8, 9, 1, 6},
                                {9, 1, 4, 5, 6, 3, 7, 8, 2},
                                {6, 2, 8, 1, 9, 7, 5, 3, 4},
                                {4, 9, 5, 8, 3, 6, 2, 7, 1},
                                {1, 8, 6, 7, 2, 9, 4, 5, 3},
                                {7, 3, 2, 4, 5, 1, 8, 6, 9},
                                {5, 6, 1, 9, 7, 4, 3, 2, 8},
                                {2, 4, 3, 6, 8, 5, 1, 9, 7},
                                {8, 7, 9, 3, 1, 2, 6, 4, 5},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues17);

                        int[][] gamePuzzleValues17 = {
                                {3, 0, 7, 2, 0, 8, 9, 0, 6},
                                {9, 0, 0, 0, 0, 0, 0, 0, 2},
                                {0, 0, 8, 1, 9, 7, 5, 0, 0},
                                {0, 0, 0, 8, 0, 6, 0, 0, 0},
                                {0, 0, 6, 0, 0, 0, 4, 0, 0},
                                {0, 0, 0, 4, 0, 1, 0, 0, 0},
                                {0, 0, 1, 9, 7, 4, 3, 0, 0},
                                {2, 0, 0, 0, 0, 0, 0, 0, 7},
                                {8, 0, 9, 3, 0, 2, 6, 0, 5},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues17);

                        break;


                    case 8:
                        int[][] gameSolutionValues18 = {
                                {1, 4, 3, 6, 9, 7, 5, 2, 8},
                                {2, 6, 9, 8, 4, 5, 1, 7, 3},
                                {8, 7, 5, 3, 1, 2, 9, 6, 4},
                                {5, 3, 6, 7, 2, 9, 8, 4, 1},
                                {9, 2, 4, 1, 8, 3, 7, 5, 6},
                                {7, 1, 8, 5, 6, 4, 2, 3, 9},
                                {4, 9, 7, 2, 3, 1, 6, 8, 5},
                                {3, 8, 2, 9, 5, 6, 4, 1, 7},
                                {6, 5, 1, 4, 7, 8, 3, 9, 2},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues18);

                        int[][] gamePuzzleValues18 = {
                                {0, 0, 3, 6, 0, 7, 5, 0, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {8, 7, 5, 0, 1, 0, 9, 6, 4},
                                {5, 0, 0, 0, 2, 0, 0, 0, 1},
                                {0, 0, 4, 1, 0, 3, 7, 0, 0},
                                {7, 0, 0, 0, 6, 0, 0, 0, 9},
                                {4, 9, 7, 0, 3, 0, 6, 8, 5},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 0, 1, 4, 0, 8, 3, 0, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues18);

                        break;


                    case 9:
                        int[][] gameSolutionValues19 = {
                                {8, 5, 9, 4, 1, 2, 6, 7, 3},
                                {1, 2, 3, 6, 5, 7, 9, 8, 4},
                                {4, 7, 6, 9, 8, 3, 2, 5, 1},
                                {7, 9, 1, 5, 6, 8, 4, 3, 2},
                                {3, 6, 4, 7, 2, 9, 5, 1, 8},
                                {5, 8, 2, 3, 4, 1, 7, 6, 9},
                                {9, 3, 5, 1, 7, 4, 8, 2, 6},
                                {2, 4, 7, 8, 3, 6, 1, 9, 5},
                                {6, 1, 8, 2, 9, 5, 3, 4, 7},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues19);

                        int[][] gamePuzzleValues19 = {
                                {0, 5, 0, 0, 0, 0, 0, 7, 0},
                                {0, 0, 0, 6, 5, 7, 0, 0, 0},
                                {4, 0, 0, 9, 0, 3, 0, 0, 1},
                                {7, 9, 1, 0, 0, 0, 4, 3, 2},
                                {0, 0, 4, 0, 0, 0, 5, 0, 0},
                                {5, 8, 2, 0, 0, 0, 7, 6, 9},
                                {9, 0, 0, 1, 0, 4, 0, 0, 6},
                                {0, 0, 0, 8, 3, 6, 0, 0, 0},
                                {0, 1, 0, 0, 0, 0, 0, 4, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues19);

                        break;


                    case 10:
                        int[][] gameSolutionValues20 = {
                                {8, 9, 1, 6, 7, 5, 4, 3, 2},
                                {5, 2, 6, 9, 3, 4, 7, 8, 1},
                                {4, 7, 3, 8, 2, 1, 9, 6, 5},
                                {3, 1, 8, 4, 5, 9, 2, 7, 6},
                                {9, 5, 4, 7, 6, 2, 8, 1, 3},
                                {2, 6, 7, 3, 1, 8, 5, 4, 9},
                                {6, 3, 9, 2, 4, 7, 1, 5, 8},
                                {7, 8, 5, 1, 9, 3, 6, 2, 4},
                                {1, 4, 2, 5, 8, 6, 3, 9, 7},
                        };
                        solution_board.setGanzesBrett(gameSolutionValues20);

                        int[][] gamePuzzleValues20 = {
                                {0, 9, 0, 6, 7, 5, 0, 3, 0},
                                {0, 2, 6, 9, 3, 4, 7, 8, 0},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {3, 0, 0, 0, 5, 0, 0, 0, 6},
                                {0, 0, 0, 7, 0, 2, 0, 0, 0},
                                {2, 0, 0, 0, 1, 0, 0, 0, 9},
                                {0, 0, 0, 0, 0, 0, 0, 0, 0},
                                {0, 8, 5, 1, 9, 3, 6, 2, 0},
                                {0, 4, 0, 5, 8, 6, 0, 9, 0},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValues20);

                        break;
                    default:
                        System.out.println("(Default case game:)");

                        int[][] gameSolutionValuesX = {
                                {2, 8, 9, 6, 4, 3, 5, 1, 7},
                                {5, 7, 4, 9, 2, 1, 8, 6, 3},
                                {1, 3, 6, 7, 8, 5, 2, 9, 4},
                                {8, 6, 1, 5, 3, 9, 4, 7, 2},
                                {4, 5, 2, 8, 1, 7, 6, 3, 9},
                                {3, 9, 7, 2, 6, 4, 1, 8, 5},
                                {6, 4, 8, 3, 9, 2, 7, 5, 1},
                                {9, 2, 5, 1, 7, 8, 3, 4, 6},
                                {7, 1, 3, 4, 5, 6, 9, 2, 8},
                        };
                        solution_board.setGanzesBrett(gameSolutionValuesX);

                        int[][] gamePuzzleValuesX = {
                                {2, 8, 0, 0, 0, 0, 0, 1, 7},
                                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                                {0, 0, 6, 0, 8, 0, 0, 0, 4},
                                {0, 6, 0, 5, 0, 0, 0, 7, 0},
                                {0, 0, 0, 0, 1, 0, 0, 0, 9},
                                {0, 0, 7, 0, 0, 0, 0, 8, 0},
                                {0, 0, 0, 3, 0, 0, 0, 5, 0},
                                {0, 0, 5, 0, 0, 0, 3, 0, 0},
                                {0, 1, 0, 4, 0, 0, 9, 0, 8},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValuesX);
                        break;
                }
            } else {

            /*switch (randomNumber) {

                    //leicht:
                    case 1:
                        //schwer:


                /* (Hier insges. 30 cases einfügen für die Spiele, Name jeweils
                 gameSolutionValues1, gamePuzzleValues1, Zahl je nach case-Nummer anpassen!)


                    default:
                        System.out.println("(Default case game:)");

                        int[][] gameSolutionValuesX = {
                                {2, 8, 9, 6, 4, 3, 5, 1, 7},
                                {5, 7, 4, 9, 2, 1, 8, 6, 3},
                                {1, 3, 6, 7, 8, 5, 2, 9, 4},
                                {8, 6, 1, 5, 3, 9, 4, 7, 2},
                                {4, 5, 2, 8, 1, 7, 6, 3, 9},
                                {3, 9, 7, 2, 6, 4, 1, 8, 5},
                                {6, 4, 8, 3, 9, 2, 7, 5, 1},
                                {9, 2, 5, 1, 7, 8, 3, 4, 6},
                                {7, 1, 3, 4, 5, 6, 9, 2, 8},
                        };
                        solution_board.setGanzesBrett(gameSolutionValuesX);

                        int[][] gamePuzzleValuesX = {
                                {2, 8, 0, 0, 0, 0, 0, 1, 7},
                                {0, 0, 0, 9, 0, 1, 0, 0, 0},
                                {0, 0, 6, 0, 8, 0, 0, 0, 4},
                                {0, 6, 0, 5, 0, 0, 0, 7, 0},
                                {0, 0, 0, 0, 1, 0, 0, 0, 9},
                                {0, 0, 7, 0, 0, 0, 0, 8, 0},
                                {0, 0, 0, 3, 0, 0, 0, 5, 0},
                                {0, 0, 5, 0, 0, 0, 3, 0, 0},
                                {0, 1, 0, 4, 0, 0, 9, 0, 8},
                        };
                        puzzle_board.setGanzesBrett(gamePuzzleValuesX);
                        break;

                }
                */
            }
        }

    public static Board getSolution_board() {
        return solution_board;
    }

    public static Board getPuzzle_board() {
        return puzzle_board;
    }



    /*
    public static List<String> read() {

        List<String> entries = new ArrayList<>();
        try {
            BufferedReader newReader = new BufferedReader(new FileReader("games.txt"));
            String line;
            while ((line = newReader.readLine()) != null) {
                entries.add(line);
            }
            newReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return entries;
    }
     */

}
