package gnavarro77.blog.spring.batch;

import static org.hamcrest.CoreMatchers.is;
import gnavarro77.blog.spring.batch.bean.StatisticBean;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.validation.BindException;

public class IncludeFieldsTest {

	@Test
	public void test() throws BindException {
		String line = "Tony Parker,2013-14,,,,,16.7,,,";
		DelimitedLineTokenizer tokenizer = new DelimitedLineTokenizer();
		// names match StatisticBean properties for usage of
		// BeanWrapperFieldSetMapper
		tokenizer.setNames(new String[] { "player", "season", "appg" });
		// specify the fields to include
		tokenizer.setIncludedFields(new int[] { 0, 1, 6 });
		FieldSetMapper<StatisticBean> fieldSetMapper = new BeanWrapperFieldSetMapper<StatisticBean>();
		((BeanWrapperFieldSetMapper<StatisticBean>) fieldSetMapper)
				.setTargetType(StatisticBean.class);
		StatisticBean bean = fieldSetMapper.mapFieldSet(tokenizer
				.tokenize(line));
		Assert.assertThat(bean.getPlayer(), is("Tony Parker"));
		Assert.assertThat(bean.getSeason(), is("2013-14"));
		Assert.assertThat(bean.getAppg(), is((float) 16.7));
	}
}
