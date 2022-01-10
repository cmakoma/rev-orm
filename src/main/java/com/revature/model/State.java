package com.revature.model;

import java.io.Serializable;
import java.util.Objects;

import com.revature.annotation.Column;
import com.revature.annotation.Getter;
import com.revature.annotation.PrimaryKey;
import com.revature.annotation.SerialKey;
import com.revature.annotation.Setter;
import com.revature.annotation.Table;

@Table(tableName="states")
public class State implements Serializable {
	
	@PrimaryKey(columnName="state_id")
	public int id;
	
	@Column(columnName = "status")
	public String status;
	
	@SerialKey(columnName="state_serial_key")
	public int serialKey;

	public State() {
		super();
	}

	public State(String status, int serialKey) {
		super();
		this.status = status;
		this.serialKey = serialKey;
	}

	public State(int id, String status, int serialKey) {
		super();
		this.id = id;
		this.status = status;
		this.serialKey = serialKey;
	}

	@Getter(columnName="get_id")
	public int getId() {
		return id;
	}

	@Setter(columnName="set_id")
	public void setId(int id) {
		this.id = id;
	}
	
	@Getter(columnName="get_status")
	public String getStatus() {
		return status;
	}

	@Setter(columnName="set_status")
	public void setStatus(String status) {
		this.status = status;
	}

	@Getter(columnName="get_serial_key")
	public int getSerialKey() {
		return serialKey;
	}

	@Setter(columnName="set_serial_key")
	public void setSerialKey(int serialKey) {
		this.serialKey = serialKey;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, serialKey, status);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		State other = (State) obj;
		return id == other.id && serialKey == other.serialKey && Objects.equals(status, other.status);
	}

	@Override
	public String toString() {
		return "State [id=" + id + ", status=" + status + ", serialKey=" + serialKey + "]";
	}
	

	
}
