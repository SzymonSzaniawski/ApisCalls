package pl.sda.szymon.apisCalls.tab;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString//(of = {"currency", "code","mid"})
@NoArgsConstructor

public class Rates {

    private String currency;
    private String code;
    private Double mid;

}
