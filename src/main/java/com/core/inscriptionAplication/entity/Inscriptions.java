package com.core.inscriptionAplication.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Inscriptions implements Serializable {


	private static final long serialVersionUID = 1L;

	@Column
	@Id
    @GeneratedValue(strategy= GenerationType.AUTO )
	private long id;
	
	@Column(name="class_name")
	@NotBlank
	private String className;
	@Column(name="class_id")
	@NotNull
	private long classId;
	@NotBlank
	@Column(name="student_name" )
	
	private String studentName;
	@NotNull
	@Column(name="student_dni")
	private int studentDni;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getClassName() {
		return className;
	}
	public void setClassName(String className) {
		this.className = className;
	}
	public long getClassId() {
		return classId;
	}
	public void setClassId(long classId) {
		this.classId = classId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentDni() {
		return studentDni;
	}
	public void setStudentDni(int studentDni) {
		this.studentDni = studentDni;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (classId ^ (classId >>> 32));
		result = prime * result + ((className == null) ? 0 : className.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + studentDni;
		result = prime * result + ((studentName == null) ? 0 : studentName.hashCode());
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
		Inscriptions other = (Inscriptions) obj;
		if (classId != other.classId)
			return false;
		if (className == null) {
			if (other.className != null)
				return false;
		} else if (!className.equals(other.className))
			return false;
		if (id != other.id)
			return false;
		if (studentDni != other.studentDni)
			return false;
		if (studentName == null) {
			if (other.studentName != null)
				return false;
		} else if (!studentName.equals(other.studentName))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Inscriptions [id=" + id + ", className=" + className + ", classId=" + classId + ", studentName="
				+ studentName + ", studentDni=" + studentDni + "]";
	}
	public Inscriptions(long id, String className, long classId, String studentName, int studentDni) {
		
		this.id = id;
		this.className = className;
		this.classId = classId;
		this.studentName = studentName;
		this.studentDni = studentDni;
	}
	
	public Inscriptions() {
		
	}
	
}
