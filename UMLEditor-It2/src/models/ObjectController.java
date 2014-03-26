package models;

import gui.Manager;

public class ObjectController {
	
	private boolean isDragging, showPopUp;
	private int isDraggingWho, selectedClassObject;
	
	public ObjectController (Manager manager) {
		isDragging = false;
		showPopUp = false;
		isDraggingWho = -1;
		selectedClassObject = -1;
	}

	public boolean isDragging() {
		return isDragging;
	}

	public void setDragging(boolean isDragging) {
		this.isDragging = isDragging;
	}

	public boolean isShowPopUp() {
		return showPopUp;
	}

	public void setShowPopUp(boolean showPopUp) {
		this.showPopUp = showPopUp;
	}

	public int getIsDraggingWho() {
		return isDraggingWho;
	}

	public void setIsDraggingWho(int isDraggingWho) {
		this.isDraggingWho = isDraggingWho;
	}

	public int getSelectedClassObject() {
		return selectedClassObject;
	}

	public void setSelectedClassObject(int selectedClassObject) {
		this.selectedClassObject = selectedClassObject;
	}
	
    public void togglePopUp() {
        if (!showPopUp) {
            showPopUp = true;
        } else {
            showPopUp = false;
        }
    }
}
