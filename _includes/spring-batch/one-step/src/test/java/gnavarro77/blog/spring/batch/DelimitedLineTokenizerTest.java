package gnavarro77.blog.spring.batch;

import java.util.Properties;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.batch.item.file.transform.FieldSet;

public class DelimitedLineTokenizerTest {

	private DelimitedLineTokenizer tokenizer;

	private String line;

	@Before
	public void setup() {
		this.tokenizer = new DelimitedLineTokenizer();
		this.line = "Tony Parker,2013-14,68,29.4,6.7,13.4,49.9%,0.4,1.0,37.3%,2.9,3.6,81.1%,0.3,2.0,2.3,5.7,2.2,0.5,0.1,1.3,2,0,16.7";
	}

	@Test
	public void getValueByIndexTest() {
		String[] values = tokenizer.tokenize(line).getValues();
		Assert.assertThat(values[0], CoreMatchers.is("Tony Parker"));
		Assert.assertThat(values[1], CoreMatchers.is("2013-14"));
	}

	@Test
	public void getValueByNameTest() {
		String[] names = { "player", "season", "gp", "min", "fgm", "fga",
				"fg%", "3fgm", "3fga", "3fg%", "ftm", "fta", "ft%", "oreb",
				"dreb", "reb", "ast", "tov", "stl", "blk", "pf", "dd2", "td3",
				"pts" };
		tokenizer.setNames(names);
		Properties props = tokenizer.tokenize(line).getProperties();
		Assert.assertThat(props.getProperty("player"),
				CoreMatchers.is("Tony Parker"));
		Assert.assertThat(props.getProperty("season"),
				CoreMatchers.is("2013-14"));
	}

	@Test
	public void getIncludedFieldsTest() {
		tokenizer.setNames(new String[] { "player", "pts" });
		tokenizer.setIncludedFields(new int[] { 0, 23 });
		FieldSet fieldSet = tokenizer.tokenize(line);
		Properties props = fieldSet.getProperties();
		Assert.assertThat(2, CoreMatchers.is(fieldSet.getFieldCount()));
		Assert.assertThat(props.getProperty("player"),
				CoreMatchers.is("Tony Parker"));
		Assert.assertThat(props.getProperty("pts"), CoreMatchers.is("16.7"));
	}
}
