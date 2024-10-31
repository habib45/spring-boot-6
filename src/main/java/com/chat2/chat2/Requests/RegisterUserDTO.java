package com.chat2.chat2.Requests;


import com.chat2.chat2.Models.User;
// import java.util.Date;
// import jakarta.validation.Valid;
// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
// import jakarta.validation.constraints.NotNull;
// import jakarta.validation.constraints.Past;
// import jakarta.validation.constraints.Pattern.Flag;
import jakarta.validation.constraints.Size;
// import jakarta.validation.constraints.*;


@SuppressWarnings("unused")
public class RegisterUserDTO {

      @NotEmpty(message = "The name is required.")
      @Size(min = 2, max = 100, message = "The length of full name must be between 2 and 100 characters.")
     
    private String name;

    public RegisterUserDTO(String name) {
        this.name = name;
    }
      

      public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }


}
