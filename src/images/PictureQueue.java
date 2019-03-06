package images;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javafx.scene.image.Image;

public abstract class PictureQueue {

	protected ArrayList<Image> images ;
	protected String directory;



	public ArrayList<Image> setImageArray(String dir){
		ArrayList<Image> imagesArr = new ArrayList <Image>();
		File f = new File(dir);

		for(File a : f.listFiles()){
			String name=a.getName();
			Image im = new Image(getClass().getResourceAsStream("/"+name));
			imagesArr.add(im);
		}
		return imagesArr;
	}
	private boolean checkIsEmpty(){
		if (images.size()==0)
			return true;
		else 
			return false;

	}

	public Image takeOnePictureDequeue() {
		if (! checkIsEmpty()) {
			Image first = images.get(0);     
			images.remove(0);
			return first;
		}
		else
			throw new ArrayIndexOutOfBoundsException();		
	}
}


