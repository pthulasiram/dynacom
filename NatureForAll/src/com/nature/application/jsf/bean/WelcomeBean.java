package com.nature.application.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name="welcomeBean")
@RequestScoped
public class WelcomeBean {
	private String name = "John Doe";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
