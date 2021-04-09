package min.md.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	
	private long seq;
	private String subject;
	private String content;
	private String writer;
	private String email;
	private Date rdate;

}
