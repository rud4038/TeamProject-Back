package kyungsu.project.projects.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CartPayDto {
	private List<CartResponseDto> variables;
	private String address;
}
