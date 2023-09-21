package controller;

import java.util.LinkedList;

import model.Tag;

public class TagController {
	private LinkedList<Tag> listaTags = new LinkedList<Tag>();
	
	public void cadastrarTag(Tag tag) {
		this.listaTags.add(tag);
	}
	public LinkedList<Tag> getListaTags() {
		return this.listaTags;
	}
	public Tag buscarTag(String tagNome) {
		for(int i=0;i<=this.getListaTags().size()-1;i++ ) {
			if(this.getListaTags().get(i).getNome().contains(tagNome)){
				return this.getListaTags().get(i);
			}
		}
		return this.getListaTags().get(0);
	}
}
