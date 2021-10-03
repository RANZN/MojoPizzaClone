package com.ranzan.mojopizzaclone.Location;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;


public class ResultsDTO implements Serializable {

	@SerializedName("houseNumber")
	private String houseNumber;

	@SerializedName("houseName")
	private String houseName;

	@SerializedName("poi")
	private String poi;

	@SerializedName("poi_dist")
	private String poiDist;

	@SerializedName("street")
	private String street;

	@SerializedName("street_dist")
	private String streetDist;

	@SerializedName("subSubLocality")
	private String subSubLocality;

	@SerializedName("subLocality")
	private String subLocality;

	@SerializedName("locality")
	private String locality;

	@SerializedName("village")
	private String village;

	@SerializedName("district")
	private String district;

	@SerializedName("subDistrict")
	private String subDistrict;

	@SerializedName("city")
	private String city;

	@SerializedName("state")
	private String state;

	@SerializedName("pincode")
	private String pincode;

	@SerializedName("lat")
	private String lat;

	@SerializedName("lng")
	private String lng;

	@SerializedName("area")
	private String area;

	@SerializedName("formatted_address")
	private String formattedAddress;

	public void setHouseNumber(String houseNumber){
		this.houseNumber = houseNumber;
	}

	public String getHouseNumber(){
		return houseNumber;
	}

	public void setHouseName(String houseName){
		this.houseName = houseName;
	}

	public String getHouseName(){
		return houseName;
	}

	public void setPoi(String poi){
		this.poi = poi;
	}

	public String getPoi(){
		return poi;
	}

	public void setPoiDist(String poiDist){
		this.poiDist = poiDist;
	}

	public String getPoiDist(){
		return poiDist;
	}

	public void setStreet(String street){
		this.street = street;
	}

	public String getStreet(){
		return street;
	}

	public void setStreetDist(String streetDist){
		this.streetDist = streetDist;
	}

	public String getStreetDist(){
		return streetDist;
	}

	public void setSubSubLocality(String subSubLocality){
		this.subSubLocality = subSubLocality;
	}

	public String getSubSubLocality(){
		return subSubLocality;
	}

	public void setSubLocality(String subLocality){
		this.subLocality = subLocality;
	}

	public String getSubLocality(){
		return subLocality;
	}

	public void setLocality(String locality){
		this.locality = locality;
	}

	public String getLocality(){
		return locality;
	}

	public void setVillage(String village){
		this.village = village;
	}

	public String getVillage(){
		return village;
	}

	public void setDistrict(String district){
		this.district = district;
	}

	public String getDistrict(){
		return district;
	}

	public void setSubDistrict(String subDistrict){
		this.subDistrict = subDistrict;
	}

	public String getSubDistrict(){
		return subDistrict;
	}

	public void setCity(String city){
		this.city = city;
	}

	public String getCity(){
		return city;
	}

	public void setState(String state){
		this.state = state;
	}

	public String getState(){
		return state;
	}

	public void setPincode(String pincode){
		this.pincode = pincode;
	}

	public String getPincode(){
		return pincode;
	}

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setLng(String lng){
		this.lng = lng;
	}

	public String getLng(){
		return lng;
	}

	public void setArea(String area){
		this.area = area;
	}

	public String getArea(){
		return area;
	}

	public void setFormattedAddress(String formattedAddress){
		this.formattedAddress = formattedAddress;
	}

	public String getFormattedAddress(){
		return formattedAddress;
	}

	@Override
 	public String toString(){
		return 
			"ResultsDTO{" + 
			"houseNumber = '" + houseNumber + '\'' + 
			",houseName = '" + houseName + '\'' + 
			",poi = '" + poi + '\'' + 
			",poi_dist = '" + poiDist + '\'' + 
			",street = '" + street + '\'' + 
			",street_dist = '" + streetDist + '\'' + 
			",subSubLocality = '" + subSubLocality + '\'' + 
			",subLocality = '" + subLocality + '\'' + 
			",locality = '" + locality + '\'' + 
			",village = '" + village + '\'' + 
			",district = '" + district + '\'' + 
			",subDistrict = '" + subDistrict + '\'' + 
			",city = '" + city + '\'' + 
			",state = '" + state + '\'' + 
			",pincode = '" + pincode + '\'' + 
			",lat = '" + lat + '\'' + 
			",lng = '" + lng + '\'' + 
			",area = '" + area + '\'' + 
			",formatted_address = '" + formattedAddress + '\'' + 
			"}";
		}
}