package min.md.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 파라미터가 없는 생성자
@AllArgsConstructor // 모든 파라미터를 만드는 생성자 
@Data 
public class Human {
	
	private String name;
	private int age;
	
	
	
}
