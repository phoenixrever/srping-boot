package com.phoenixhell.boot.bean;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author phoenixhell
 * @create 2021/1/19 0019-下午 3:53
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CustomPage<T> {

    private String hasNext;
    private String hasPrevious;
    private Page<T> page;
}
