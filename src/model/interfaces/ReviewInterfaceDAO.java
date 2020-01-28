package model.interfaces;

import java.util.ArrayList;

public interface ReviewInterfaceDAO {

	public ArrayList<ReviewInterface> selectReview(int id);
	public boolean saveReview(ReviewInterface review);
}
