package com.devsuperior.dslearnbds.entities;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.devsuperior.dslearnbds.entities.pk.EnrollmentPK;

@Entity
@Table(name = "tb_enrollment")
public class Enrollment {

	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();

	@Column(name = "ENROLL_MOMENT", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;

	@Column(name = "REFUND_MOMENT", columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;

	@Column(name = "AVAILABLE")
	private boolean available;

	@Column(name = "ONLY_UPDATE")
	private boolean onlyUpdate;

	@ManyToMany(mappedBy = "enrollmentsDone")
	private Set<Lesson> lessonsDone = new HashSet<Lesson>();

	@OneToMany(mappedBy = "enrollment")
	private List<Deliver> deliveres = new ArrayList<Deliver>();

	public Enrollment() {

	}

	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		this.id.setUser(user);
		this.id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}

	public User getStudent() {
		return this.id.getUser();
	}

	public void setStudent(User user) {
		this.id.setUser(user);
	}

	public Offer getOffer() {
		return this.id.getOffer();
	}

	public void setOffer(Offer offer) {
		this.id.setOffer(offer);
	}

	public Instant getEnrollMoment() {
		return enrollMoment;
	}

	public void setEnrollMoment(Instant enrollMoment) {
		this.enrollMoment = enrollMoment;
	}

	public Instant getRefundMoment() {
		return refundMoment;
	}

	public void setRefundMoment(Instant refundMoment) {
		this.refundMoment = refundMoment;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public boolean isOnlyUpdate() {
		return onlyUpdate;
	}

	public void setOnlyUpdate(boolean onlyUpdate) {
		this.onlyUpdate = onlyUpdate;
	}

	public Set<Lesson> getLessonsDone() {
		return lessonsDone;
	}

	public List<Deliver> getDeliveres() {
		return deliveres;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Enrollment other = (Enrollment) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}	
}