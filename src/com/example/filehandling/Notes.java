package com.example.filehandling;

import java.io.Serializable;

public class Notes implements Serializable
{
	String nameTitle;
	Boolean Selected;
	
	public Notes(){}
	@Override
	public String toString() {
		return "Notes [nameTitle=" + nameTitle + ", Selected=" + Selected + "]";
	}
	public String getNameTitle() {
		return nameTitle;
	}
	public void setNameTitle(String nameTitle) {
		this.nameTitle = nameTitle;
	}
	public Boolean getSelected() {
		return Selected;
	}
	public void setSelected(Boolean selected) {
		Selected = selected;
	}
	public Notes(String nameTitle, Boolean selected) {
		super();
		this.nameTitle = nameTitle;
		Selected = selected;
	}
}
