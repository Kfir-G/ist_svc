package com.ist.svc.common.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @Author: sunhaitao
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SvcException extends RuntimeException{
    private String code;
    private String msg;
}
