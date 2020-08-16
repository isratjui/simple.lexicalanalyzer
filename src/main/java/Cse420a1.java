

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author jui
 */
public class Cse420a1 {

    //language definition
    public static String[] key = {"if", "else", "while", "int", "float", "double", "for"};
    public static String[] mathOp = {"+", "*", "=", "/", "-"};
    public static String[] logicalOp = {"<", ">", "=="};
    public static String[] others = {"{", "}", "(", ")", ";", ","};

    //array size is dynamic
    //we will use resize function to increase capacity.
    public static String[] keyOut = new String[1];
    public static String[] logicOut = new String[1];
    public static String[] numOut = new String[1];
    public static String[] mathOut = new String[1];
    public static String[] idOut = new String[1];
    public static String[] othOut = new String[1];
    //usefull variables
    public static String token = "";
    public static int keycount = 0, mathcount = 0, logiccount = 0, othercount = 0, numericcount = 0, identifycount = 0;
    public static int c = 0;

    public static void main(String[] args) {

        try {
            //file
            File f = new File("input1.txt");
            //read each line
            Scanner inputLine = new Scanner(f);
            //for each line
            while (inputLine.hasNextLine()) {
                //take a line
                String line = inputLine.nextLine();
                //tokenize
                StringTokenizer strToken = new StringTokenizer(line);
                while (strToken.hasMoreTokens()) {
                    c = 0;
                    //System.out.println(strToken.nextToken());
                    token = strToken.nextToken();
                    //checking against each token
                    //once found in aany of this making false by setting c=1
                    checkKeys(strToken, token);
                    checkMath(strToken, token);
                    checkLogic(strToken, token);
                    checkOther(strToken, token);
                    checkNum(strToken, token);
                    //System.out.println(line);
                    //put into array
                }
            }
        } catch (FileNotFoundException ex) {
            System.out.println("No input file! ");
            //exception handling
        }

        //printing each type
        printKey();
        printMath();
        printNum();
        printLog();
        printOth();
        printId();
    }

    public static void checkKeys(StringTokenizer strToken, String token) {

        if (c == 0) {
            for (int i = 0; i < key.length; i++) {
                if (key[i].equals(token)) {
                    c = 1;
                    int found = 0;
                    for (int j = 0; j < keycount; j++) {
                        if (keyOut[j].equals(token)) {
                            found++;
                        }
                    }
                    if (found == 0) {
                        if (keyOut[keyOut.length - 1] != null) {
                            keyOut = resizeArray(keyOut, keycount + 1);
                        }
                        keyOut[keycount] = token;
                        keycount++;
                        if (token.equals("int") || token.equals("double") || token.equals("float") || token.equals("String")) {
                            while (strToken.hasMoreTokens()) {
                                token = strToken.nextToken();
                                if (token.equals(",")) {
                                    int fo = 0;
                                    for (int j = 0; j < othercount; j++) {
                                        if (othOut[j].equals(token)) {
                                            fo++;
                                        }
                                    }
                                    if (fo == 0) {
                                        if (othOut[othOut.length - 1] != null) {
                                            othOut = resizeArray(othOut, othercount + 1);
                                        }
                                        othOut[othercount] = token;
                                        othercount++;
                                    }
                                }
                                if (token.equals(";")) {
                                    break;
                                }
                                if (!token.equals(",")) {
                                    if (idOut[idOut.length - 1] != null) {
                                        idOut = resizeArray(idOut, identifycount + 1);
                                    }
                                    idOut[identifycount] = token;
                                    identifycount++;

                                }

                            }
                        }
                    }

                }
            }
        }
    }

    public static void checkMath(StringTokenizer strToken, String token) {
        if (c == 0) {
            for (int i = 0; i < mathOp.length; i++) {
                if (mathOp[i].equals(token)) {
                    c = 1;
                    int found = 0;
                    for (int j = 0; j < mathcount; j++) {
                        if (mathOut[j].equals(token)) {
                            found++;
                        }
                    }
                    if (found == 0) {
                        if (mathOut[mathOut.length - 1] != null) {
                            mathOut = resizeArray(mathOut, mathcount + 1);
                        }
                        mathOut[mathcount] = token;
                        mathcount++;
                        //System.out.println(mathcount);
                    }

                }
            }
        }
    }

    public static void checkLogic(StringTokenizer strToken, String token) {
        if (c == 0) {
            for (int i = 0; i < logicalOp.length; i++) {
                if (logicalOp[i].equals(token)) {
                    c = 1;
                    int found = 0;
                    for (int j = 0; j < logiccount; j++) {
                        if (logicOut[j].equals(token)) {
                            found++;
                        }
                    }
                    if (found == 0) {

                        if (logicOut[logicOut.length - 1] != null) {
                            logicOut = resizeArray(logicOut, logiccount + 1);
                        }
                        logicOut[logiccount] = token;
                        logiccount++;
                    }

                }
            }
        }
    }

    public static void checkNum(StringTokenizer strToken, String token) {
        if (c == 0) {
            if (token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                c = 1;
                int found = 0;
                for (int j = 0; j < numericcount; j++) {
                    if (numOut[j].equals(token)) {
                        found++;
                    }
                }
                if (found == 0) {
                    if (numOut[numOut.length - 1] != null) {
                        numOut = resizeArray(numOut, numericcount + 1);
                    }
                    numOut[numericcount] = token;
                    numericcount++;
                }

            }
        }
    }

    public static void checkOther(StringTokenizer strToken, String token) {
        if (c == 0) {
            for (int i = 0; i < others.length; i++) {
                if (others[i].equals(token)) {
                    c = 1;
                    int found = 0;
                    for (int j = 0; j < othercount; j++) {
                        if (othOut[j].equals(token)) {
                            found++;
                        }
                    }
                    if (found == 0) {
                        if (othOut[othOut.length - 1] != null) {
                            othOut = resizeArray(othOut, othercount + 1);
                        }
                        othOut[othercount] = token;
                        othercount++;
                    }

                }
            }
        }
    }

    //resize array method
    public static String[] resizeArray(String[] arr, int newCap) {
        int oldCap = arr.length;
        String[] reArr = new String[newCap];
        System.arraycopy(arr, 0, reArr, 0, oldCap);

        /*
         *   for (int c = 0; c < oldCap; c++) {
         *   reArr[c] = arr[c];
         *   }
         */
        return reArr;
    }

    //print output
    public static void printKey() {
        System.out.print("Keyword : ");
        for (int index = 0; index < keycount; index++) {
            System.out.print(keyOut[index] + " ");
        }
        System.out.print("\n");
    }

    public static void printMath() {
        System.out.print("Math Operators : ");
        for (int index = 0; index < mathcount; index++) {
            System.out.print(mathOut[index] + " ");
        }
        System.out.println();
    }

    public static void printLog() {
        System.out.print("Logical Operators : ");
        for (int index = 0; index < logiccount; index++) {
            System.out.print(logicOut[index] + " ");
        }
        System.out.println();
    }

    public static void printOth() {
        System.out.print("Others : ");
        for (int index = 0; index < othercount; index++) {
            System.out.print(othOut[index] + " ");
        }
        System.out.println();
    }

    public static void printNum() {
        System.out.print("Numeric Value : ");
        for (int index = 0; index < numericcount; index++) {
            System.out.print(numOut[index] + " ");
        }
        System.out.println();
    }

    public static void printId() {
        System.out.print("Identifiers : ");
        for (int index = 0; index < identifycount; index++) {
            System.out.print(idOut[index] + " ");
        }
        System.out.println();
    }
}
