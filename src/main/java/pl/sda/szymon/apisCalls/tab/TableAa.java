package pl.sda.szymon.apisCalls.tab;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString

public class TableAa {

        private String table;
        private String no;
        private String effectiveDate;
        private List<Rates> rates;


}
