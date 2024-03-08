package worker_dto;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Worker_dto {
private	String wname;
@Id
private int wno;
public String getWname() {
	return wname;
}
public void setWname(String wname) {
	this.wname = wname;
}
public int getWno() {
	return wno;
}
public void setWno(int wno) {
	this.wno = wno;
}
@Override
public String toString() {
	return "Worker_dto [wname=" + wname + ", wno=" + wno + ", getWname()=" + getWname() + ", getWno()=" + getWno()
			+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
}
}
