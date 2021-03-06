package ua.co.ur6lad.ipinfo;

/*
 * Copyright 2017 Vitaliy Berdinskikh
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Short IP details bean.
 *
 * See IpInfo's <a href="https://ipinfo.io/developers/specific-fields">Specific fields</a>.
 *
 * @since 1.0.0
 * @author Vitaliy Berdinskikh
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class IpGeo {

	private boolean bogon;
	private String city;
	private String country;
	private String ip;
	private String loc;
	private String postal;
	private String region;

	@JsonCreator
	public IpGeo(@JsonProperty("bogon") boolean bogon, @JsonProperty("city") String city, @JsonProperty("country") String country,
			@JsonProperty("ip") String ip, @JsonProperty("loc") String loc, @JsonProperty("postal") String postal,
			@JsonProperty("region") String region) {
		this.bogon = bogon;
		this.city = city;
		this.country = country;
		this.ip = ip;
		this.loc = loc;
		this.postal = postal;
		this.region = region;
	}

	public boolean isBogon() {
		return bogon;
	}

	public String getCity() {
		return city;
	}

	public String getCountry() {
		return country;
	}

	public String getIp() {
		return ip;
	}

	public String getLoc() {
		return loc;
	}

	public String getPostal() {
		return postal;
	}

	public String getRegion() {
		return region;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		if (obj instanceof IpGeo) {
			IpGeo info = (IpGeo) obj;

			if (null != getIp()) {
				return getIp().equals(info.getIp());
			}
		}

		return false;
	}

	@Override
	public int hashCode() {
		return null == getIp() ? 0 : getIp().hashCode() + 3;
	}

	public String toString() {
		StringBuilder builder = new StringBuilder(this.getClass().getSimpleName());

		builder.append("{ ip: ").append(getIp());
		builder.append(", bogon: ").append(isBogon());
		builder.append(", country: ").append(getCountry());
		builder.append(", region: ").append(getRegion());
		builder.append(", city: ").append(getCity());
		builder.append(", loc: ").append(getLoc());
		builder.append(", postal: ").append(getPostal()).append(" }");

		return builder.toString();
	}

}