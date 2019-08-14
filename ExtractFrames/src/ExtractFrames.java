/* Author: Andre Barros de Medeiros
 * Date: 14/08/19
 * Description: Function for extracting frames from video
 * Copyright: Free to use, copy, and modify
 * */

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.videoio.VideoCapture;
import org.opencv.imgproc.Imgproc;



public class ExtractFrames{
	
	//function to extract frames from video file
	private static void extractframes(String pathIN, String pathOUT){
		//new variables
		Mat frame = new Mat();
		Mat grayframe = new Mat();
		int count = 0;
		//capture video from file at pathIN
		VideoCapture cap = new VideoCapture(pathIN); //For camera, use 0
		//loop to read all frames
		while (cap.isOpened()) {
			cap.read(frame);
			//read a frame every 10 frames
			if(!frame.empty() & (count%10)==0) {
				System.out.println("Read " +count+ "  frame"); //verification of read print
				//Imgproc.cvtColor(frame, grayframe, Imgproc.COLOR_RGB2GRAY); //convert frame to gray scale
				//System.out.println("Frame "+count+" converted"); //verification of gray conversion
				Imgcodecs.imwrite(pathOUT+"frame"+count+".jpg", grayframe); //write frame to pathOUT
				count+=1;
			}
			else if((count%10)!=0){
				count+=1;
			}
			else {
				break; //break out of loop when video over
			}
			
		}
		cap.release(); //end video capture
		
	}
	
	//Main function
	public static void main(String[] args){
		
		System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
		
		extractframes("C:/Users/Andre/Videos/FIFA/Video.mp4","C:/Users/Andre/Desktop/Jtstframes/");
	}
}