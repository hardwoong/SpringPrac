package hello.core.member.discount;

import hello.core.member.Member;

public interface DiscountPolicy {
  int discount(Member member, int price);
}
