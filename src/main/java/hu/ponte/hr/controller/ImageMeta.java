package hu.ponte.hr.controller;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author zoltan
 */
@Getter
@Setter
@Entity
@Table(name = "imagemeta")
public class ImageMeta
{
	@Id
	private String id;
	private String name;
	private String mimeType;
	private long size;
	@Column(length=500)
	private String digitalSign;
	
	public ImageMeta() {}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMimeType() {
		return mimeType;
	}
	public void setMimeType(String mimeType) {
		this.mimeType = mimeType;
	}
	public long getSize() {
		return size;
	}
	public void setSize(long size) {
		this.size = size;
	}
	public String getDigitalSign() {
		return digitalSign;
	}
	public void setDigitalSign(String digitalSign) {
		this.digitalSign = digitalSign;
	}
	
	
}
