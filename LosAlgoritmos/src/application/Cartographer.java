/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package application;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Provides functionality for loading .map files to the program as a char matrix.
 * @author Elias Nygren
 */
public class Cartographer {
    private File map;
    private Scanner scanner;
    
    /**
     * Constructor. The parameter file is loaded immediately - toCharArray can be called after this.
     * @param file
     * @throws FileNotFoundException 
     */
    
    public Cartographer(File file) throws FileNotFoundException{
        this.map = file;        
        if(!loadFile()){
            throw new FileNotFoundException();
        }        
    }

    /**
     * Loads a new map file.      
     * @param file
     * @return returns true if the file was loaded successfully.
     */
    public boolean loadMap(File file){
        map = file;
        return loadFile();
    }
    
    private boolean loadFile(){
        try {            
            scanner = new Scanner(map);
            return true;
        } catch (FileNotFoundException ex) {
            return false;
        }
    }
    /**
     * Parses the .map file to a char matrix and returns it.
     * @return Returns the provided .map as a charMatrix.
     * @throws Exception "Invalid .map format." if the provided .map is not of the correct format.
     */
    
    public char[][] toCharMatrix() throws Exception{
        char[][] charMatrix = createMatrix();
        int i = 0;
        while(i<charMatrix.length){
            charMatrix[i] = scanner.nextLine().toCharArray();
            i++;
        }
        return charMatrix;        
    }
    
    private char[][] createMatrix() throws Exception{
        String heightline;
        String widthline;
        try{
            scanner.nextLine(); //skip typeline
            heightline = scanner.nextLine();
            widthline = scanner.nextLine();            
            char[][] charMatrix = 
                new char[Integer.parseInt(heightline.substring(7))]
                        [Integer.parseInt(widthline.substring(6))];
            scanner.nextLine(); //skip mapline                        
            return charMatrix;
        } catch (Exception e){
            throw new Exception("Invalid .map format.");            
        }        
    }
}
