package gnavarro77.blog.spring.batch;

import static org.hamcrest.CoreMatchers.is;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/simple-job-launcher-context.xml",
		"/jobs/filtering-records-job.xml" })
public class FilteringRecordsTest {

	@Autowired
	private JobLauncherTestUtils launcher;

	@Autowired
	private Job job;

	/**
	 * 
	 */
	@Test
	public void test() throws Exception {
		String inputFile = "/filtering-lines.txt";
		String outputFile = "target/filtering-lines.out.txt";
		launcher.setJob(job);
		JobParameters parameters = new JobParametersBuilder()
				.addString("inputFile", inputFile)
				.addString("outputFile", outputFile).toJobParameters();
		JobExecution jobExecution = launcher.launchJob(parameters);
		Assert.assertThat(jobExecution.getStatus(), is(BatchStatus.COMPLETED));
		// read all the output file lines
		List<String> lines = Files.readAllLines(Paths.get(outputFile),
				Charset.forName("UTF-8"));
		Assert.assertThat(lines.size(), is(2));
		Assert.assertThat(lines.get(0), is("Tony Parker"));
		Assert.assertThat(lines.get(1), is("Nicolas Batum"));
	}
}
