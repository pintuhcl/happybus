/*
 * Copyright (c) 2017, 2018, CBA and/or its affiliates. All rights reserved.
 * CBA PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 */
package com.cbabackend.writer;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.Region;
import com.cbabackend.util.SQLConstants;

/**
 * This class is used to Writing the Region Details of Common Wealth Bank from
 * Database
 * 
 * @author Sathish.Bandi
 * @since CBABE 1.0
 * 
 */
@Repository
public class RegionItemWriterImpl implements RegionItemWriter {
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;

	/**
	 * This method is used to save the Region Details of Common Wealth Bank from
	 * Database
	 * 
	 * @return ItemWriter<Region>
	 */
	@Override
	public ItemWriter<Region> saveRegionDetails() {
		JdbcBatchItemWriter<Region> itemWriter = new JdbcBatchItemWriter<Region>();
		itemWriter.setDataSource(dataSource);
		itemWriter.setSql(SQLConstants.SQL_SAVE_REGION_DETAILS);
		itemWriter.setItemPreparedStatementSetter((Region Region, PreparedStatement pst) -> {
			pst.setInt(1, Region.getRegionId());
			pst.setString(2, Region.getRegionName());
			pst.setString(3, Region.getRegionCode());
			pst.setString(4, Region.getRegionHeadOffice());
			pst.setString(5, Region.getRegionDesc());
			pst.setString(6, Region.getRegionAddress());
			pst.setInt(7, Region.getBankId());

		});
		return itemWriter;
	}

}
