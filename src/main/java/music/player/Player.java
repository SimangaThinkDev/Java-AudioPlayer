package music.player;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class Player {

    public static void main(String[] args) {
        
        String filePath = "/home/innocent/Documents/JAVA/Batch 4/Tuesday 8/04. Russell Zuma & George Lesley - Amanxeba (feat. Sino Msolo, Tumi Musiq & Omit ST).wav";  
        File file = new File(filePath);

        try ( AudioInputStream audioStream = AudioSystem.getAudioInputStream(file);
              Scanner scanner = new Scanner(System.in) ) {
            
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);


            String response = "";

            while ( ! response.equals("Q") ) {

                System.out.print( """
                        P -> Play
                        S -> Stop
                        R -> Reset
                        Q -> Quit
                        >>> """ 
                        );

                response = scanner.next().toUpperCase();

                switch ( response ) {
                    case "P" -> clip.start();
                    case "S" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    // default  -> System.out.println("\nInvalid Command, Try:");
                }
            }

        } catch ( LineUnavailableException e ) {

            System.out.println( "Unable to access audio resource" );

        } catch ( UnsupportedAudioFileException e ) {

            System.out.println( "Audio Not supported" );

        } catch ( FileNotFoundException e ) {

            System.out.println( "File Not Found" );

        } catch ( IOException e ) {
            System.out.println( "Something went wrong!" );
        }

    }

}
