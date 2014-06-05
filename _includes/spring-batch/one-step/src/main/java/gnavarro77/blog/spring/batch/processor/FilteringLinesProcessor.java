package gnavarro77.blog.spring.batch.processor;

import gnavarro77.blog.spring.batch.bean.StatisticBean;

import org.springframework.batch.item.ItemProcessor;

public class FilteringLinesProcessor implements
		ItemProcessor<StatisticBean, StatisticBean> {

	@Override
	public StatisticBean process(StatisticBean item) throws Exception {
		StatisticBean bean = item;
		if (bean.getAppg() < 13) {
			// returning null result in item not being passed to item writer
			bean = null;
		}
		return bean;
	}

}
