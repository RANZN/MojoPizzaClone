package com.ranzan.mojopizzaclone.Location;

import java.util.List;
import java.io.Serializable;

public class ResponseDTO implements Serializable {

	private int responseCode;

	private String version;

	private List<ResultsDTO> results;

	public void setResponseCode(int responseCode){
		this.responseCode = responseCode;
	}

	public int getResponseCode(){
		return responseCode;
	}

	public void setVersion(String version){
		this.version = version;
	}

	public String getVersion(){
		return version;
	}

	public void setResults(List<ResultsDTO> results){
		this.results = results;
	}

	public List<ResultsDTO> getResults(){
		return results;
	}

	@Override
 	public String toString(){
		return 
			"ResponseDTO{" + 
			"responseCode = '" + responseCode + '\'' + 
			",version = '" + version + '\'' + 
			",results = '" + results + '\'' + 
			"}";
		}
}