package gnavarro77.blog.spring.batch.step.one;

import static org.hamcrest.CoreMatchers.is;
import gnavarro77.blog.spring.batch.bean.StatisticBean;

import java.util.Properties;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.validation.BindException;

public class AveragePointsPerGameUpdateJobTest {

	/**
	 * LineTokenizer is here to split a line into its atomic fields
	 */
	private LineTokenizer tokenizer;

	/**
	 * Out of a line i need to get the player name, the season and the average
	 * number of points per game.
	 */
	@Test
	public void tokenizeLineTest() {
		String line = "Tony Parker,2013-14,68,29.4,6.7,13.4,49.9%,0.4,1.0,37.3%,2.9,3.6,81.1%,0.3,2.0,2.3,5.7,2.2,0.5,0.1,1.3,2,0,16.7";
		Properties props = tokenizer.tokenize(line).getProperties();
		// Here i made a choice on the way i get values out of the
		// LineTokenizer; Could have been otherwise
		Assert.assertThat(props.getProperty("player"), is("Tony Parker"));
		Assert.assertThat(props.getProperty("season"), is("2013-14"));
		Assert.assertThat(props.getProperty("appg"), is("16.7"));
	}

	/**
	 * FieldSetMapper is here to make a line available as an instance of bean
	 * StatisticBean
	 */
	private FieldSetMapper<StatisticBean> fieldSetMapper;

	/**
	 * We chose to map a line to a bean instance, it could have been otherwise
	 * 
	 * @throws BindException
	 */
	@Test
	public void mapFieldSetTest() throws BindException {
		String line = "Tony Parker,2013-14,68,29.4,6.7,13.4,49.9%,0.4,1.0,37.3%,2.9,3.6,81.1%,0.3,2.0,2.3,5.7,2.2,0.5,0.1,1.3,2,0,16.7";
		StatisticBean bean = fieldSetMapper.mapFieldSet(tokenizer
				.tokenize(line));
		Assert.assertThat(bean.getPlayer(), is("Tony Parker"));
		Assert.assertThat(bean.getSeason(), is("2013-14"));
		Assert.assertThat(bean.getAppg(), is((float) 16.7));
	}

	/**
	 * We know that we read data out of a flat file that's why we go for a
	 * ResourceAwareItemReaderItemStream
	 */
	private ResourceAwareItemReaderItemStream<StatisticBean> itemReader;

	/**
	 * 
	 * @throws Exception
	 */
	public void readTest() throws Exception {
		String line = "Tony Parker,2013-14,68,29.4,6.7,13.4,49.9%,0.4,1.0,37.3%,2.9,3.6,81.1%,0.3,2.0,2.3,5.7,2.2,0.5,0.1,1.3,2,0,16.7";
		itemReader.setResource(new ByteArrayResource(line.getBytes()));
		itemReader.open(new ExecutionContext());
		try {
			StatisticBean bean = itemReader.read();
			Assert.assertThat(bean.getPlayer(), is("Tony Parker"));
			Assert.assertThat(bean.getSeason(), is("2013-14"));
			Assert.assertThat(bean.getAppg(), is((float) 16.7));
		} finally {
			itemReader.close();
		}

	}
	
	
	private ItemWriter<StatisticBean> itemWriter;

}
