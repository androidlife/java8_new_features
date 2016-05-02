package java8.interfaces;

import com.sun.javafx.geom.transform.GeneralTransform3D;

public interface PersonInterface {
	String getName();

	int getAge();

	default String combineNameNAge() {
		return getName() + " (" + String.valueOf(getAge()) + " )";
	}

	static String addAgeNName(int add) {
		add += 40;
		return String.valueOf(add);
	}
}
