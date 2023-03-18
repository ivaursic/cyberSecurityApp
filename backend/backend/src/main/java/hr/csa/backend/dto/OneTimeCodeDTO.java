package hr.csa.backend.dto;

public class OneTimeCodeDTO {

    String code;

    public String getCode() {
        return code;
    }

    public OneTimeCodeDTO(String code) {
        super();
        this.code = code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
