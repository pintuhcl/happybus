/*Copyright(c) 2017-2018 CBA and /or its affiliates.All rights reserved
 * CBA PROPRIETARY/Confidential.Use its subject to license terms.
  */

package com.cbabackend.writer;

import java.sql.PreparedStatement;

import javax.sql.DataSource;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import com.cbabackend.beans.Card;

import com.cbabackend.util.SQLConstants;

/*
 * This class is used to Write the Card Details into the database.
 * 
 * @author Rahul M.
 * @since CBABE 1.0
 * 
 * 
 * */
@Repository
public class CardItemWriterImpl implements CardItemWriter {

	@Autowired
	@Qualifier("ds")
	private DataSource dataSource;

	
	@Override
	public ItemWriter<Card> saveCardDetails() {
		
			JdbcBatchItemWriter<Card> itemWriter = new JdbcBatchItemWriter<Card>();
			itemWriter.setDataSource(dataSource);
			itemWriter.setSql(SQLConstants.SQL_SAVE_Card_DETAILS);
			itemWriter.setItemPreparedStatementSetter((Card card, PreparedStatement pst) -> {
				pst.setInt(1, card.getCardId());
				pst.setString(2, card.getCardNumber());
				pst.setString(3, card.getCardHolderName());
				pst.setDate(4,card.getExpiryDate());
				pst.setInt(5, card.getCvv());
				pst.setInt(6, card.getCardTypeId());
							});
			return itemWriter;
	}//saveCardDetails()
}//class
