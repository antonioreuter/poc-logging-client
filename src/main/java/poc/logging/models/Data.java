package poc.logging.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * Created by 310280812 on 3/17/2017.
 */

@lombok.Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"organization"})
public class Data implements Serializable {

    private Long id;

    @Length(min = 5, max = 100)
    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-_|@:?!.,'+/ \\^]*$")
    private String device;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-_|@:?!.,'+/ \\^]*$")
    private String organization;

    @NotNull
    @Pattern(regexp = "^[a-zA-Z0-9-_|@:?!.,'+/ \\^]*$")
    private String name;
}
