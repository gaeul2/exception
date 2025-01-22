package hello.exception.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class ApiExceptionController {

    @Data
    @AllArgsConstructor
    static class MemberDto{
        private String memberId;
        private String name;
    }


    @GetMapping("/api/members/{id}")
    public MemberDto getMember(@PathVariable("id") String id) {
        if (id.equals("ex")) {
            throw new RuntimeException("잘못된 사용자");
        }

        if (id.equals("bad")){
            throw new IllegalArgumentException("잘못된 입력값");
        }
        return new MemberDto(id, "hello " + id);
    }
}
