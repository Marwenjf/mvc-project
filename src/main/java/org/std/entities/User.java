package org.std.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User implements Serializable {
	
	@Id
	@Column(name="login")
	private String login;
	
	private String pass;
	
	private boolean actived;
	
	@ManyToMany
	@JoinTable(name="USERS_ROLES")
	private Collection<Role> roles;

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String password) {
		this.pass = password;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public Collection<Role> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Role> roles) {
		this.roles = roles;
	}

	public User() {

	}

	public User(String login, String password) {
		super();
		this.login = login;
		this.pass = password;
	}

	public User(String login, String password, boolean actived) {
		super();
		this.login = login;
		this.pass = password;
		this.actived = actived;
	}

}
