package com.example.oauthjwt.dto;

import java.util.Map;

public class KakaoResponse implements OAuth2Response {
  private final Map<String, Object> attribute;

  public KakaoResponse(Map<String, Object> attribute) {
    this.attribute = attribute;
  }

  @Override
  public String getProvider() {
    return "kakao";
  }

  @Override
  public String getProviderId() {
    // 카카오의 id는 최상위에 있음
    return attribute.get("id").toString();
  }

  @Override
  public String getEmail() {
    // email은 kakao_account에 있음
    Map<String, Object> kakaoAccount = (Map<String, Object>) attribute.get("kakao_account");
    if (kakaoAccount != null && kakaoAccount.get("email") != null) {
      return kakaoAccount.get("email").toString();
    }
    return null;
  }

  @Override
  public String getName() {
    // 닉네임은 kakao_account.profile.nickname에 있음
    Map<String, Object> kakaoAccount = (Map<String, Object>) attribute.get("kakao_account");
    if (kakaoAccount != null) {
      Map<String, Object> profile = (Map<String, Object>) kakaoAccount.get("profile");
      if (profile != null && profile.get("nickname") != null) {
        return profile.get("nickname").toString();
      }
    }
    return null;
  }
}