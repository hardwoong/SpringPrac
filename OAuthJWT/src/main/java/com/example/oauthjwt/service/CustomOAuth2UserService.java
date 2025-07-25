package com.example.oauthjwt.service;

import com.example.oauthjwt.controller.CustomOAuth2User;
import com.example.oauthjwt.dto.GoogleResponse;
import com.example.oauthjwt.dto.OAuth2Response;
import com.example.oauthjwt.dto.UserDTO;
import com.example.oauthjwt.entity.UserEntity;
import com.example.oauthjwt.repository.UserRepository;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {
  private final UserRepository userRepository;

  public CustomOAuth2UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {

    OAuth2User oAuth2User = super.loadUser(userRequest);

    System.out.println(oAuth2User);

    String registrationId = userRequest.getClientRegistration().getRegistrationId();
    OAuth2Response oAuth2Response = null;
    if (registrationId.equals("google")) {
      oAuth2Response = new GoogleResponse(oAuth2User.getAttributes());
    } else if (registrationId.equals("kakao")) {
      oAuth2Response = new com.example.oauthjwt.dto.KakaoResponse(oAuth2User.getAttributes());
    } else {
      return null;
    }
    String username = oAuth2Response.getProvider() + " " + oAuth2Response.getProviderId();
    UserEntity existData = userRepository.findByUsername(username);

    if (existData == null) {

      UserEntity userEntity = new UserEntity();
      userEntity.setUsername(username);
      userEntity.setEmail(oAuth2Response.getEmail());
      userEntity.setName(oAuth2Response.getName());
      userEntity.setRole("ROLE_USER");

      userRepository.save(userEntity);

      UserDTO userDTO = new UserDTO();
      userDTO.setUsername(username);
      userDTO.setName(oAuth2Response.getName());
      userDTO.setRole("ROLE_USER");

      return new CustomOAuth2User(userDTO);
    } else {

      existData.setEmail(oAuth2Response.getEmail());
      existData.setName(oAuth2Response.getName());

      userRepository.save(existData);

      UserDTO userDTO = new UserDTO();
      userDTO.setUsername(existData.getUsername());
      userDTO.setName(oAuth2Response.getName());
      userDTO.setRole(existData.getRole());

      return new CustomOAuth2User(userDTO);
    }
  }
}