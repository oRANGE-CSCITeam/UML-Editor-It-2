package models;

import java.io.Serializable;

public class RLmodel implements Serializable {
	private static final long serialVersionUID = 1L;

	private int originId;
	private int destinationId;
	private int rType;

	public RLmodel(int oId, int dId, int rT) {
		originId = oId;
		destinationId = dId;
		rType = rT;

	}

	public int getoriginId() {

		return originId;
	}

	public int getDestinationId() {

		return destinationId;
	}

	public int getType() {

		return rType;
	}
}
