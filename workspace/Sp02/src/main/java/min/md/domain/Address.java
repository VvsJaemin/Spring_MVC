package min.md.domain;

import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	
	private long seq;
	private String name;
	private String addr;
	private Date rdate;
	
//	private List<AddressAttachVO> attachList;

}
