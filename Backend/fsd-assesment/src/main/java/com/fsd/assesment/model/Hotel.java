package com.fsd.assesment.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "hotel")
public class Hotel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hotel_id")
	private Long hotelid;

	@NotNull(message = "name  cannot not be NULL")
	@Column(name = "name")
	private String name;

	@Column(name = "image_url")
	private String imageUrl;

	@Column(name = "description")
	private String description;

	@NotNull(message = "rating  cannot not be NULL")
//	@Size(min = 1, max = 5)
	@Column(name = "rating")
	private Integer rating;

	@NotNull(message = "city  cannot not be NULL")
	@Column(name = "city")
	private String city;

	@Email(message = "email cannot be null or empty")
	@Column(name = "email")
	private String email;

	@NotNull(message = "wifi  cannot not be NULL")
	@Column(name = "wifi")
	private String wifi;

	@NotNull(message = "gym  cannot not be NULL")
	@Column(name = "gym")
	private String gym;

	@NotNull(message = "pool  cannot not be NULL")
	@Column(name = "pool")
	private String pool;

	@Column(name = "is_active")
//	@Size(min = 0, max = 1)
	private Integer isactive;

	public Long getHotelid() {
		return hotelid;
	}

	public void setHotelid(Long hotelid) {
		this.hotelid = hotelid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getWifi() {
		return wifi;
	}

	public void setWifi(String wifi) {
		this.wifi = wifi;
	}

	public String getGym() {
		return gym;
	}

	public void setGym(String gym) {
		this.gym = gym;
	}

	public String getPool() {
		return pool;
	}

	public void setPool(String pool) {
		this.pool = pool;
	}

	public Integer getIsactive() {
		return isactive;
	}

	public void setIsactive(Integer isactive) {
		this.isactive = isactive;
	}

	public Hotel(@NotNull(message = "name  cannot not be NULL") String name, String imageUrl, String description,
			@NotNull(message = "rating  cannot not be NULL") @Size(min = 1, max = 5) Integer rating,
			@NotNull(message = "city  cannot not be NULL") String city,
			@Email(message = "email cannot be null or empty") String email,
			@NotNull(message = "wifi  cannot not be NULL") String wifi,
			@NotNull(message = "gym  cannot not be NULL") String gym,
			@NotNull(message = "pool  cannot not be NULL") String pool, @Size(min = 0, max = 1) Integer isactive) {
		super();
		this.name = name;
		this.imageUrl = imageUrl;
		this.description = description;
		this.rating = rating;
		this.city = city;
		this.email = email;
		this.wifi = wifi;
		this.gym = gym;
		this.pool = pool;
		this.isactive = isactive;
	}

	public Hotel() {
		super();
	}

	@Override
	public String toString() {
		return "Hotel [hotelid=" + hotelid + ", name=" + name + ", imageUrl=" + imageUrl + ", description="
				+ description + ", rating=" + rating + ", city=" + city + ", email=" + email + ", wifi=" + wifi
				+ ", gym=" + gym + ", pool=" + pool + ", isactive=" + isactive + "]";
	}

}
