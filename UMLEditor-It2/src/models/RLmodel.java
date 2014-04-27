package models;

import java.io.Serializable;

public class RLmodel implements Serializable {
	private static final long serialVersionUID = 1L;

	private static int originId;
	private static int destinationId;
	private static int rType;

	public RLmodel(int oId, int dId, int rT) {
		originId = oId;
		destinationId = dId;
		rType = rT;

	}

	public static int getOriginId() {

		return originId;
	}

	public static int getDestinationId() {

		return destinationId;
	}

	public static int getType() {

		return rType;
	}
}
