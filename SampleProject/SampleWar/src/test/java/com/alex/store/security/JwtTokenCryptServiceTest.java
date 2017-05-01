package com.alex.store.security;

import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Date;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.alex.store.config.Environment;
import com.alex.store.user.UserDao;
import com.alex.store.user.UserTokenDto;
import com.alex.store.vo.UserNameData; 

public class JwtTokenCryptServiceTest {

	@Mock
	private Environment env;
	
	@Mock
	private UserDao userDao;
	
	@Mock
	private UserInfoConverter userInfoConverter;

	@InjectMocks
	private JwtTokenCryptService jwtTokenCryptService;

	@BeforeClass
	public void before() {
		initMocks(this);
	}

	@Test(dataProvider = "tokenDataProvider")
	public void testVerifyToken(String token) {
		when(env.getTokenExpirationTime()).thenReturn(new Date().getTime());
		jwtTokenCryptService.verifyAndGetUserDetails(token);		
	}
	
	

	@Test(expectedExceptions = {InvalidJwtAuthenticationToken.class})
	public void testTokenExpirationDate() {

	}

	@DataProvider(name="tokenDataProvider")
	private Object[][] data() {
		UserTokenDto userTokenDto = new UserTokenDto();
		userTokenDto.setLogin("alex");
		userTokenDto.setUserId(25);
		UserNameData userNameData = new UserNameData();
		userNameData.setFirstName("first");
		userNameData.setLastName("last");
		userNameData.setSecondName("second");
		userTokenDto.setUserNameData(userNameData);
		String oldtoken = jwtTokenCryptService.constructToken(userTokenDto);
		return new Object[][] 
			{{null}, 
			 {oldtoken}};
	}
}
