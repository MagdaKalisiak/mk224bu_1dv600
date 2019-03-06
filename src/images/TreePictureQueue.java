package images;

public class TreePictureQueue extends PictureQueue {
 protected String directoryTree ="imagesHangman";


public	TreePictureQueue() {
	images= setImageArray(directoryTree);
	directory= directoryTree;
}
	
	
}
