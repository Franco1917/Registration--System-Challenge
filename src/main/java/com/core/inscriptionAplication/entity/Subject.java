package com.core.inscriptionAplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Subject implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */

	@Column
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO )
	private long id;
	
	@Column
	@NotBlank
	private String name;
	@Column
	@NotBlank
	private String schedule;
	@Column
	@NotBlank
	private String teacher;
	
	@Column
	@NotNull (message="numero invalido")
	private int quota;
	
	// como buena practica se recomienda generar el hashcode y el equlas
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + quota;
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((teacher == null) ? 0 : teacher.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Subject other = (Subject) obj;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (quota != other.quota)
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (teacher == null) {
			if (other.teacher != null)
				return false;
		} else if (!teacher.equals(other.teacher))
			return false;
		return true;
	}
//como buena practica se recomienda generar toString()
	@Override
	public String toString() {
		return "Materia [id=" + id + ", name=" + name + ", schedule=" + schedule + ", teacher=" + teacher + ", quota="
				+ quota + "]";
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getTeacher() {
		return teacher;
	}

	public void setTeacher(String teacher) {
		this.teacher = teacher;
	}

	public int getQuota() {
		return quota;
	}

	public void setQuota(int quota) {
		this.quota = quota;
	}

	public Subject(long id, String name, String schedule, String teacher, int quota) {
		
		this.id = id;
		this.name = name;
		this.schedule = schedule;
		this.teacher = teacher;
		this.quota = quota;
	}

	public Subject() {
		
	}
	
}
