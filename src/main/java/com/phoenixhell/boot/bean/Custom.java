package com.phoenixhell.boot.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/15 0015-上午 9:22
 */
@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Custom {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}
