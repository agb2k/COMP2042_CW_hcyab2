package p4_group_8_repo;

import javafx.scene.image.Image;

public class BackgroundImage extends Actor{

	@Override
	public void act(long now) {
		
		
	}
//	Changed the zoom settings
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 700, 857, true, true));
		
	}

}
