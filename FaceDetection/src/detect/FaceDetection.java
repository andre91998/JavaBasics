/* Author: Andre Barros de Medeiros
 * Date: 10/08/19
 * Description: Function for identifying faces in images, and saving processed image
 * Copyright: Free to use, copy, and modify
 * */
package detect;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.MatOfRect;
import org.opencv.core.Point;
import org.opencv.core.Rect;
import org.opencv.core.Scalar;
	
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
  
public class FaceDetection {
   public static void main (String[] args) {
      // Loading the OpenCV core library
      System.loadLibrary( Core.NATIVE_LIBRARY_NAME );

      // Reading the Image from the file and storing it in to a Matrix object
      String file ="C:/Users/Andre/Pictures/phone/facedetection_input.jpg";
      Mat src = Imgcodecs.imread(file);

      // Instantiating the CascadeClassifier
      String xmlFile = "C:/Users/Andre/Downloads/opencv/build/etc/lbpcascades/lbpcascade_frontalface.xml";
      CascadeClassifier classifier = new CascadeClassifier(xmlFile);

      // Detecting the face in the snap
      MatOfRect faceDetections = new MatOfRect();
      classifier.detectMultiScale(src, faceDetections);
      System.out.println(String.format("Detected %s faces", 
         faceDetections.toArray().length));

      // Drawing boxes
      for (Rect rect : faceDetections.toArray()) {
         Imgproc.rectangle(
            src,                                               // where to draw the box
            new Point(rect.x, rect.y),                            // bottom left
            new Point(rect.x + rect.width, rect.y + rect.height), // top right
            new Scalar(0, 0, 255),
            3                                                     // RGB colour
         );
      }

      // Writing the image
      Imgcodecs.imwrite("C:/Users/Andre/Pictures/phone/facedetection_output.jpg", src);

      System.out.println("Image Processed");
   }
}
