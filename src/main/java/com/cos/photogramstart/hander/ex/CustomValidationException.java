package com.cos.photogramstart.hander.ex;

import java.util.Map;

public class CustomValidationException extends RuntimeException {

        // 객체를 구분할 때 사용하는 값
        private static final long serialVersionUID = 1L;

        private Map<String, String> errorMap;

        public CustomValidationException(String massege, Map<String, String> errorMap) {
            super(massege);
            this.errorMap = errorMap;
        }

        public Map<String, String> getErrorMap() {
            return errorMap;
        }
}
