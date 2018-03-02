package org.usfirst.frc.team816.vision;

import java.util.ArrayList;

import org.opencv.core.Mat;
import org.opencv.core.MatOfPoint;
import org.opencv.core.Rect;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.UsbCamera;

public class Run {
	UsbCamera cam;
	VisionPipeline pipe;
	CvSink cvSink;
	
	public Run() {
		pipe = new VisionPipeline();
	}
	
	public void init() {
		cam = new UsbCamera(Config.CAM_1_NAME, Config.CAM_1);
		
		
		
		cvSink = new CvSink(Config.CAM_1_NAME);
		cvSink.setSource(cam);
		
		//CvSource imageSource = new CvSource(Config.CAM_1_NAME, VideoMode.PixelFormat.kMJPEG, Config.CAM_1_WIDTH, Config.CAM_1_HEIGHT, 30);
		
		
		
	}
	
	public void start() {
		Mat inputImage = new Mat();
		
		while(cam.isConnected()) {
			long frameTime = cvSink.grabFrame(inputImage);
			if(frameTime == 0) {
				continue;
			}
			
			pipe.process(inputImage);
			ArrayList<MatOfPoint> contours = pipe.convexHullsOutput();
			
			ArrayList<Rect> rects = new ArrayList<Rect>();
			
			/*
			for(MatOfPoint mat : contours) {
				rects.add(Imgproc.boundingRect(mat));
			}*/
			
			//Find matching shapes
			while(contours.size() > 0) {
				MatOfPoint c1 = contours.get(0);
				MatOfPoint c2 = contours.get(0);
				
				for(MatOfPoint contour1 : contours) {
					for(MatOfPoint contour2 : contours) {
					if(contour1 == contour2) continue;
						
					if( Imgproc.matchShapes(contour1, contour2, Imgproc.CV_CONTOURS_MATCH_I1, 0.0) < 0.03);
						c1 = contour1;
						c2 = contour2;
					}
				}
				
				if(c1 == c2) {
					contours.remove(c1);
				}else {
					rects.add(Imgproc.boundingRect(c1));
					rects.add(Imgproc.boundingRect(c2));
					contours.remove(c1);
					contours.remove(c2);
				}
			}
			
			ArrayList<Rect> correct = new ArrayList<Rect>();
			
			//Test if they are long rects
			if(!Config.CAM_1_FLIP) {
				for(Rect rect : rects) {
					if(rect.height/rect.width > 6) {
						correct.add(rect);
					}
				}
			}else{
				for(Rect rect : rects) {
					if(rect.width/rect.height > 6) {
						correct.add(rect);
					}
				}
			}
			
			if(correct.size() > 2) {
				//Pls no I dont wanna
				
			}else {
				//We found ze goods m8
				
			}
			
			
			
		}
		
	}
	
	
	public static void main(String args[]) {
			Run run = new Run();
			run.init();
			run.start();
	}
}
