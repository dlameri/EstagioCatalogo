package test.unitary.util;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.codehaus.jackson.type.TypeReference;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import com.ideaiseletronics.catalogo.spring.domain.Category;
import com.ideaiseletronics.catalogo.util.JsonUtil;

@RunWith(JUnit4.class)
public class JsonUtilTest {
	
	private String objectInJsonFormat;
	
	@Before
	public void setUp() {
		objectInJsonFormat = "";		
	}
	
	@Test
	public void test_read_json_to_category() {
		objectInJsonFormat = createCategoryObject();
		
		Category category = (Category) JsonUtil.readJsonToObject(objectInJsonFormat, new TypeReference<Category>(){});
		assertEquals(objectInJsonFormat, category.toJson());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void test_read_json_to_category_list() {
		objectInJsonFormat = createCategoriesInJsonFormat();
		
		List<Category> categories = (List<Category>) JsonUtil.readJsonToObject(objectInJsonFormat, new TypeReference<List<Category>>(){});
		String categoriesToJson = "[";
		categoriesToJson = concatCategoriesToString(categories, categoriesToJson);
		categoriesToJson = categoriesToJson.concat("]"); 
		assertEquals(objectInJsonFormat, categoriesToJson);
	}
	
	private String createCategoryObject() {
		return "{" 
				+"\"id\": 2," 
				+"\"name\": \"categoria 2\","
				+ "\"subcategories\": []}";
	}
	
	private String createCategoriesInJsonFormat() {
		return 	"[{" 
				+"\"id\": 1," 
				+"\"name\": \"categoria 1\","
				+ "\"subcategories\": []},"
				+ "{" 
				+"\"id\": 2," 
				+"\"name\": \"categoria 2\","
				+ "\"subcategories\": []}"
				+ "]";
	}

	private String concatCategoriesToString(List<Category> categories, String categoriesToJson) {
		for (int i = 0; i < categories.size(); i++) {
			Category category = categories.get(i);
			categoriesToJson = categoriesToJson.concat(category.toJson());
			if(i < categories.size() - 1){
				categoriesToJson = categoriesToJson.concat(",");
			}
		}
		return categoriesToJson;
	}

}
