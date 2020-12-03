package Model;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/**
 * This class inherits the World class
 * Used to add all the items to one stage
 */

public class MyStage extends World{
	MediaPlayer mediaPlayer;
	@Override
	public void act(long now) {
		
	}

	/**
	 * Initiates the MyStage type to be used later on
	 */
	public MyStage() {
		
//		mediaPlayer.play();
//		mediaPlayer.setOnEndOfMedia(new Runnable() {
//
//			@Override
//			public void run() {
//				mediaPlayer.seek(Duration.ZERO);
//				
//			}
//			
//		});
//		mediaPlayer.play();
	}

	/**
	 * Plays music assigned through the filepath
	 */
	public void playMusic() {
		String musicFile = "src/main/resources/Music/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**
	 * Stops music assigned earlier through the filepath
	 */
	public void stopMusic() {
		mediaPlayer.stop();
	}

}