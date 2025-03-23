package configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan( // @ComponentScan 애너테이션을 사용하여 스프링에 스테레오타입으로 애너테이션된 클래스를 검색할 패키지를 알려준다.
    // 여기에서 model 패키지는 스테레오타입 애너테이션이 달린 클래스를 포함하지 않기 때문에 추가되지 않았다는 것을 볼 수 있다.
  basePackages = {"proxies", "services", "repositories"}
)
public class ProjectConfiguration {
}
