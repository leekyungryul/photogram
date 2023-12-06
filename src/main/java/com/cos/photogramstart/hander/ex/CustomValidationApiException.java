package com.cos.photogramstart.hander.ex;

import java.util.Map;

public class CustomValidationApiException extends RuntimeException {

        // 객체를 구분할 때 사용하는 값
        private static final long serialVersionUID = 1L;

        private Map<String, String> errorMap;

        public CustomValidationApiException(String massege) {
            super(massege);
        }

        public CustomValidationApiException(String massege, Map<String, String> errorMap) {
            super(massege);
            this.errorMap = errorMap;
        }

        public Map<String, String> getErrorMap() {
            return errorMap;
        }
}
