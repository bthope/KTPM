package vn.edu.iuh.fit.jdepend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class AccountLoginDTO {
    private String phoneNumber;
    private String password;
}
