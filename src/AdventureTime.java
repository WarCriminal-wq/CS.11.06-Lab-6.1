import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.util.Scanner;


public class AdventureTime {

    /** This is the main method and it is where you will test your implementations for challengeOne, challengeTwo, etc.
     *
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {



    }

    /** TODO 1
     *
     * Challenge 1
     *
     * @param fileName
     * @return Answer to Challenge 1
     * @throws IOException
     */
    public static int challengeOne(String fileName) throws IOException {
        int bomboclat = 0;
        int[] diddy = readFile(fileName);
        for(int i = 1; i < diddy.length; i++){
            if(diddy[i] > diddy[i-1]){
                bomboclat = bomboclat + 1;
            }
        }
        return bomboclat;
    }

    /** TODO 2
     *
     * Challenge 2
     *
     * @param fileName
     * @return Answer to Challenge 2
     * @throws FileNotFoundException
     */
    public static int challengeTwo(String fileName) throws FileNotFoundException {
        int[] data = readFile(fileName);
        int increaseCount = 0;

        for (int i = 0; i < data.length - 3; i++) {
            int sum1 = data[i] + data[i + 1] + data[i + 2];
            int sum2 = data[i + 1] + data[i + 2] + data[i + 3];

            if (sum2 > sum1) {
                increaseCount++;
            }
        }

        return increaseCount;
    }

    /** TODO 3
     *
     * Challenge 3
     *
     * @param fileName
     * @return Answer to Challenge 3
     * @throws FileNotFoundException
     */
    public static int challengeThree(String fileName) throws FileNotFoundException {
        int linesInFile = countLinesInFile(fileName);
        String[] hell = new String[linesInFile];
        String[] diddy = new String[1];
        int horizontal = 0;
        int vertical = 0;
        for(int i = 0; i < linesInFile; i++){
            String gay = hell[i];
            if( ArrayUtils.contains(diddy, "forward")){
                horizontal = horizontal + Integer.valueOf(gay.substring(gay.length()-1));
            }else if( ArrayUtils.contains(diddy, "down")){
                vertical = vertical - Integer.valueOf(gay.substring(gay.length()-1));
            } else if( ArrayUtils.contains(diddy, "up")){
                vertical = vertical + Integer.valueOf(gay.substring(gay.length()-1));
            }

        }

        return horizontal * vertical;

    }

    /** TODO 4
     *
     * Challenge 4
     *
     * @param filename
     * @return Answer to Challenge 4
     * @throws FileNotFoundException
     */
    public static int challengeFour(String filename) throws FileNotFoundException {
        List<String> commands = readFile(fileName);
        int horizontalPosition = 0;
        int depth = 0;
        int aim = 0;

        for (String command : commands) {
            String[] parts = command.split(" ");
            String direction = parts[0];
            int value = Integer.parseInt(parts[1]);

            switch (direction) {
                case "forward":
                    horizontalPosition += value;
                    depth += aim * value;
                    break;
                case "down":
                    aim += value;
                    break;
                case "up":
                    aim -= value;
                    break;
            }
        }
    }

    /** This method will write the values passed as challengeOne, challengeTwo, challengeThree, and challengeFour to a text file.
     * Do not edit this method.
     */
    private static void writeFileAllAnswers(String outPutFilename, int challengeOne, int challengeTwo, int challengeThree, int challengeFour) throws IOException {
        File file = new File(outPutFilename);
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
        bufferedWriter.write("Challenge 1: " + "\t" + challengeOne + "\n");
        bufferedWriter.write("Challenge 2: " + "\t" + challengeTwo + "\n");
        bufferedWriter.write("Challenge 3: " + "\t" + challengeThree + "\n");
        bufferedWriter.write("Challenge 4: " + "\t" + challengeFour + "\n");
        bufferedWriter.close();
    }

    /** This method will read the values in inputFilename into an array of integers, which it will return.
     * Do not edit this method.
     */
    private static int[] readFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int numberOfLinesInFile = countLinesInFile(inputFilename);
        int[] data = new int[numberOfLinesInFile];
        int index = 0;
        while (scanner.hasNextLine()) {
            data[index++] = scanner.nextInt();
        }
        scanner.close();
        return data;
    }

    /** This method will count the number of lines in a text file, which it will return.
     * Do not edit this method.
     */
    private static int countLinesInFile(String inputFilename) throws FileNotFoundException {
        File file = new File(inputFilename);
        Scanner scanner = new Scanner(file);
        int lineCount = 0;
        while (scanner.hasNextLine()) {
            lineCount++;
            scanner.nextLine();
        }
        scanner.close();
        return lineCount;
    }

}