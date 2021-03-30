package com.devsuperior.dslearnbds.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "tb_content")
public class Content extends Lesson {

	private static final long serialVersionUID = 1L;

	@Column(name = "TEXT_CONTENT", length = 100)
	private String textContent;

	@Column(name = "VIDEO_URI", length = 200)
	private String videoUri;

	public Content() {

	}

	public Content(Long id, String title, Integer position, Section section, String textContent, String videoUri) {
		super(id, title, position, section);
		this.textContent = textContent;
		this.videoUri = videoUri;
	}

	public String getTextContent() {
		return textContent;
	}

	public void setTextContent(String textContent) {
		this.textContent = textContent;
	}

	public String getVideoUri() {
		return videoUri;
	}

	public void setVideoUri(String videoUri) {
		this.videoUri = videoUri;
	}
}
