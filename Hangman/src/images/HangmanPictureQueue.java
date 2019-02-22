package images;

import java.io.File;

import javafx.scene.image.Image;

public class HangmanPictureQueue extends PictureQueue{
	
	protected String directoryHangman ="imagesHangman";


	public	HangmanPictureQueue() {
		images= setImageArray(directoryHangman);
		directory= directoryHangman;
	}

}