package com.devsuperior.dslearnbds.dto;

import com.devsuperior.dslearnbds.entities.Role;

public class RoleDTO {

	private Long id;
	private String authority;

	public RoleDTO() {

	}

	public RoleDTO(Role entity) {
		this.id = entity.getId();
		this.authority = entity.getAuthority();
	}

	public RoleDTO(Long id, String authority) {
		this.id = id;
		this.authority = authority;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
}