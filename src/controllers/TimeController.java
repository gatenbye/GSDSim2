import java.lang.System.*;
import java.util.*;
import java.io.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import com.google.gson.*;
import java.util.concurrent.*;

public class TimeController {
	
	private javax.swing.Timer timer;
	private final MainController mainController;
	private long oldNanos;
	private long newNanos;
	private long difference;
	private double time;
	private int secondsPerDay;
	private double nanosPerDay;
	private double no;
	private long displayTime;
	private String displayedTimeString;
	private long hours;
	private long oldHours;
	private boolean paused;

	public TimeController(final MainController mainController) {

		this.mainController = mainController;
		secondsPerDay = mainController.getStartupController().getSecondsPerDay();
		no = (60 * 60 * 24) / secondsPerDay;
		timer = new javax.swing.Timer(0, new ActionListener () {
			@Override
			public void actionPerformed(ActionEvent e) {
				newNanos = System.nanoTime();
				if (!paused) {
					difference = newNanos - oldNanos;
					displayTime += (long)((difference) * no);
					hours = TimeUnit.HOURS.convert(displayTime, TimeUnit.NANOSECONDS);
					displayedTimeString = String.format("%02d:%02d", hours % 24, TimeUnit.MINUTES.convert(displayTime, TimeUnit.NANOSECONDS) % 60);
					mainController.getMapController().setTime(displayedTimeString);
				}
				if(hours != oldHours) {
					mainController.getProcessController().hourlyUpdate(hours);
					oldHours = hours;
				}
				oldNanos = newNanos;
			}

		});
		timer.start();

	}

	public boolean getPaused() {
		return paused;
	}

	public void setPaused(boolean val) {
		paused = val;
	}
}
