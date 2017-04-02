package com.alex.store.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.alex.store.user.StoreUserDetails;
import com.alex.store.user.UserInfo;
import com.alex.store.user.UserTokenDto;


@Component
public class UserInfoConverter {
	
	public UserDetails getUserDetails(UserInfo info) {
		if (info == null) {
			return null;
		}
		StoreUserDetails details = new StoreUserDetails();
		details.setUsername(info.getLogin());
		return details;
	}
	
	public UserDetails getUserDetails(UserTokenDto userTokenDto) {
		StoreUserDetails details = new StoreUserDetails();
		details.setUsername(userTokenDto.getLogin());
		details.setUserId(userTokenDto.getUserId());
		return details;
	}
	
	public UserTokenDto getUserTokenDto(UserInfo userInfo) {
		if (userInfo == null) {
			return null;
		}
		UserTokenDto dto = new UserTokenDto();
		dto.setUserNameData(userInfo.getUserNameData());
		dto.setLogin(userInfo.getLogin());
		dto.setUserId(userInfo.getId());
		return dto;
	}
	
}
